package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MeatBaseDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.MeatBase;

public class MeatBaseServiceDao {
private MeatBaseDao meatBaseDao = new MeatBaseDao();
	
	public List<MeatBase> getMeatBases() {
		try(Connection conn = OracleDBUtil.getConnection()) {
        	return meatBaseDao.getMeatBases(conn);
		} catch(SQLException ex) {
			throw new DBException("Error while getting meat bases from DB.", ex);
		}
	}
}
