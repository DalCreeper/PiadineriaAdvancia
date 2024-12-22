package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MeatBaseDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;
import model.classes.MeatBase;

public class MeatBaseServiceDao {
	private final MeatBaseDao meatBaseDao = new MeatBaseDao();
	
	public List<MeatBase> getMeatBases() {
		try(Connection conn = OracleDBUtil.getConnection()) {
            try {
                List<MeatBase> meatBases = meatBaseDao.getMeatBases(conn);
                conn.commit();
                return meatBases;
            } catch(SQLException ex) {
                conn.rollback();
                throw new DBException("Error while getting meat bases from DB.", ex);
            }
        } catch(SQLException ex) {
            throw new DBException("Error while establishing DB connection for getting meat bases.", ex);
        }
	}
}
