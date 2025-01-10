package com.advancia.PiadineriaAdvancia.dao.services;

import java.util.Map;
import java.util.Set;

import javax.persistence.EntityTransaction;

import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.AddDoughDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.AddMeatBaseDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.AddOptionalElementsDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.AddSaucesDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.GetDoughDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.GetMeatBaseDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.GetOptionalElementsDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.GetSaucesDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.PiadinaComponentsDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.RemoveDoughDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.RemoveMeatBaseDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.RemoveOptionalElementsDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.RemoveSaucesDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.UpdateDoughDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.UpdateMeatBaseDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.UpdateOptionalElementsDao;
import com.advancia.PiadineriaAdvancia.dao.piadinacomponents.UpdateSaucesDao;
import com.advancia.PiadineriaAdvancia.dao.utils.CloseableEntityManager;
import com.advancia.PiadineriaAdvancia.exceptions.DBException;
import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;

public class PiadinaComponentsDaoService {
	private final PiadinaComponentsDao piadinaComponentsDao = new PiadinaComponentsDao();
	
	private final AddDoughDao addDoughDao = new AddDoughDao();
	private final AddMeatBaseDao addMeatBaseDao = new AddMeatBaseDao();
	private final AddSaucesDao addSaucesDao = new AddSaucesDao();
	private final AddOptionalElementsDao addOptionalElementsDao = new AddOptionalElementsDao();
	
	private final GetDoughDao getDoughDao = new GetDoughDao();
	private final GetMeatBaseDao getMeatBaseDao = new GetMeatBaseDao();
	private final GetSaucesDao getSaucesDao = new GetSaucesDao();
	private final GetOptionalElementsDao getOptionalElementsDao = new GetOptionalElementsDao();
	
	private final UpdateDoughDao updateDoughDao = new UpdateDoughDao();
	private final UpdateMeatBaseDao updateMeatBaseDao = new UpdateMeatBaseDao();
	private final UpdateSaucesDao updateSaucesDao = new UpdateSaucesDao();
	private final UpdateOptionalElementsDao updateOptionalElementsDao = new UpdateOptionalElementsDao();
	
	private final RemoveDoughDao removeDoughDao = new RemoveDoughDao();
	private final RemoveMeatBaseDao removeMeatBaseDao = new RemoveMeatBaseDao();
	private final RemoveSaucesDao removeSaucesDao = new RemoveSaucesDao();
	private final RemoveOptionalElementsDao removeOptionalElementsDao = new RemoveOptionalElementsDao();
	
    public Map<String, Set<Object>> getAllComponents() {
        try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            Map<String, Set<Object>> components = piadinaComponentsDao.getAllComponents(em.getManager());
            
            transaction.commit();
            return components;
        } catch(Exception e) {
            throw new DBException("Error while retrieving piadina components.", e);
        }
    }
    
    public void addDough(Dough d) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            addDoughDao.add(d, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while adding dough.", e);
        }
    }
    
    public void addMeatBase(MeatBase mt) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            addMeatBaseDao.add(mt, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while adding meat base.", e);
        }
    }
    
    public void addSauces(Sauces s) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            addSaucesDao.add(s, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while adding sauces.", e);
        }
    }
    
	public void addOptionalElements(OptionalElements oe) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        EntityTransaction transaction = em.getManager().getTransaction();
	        transaction.begin();
	        
	        addOptionalElementsDao.add(oe, em.getManager());
	        
	        transaction.commit();
	    } catch(Exception e) {
	        throw new DBException("Error while adding optional elements.", e);
	    }
    }
	
	public Dough getDough(int id) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        return getDoughDao.get(id, em.getManager());
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving dough.", e);
	    }
    }
    
    public MeatBase getMeatBase(int id) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            return getMeatBaseDao.get(id, em.getManager());
        } catch(Exception e) {
            throw new DBException("Error while retrieving meat base.", e);
        }
    }
    
    public Sauces getSauces(int id) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            return getSaucesDao.get(id, em.getManager());
        } catch(Exception e) {
            throw new DBException("Error while retrieving sauces.", e);
        }
    }
    
	public OptionalElements getOptionalElements(int id) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        return getOptionalElementsDao.get(id, em.getManager());
	    } catch(Exception e) {
	        throw new DBException("Error while retrieving optional elements.", e);
	    }
    }
	
	public void updateDough(int id, Dough d) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        EntityTransaction transaction = em.getManager().getTransaction();
	        transaction.begin();
	        
	        updateDoughDao.update(id, d, em.getManager());
	        
	        transaction.commit();
	    } catch(Exception e) {
	        throw new DBException("Error while updating dough.", e);
	    }
    }
    
    public void updateMeatBase(int id, MeatBase mt) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            updateMeatBaseDao.update(id, mt, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while updating meat base.", e);
        }
    }
    
    public void updateSauces(int id, Sauces s) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            updateSaucesDao.update(id, s, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while updating sauces.", e);
        }
    }
    
	public void updateOptionalElements(int id, OptionalElements oe) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        EntityTransaction transaction = em.getManager().getTransaction();
	        transaction.begin();
	        
	        updateOptionalElementsDao.update(id, oe, em.getManager());
	        
	        transaction.commit();
	    } catch(Exception e) {
	        throw new DBException("Error while updating optional elements.", e);
	    }
    }
	
	public void deleteDough(int id) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        EntityTransaction transaction = em.getManager().getTransaction();
	        transaction.begin();
	        
	        removeDoughDao.remove(id, em.getManager());
	        
	        transaction.commit();
	    } catch(Exception e) {
	        throw new DBException("Error while deleting dough.", e);
	    }
    }
    
    public void deleteMeatBase(int id) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            removeMeatBaseDao.remove(id, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while deleting meat base.", e);
        }
    }
    
    public void deleteSauces(int id) {
    	try(CloseableEntityManager em = new CloseableEntityManager()) {
            EntityTransaction transaction = em.getManager().getTransaction();
            transaction.begin();
            
            removeSaucesDao.remove(id, em.getManager());
            
            transaction.commit();
        } catch(Exception e) {
            throw new DBException("Error while deleting sauces.", e);
        }
    }
    
	public void deleteOptionalElements(int id) {
		try(CloseableEntityManager em = new CloseableEntityManager()) {
	        EntityTransaction transaction = em.getManager().getTransaction();
	        transaction.begin();
	        
	        removeOptionalElementsDao.remove(id, em.getManager());
	        
	        transaction.commit();
	    } catch(Exception e) {
	        throw new DBException("Error while deleting optional elements.", e);
	    }
	}
}