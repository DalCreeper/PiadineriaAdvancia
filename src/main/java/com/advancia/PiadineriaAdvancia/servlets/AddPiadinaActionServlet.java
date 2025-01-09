package com.advancia.PiadineriaAdvancia.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.advancia.PiadineriaAdvancia.model.classes.Dough;
import com.advancia.PiadineriaAdvancia.model.classes.Employee;
import com.advancia.PiadineriaAdvancia.model.classes.MeatBase;
import com.advancia.PiadineriaAdvancia.model.classes.OptionalElements;
import com.advancia.PiadineriaAdvancia.model.classes.Piadina;
import com.advancia.PiadineriaAdvancia.model.classes.PiadinaDeserialize;
import com.advancia.PiadineriaAdvancia.model.classes.Sauces;
import com.advancia.PiadineriaAdvancia.services.PiadinaComponentsService;
import com.advancia.PiadineriaAdvancia.services.PiadinaService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddPiadinaActionServlet
 */
public class AddPiadinaActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(AddPiadinaActionServlet.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			ObjectMapper mapper = new ObjectMapper();
			PiadinaDeserialize piadinaDeserialized = mapper.readValue(request.getInputStream(), PiadinaDeserialize.class);
			PiadinaComponentsService componentsService = new PiadinaComponentsService();
			Map<String, Set<Object>> components = componentsService.getPiadinaComponents();

			Set<Dough> doughs = castToSet(components.get("DOUGH"), Dough.class);
			Set<MeatBase> meatBase = castToSet(components.get("MEATBASE"), MeatBase.class);
			Set<Sauces> sauces = castToSet(components.get("SAUCES"), Sauces.class);
			Set<OptionalElements> optionalElements = castToSet(components.get("OPTIONALELEMENTS"), OptionalElements.class);

			Dough choosenDough = null;
			Set<MeatBase> choosenMeatBases = new HashSet<>();
			Set<Sauces> choosenSauces = new HashSet<>();
			Set<OptionalElements> choosenOptionalElements = new HashSet<>();
	        
	        for(Dough d : doughs) {
	        	if(piadinaDeserialized.getDough() == d.getId()) {
	        		choosenDough = d;
	        		break;
	        	}
	        }
	        for(int meatType : piadinaDeserialized.getMeatBase()) {
	            for(MeatBase m : meatBase) {
	                if(meatType == m.getId()) {
	                    choosenMeatBases.add(m);
	                }
	            }
	        }
	        for(int sauceType : piadinaDeserialized.getSauces()) {
	            for(Sauces s : sauces) {
	                if(sauceType == s.getId()) {
	                    choosenSauces.add(s);
	                }
	            }
	        }
	        for(int optionalType : piadinaDeserialized.getOptionalElements()) {
	            for(OptionalElements o : optionalElements) {
	                if(optionalType == o.getId()) {
	                    choosenOptionalElements.add(o);
	                }
	            }
	        }
	        
	        Piadina p = new Piadina(
	            piadinaDeserialized.getName(),
	            choosenDough,
	            choosenMeatBases,
	            choosenSauces,
	            choosenOptionalElements,
	            piadinaDeserialized.getPrice(),
	            (Employee) httpSession.getAttribute("user")
	        );
	        PiadinaService piadinaService = new PiadinaService();
	        piadinaService.addPiadina(p);
	        
	        log.info("Piadina {}\n\tSuccessfully added.", p.toString());
	        response.setStatus(HttpServletResponse.SC_OK);
	        return;
		}
		log.error("Load dashboard session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
	
	private static <T> Set<T> castToSet(Object attribute, Class<T> clazz) {
        if(attribute instanceof Set<?>) {
        	Set<?> tempList = (Set<?>) attribute;
        	Set<T> resultList = new HashSet<>();
            for(Object item : tempList) {
                if(clazz.isInstance(item)) {
                    resultList.add(clazz.cast(item));
                } else {
                    throw new IllegalArgumentException("Invalid type in list for " + clazz.getSimpleName());
                }
            }
            return resultList;
        } else {
            throw new IllegalArgumentException("Attribute is not a list");
        }
    }
}
