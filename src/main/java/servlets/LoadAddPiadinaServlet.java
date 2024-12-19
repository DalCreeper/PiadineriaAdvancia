package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.DoughService;
import services.MeatBaseService;
import services.OptionalElementsService;
import services.SaucesService;

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
			DoughService doughService = new DoughService();
			MeatBaseService meatBaseService = new MeatBaseService();
			SaucesService saucesService = new SaucesService();
			OptionalElementsService optionalElementsService = new OptionalElementsService();
			request.setAttribute("doughs", doughService.getDoughs());
			request.setAttribute("mBases", meatBaseService.getMeatBases());
			request.setAttribute("sauces", saucesService.getSauces());
			request.setAttribute("oElements", optionalElementsService.getOptionalElements());
			log.info("Load AddPiadina successful.");
			request.getRequestDispatcher("addForm.jsp").forward(request, response);
			return;
		}
		log.error("Load AddPiadina session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}
