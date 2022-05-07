package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 PrintWriter out=response.getWriter();
		 
		 request.getRequestDispatcher("Link.html").include(request, response);
		 
		 String name=request.getParameter("name");
		 String password=request.getParameter("password");
		 
		 if (name.equals("praneeth")&&password.equals("chinna")) {
			 out.println("Login Successfully ln welcome"+name);
			 
			 Cookie co=new Cookie("name",name);
			 response.addCookie(co);
			 
			 
			
		}
		 else
			 out.println("username or password are incorrect");
		 out.close();
		 
		 
	}

}
