package servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.classes.Employee;
import model.enums.Role;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoginServlet.class);
	private static final Employee user = new Employee(UUID.randomUUID().toString(), "Mike", "Sullivan", "Mike", 1997, Role.COUNTER_STAFF);
	private static final String VALID_USERNAME = "Mike";
    private static final String VALID_PASSWORD = "Prova.1";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        
        if(VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
			httpSession.setAttribute("user", user);
			httpSession.setAttribute("rememberMe", rememberMe);
            
        	log.info("Login successful for user = {}", username);
        	response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
        	log.warn("Login failed for user = {}", username);
            httpSession.setAttribute("errorMessage", "Invalid username or password!");
            response.sendRedirect(request.getContextPath() + "/loadLogin");
        }
	}
}



























