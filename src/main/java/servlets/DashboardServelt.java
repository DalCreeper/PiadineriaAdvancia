package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashboardServelt
 */
public class DashboardServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String piadinas = request.getParameter("piadinas");
		
		if(request.getSession(false) != null) {
			if(piadinas != null) {
				response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
			} else {
				request.getRequestDispatcher("/LoadDashboardServlet").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/LoadLoginServlet").forward(request, response);
		}
	}
}
