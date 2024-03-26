package com.algonquin.cst8288.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session to log out the user
        HttpSession session = request.getSession(false); // Get the existing session, or null if there is no session
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        // Redirect the user to a logout confirmation page or back to the login page
        response.sendRedirect("logoutConfirmation.jsp");
    }
}
