package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Cookie[] cookies = httpRequest.getCookies();
        String token = null;
        
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if("auth_token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }

        HttpSession session = httpRequest.getSession(false);
        
        if(session != null && token != null && token.equals(session.getAttribute("token"))) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/loginForm.jsp");
        }
    }
}
