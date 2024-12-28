package dao.utils;

import org.hibernate.Session;

public class OracleDBUtil {
	/*
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
    */
	public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}