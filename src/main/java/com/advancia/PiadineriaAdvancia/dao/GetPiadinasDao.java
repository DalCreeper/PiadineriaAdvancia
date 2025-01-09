package com.advancia.PiadineriaAdvancia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.advancia.PiadineriaAdvancia.dao.utils.JPAUtil;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Piadina;

public class GetPiadinasDao {
	public List<Piadina> getPiadinas() {
		EntityManager em = JPAUtil.getEntityManager();

        try {
        	String jpqlBase = "SELECT DISTINCT p FROM Piadina p "
		                    + "JOIN FETCH p.dough "
		                    + "JOIN FETCH p.employee";

		    TypedQuery<Piadina> queryBase = em.createQuery(jpqlBase, Piadina.class);
		    List<Piadina> piadinas = queryBase.getResultList();
		
		    for(Piadina p : piadinas) {
		        p.getMeatBase().size();
		        p.getSauces().size();
		        p.getOptionalElements().size();
		    }
            return queryBase.getResultList();
        } catch(Exception e) {
            throw new DBException("Error while getting piadinas from DB.", e);
        } finally {
            em.close();
        }
    }
}