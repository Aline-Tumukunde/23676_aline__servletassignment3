package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        String password = (String) request.getSession().getAttribute("password");
        boolean isAuthenticated = checkAuthentication(email, password);

        if (isAuthenticated) {
            PrintWriter out = response.getWriter();
            out.println("Welcome " + email);
            request.getRequestDispatcher("resetpassword.html").forward(request, response);
        } else {
//            request.getRequestDispatcher("home.html").forward(request, response);
            response.sendRedirect("home.html");
        }
    }
    private boolean checkAuthentication(String email, String password) {
    	 String demoEmail = "tumukunde250@gmail.com";
    	    String demoPassword = "12345";
    	    if (demoEmail.equals(null) && demoPassword.equals(null)) {
    	        return true;
    	    } else {
    	        return false; 
    	    }
    }
    }

