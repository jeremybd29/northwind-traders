import java.sql.*;
import java.sql.ResultSet;


public class Program{
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    "root",
                    "upupandaway2"
            );
            System.out.println("Connected!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT ProductName FROM Products");
            while(resultSet.next()){
                System.out.println(resultSet.getString("ProductName"));
            }



        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        }
    }
