package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.AddPiadinaDao;
import dao.GetPiadinasDao;
import dao.RemovePiadinaDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class PiadinaServiceDao {
	private final GetPiadinasDao getPiadinasDao = new GetPiadinasDao();
	private final AddPiadinaDao addPiadinaDao = new AddPiadinaDao();
	private final RemovePiadinaDao removePiadinaDao = new RemovePiadinaDao();
	
	public List<Piadina> getPiadinas() {
	    try(Connection conn = OracleDBUtil.getConnection()) {
	        try {
	            List<Piadina> piadinas = getPiadinasDao.getPiadinas(conn);
	            conn.commit();
	            return piadinas;
	        } catch(SQLException ex) {
	            conn.rollback();
	            throw new DBException("Error while getting piadinas from DB.", ex);
	        }
	    } catch(SQLException ex) {
	        throw new DBException("Error while establishing DB connection for getting piadinas.", ex);
	    }
	}
	
	public void addPiadina(Piadina piadina) {
	    try(Connection conn = OracleDBUtil.getConnection()) {
	        try {
	        	addPiadinaDao.insertPiadina(conn, piadina);
	            conn.commit();
	        } catch(SQLException ex) {
	            conn.rollback();
	            throw new DBException("Error while adding piadina to DB.", ex);
	        }
	    } catch(SQLException ex) {
	        throw new DBException("Error while establishing DB connection for adding piadina.", ex);
	    }
	}
	
	public void removePiadina(int piadinaId) {
	    try(Connection conn = OracleDBUtil.getConnection()) {
	        conn.setAutoCommit(false);
	        try {
	            removePiadinaDao.deletePiadina(conn, piadinaId);
	            conn.commit();
	        } catch(SQLException ex) {
	            conn.rollback();
	            throw new DBException("Error while removing piadina from DB.", ex);
	        }
	    } catch(SQLException ex) {
	        throw new DBException("Error while establishing DB connection for removing piadina.", ex);
	    }
	}
}