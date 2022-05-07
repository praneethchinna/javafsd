package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class SuccessServlet extends HttpServlet
{
    private static final long serialVersionUID=1L;

    public SuccessServlet()
    {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        PrintWriter out=resp.getWriter();
        out.println("<h4> welocme"+ req.getParameter("username")+" login successfull </h4>");

    }
}