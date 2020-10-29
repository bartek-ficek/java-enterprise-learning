package com.isa.userengine.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();
        printWriter.write("<!DOCTYPE html><html><body>");

        printWriter.write(login +" " + password + "</br></br>");

        if (login.equals("isa@isa.pl") && password.equals("123456")) {
            printWriter.write("You're signed in!");
            printWriter.write("</br></br><a href=/admin>AdminPanel</a>");

            request.getSession().setAttribute("login",login);

        } else printWriter.write("Wrong signing data!");

        printWriter.write("</body></html>");

    }
}
