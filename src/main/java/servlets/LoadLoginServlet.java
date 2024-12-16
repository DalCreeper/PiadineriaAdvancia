package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class loadLoginServlet
 */
public class LoadLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoginServlet.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			Object rememberMe = httpSession.getAttribute("rememberMe");
			
			if("on".equals(rememberMe)) {
				log.info("Load login successful.");
		        response.sendRedirect(request.getContextPath() + "/dashboard");
		        return;
			}
		}
		log.warn("Load login session not found.");
    	request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}
}
