package services;

import java.util.List;

import dao.services.MeatBaseServiceDao;
import model.classes.MeatBase;

public class MeatBaseService {
	private MeatBaseServiceDao meatBaseServiceDao = new MeatBaseServiceDao();
	
	public List<MeatBase> getMeatBases() {
		return meatBaseServiceDao.getMeatBases();
	}
}