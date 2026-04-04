package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import dao.BookingDAO;
import model.Booking;
import model.User;

@WebServlet("/bookService")
public class BookServiceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        if (user == null || !"customer".equals(user.getRole())) {
            response.sendRedirect("/marketplace/views/login.html");
            return;
        }

        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        Booking booking = new Booking();
        booking.setServiceId(serviceId);
        booking.setCustomerId(user.getId());

        BookingDAO dao = new BookingDAO();
        dao.addBooking(booking);

        response.sendRedirect("/marketplace/viewServices?success=1");
    }
}