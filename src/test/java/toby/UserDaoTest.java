package toby;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void testUser() {
        User user = new User();
        user.setId("positoy");
        user.setName("andy");
        user.setPassword("10laskrcjs");

        assertEquals(user.getId(), "positoy");
        assertEquals(user.getName(), "andy");
        assertEquals(user.getPassword(), "10laskrcjs");
    }

    @Test
    void testUserDao() throws SQLException, ClassNotFoundException {

        User user = new User();
        user.setId("positoy");
        user.setName("andy");
        user.setPassword("10laskrcjs");

        UserDao userDao = new JdbcUserDao();
        userDao.delete("positoy");
        userDao.add(user);
        User storedUser = userDao.get("positoy");

        assertEquals(user.getId(), storedUser.getId());
        assertEquals(user.getName(), storedUser.getName());
        assertEquals(user.getPassword(), storedUser.getPassword());
    }
}