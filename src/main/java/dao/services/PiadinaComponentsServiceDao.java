package dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.PiadinaComponentsDao;
import dao.utils.OracleDBUtil;
import exceptions.DBException;

public class PiadinaComponentsServiceDao {
	private final PiadinaComponentsDao componentsDao = new PiadinaComponentsDao();

    public Map<String, List<Object>> getPiadinaComponents() {
        try(Connection conn = OracleDBUtil.getConnection()) {
            try {
                Map<String, List<Object>> components = componentsDao.getAllComponents(conn);
                conn.commit();
                return components;
            } catch(SQLException ex) {
                conn.rollback();
                throw new DBException("Error while getting piadina components from DB.", ex);
            }
        } catch(SQLException ex) {
            throw new DBException("Error while establishing DB connection for getting piadina components.", ex);
        }
    }
}