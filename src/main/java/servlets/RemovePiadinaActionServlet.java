package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.classes.Piadina;
import services.PiadinaService;

/**
 * Servlet implementation class RemovePiadinaActionServlet
 */
public class RemovePiadinaActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(RemovePiadinaActionServlet.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			StringBuilder jsonBuffer = new StringBuilder();
			
	        try(BufferedReader reader = request.getReader()) {
	            String line;
	            while((line = reader.readLine()) != null) {
	                jsonBuffer.append(line);
	            }
	        }
	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        String piadinaName = objectMapper.readValue(jsonBuffer.toString(), String.class);

			if(piadinaName != null && !piadinaName.isEmpty()) {
				Piadina[] piadinas = PiadinaService.getPiadinas();
				Piadina piadinaToRemove = null;
				
				for(Piadina p : piadinas) {
					if(p.getName().equalsIgnoreCase(piadinaName)) {
						piadinaToRemove = p;
						break;
					}
				}
				
				if(piadinaToRemove != null) {
					PiadinaService.removePiadina(piadinaToRemove);
					log.info("Piadina '{}' successfully removed.", piadinaName);
					response.setStatus(HttpServletResponse.SC_OK);
				} else {
					log.warn("Piadina '{}' not found.", piadinaName);
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
			} else {
				log.error("Piadina name parameter is missing or invalid.");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			return;
		}
		log.error("Load dashboard session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}
