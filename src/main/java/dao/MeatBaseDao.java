package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import model.classes.MeatBase;

public class MeatBaseDao {
	private final String GET_MEATBASES= ""
		+ "SELECT "
			+ "ID, "
			+ "TYPE, "
			+ "DESCRIPTION, "
			+ "PRICE "
		+ "FROM "
			+ "MEATBASE"
		;
	
	public List<MeatBase> getMeatBases(Connection conn) throws SQLException {
		try(PreparedStatement stmt = conn.prepareStatement(GET_MEATBASES)) {
	        try(ResultSet rs = stmt.executeQuery()) {
	        	List<MeatBase> meatBases = new ArrayList<>();
	        	
	        	while(rs.next()) {
	        		MeatBase meatBase = new MeatBase(
        	            rs.getInt("ID"),
        	            rs.getString("TYPE"),
        	            rs.getString("DESCRIPTION"),
        	            rs.getDouble("PRICE")
        	        );
	        		meatBases.add(meatBase);
	        	}
	        	return meatBases;
	        }
		} catch(SQLException e) {
	        throw new DBException("Error while getting meat bases from DB.", e);
	    }
	}
}