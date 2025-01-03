package dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import dao.utils.JPAUtil;
import exceptions.DBException;
import model.classes.Dough;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Sauces;

public class PiadinaComponentsDao {
	public Map<String, Set<Object>> getAllComponents() {
        Map<String, Set<Object>> components = new HashMap<>();
        components.put("DOUGH", new HashSet<>());
        components.put("MEATBASE", new HashSet<>());
        components.put("SAUCES", new HashSet<>());
        components.put("OPTIONALELEMENTS", new HashSet<>());

        EntityManager em = JPAUtil.getEntityManager();

        try {
            components.get("DOUGH").addAll(
                em.createQuery("SELECT d FROM Dough d", Dough.class).getResultList()
            );
            components.get("MEATBASE").addAll(
                em.createQuery("SELECT m FROM MeatBase m", MeatBase.class).getResultList()
            );
            components.get("SAUCES").addAll(
                em.createQuery("SELECT s FROM Sauces s", Sauces.class).getResultList()
            );
            components.get("OPTIONALELEMENTS").addAll(
                em.createQuery("SELECT o FROM OptionalElements o", OptionalElements.class).getResultList()
            );

            return components;
        } catch(Exception e) {
            throw new DBException("Error while getting piadina components from DB.", e);
        } finally {
            em.close();
        }
    }
}
