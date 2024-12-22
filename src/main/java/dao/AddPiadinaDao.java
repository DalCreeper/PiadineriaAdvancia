package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exceptions.DBException;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Piadina;
import model.classes.Sauces;

public class AddPiadinaDao {
	private final String INSERT_PIADINA = ""
	    + "INSERT "
	    	+ "INTO PIADINA (NAME, DOUGH_ID, PRICE, EMPLOYEE_ID) "
	    + "VALUES "
	    	+ "(?, ?, ?, ?)"
	    ;
	
	private final String INSERT_PIADINA_MEATBASES = ""
	    + "INSERT "
	    	+ "INTO PIADINA_MEATBASE (PIADINA_ID, MEATBASE_ID) "
	    + "VALUES "
	    	+ "(?, ?)"
	    ;
	
	private final String INSERT_PIADINA_SAUCES = ""
	    + "INSERT "
	    	+ "INTO PIADINA_SAUCES (PIADINA_ID, SAUCES_ID) "
	    + "VALUES "
	    	+ "(?, ?)"
	    ;
	
	private final String INSERT_PIADINA_OPTIONAL_ELEMENTS = ""
	    + "INSERT "
	    	+ "INTO PIADINA_OPTIONAL_ELEMENTS (PIADINA_ID, OPTIONAL_ELEMENTS_ID) "
	    + "VALUES "
	    	+ "(?, ?)"
	    ;
	
	public void insertPiadina(Connection conn, Piadina piadina) throws SQLException {
	    try(PreparedStatement stmt = conn.prepareStatement(INSERT_PIADINA, new String[] {"ID"})) {
	        stmt.setString(1, piadina.getName());
	        stmt.setInt(2, piadina.getDough().getId());
	        stmt.setDouble(3, piadina.getPrice());
	        stmt.setInt(4, piadina.getEmployee().getUID());

	        int affectedRows = stmt.executeUpdate();

	        if(affectedRows == 0) {
	            throw new SQLException("Inserting piadina failed, no rows affected.");
	        }

	        try(ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if(generatedKeys.next()) {
	                piadina.setId(generatedKeys.getInt(1));
	            } else {
	                throw new SQLException("Inserting piadina failed, no ID obtained.");
	            }
	        }
	        insertRelatedElements(conn, piadina);

	    } catch(SQLException e) {
	        throw new DBException("Error while inserting piadina into DB.", e);
	    }
	}
	
	private void insertRelatedElements(Connection conn, Piadina piadina) throws SQLException {
	    if(piadina.getId() <= 0) {
	        throw new SQLException("Invalid Piadina ID: " + piadina.getId());
	    }

	    for(MeatBase meatBase : piadina.getMeatBase()) {
	        try(PreparedStatement stmt = conn.prepareStatement(INSERT_PIADINA_MEATBASES)) {
	            stmt.setInt(1, piadina.getId());
	            stmt.setInt(2, meatBase.getId());
	            stmt.executeUpdate();
	        }
	    }

	    for(Sauces sauce : piadina.getSauces()) {
	        try(PreparedStatement stmt = conn.prepareStatement(INSERT_PIADINA_SAUCES)) {
	            stmt.setInt(1, piadina.getId());
	            stmt.setInt(2, sauce.getId());
	            stmt.executeUpdate();
	        }
	    }

	    for(OptionalElements optionalElement : piadina.getOptionalElements()) {
	        try(PreparedStatement stmt = conn.prepareStatement(INSERT_PIADINA_OPTIONAL_ELEMENTS)) {
	            stmt.setInt(1, piadina.getId());
	            stmt.setInt(2, optionalElement.getId());
	            stmt.executeUpdate();
	        }
	    }
	}
}
