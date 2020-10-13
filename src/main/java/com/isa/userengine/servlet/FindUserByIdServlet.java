package com.isa.userengine.servlet;

import com.isa.userengine.domain.User;
import com.isa.userengine.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

//        response.setContentType("text/html;charset=UTF-8");

        UserService userService = new UserService();
        User foundUser = userService.findById(Long.parseLong(idParam));
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        if (foundUser != null) {
            writer.println("ID: " + foundUser.getId() + "<br>");
            writer.println("Name: " + foundUser.getName() + "<br>");
            writer.println("Login: " + foundUser.getLogin() + "<br>");
            writer.println("Age: " + foundUser.getAge() + "<br>");
        } else {
            writer.println("User has not been found. Please type correct Id");
        }

        writer.println("</body");
        writer.println("</html");
    }
}
