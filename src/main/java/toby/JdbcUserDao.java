package toby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUserDao extends UserDao{
    @Override
    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(UserDao.dbClass);
        return DriverManager.getConnection(UserDao.dbUrl, UserDao.dbUser, UserDao.dbPassword);
    }
}
