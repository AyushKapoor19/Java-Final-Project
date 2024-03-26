package com.algonquin.cst8288.servlet;

import com.algonquin.cst8288.dao.UserDao;
import com.algonquin.cst8288.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDaoImpl(); // Instantiate UserDaoImpl

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the user is valid using UserDaoImpl
        if (userDao.isValidUser(username, password)) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("username", username); // Set username attribute in session
            response.sendRedirect("welcome.jsp"); // Redirect to a welcome page after successful login
        } else {
            // Failed login
            response.sendRedirect("login.jsp?error=1"); // Redirect back to login page with error parameter
        }
    }
}
