package dao;

import java.sql.*;
import java.util.*;
import model.Service;
import util.DBConnection;

public class ServiceDAO {

    public boolean addService(Service service) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO services(title, description, price, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, service.getTitle());
            ps.setString(2, service.getDescription());
            ps.setDouble(3, service.getPrice());
            ps.setInt(4, service.getUserId());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Service> getAllServices() {
        List<Service> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM services";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt("id"));
                s.setTitle(rs.getString("title"));
                s.setDescription(rs.getString("description"));
                s.setPrice(rs.getDouble("price"));
                s.setUserId(rs.getInt("user_id"));

                list.add(s);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}