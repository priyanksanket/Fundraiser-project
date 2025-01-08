package com.user.controller;

import com.user.service.UserService;
import com.user.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ProfileServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("profile.jsp").forward(request, response); // Show user profile
        } else {
            response.sendRedirect("login.html"); // Redirect to login if not logged in
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            user.setName(name);
            user.setPhone(phone);
            user.setAddress(address);

            boolean success = userService.updateUser(user);
            if (success) {
                session.setAttribute("user", user);
                response.sendRedirect("profile.jsp"); // Redirect to updated profile
            } else {
                response.sendRedirect("profile.jsp?error=updateFailed"); // Redirect with error
            }
        } else {
            response.sendRedirect("login.html"); // Redirect to login if not logged in
        }
    }
}
