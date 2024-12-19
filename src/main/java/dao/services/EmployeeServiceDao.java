package dao.services;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmployeeDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.Employee;

public class EmployeeServiceDao {
private EmployeeDao employeeDao = new EmployeeDao();
	
	public Employee getUser(String username, String password) {
		try(Connection conn = OracleDBUtil.getConnection()) {
        	return employeeDao.getEmployee(username, password, conn);
		} catch(SQLException ex) {
			throw new DBException("Error while getting user from DB with username: " + username, ex);
		}
	}
}