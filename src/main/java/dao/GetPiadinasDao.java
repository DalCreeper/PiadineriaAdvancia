package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import exceptions.DBException;
import model.classes.Dough;
import model.classes.Employee;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Piadina;
import model.classes.Sauces;
import model.enums.Role;

public class GetPiadinasDao {
	private final String GET_PIADINAS= ""
		+ "SELECT "
			+ "P.ID, "
			+ "P.NAME, "
			+ "D.ID AS DOUGH_ID, "
			+ "D.TYPE AS DOUGH_TYPE, "
			+ "D.DESCRIPTION AS DOUGH_DES, "
			+ "D.PRICE AS DOUGH_PRICE, "
			+ "M.ID AS MEATBASE_ID, "
			+ "M.TYPE AS MEATBASE_TYPE, "
			+ "M.DESCRIPTION AS MEATBASE_DES, "
			+ "M.PRICE AS MEATBASE_PRICE, "
			+ "S.ID AS SAUCE_ID, "
			+ "S.TYPE AS SAUCE_TYPE, "
			+ "S.DESCRIPTION AS SAUCE_DES, "
			+ "S.PRICE AS SAUCE_PRICE, "
			+ "O.ID AS OPTIONAL_ID, "
			+ "O.TYPE AS OPTIONAL_TYPE, "
			+ "O.DESCRIPTION AS OPTIONAL_DES, "
			+ "O.PRICE AS OPTIONAL_PRICE, "
			+ "P.PRICE, "
			+ "E.ID AS EMPLOYEE_ID, "
			+ "E.NAME AS EMPLOYEE_NAME, "
			+ "E.SURNAME, "
			+ "E.USERNAME, "
			+ "E.YOB, "
			+ "E.ROLE "
		+ "FROM "
			+ "PIADINA P "
		+ "JOIN "
			+ "DOUGH D ON P.DOUGH_ID = D.ID "
		+ "JOIN "
			+ "PIADINA_MEATBASE PM ON P.ID = PM.PIADINA_ID "
		+ "JOIN "
			+ "MEATBASE M ON PM.MEATBASE_ID = M.ID "
		+ "JOIN "
			+ "PIADINA_SAUCES PS ON P.ID = PS.PIADINA_ID "
		+ "JOIN "
			+ "SAUCES S ON PS.SAUCES_ID = S.ID "
		+ "JOIN "
			+ "PIADINA_OPTIONAL_ELEMENTS PO ON P.ID = PO.PIADINA_ID "
		+ "JOIN "
			+ "OPTIONAL_ELEMENTS O ON PO.OPTIONAL_ELEMENTS_ID = O.ID "
		+ "JOIN "
			+ "EMPLOYEE E ON P.EMPLOYEE_ID = E.ID"
		;
	
	public List<Piadina> getPiadinas(Connection conn) throws SQLException {
	    try(PreparedStatement stmt = conn.prepareStatement(GET_PIADINAS)) {
	        try(ResultSet rs = stmt.executeQuery()) {
	            Map<Integer, Piadina> piadinaMap = new HashMap<>();

	            while(rs.next()) {
	                int piadinaId = rs.getInt("ID");

	                Piadina piadina = piadinaMap.get(piadinaId);
	                if(piadina == null) {
	                    piadina = new Piadina(
	                        piadinaId,
	                        rs.getString("NAME"),
	                        new Dough(
	                            rs.getInt("DOUGH_ID"),
	                            rs.getString("DOUGH_TYPE"),
	                            rs.getString("DOUGH_DES"),
	                            rs.getDouble("DOUGH_PRICE")
	                        ),
	                        new ArrayList<>(),
	                        new ArrayList<>(),
	                        new ArrayList<>(),
	                        rs.getDouble("PRICE"),
	                        new Employee(
	                            rs.getInt("EMPLOYEE_ID"),
	                            rs.getString("EMPLOYEE_NAME"),
	                            rs.getString("SURNAME"),
	                            rs.getString("USERNAME"),
	                            rs.getInt("YOB"),
	                            Role.getEnumText(rs.getString("ROLE"))
	                        )
	                    );
	                    piadinaMap.put(piadinaId, piadina);
	                }

	                if(rs.getInt("MEATBASE_ID") != 0) {
	                    MeatBase meatBase = new MeatBase(
	                        rs.getInt("MEATBASE_ID"),
	                        rs.getString("MEATBASE_TYPE"),
	                        rs.getString("MEATBASE_DES"),
	                        rs.getDouble("MEATBASE_PRICE")
	                    );
	                    if(!piadina.getMeatBase().contains(meatBase)) {
	                        piadina.addMeatBase(meatBase);
	                    }
	                }
	                if(rs.getInt("SAUCE_ID") != 0) {
	                    Sauces sauce = new Sauces(
	                        rs.getInt("SAUCE_ID"),
	                        rs.getString("SAUCE_TYPE"),
	                        rs.getString("SAUCE_DES"),
	                        rs.getDouble("SAUCE_PRICE")
	                    );
	                    if(!piadina.getSauces().contains(sauce)) {
	                        piadina.addSauces(sauce);
	                    }
	                }
	                if(rs.getInt("OPTIONAL_ID") != 0) {
	                    OptionalElements optionalElement = new OptionalElements(
	                        rs.getInt("OPTIONAL_ID"),
	                        rs.getString("OPTIONAL_TYPE"),
	                        rs.getString("OPTIONAL_DES"),
	                        rs.getDouble("OPTIONAL_PRICE")
	                    );
	                    if(!piadina.getOptionalElements().contains(optionalElement)) {
	                        piadina.addOptionalElement(optionalElement);
	                    }
	                }
	            }

	            for(Piadina piadina : piadinaMap.values()) {
	                piadina.setMeatBase(
	                    new ArrayList<>(new HashSet<>(piadina.getMeatBase()))
	                );
	                piadina.setSauces(
	                    new ArrayList<>(new HashSet<>(piadina.getSauces()))
	                );
	                piadina.setOptionalElements(
	                    new ArrayList<>(new HashSet<>(piadina.getOptionalElements()))
	                );
	            }

	            return new ArrayList<>(piadinaMap.values());
	        }
	    } catch(SQLException e) {
	        throw new DBException("Error while getting piadinas from DB.", e);
	    }
	}
}
