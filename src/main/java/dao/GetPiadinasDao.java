package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.utils.HibernateUtil;
import exceptions.DBException;
import model.classes.Piadina;

public class GetPiadinasDao {
	public List<Piadina> getPiadinas() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM Piadina p "
                       + "JOIN FETCH p.dough "
                       + "JOIN FETCH p.employee";
            Query<Piadina> query = session.createQuery(hql, Piadina.class);
            List<Piadina> piadinas = query.getResultList();
            
            for(Piadina piadina : piadinas) {
                Hibernate.initialize(piadina.getMeatBase());
                Hibernate.initialize(piadina.getSauces());
                Hibernate.initialize(piadina.getOptionalElements());
            }

            return piadinas;
        } catch(Exception e) {
            throw new DBException("Error while getting piadinas from DB.", e);
        }
    }
}
