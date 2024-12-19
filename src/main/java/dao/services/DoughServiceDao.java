package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DoughDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Dough;

public class DoughServiceDao {
private DoughDao doughDao = new DoughDao();
	
	public List<Dough> getDoughs() {
		try(Connection conn = OracleDBUtil.getConnection()) {
        	return doughDao.getDoughs(conn);
		} catch(SQLException ex) {
			throw new DBException("Error while getting doughs from DB.", ex);
		}
	}
}
