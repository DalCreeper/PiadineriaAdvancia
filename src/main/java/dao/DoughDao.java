package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import model.classes.Dough;

public class DoughDao {
	private final String GET_DOUGHS= ""
		+ "SELECT "
			+ "ID, "
			+ "TYPE, "
			+ "DESCRIPTION, "
			+ "PRICE "
		+ "FROM "
			+ "DOUGH"
		;
	
	public List<Dough> getDoughs(Connection conn) throws SQLException {
		try(PreparedStatement stmt = conn.prepareStatement(GET_DOUGHS)) {
	        try(ResultSet rs = stmt.executeQuery()) {
	        	List<Dough> doughs = new ArrayList<>();
	        	
	        	while(rs.next()) {
	        		Dough dough = new Dough(
        	            rs.getInt("ID"),
        	            rs.getString("TYPE"),
        	            rs.getString("DESCRIPTION"),
        	            rs.getDouble("PRICE")
        	        );
	        		doughs.add(dough);
	        	}
	        	return doughs;
	        }
		} catch(SQLException e) {
	        throw new DBException("Error while getting doughs from DB.", e);
	    }
	}
}
