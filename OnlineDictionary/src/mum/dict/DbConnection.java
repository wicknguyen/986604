package mum.dict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    public static Connection connection;
    public static Statement statement;

    public static void openConnection() throws Exception{
//        String driver = "com.mysql.jdbc.Driver";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String pass = "rootuser";
        String url = "jdbc:mysql://localhost:3306/entries?serverTimezone=UTC";

        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url, user, pass);
        statement = connection.createStatement();
        if(connection==null){
            System.out.println("No connection");
        }
    }

    public static void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}
