
package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet
{
    private static final long serialVersionUID=1L;

    public LoginController()
    {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        RequestDispatcher rd=null;
        if(username.equalsIgnoreCase("tom")&& password.equals("jerry"))
        {
            rd=req.getRequestDispatcher("SuccessServlet");
            rd.forward(req,resp);

        }
        else
            rd=req.getRequestDispatcher("index.jsp");
        PrintWriter out=resp.getWriter();
        rd.include(req,resp);
        out.println("<center><span style='color:red'>Invalid Credentials!!</span></center>");
    }
}
