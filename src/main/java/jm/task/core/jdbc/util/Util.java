package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/db_1.1.4_final";
    private static final String USER = "postgres";
    private static final String PASS = "zhum99";

    private static Connection jdbcConnection;

    public static Connection connectWithJDBC() {
        try {
            Class.forName(JDBC_DRIVER);
            jdbcConnection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected with JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jdbcConnection;
    }

    public static void closeConnection() {
        try {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
                System.out.println("JDBC connection closed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
