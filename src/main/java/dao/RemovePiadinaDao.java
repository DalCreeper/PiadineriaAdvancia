package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exceptions.DBException;

public class RemovePiadinaDao {
	private final String DELETE_PIADINA = ""
		+ "DELETE "
		+ "FROM "
			+ "PIADINA "
		+ "WHERE "
			+ "ID = ?"
		;
	
	private final String DELETE_PIADINA_MEATBASES = ""
		+ "DELETE "
		+ "FROM "
			+ "PIADINA_MEATBASE "
		+ "WHERE "
			+ "PIADINA_ID = ?"
		;
	
	private final String DELETE_PIADINA_SAUCES = ""
		+ "DELETE "
		+ "FROM "
			+ "PIADINA_SAUCES "
		+ "WHERE "
			+ "PIADINA_ID = ?"
		;
	
	private final String DELETE_PIADINA_OPTIONAL_ELEMENTS = ""
		+ "DELETE "
		+ "FROM "
			+ "PIADINA_OPTIONAL_ELEMENTS "
		+ "WHERE "
			+ "PIADINA_ID = ?"
		;

	public void deletePiadina(Connection conn, int piadinaId) throws SQLException {
	    try {
	        deleteRelatedElements(conn, piadinaId);

	        try(PreparedStatement stmt = conn.prepareStatement(DELETE_PIADINA)) {
	            stmt.setInt(1, piadinaId);
	            int affectedRows = stmt.executeUpdate();
	            if(affectedRows == 0) {
	                throw new SQLException("Deleting piadina failed, no rows affected.");
	            }
	        }
	    } catch(SQLException e) {
	        throw new DBException("Error while deleting piadina from DB.", e);
	    }
	}

	private void deleteRelatedElements(Connection conn, int piadinaId) throws SQLException {
	    try(PreparedStatement stmt = conn.prepareStatement(DELETE_PIADINA_MEATBASES)) {
	        stmt.setInt(1, piadinaId);
	        stmt.executeUpdate();
	    }

	    try(PreparedStatement stmt = conn.prepareStatement(DELETE_PIADINA_SAUCES)) {
	        stmt.setInt(1, piadinaId);
	        stmt.executeUpdate();
	    }

	    try(PreparedStatement stmt = conn.prepareStatement(DELETE_PIADINA_OPTIONAL_ELEMENTS)) {
	        stmt.setInt(1, piadinaId);
	        stmt.executeUpdate();
	    }
	}
}
