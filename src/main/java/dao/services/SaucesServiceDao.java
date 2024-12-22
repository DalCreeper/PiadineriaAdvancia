package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.SaucesDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Sauces;

public class SaucesServiceDao {
	private final SaucesDao saucesDao = new SaucesDao();
	
	public List<Sauces> getSauces() {
		try(Connection conn = OracleDBUtil.getConnection()) {
            try {
                List<Sauces> sauces = saucesDao.getSauces(conn);
                conn.commit();
                return sauces;
            } catch(SQLException ex) {
                conn.rollback();
                throw new DBException("Error while getting sauces from DB.", ex);
            }
        } catch(SQLException ex) {
            throw new DBException("Error while establishing DB connection for getting sauces.", ex);
        }
	}
}
