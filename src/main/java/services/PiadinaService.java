package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.classes.Piadina;

public class PiadinaService {
	private static Piadina[] piadinasTemp = Piadina.hardCodedList();
	
	public static Piadina[] getPiadinas() {
		return piadinasTemp;
	}
	
	public static void addPiadina(Piadina p) {
		List<Piadina> listTemp = new ArrayList<>(Arrays.asList(piadinasTemp));
		listTemp.add(p);
		
		piadinasTemp = listTemp.stream().toArray(Piadina[]::new);
	}
	
	public static void removePiadina(Piadina p) {
		List<Piadina> listTemp = new ArrayList<>(Arrays.asList(piadinasTemp));
		listTemp.remove(p);
		
		piadinasTemp = listTemp.stream().toArray(Piadina[]::new);
	}
}
