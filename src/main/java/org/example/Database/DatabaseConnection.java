package org.example.Database;

import java.sql.*;

public class DatabaseConnection {

    private static final String CONTROLLER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Selling_System";
    private static final String USER = "root";
    private static final String PASSWORD = "DejoGade.1005";

    static {
        try {
            Class.forName(CONTROLLER);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
    }

    public static Connection connectionDatabase(){
        Connection databaseConnection = null;
        try {
            databaseConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return databaseConnection;
    }

    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
