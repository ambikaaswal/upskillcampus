package dao;

import java.sql.*;
import model.User;
import util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
public class UserDAO {

    public boolean registerUser(User user) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public User loginUser(String email, String password) {

    User user = null;

    try {
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM users WHERE email=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, email);
        // ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        // if (rs.next()) {
        //     user = new User();
        //     user.setName(rs.getString("name"));
        //     user.setEmail(rs.getString("email"));
        //     user.setPassword(rs.getString("password"));
        // }


        if (rs.next()) {
            String storedHashedPassword = rs.getString("password");

            if (BCrypt.checkpw(password, storedHashedPassword)) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(storedHashedPassword);
                user.setRole(rs.getString("role"));
                // return user; // login success
            }
        }
        // return null; // login failed
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return user; //final return
}
}