package com.isa.userengine.servlet;

import com.isa.userengine.domain.User;
import com.isa.userengine.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name","Beniaminek");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        PrintWriter writer = response.getWriter();

        UserService userService = new UserService();
        userService.save(user);
        if (user.getId()!=null) {
            writer.println("<!DOCTYPE html><html><body><h2>User saved correctly in DB.</h2></body></html>");
        }

        writer.println("<!DOCTYPE html><html><body>" + user + "</body></html>");

    }
}
