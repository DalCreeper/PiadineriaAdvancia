package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.DBException;
import model.classes.Dough;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Sauces;

public class PiadinaComponentsDao {
    private static final String GET_ALL_COMPONENTS = ""
        + "SELECT "
        	+ "'DOUGH' AS COMPONENT_TYPE, "
	        + "ID, "
	        + "TYPE, "
	        + "DESCRIPTION, "
	        + "PRICE "
        + "FROM "
        	+ "DOUGH "
        + "UNION "
        	+ "ALL "
        + "SELECT "
	        + "'MEATBASE' AS COMPONENT_TYPE, "
	        + "ID, "
	        + "TYPE, "
	        + "DESCRIPTION, "
	        + "PRICE "
        + "FROM "
        	+ "MEATBASE "
        + "UNION "
        	+ "ALL "
        + "SELECT "
	        + "'SAUCES' AS COMPONENT_TYPE, "
	        + "ID, "
	        + "TYPE, "
	        + "DESCRIPTION, "
	        + "PRICE "
        + "FROM "
        	+ "SAUCES "
        + "UNION "
        	+ "ALL "
        + "SELECT "
	        + "'OPTIONALELEMENTS' AS COMPONENT_TYPE, "
	        + "ID, "
	        + "TYPE, "
	        + "DESCRIPTION, "
	        + "PRICE "
        + "FROM "
        	+ "OPTIONAL_ELEMENTS"
        ;

    public Map<String, List<Object>> getAllComponents(Connection conn) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement(GET_ALL_COMPONENTS);
             ResultSet rs = stmt.executeQuery()) {

            Map<String, List<Object>> components = new HashMap<>();
            components.put("DOUGH", new ArrayList<>());
            components.put("MEATBASE", new ArrayList<>());
            components.put("SAUCES", new ArrayList<>());
            components.put("OPTIONALELEMENTS", new ArrayList<>());

            while(rs.next()) {
                String type = rs.getString("COMPONENT_TYPE");
                int id = rs.getInt("ID");
                String componentType = rs.getString("TYPE");
                String description = rs.getString("DESCRIPTION");
                double price = rs.getDouble("PRICE");

                switch(type) {
                    case "DOUGH" :
                        components.get("DOUGH").add(new Dough(id, componentType, description, price));
                        break;
                    case "MEATBASE" :
                        components.get("MEATBASE").add(new MeatBase(id, componentType, description, price));
                        break;
                    case "SAUCES" :
                        components.get("SAUCES").add(new Sauces(id, componentType, description, price));
                        break;
                    case "OPTIONALELEMENTS" :
                        components.get("OPTIONALELEMENTS").add(new OptionalElements(id, componentType, description, price));
                        break;
                }
            }
            return components;
        } catch(SQLException e) {
            throw new DBException("Error while getting piadina components from DB.", e);
        }
    }
}
