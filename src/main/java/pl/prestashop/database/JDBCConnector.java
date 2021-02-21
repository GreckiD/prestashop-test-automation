package pl.prestashop.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static pl.prestashop.config.BuildConfiguration.getTestData;

public class JDBCConnector {

    private String dbHost = getTestData("dbHost");
    private String dbUser = getTestData("dbUser");
    private String dbPassword = getTestData("dbPassword");

    public Connection connectToDataBase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dataBaseConnection = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        return dataBaseConnection;
    }

    public List<String> getNameAndLastNameOfCustomers() {
        List<String> customers = new ArrayList<>();
        try (Connection connection = connectToDataBase(); Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * from ps_customer");
            while (result.next()) {
                customers.add(result.getString("firstname") + " " + result.getString("lastname"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Nie udało się wykonać zapytania");
            e.printStackTrace();
        }
        return customers;
    }

    public void deleteOrder(String orderIdentifier) {
        try (Connection connection = connectToDataBase(); Statement statement = connection.createStatement()) {
            int rows = statement.executeUpdate("DELETE FROM ps_orders WHERE reference = '" + orderIdentifier + "'");
            System.out.println("Usuniętych zamówień: " + rows + ", " + "Identyfikator zamówienia: " + orderIdentifier);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Nie udało się usunąć zamówienia");
            e.printStackTrace();
        }
    }
}
