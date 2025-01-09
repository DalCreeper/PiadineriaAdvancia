package com.advancia.PiadineriaAdvancia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(LogoutServlet.class);
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		
		if(httpSession != null) {
			httpSession.invalidate();
			log.info("Logout successful.");
			response.sendRedirect(request.getContextPath() + "/loadLogin");
	        return;
		}
		log.error("Logout failed.");
		response.sendRedirect(request.getContextPath() + "/loadLogin");
	}
}