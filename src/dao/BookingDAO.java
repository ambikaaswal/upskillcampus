package dao;

import java.sql.*;
import model.Booking;
import util.DBConnection;

public class BookingDAO {

    public boolean addBooking(Booking booking) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO bookings(service_id, customer_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, booking.getServiceId());
            ps.setInt(2, booking.getCustomerId());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}