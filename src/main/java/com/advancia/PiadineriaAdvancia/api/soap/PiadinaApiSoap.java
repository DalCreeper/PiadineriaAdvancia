package com.advancia.PiadineriaAdvancia.api.soap;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.advancia.PiadineriaAdvancia.model.api.PiadinaServiceApi;
import com.advancia.PiadineriaAdvancia.model.classes.Piadina;
import com.advancia.PiadineriaAdvancia.services.PiadinaService;

@WebService
public class PiadinaApiSoap implements PiadinaServiceApi {
	private final PiadinaService piadinaService = new PiadinaService();

	@Override
	public List<Piadina> getPiadinas() {
		try {
			List<Piadina> piadinas = piadinaService.getPiadinas();
            if(piadinas != null && !piadinas.isEmpty()) {
                return piadinas;
            } else {
                throw new RuntimeException("No piadinas found");
            }
        } catch(Exception e) {
            throw new RuntimeException("An error occurred while retrieving piadinas", e);
        }
	}

	@Override
	public String test(@WebParam(name = "message") String message) {
		return "Message test -> " + message + "!";
	}
}
