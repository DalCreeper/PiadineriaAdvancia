package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.utils.ConsoleUtils;

/**
 * Servlet implementation class AddPiadinaServlet
 */
public class AddPiadinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			Object doughs = httpSession.getAttribute("doughs");
			Object mBases = httpSession.getAttribute("mBases");
			Object sauces = httpSession.getAttribute("sauces");
			Object oElements = httpSession.getAttribute("oElements");
			
			if(doughs != null && mBases != null && sauces != null && oElements != null) {
				ConsoleUtils.print("S", "AddPiadina opening successful.");
				response.sendRedirect(request.getContextPath() + "/addForm.jsp");
			} else {
				ConsoleUtils.print("W", "AddPiadina opening failed.");
				request.getRequestDispatcher("/LoadLoginServlet").forward(request, response);
			}
		} else {
			ConsoleUtils.print("E", "AddPiadina session not found.");
			request.getRequestDispatcher("/LoadLoginServlet").forward(request, response);
		}
	}
}
