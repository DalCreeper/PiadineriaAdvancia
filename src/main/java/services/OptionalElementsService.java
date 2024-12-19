package services;

import java.util.List;

import dao.services.OptionalElementsServiceDao;
import model.classes.OptionalElements;

public class OptionalElementsService {
	private OptionalElementsServiceDao optionalElementsServiceDao = new OptionalElementsServiceDao();
	
	public List<OptionalElements> getOptionalElements() {
		return optionalElementsServiceDao.getOptionalElements();
	}
}