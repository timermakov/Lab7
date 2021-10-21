package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String login = "s311733";
    private static String password = "klv733";
    private static String URL = "jdbc:postgresql://pg:5432/studs";
    private static Connection connection = null;
    public static boolean isConnected() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, login, password);

        } catch (SQLException e) {
            System.out.println("Подключение разорвано");
        }
        if (connection != null) {
            return true;
        } else {
            System.out.println("Не удалось подключиться к базе данных");
            return false;
        }
    }


    public static Connection getConnection(){
        return connection;
    }
}
