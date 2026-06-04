import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Program{
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    "root",
                    "upupandaway2"
            );
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        }
    }
