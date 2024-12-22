package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.PiadinaComponentsService;

/**
 * Servlet implementation class LoadAddPiadinaServlet
 */
public class LoadAddPiadinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoadAddPiadinaServlet.class);
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			PiadinaComponentsService componentsService = new PiadinaComponentsService();

			Map<String, List<Object>> components = componentsService.getPiadinaComponents();
			request.setAttribute("doughs", components.get("DOUGH"));
			request.setAttribute("mBases", components.get("MEATBASE"));
			request.setAttribute("sauces", components.get("SAUCES"));
			request.setAttribute("oElements", components.get("OPTIONALELEMENTS"));
			log.info("Load AddPiadina successful.");
			request.getRequestDispatcher("addForm.jsp").forward(request, response);
			return;
		}
		log.error("Load AddPiadina session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}
