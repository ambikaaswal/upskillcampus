// import java.sql.Connection;
// import java.sql.DriverManager;

// public class DBConnection {
//     public static void main(String[] args) {
//         try {
//             String url = "jdbc:mysql://localhost:3306/marketplace";
//             String user = "root";
//             String password = "SqlServer@1757";  // replace this

//             Connection con = DriverManager.getConnection(url, user, password);

//             System.out.println("Connected successfully!");

//             con.close();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/marketplace";
    private static final String USER = "root";
    private static final String PASSWORD = "SqlServer@1757";

    // The database password is set to "". 
    // Please update it according to your local MySQL configuration before running the project.
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}