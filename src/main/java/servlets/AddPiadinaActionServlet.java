package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.classes.Dough;
import model.classes.Employee;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Piadina;
import model.classes.PiadinaDeserialize;
import model.classes.Sauces;
import services.PiadinaComponentsService;
import services.PiadinaService;

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
			Map<String, List<Object>> components = componentsService.getPiadinaComponents();

	        List<Dough> doughs = castToList(components.get("DOUGH"), Dough.class);
	        List<MeatBase> meatBase = castToList(components.get("MEATBASE"), MeatBase.class);
	        List<Sauces> sauces = castToList(components.get("SAUCES"), Sauces.class);
	        List<OptionalElements> optionalElements = castToList(components.get("OPTIONALELEMENTS"), OptionalElements.class);

			Dough choosenDough = null;
	        List<MeatBase> choosenMeatBases = new ArrayList<>();
	        List<Sauces> choosenSauces = new ArrayList<>();
	        List<OptionalElements> choosenOptionalElements = new ArrayList<>();
	        
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
        		1,
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
	
	private static <T> List<T> castToList(Object attribute, Class<T> clazz) {
        if(attribute instanceof List<?>) {
            List<?> tempList = (List<?>) attribute;
            List<T> resultList = new ArrayList<>();
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
