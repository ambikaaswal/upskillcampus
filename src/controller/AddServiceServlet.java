package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import dao.ServiceDAO;
import model.Service;
import model.User;

@WebServlet("/addService")
public class AddServiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        if (user == null || !"merchant".equals(user.getRole())) {
            response.sendRedirect("/marketplace/views/login.html");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Service service = new Service();
        service.setTitle(title);
        service.setDescription(description);
        service.setPrice(price);
        service.setUserId(user.getId());

        ServiceDAO dao = new ServiceDAO();
        dao.addService(service);

        response.sendRedirect("/marketplace/views/merchant.jsp");
    }
}