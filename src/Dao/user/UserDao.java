package Dao.user;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException;
    //增加用户信息
    public int add( User user) throws Exception;
}
