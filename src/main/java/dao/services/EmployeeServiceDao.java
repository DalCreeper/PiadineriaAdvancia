package dao.services;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmployeeDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Employee;

public class EmployeeServiceDao {
	private final EmployeeDao employeeDao = new EmployeeDao();
	
	public Employee getUser(String username, String password) {
		try(Connection conn = OracleDBUtil.getConnection()) {
            try {
                Employee employee = employeeDao.getEmployee(username, password, conn);
                conn.commit();
                return employee;
            } catch(SQLException ex) {
                conn.rollback();
                throw new DBException("Error while getting user from DB with username: " + username, ex);
            }
        } catch(SQLException ex) {
            throw new DBException("Error while establishing DB connection for getting user.", ex);
        }
	}
}