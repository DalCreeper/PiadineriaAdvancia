package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.PiadinaDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class PiadinaServiceDao {
private PiadinaDao piadinaDao = new PiadinaDao();
	
	public List<Piadina> getPiadinas() {
		try(Connection conn = OracleDBUtil.getConnection()) {
        	return piadinaDao.getPiadinas(conn);
		} catch(SQLException ex) {
			throw new DBException("Error while getting piadinas from DB.", ex);
		}
	}
}