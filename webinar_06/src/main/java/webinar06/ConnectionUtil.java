package webinar06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test_database",
                            "postgres",
                            "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
