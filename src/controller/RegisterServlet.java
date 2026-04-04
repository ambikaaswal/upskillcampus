package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import dao.UserDAO;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        //String password = request.getParameter("password");

        String password = request.getParameter("password");

        // hash password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        // store hashed password
        user.setPassword(hashedPassword);
        if(name=="admin" && password.equals("Market@Place")){
            user.setRole("admin");
        }else{
            user.setRole(role); // default role
        }
        UserDAO dao = new UserDAO();
        boolean result = dao.registerUser(user);

        if (result) {
            response.getWriter().println("Registration Successful!");
        } else {
            response.getWriter().println("Error!");
        }
    }
}