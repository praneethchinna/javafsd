package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		 request.getRequestDispatcher("Link.html").include(request, response);
		
		
		
		Cookie ck[]=request.getCookies();
		if(ck!=null)
		{
			String name=ck[0].getValue();
			if (!name.equals("")||name!=null) {
				
				out.println("welcome to profile");
				out.println(name);	
			}
			else
			{
				out.println("please login first");
				request.getRequestDispatcher("Login.html").include(request, response);
			}
			out.close();
			
		} 
		
	}

}
