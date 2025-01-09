package com.advancia.PiadineriaAdvancia.services;

import java.util.List;

import com.advancia.PiadineriaAdvancia.dao.AddPiadinaDao;
import com.advancia.PiadineriaAdvancia.dao.GetPiadinasDao;
import com.advancia.PiadineriaAdvancia.dao.RemovePiadinaDao;
import com.advancia.PiadineriaAdvancia.model.classes.Piadina;

public class PiadinaService {
	private final GetPiadinasDao getPiadinasDao = new GetPiadinasDao();
	private final AddPiadinaDao addPiadinaDao = new AddPiadinaDao();
	private final RemovePiadinaDao removePiadinaDao = new RemovePiadinaDao();
	
	public List<Piadina> getPiadinas() {
		return getPiadinasDao.getPiadinas();
	}
	
	public void addPiadina(Piadina piadina) {
		addPiadinaDao.insertPiadina(piadina);
	}
	
	public void removePiadina(int piadinaId) {
		removePiadinaDao.deletePiadina(piadinaId);
	}
}
