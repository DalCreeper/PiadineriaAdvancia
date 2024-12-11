package servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;

import model.utils.ConsoleUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log1 = Logger.getLogger(LoginServlet.class.getName());
	private static final String VALID_USERNAME = "Mike";
    private static final String VALID_PASSWORD = "Prova.1";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        
        if(VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
        	log1.warning("Login successful for user = " + username);
    		//log("prova test");
        	//ConsoleUtils.print("S", "Login successful for user", username);
        	httpSession.setAttribute("user", username);
        	response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        	
        	/*
        	 * check session if yes forward dashbord.jsp not -> "/loginForm.jsp"
        	 * 
        	 */
        } else {
        	ConsoleUtils.print("S", "Login failed for user", username);
            httpSession.setAttribute("errorMessage", "Invalid username or password!");
            response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
        }
	}
}



























