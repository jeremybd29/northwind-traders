import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;


public class Program{
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    "root",
                    "upupandaway2"
            );
            System.out.println("Connected!");

            Scanner scanner = new Scanner(System.in);
            System.out.print("what would you like to do?");
            System.out.print("1) Display all products");
            System.out.print("2) Display all customers");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == 1){

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
            } else if (choice == 2){
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(
                        "SELECT ContactName, CompanyName, City, Country, Phone "+
                                "FROM Customers "+
                                "ORDER BY Country"
                );

                while (resultSet.next()) {

                    System.out.println(
                            resultSet.getString("ContactName") +" | " +
                                    resultSet.getString("CompanyName") + " | " +
                                    resultSet.getString("City") + " | " +
                                    resultSet.getString("Country") + " | " +
                                    resultSet.getString("Phone")

                    );
                }

                }
            }
            catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        }
    }
