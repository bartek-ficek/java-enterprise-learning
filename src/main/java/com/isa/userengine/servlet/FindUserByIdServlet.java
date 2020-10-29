package com.isa.userengine.servlet;

import com.isa.userengine.cdi.MaxPulseBean;
import com.isa.userengine.domain.Gender;
import com.isa.userengine.domain.User;
import com.isa.userengine.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    private double pulse;

    @Inject
    UserService userService;

    @Inject
    MaxPulseBean maxPulseBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isBlank()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        User foundUser = userService.findById(Long.parseLong(idParam));
        PrintWriter writer = response.getWriter();

        if (foundUser.getGender()== Gender.MAN) {
            pulse = maxPulseBean.maxPulseOfMan(foundUser);
        } else {
            pulse = maxPulseBean.maxPulseOfWoman(foundUser);
        }

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        if (foundUser != null) {
            writer.println("ID: " + foundUser.getId() + "<br>");
            writer.println("Name: " + foundUser.getName() + "<br>");
            writer.println("Gender: " + foundUser.getGender() + "<br>");
            writer.println("Max Pulse: " + pulse + "<br>");
            writer.println("Login: " + foundUser.getLogin() + "<br>");
            writer.println("Age: " + foundUser.getAge() + "<br>");
        } else {
            writer.println("User has not been found. Please type correct Id");
        }

        writer.println("</body");
        writer.println("</html");
    }
}
