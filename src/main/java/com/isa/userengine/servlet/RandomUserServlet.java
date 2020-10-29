package com.isa.userengine.servlet;

import com.isa.userengine.cdi.RandomUserCDIApplicationDaoBean;
import com.isa.userengine.cdi.RandomUserCDIRequestDaoBean;
import com.isa.userengine.cdi.RandomUserCDISessionDaoBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-user")
public class RandomUserServlet extends HttpServlet {

    @Inject
    RandomUserCDIApplicationDaoBean applicationDaoBean;
    @Inject
    RandomUserCDIRequestDaoBean requestDaoBean;
    @Inject
    RandomUserCDISessionDaoBean sessionDaoBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer  = response.getWriter();
        writer.println("<!DOCTYPE html><html><body>");
        writer.println("<h1>Request</h1>"+ "<br>");
        writer.println(requestDaoBean.getRandomUser().getLogin() + "<br>");
        writer.println("<h1>Application</h1>"+ "<br>");
        writer.println(applicationDaoBean.getRandomUser().getLogin() + "<br>");
        writer.println("<h1>Session</h1>"+ "<br>");
        writer.println(sessionDaoBean.getRandomUser().getLogin() + "<br>");
        writer.println("</body></html>");
    }
}
