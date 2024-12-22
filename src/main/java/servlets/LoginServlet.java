package servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.classes.Employee;
import services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoginServlet.class);
	private UserService userService = new UserService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
        String rememberMe = request.getParameter("rememberMe");
        
        Optional<Employee> employee = getEmployeeOrFail(request, response);
        if(employee.isPresent()) {
        	httpSession.setAttribute("user", employee.get());
    		httpSession.setAttribute("rememberMe", rememberMe);
        	response.sendRedirect(request.getContextPath() + "/dashboard");
        }
	}

	private Optional<Employee> getEmployeeOrFail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		
		try {
			Employee employee = userService.getUser(username, password);
			log.info("Login successful for user = {}", username);
        	return Optional.of(employee);
        } catch(Exception e) {
        	log.warn("Login failed for user = {}", username);
            httpSession.setAttribute("errorMessage", "Invalid username or password!");
            response.sendRedirect(request.getContextPath() + "/loadLogin");
            return Optional.empty();
        }
	}
}