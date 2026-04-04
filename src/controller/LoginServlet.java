package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import dao.UserDAO;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.loginUser(email, password);

        if (user != null) {
            // login success
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // response.getWriter().println("Login Successful!");
            //old code without roles:
            // response.sendRedirect("/marketplace/views/dashboard.jsp");
            if (user.getRole().equals("admin")) {
                response.sendRedirect("/marketplace/views/admin.jsp");
            } else if (user.getRole().equals("merchant")) {
                response.sendRedirect("/marketplace/views/merchant.jsp");
            } else {
                response.sendRedirect("/marketplace/views/dashboard.jsp");
            }

        } else {
            // login failed
            response.sendRedirect("/marketplace/views/login.html");
        }
    }
}