package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.OptionalElementsDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.OptionalElements;

public class OptionalElementsServiceDao {
	private final OptionalElementsDao optionalElementsDao = new OptionalElementsDao();
	
	public List<OptionalElements> getOptionalElements() {
		try(Connection conn = OracleDBUtil.getConnection()) {
            try {
                List<OptionalElements> optionalElements = optionalElementsDao.getOptionalElements(conn);
                conn.commit();
                return optionalElements;
            } catch(SQLException ex) {
                conn.rollback();
                throw new DBException("Error while getting optional elements from DB.", ex);
            }
        } catch(SQLException ex) {
            throw new DBException("Error while establishing DB connection for getting optional elements.", ex);
        }
	}
}
