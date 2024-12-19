package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.SaucesDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Sauces;

public class SaucesServiceDao {
private SaucesDao saucesDao = new SaucesDao();
	
	public List<Sauces> getSauces() {
		try(Connection conn = OracleDBUtil.getConnection()) {
        	return saucesDao.getSauces(conn);
		} catch(SQLException ex) {
			throw new DBException("Error while getting sauces from DB.", ex);
		}
	}
}
