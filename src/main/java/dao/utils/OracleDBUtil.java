package dao.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.DBException;

public class OracleDBUtil {
	private static Logger log = LogManager.getLogger(OracleDBUtil.class);
	
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/OracleDataSource");
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            log.info("Connection to DB extabilished.");
        } catch(NamingException | SQLException e) {
        	throw new DBException("DataSource extraction failed.", e);
        }
        return connection;
    }
}