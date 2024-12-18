package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtils implements AutoCloseable {
	private static Logger log = LogManager.getLogger(DBUtils.class);
	private static Connection conn;
	private static String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String username = "Loris";
	private static String password = "Password98";
	
	public static void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, username, password);
			
			if(conn != null) {
				conn.setAutoCommit(false);
				log.info("Connection to DB extabilished.");
			}
		} catch (ClassNotFoundException ex) {
	        log.error("Oracle JDBC Driver not found!", ex);
	    } catch(SQLException ex) {
			log.error("Connection to DB failed. {}", ex);
		}
	}
	
	public static Connection getConn() {
		if(conn == null) {
			connect();
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