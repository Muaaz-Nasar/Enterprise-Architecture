package jdbc_wamp_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3308/mydb"; 
        String username = "root";
        String password = "";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students"); // your table

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name"));
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
