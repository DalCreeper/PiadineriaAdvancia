package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class AddPiadinaActionServlet
 */
public class AddPiadinaActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoginServlet.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		ObjectMapper mapper = new ObjectMapper();
        PiadinaDeserialize piadinaDeserialized = mapper.readValue(request.getInputStream(), PiadinaDeserialize.class);
        Dough[] hardCodedDoughs = Dough.hardCodedList();
        MeatBase[] hardCodedMeatBases = MeatBase.hardCodedList();
        Sauces[] hardCodedSauces = Sauces.hardCodedList();
        OptionalElements[] hardCodedOptionalElements = OptionalElements.hardCodedList();
        Dough choosenDough = null;
        List<MeatBase> choosenMeatBases = new ArrayList<>();
        List<Sauces> choosenSauces = new ArrayList<>();
        List<OptionalElements> choosenOptionalElements = new ArrayList<>();
        
        for(Dough d : hardCodedDoughs) {
        	if(piadinaDeserialized.getDough().equals(d.getType())) {
        		choosenDough = d;
        		break;
        	}
        }
        for(String meatType : piadinaDeserialized.getMeatBase()) {
            for(MeatBase m : hardCodedMeatBases) {
                if(meatType.equals(m.getType())) {
                    choosenMeatBases.add(m);
                }
            }
        }
        for(String sauceType : piadinaDeserialized.getSauces()) {
            for(Sauces s : hardCodedSauces) {
                if(sauceType.equals(s.getType())) {
                    choosenSauces.add(s);
                }
            }
        }
        for(String optionalType : piadinaDeserialized.getOptionalElements()) {
            for(OptionalElements o : hardCodedOptionalElements) {
                if(optionalType.equals(o.getType())) {
                    choosenOptionalElements.add(o);
                }
            }
        }
        
        Piadina p = new Piadina(
            piadinaDeserialized.getName(),
            choosenDough,
            choosenMeatBases.toArray(new MeatBase[0]),
            choosenSauces.toArray(new Sauces[0]),
            choosenOptionalElements.toArray(new OptionalElements[0]),
            piadinaDeserialized.getPrice(),
            (Employee) httpSession.getAttribute("user")
        );
        
        log.info("Piadina {}\n\tSuccessfully added.", p.toString());
        response.setStatus(HttpServletResponse.SC_OK);
	}
}
