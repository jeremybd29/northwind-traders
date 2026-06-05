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
                    "SELECT ProductID, ProductName, UnitPrice, UnitsInStock  FROM Products");
            while(resultSet.next()){
                System.out.println(resultSet.getString("ProductID") + " " +
                        resultSet.getString("ProductName")+ " " +
                        resultSet.getDouble("UnitPrice") + " " + " Stock:"+
                        resultSet.getInt("UnitsInStock")

                );
            }

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        }
    }
