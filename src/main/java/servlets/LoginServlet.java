package servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;

import model.utils.ConsoleUtils;
import model.utils.TokenUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(LoginServlet.class.getName());
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
			String token = TokenUtil.generateToken();
			
			httpSession.setAttribute("user", username);
            httpSession.setAttribute("token", token);
            
            if("on".equals(rememberMe)) {
                Cookie tokenCookie = new Cookie("auth_token", token);
                tokenCookie.setHttpOnly(true);
                tokenCookie.setMaxAge(60 * 60 * 24 * 14);
                response.addCookie(tokenCookie);
            }
        	//log.info("Login successful for user = " + username);
    		//log("prova test");
        	ConsoleUtils.print("S", "Login successful for user", username);
        	request.getRequestDispatcher("/LoadDashboardServlet").forward(request, response);
        } else {
        	ConsoleUtils.print("S", "Login failed for user", username);
            httpSession.setAttribute("errorMessage", "Invalid username or password!");
            response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
        }
	}
}



























