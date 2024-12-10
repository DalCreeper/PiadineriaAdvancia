package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import model.utils.ConsoleUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VALID_USERNAME = "Mike";
    private static final String VALID_PASSWORD = "Prova.1";

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		response.setContentType("text/jsp/");
		PrintWriter out = response.getWriter();
		
		out.println(
		  "<!DOCTYPE html>\n"
		+ "<html lang=\"en\">\n"
		+ "<head>\n"
		+ "    <meta charset=\"UTF-8\">\n"
		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
		+ "    <title>PiadineriaAdvancia Dashboard</title>\n"
		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n"
		+ "	<link rel=\"stylesheet\" href=\"resources/css/stylesDash.css\">\n"
		+ "</head>\n"
		+ "<body>\n");
		
		out.println("<h2>Login</h2>\n");
		
		out.println(
		  "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n"
	    + "</body>\n"
	    + "</html>\n");
		
		out.close();
		*/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
        	ConsoleUtils.print("S", "Login successful for user", username);
        	request.setAttribute("user", username);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
        	ConsoleUtils.print("S", "Login failed for user", username);
            request.setAttribute("errorMessage", "Invalid username or password!");
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
        }
	}
}



























