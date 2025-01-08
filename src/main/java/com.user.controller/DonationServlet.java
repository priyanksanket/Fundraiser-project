package com.user.controller;

import com.user.dao.UseDao;
import com.user.model.Donation;
import com.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DonationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Added serialVersionUID to avoid warning

    private UseDao useDao;

    @Override
    public void init() {
        useDao = new UseDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve donation history
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("loggedInUser");

        if (user != null) {
            int userId = user.getUserId();
            List<Donation> donations = useDao.getDonationsByUser(userId);

            request.setAttribute("donations", donations);
            request.getRequestDispatcher("/WEB-INF/views/donationHistory.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle donation submission
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("loggedInUser");

        if (user != null) {
            int userId = user.getUserId();
            String donationType = request.getParameter("donationType");
            double donationAmount = Double.parseDouble(request.getParameter("donationAmount"));
            String donationDescription = request.getParameter("donationDescription");

            Donation donation = new Donation();
            donation.setUserId(userId);
            donation.setDonationType(donationType);
            donation.setDonationAmount(donationAmount);
            donation.setDonationDescription(donationDescription);

            boolean isSuccess = useDao.insertDonation(donation);

            if (isSuccess) {
                response.sendRedirect("donation?success=true");
            } else {
                response.sendRedirect("donation?error=true");
            }
        } else {
            response.sendRedirect("login.html");
        }
    }
}

