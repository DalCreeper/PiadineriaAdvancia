package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import exceptions.DBException;
import model.classes.Dough;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Sauces;

public class PiadinaComponentsDao {
	public Map<String, List<Object>> getAllComponents(Session session) {
        Map<String, List<Object>> components = new HashMap<>();
        components.put("DOUGH", new ArrayList<>());
        components.put("MEATBASE", new ArrayList<>());
        components.put("SAUCES", new ArrayList<>());
        components.put("OPTIONALELEMENTS", new ArrayList<>());

        try {
            Query<Dough> doughQuery = session.createQuery("FROM Dough", Dough.class);
            components.get("DOUGH").addAll(doughQuery.list());
            
            Query<MeatBase> meatBaseQuery = session.createQuery("FROM MeatBase", MeatBase.class);
            components.get("MEATBASE").addAll(meatBaseQuery.list());

            Query<Sauces> saucesQuery = session.createQuery("FROM Sauces", Sauces.class);
            components.get("SAUCES").addAll(saucesQuery.list());

            Query<OptionalElements> optionalElementsQuery = session.createQuery("FROM OptionalElements", OptionalElements.class);
            components.get("OPTIONALELEMENTS").addAll(optionalElementsQuery.list());

            return components;
        } catch(Exception e) {
            throw new DBException("Error while getting piadina components from DB.", e);
        }
    }
}
