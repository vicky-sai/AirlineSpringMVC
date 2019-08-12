package com.application.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
    public void doFilter(ServletRequest req, ServletResponse res,
                FilterChain chain) throws IOException,
                ServletException {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            String url = request.getServletPath();

            response.setHeader("pragma", "no-cache");              
            response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
            response.setHeader("Expires", "0"); 
            HttpSession session = request.getSession(false);

            Boolean  byPassFilter = url.contains("login.do") || url.contains("signup.do")||url.contains("validateLogin.do") || url.contains("registration.do");
            if(session!=null && session.getAttribute("admin")!=null || byPassFilter)
            	chain.doFilter(req, res);
            else {
                response.sendRedirect("login.do"); // here goto http://yourdoamin/login.html
               // return; //break filter chain, requested JSP/servlet will not be executed
            }

            
        }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
