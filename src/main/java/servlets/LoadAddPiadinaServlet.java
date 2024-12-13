package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.enums.Dough;
import model.enums.MeatBase;
import model.enums.OptionalElements;
import model.enums.Sauces;
import model.utils.ConsoleUtils;

/**
 * Servlet implementation class LoadAddPiadinaServlet
 */
public class LoadAddPiadinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			httpSession.setAttribute("doughs", doughs);
			httpSession.setAttribute("mBases", mBases);
			httpSession.setAttribute("sauces", sauces);
			httpSession.setAttribute("oElements", oElements);
			ConsoleUtils.print("S", "Load AddPiadina successful.");
			request.getRequestDispatcher("addForm.jsp").forward(request, response);
		} else {
			ConsoleUtils.print("E", "Load AddPiadina session not found.");
			request.getRequestDispatcher("LoadLoginServlet").forward(request, response);
		}
	}
}
