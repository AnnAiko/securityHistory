package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*Подключитьсся к базе данных*/
public class ConnectionBD {

    //URL базы данных
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/securities";
    //Логин и пароль
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Properties info = new Properties();
            info.setProperty("characterEncoding", "utf8");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            //Установить соединение с базой данных
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("Соединение установлено");
        } else {
            System.out.println("Соединение не установлено. Произошла ошибка.");
        }
        return connection;
    }
}
