package ua.ithille.lesson35.classwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConnectionUtils {

    public Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ith", "ith", "mysecretpassword");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
