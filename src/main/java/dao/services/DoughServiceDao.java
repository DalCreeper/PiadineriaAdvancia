package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DoughDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Dough;

public class DoughServiceDao {
	private final DoughDao doughDao = new DoughDao();
	
	public List<Dough> getDoughs() {
		try(Connection conn = OracleDBUtil.getConnection()) {
            try {
                List<Dough> doughs = doughDao.getDoughs(conn);
                conn.commit();
                return doughs;
            } catch(SQLException ex) {
                conn.rollback();
                throw new DBException("Error while getting doughs from DB.", ex);
            }
        } catch(SQLException ex) {
            throw new DBException("Error while establishing DB connection for getting doughs.", ex);
        }
	}
}
