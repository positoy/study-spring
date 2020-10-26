package toby;

public class DaoFactory {
    public ConnectionMaker connectionMaker() {
        return new JdbcConnectionMaker();
    }

    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

//    public AccountDao accountDao() {
//        return new AccountDao(connectionMaker());
//    }
}
