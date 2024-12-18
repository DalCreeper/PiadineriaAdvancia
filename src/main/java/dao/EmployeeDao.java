package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DBException;
import model.classes.Employee;
import model.enums.Role;

public class EmployeeDao {
	private final String GET_USER_BY_USERNAME_PASSWORD = ""
		+ "SELECT "
			+ "ID, "
			+ "NAME, "
			+ "SURNAME, "
			+ "USERNAME, "
			+ "PASSWORD, "
			+ "YOB, "
			+ "ROLE "
		+ "FROM "
			+ "EMPLOYEE "
		+ "WHERE "
			+ "USERNAME = ? "
			+ "AND "
			+ "PASSWORD = ?";
	
	public Employee getEmployee(String username, String password, Connection conn) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement(GET_USER_BY_USERNAME_PASSWORD)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                	return new Employee(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("USERNAME"),
                        rs.getInt("YOB"),
                        Role.getEnumText(rs.getString("ROLE"))
                    );
                }
            }
        }
        throw new DBException("Error while getting user with username: " + username);
    }
}
