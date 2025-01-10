package com.advancia.PiadineriaAdvancia.dao.piadinacomponents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;

public class PiadinaComponentsDao {
	public Map<String, Set<Object>> getAllComponents(EntityManager em) {
        Map<String, Set<Object>> components = new HashMap<>();
        components.put("DOUGH", new HashSet<>());
        components.put("MEATBASE", new HashSet<>());
        components.put("SAUCES", new HashSet<>());
        components.put("OPTIONALELEMENTS", new HashSet<>());

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
        }
    }
}