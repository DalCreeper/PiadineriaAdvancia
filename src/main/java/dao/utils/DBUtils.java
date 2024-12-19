package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.DBException;

@Deprecated
public class DBUtils implements AutoCloseable {
	private static Logger log = LogManager.getLogger(DBUtils.class);
	private static Connection conn;
	private static String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String username = "Loris";
	private static String password = "Password98";
	
	public synchronized static Connection connect() {
		if(conn != null) {
			return conn;
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, username, password);
			
			if(conn == null) {
				throw new DBException("An error occurred, empty connection generated!");
			}
			conn.setAutoCommit(false);
			log.info("Connection to DB extabilished.");
			return conn;
		} catch (ClassNotFoundException ex) {
	        throw new DBException("Oracle JDBC Driver not found!", ex);
	    } catch(SQLException ex) {
	    	throw new DBException("Connection to DB failed.", ex);
		}
	}
	
	public static Connection getConn() {
		if(conn == null) {
			return connect();
		}
		return conn;
	}

	@Override
	public void close() throws Exception {
		try {
			if(conn != null) {
				conn.close();
				log.info("Disconnection from the DB was successful.");
			}
		} catch(SQLException ex) {
			log.error("Disconnection from the DB failed. {}", ex);
		}
	}
}