package toby;

import java.sql.*;

public class UserDao {

    final static String dbClass = "com.mysql.cj.jdbc.Driver";
    final static String dbUrl = "jdbc:mysql://localhost/toby?serverTimezone=UTC&characterEncoding=UTF-8";
    final static String dbUser = "root";
    final static String dbPassword = "1234";

    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbClass);
        Connection c = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        return c;
    }
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public void delete(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("delete from users where id=?");
        ps.setString(1, id);
        ps.execute();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id=?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
