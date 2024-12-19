package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import model.classes.OptionalElements;

public class OptionalElementsDao {
	private final String GET_OPTIONALELEMENTS= ""
		+ "SELECT "
			+ "ID, "
			+ "TYPE, "
			+ "DESCRIPTION, "
			+ "PRICE "
		+ "FROM "
			+ "OPTIONAL_ELEMENTS"
		;
	
	public List<OptionalElements> getOptionalElements(Connection conn) throws SQLException {
		try(PreparedStatement stmt = conn.prepareStatement(GET_OPTIONALELEMENTS)) {
	        try(ResultSet rs = stmt.executeQuery()) {
	        	List<OptionalElements> optionalElements = new ArrayList<>();
	        	
	        	while(rs.next()) {
	        		OptionalElements optionalElement = new OptionalElements(
        	            rs.getInt("ID"),
        	            rs.getString("TYPE"),
        	            rs.getString("DESCRIPTION"),
        	            rs.getDouble("PRICE")
        	        );
	        		optionalElements.add(optionalElement);
	        	}
	        	return optionalElements;
	        }
		} catch(SQLException e) {
	        throw new DBException("Error while getting optional elements from DB.", e);
	    }
	}
}
