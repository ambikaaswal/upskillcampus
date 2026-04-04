package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import dao.ServiceDAO;

@WebServlet("/viewServices")
public class ViewServicesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServiceDAO dao = new ServiceDAO();
        request.setAttribute("services", dao.getAllServices());

        RequestDispatcher rd = request.getRequestDispatcher("/views/services.jsp");
        rd.forward(request, response);
    }
}