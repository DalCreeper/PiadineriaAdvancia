package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.classes.Dough;
import model.classes.MeatBase;
import model.classes.OptionalElements;
import model.classes.Sauces;

/**
 * Servlet implementation class LoadAddPiadinaServlet
 */
public class LoadAddPiadinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoadAddPiadinaServlet.class);
	private static final Dough[] doughs = Dough.hardCodedList();
	private static final MeatBase[] mBases = MeatBase.hardCodedList();
	private static final Sauces[] sauces = Sauces.hardCodedList();
	private static final OptionalElements[] oElements = OptionalElements.hardCodedList();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			request.setAttribute("doughs", doughs);
			request.setAttribute("mBases", mBases);
			request.setAttribute("sauces", sauces);
			request.setAttribute("oElements", oElements);
			log.info("Load AddPiadina successful.");
			request.getRequestDispatcher("addForm.jsp").forward(request, response);
			return;
		}
		log.error("Load AddPiadina session not found.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}
