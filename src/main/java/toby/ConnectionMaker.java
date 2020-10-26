package toby;

import java.sql.Connection;
import java.sql.SQLException;

interface ConnectionMaker {
    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
