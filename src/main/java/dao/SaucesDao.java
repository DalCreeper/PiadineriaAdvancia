package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import model.classes.Sauces;

public class SaucesDao {
	private final String GET_SAUCES= ""
		+ "SELECT "
			+ "ID, "
			+ "TYPE, "
			+ "DESCRIPTION, "
			+ "PRICE "
		+ "FROM "
			+ "SAUCES"
		;
	
	public List<Sauces> getSauces(Connection conn) throws SQLException {
		try(PreparedStatement stmt = conn.prepareStatement(GET_SAUCES)) {
	        try(ResultSet rs = stmt.executeQuery()) {
	        	List<Sauces> sauces = new ArrayList<>();
	        	
	        	while(rs.next()) {
	        		Sauces sauce = new Sauces(
        	            rs.getInt("ID"),
        	            rs.getString("TYPE"),
        	            rs.getString("DESCRIPTION"),
        	            rs.getDouble("PRICE")
        	        );
	        		sauces.add(sauce);
	        	}
	        	return sauces;
	        }
		} catch(SQLException e) {
	        throw new DBException("Error while getting sauces from DB.", e);
	    }
	}
}
