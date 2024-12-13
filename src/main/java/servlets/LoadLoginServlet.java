package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.utils.ConsoleUtils;

/**
 * Servlet implementation class loadLoginServlet
 */
public class LoadLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			Object rememberMe = httpSession.getAttribute("rememberMe");
			
			if("on".equals(rememberMe)) {
				ConsoleUtils.print("S", "Load login successful.");
		        response.sendRedirect(request.getContextPath() + "/LoadDashboardServlet");
		        return;
			}
		}
		ConsoleUtils.print("W", "Load login session not found.");
    	request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}
}
