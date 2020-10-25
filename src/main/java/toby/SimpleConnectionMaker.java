package toby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

    final static String dbClass = "com.mysql.cj.jdbc.Driver";
    final static String dbUrl = "jdbc:mysql://localhost/toby?serverTimezone=UTC&characterEncoding=UTF-8";
    final static String dbUser = "root";
    final static String dbPassword = "1234";

    Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbClass);
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

}
