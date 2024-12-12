package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.classes.Piadina;
import model.utils.ConsoleUtils;

/**
 * Servlet implementation class LoadDashboardServlet
 */
public class LoadDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Piadina[] piadinasTemp = Piadina.randomList(4);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			Object user = httpSession.getAttribute("user");
			
			if(user != null) {
				httpSession.setAttribute("piadinas", piadinasTemp);
				ConsoleUtils.print("S", "Load dashboard successful.");
		        request.getRequestDispatcher("/DashboardServlet").forward(request, response);
		    } else {
		    	httpSession.invalidate();
		    	ConsoleUtils.print("W", "Load dashboard failed.");
		    	request.getRequestDispatcher("/LoadLoginServlet").forward(request, response);
		    }
		} else {
			ConsoleUtils.print("E", "Load dashboard session not found.");
			request.getRequestDispatcher("/LoadLoginServlet").forward(request, response);
		}
	}
}