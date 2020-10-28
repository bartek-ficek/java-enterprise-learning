package com.isa.userengine.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessionLogin = (String) request.getSession().getAttribute("login");
        if (sessionLogin==null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<!DOCTYPE html><html><body><h2>Panel Administracyjny</h2></body></html>");
        }
    }
}
