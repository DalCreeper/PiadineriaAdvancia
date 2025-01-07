package services;

import java.util.List;

import dao.services.PiadinaDaoService;
import model.classes.Piadina;

public class PiadinaService {
	private final PiadinaDaoService piadinaDaoService = new PiadinaDaoService();
	
	public List<Piadina> getPiadinas() {
		return piadinaDaoService.getPiadinas();
	}
	
	public void addPiadina(Piadina piadina) {
		piadinaDaoService.addPiadina(piadina);
	}
	
	public void removePiadina(int piadinaId) {
		piadinaDaoService.removePiadina(piadinaId);
	}
}
