package com.advancia.PiadineriaAdvancia.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.advancia.PiadineriaAdvancia.model.classes.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LoginServlet.class);

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
	    String loginJson = createLoginJson(username, password);
	    String apiUrl = "http://localhost:8080/PiadineriaAdvancia/api/users/login";
	    String responseJson = sendPostRequest(apiUrl, loginJson);

	    if(responseJson != null) {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Employee employee = objectMapper.readValue(responseJson, Employee.class);
	        log.info("Login successful for user = {}", username);

	        return Optional.of(employee);
	    } else {
	        log.warn("Login failed for user = {}", username);
	        httpSession.setAttribute("errorMessage", "Invalid username or password!");
	        response.sendRedirect(request.getContextPath() + "/loadLogin");
	        return Optional.empty();
	    }
	}

	private String createLoginJson(String username, String password) {
	    return "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
	}

	private String sendPostRequest(String apiUrl, String jsonInputString) throws IOException {
	    URL url = new URL(apiUrl);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/json");
	    connection.setDoOutput(true);

	    try(OutputStream os = connection.getOutputStream()) {
	        byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
	        os.write(input, 0, input.length);
	    }

	    try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
	        StringBuilder response = new StringBuilder();
	        String responseLine;
	        while((responseLine = br.readLine()) != null) {
	            response.append(responseLine.trim());
	        }
	        return response.toString();
	    } catch(IOException e) {
	        return null;
	    }
	}
}