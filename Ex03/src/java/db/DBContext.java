package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    //Create a connection from the application to the database server
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost;databaseName=store;user=sa;password=12345";
        Connection con = null;
        try {
            //Loading a driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Creating a connection
            con = DriverManager.getConnection(url);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
        return con;
    }
}
