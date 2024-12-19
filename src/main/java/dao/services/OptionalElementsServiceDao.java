package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.OptionalElementsDao;
import dao.PiadinaDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.OptionalElements;

public class OptionalElementsServiceDao {
private OptionalElementsDao optionalElementsDao = new OptionalElementsDao();
	
	public List<OptionalElements> getOptionalElements() {
		try(Connection conn = OracleDBUtil.getConnection()) {
        	return optionalElementsDao.getOptionalElements(conn);
		} catch(SQLException ex) {
			throw new DBException("Error while getting optional elements from DB.", ex);
		}
	}
}
