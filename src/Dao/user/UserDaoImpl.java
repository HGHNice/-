package Dao.user;

import Dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private UserDao userDao;
    public static PreparedStatement ps;

    @Override
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException {
//        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作。
            user = userDao.getLoginUser(connection, userCode,userPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResourse(connection,null,null);
        }
        return user;
    }

    @Override
    public int add( User user) throws Exception {
        Connection connection = BaseDao.getConnection();
        String RoomName = user.getUser_account();
        String pwd = user.getSetUser_password();
        String moblie = user.getMobile_phone();
        Integer Room_number = user.getRoom_number();
        ps=connection.prepareStatement("insert into owner(Room_name,pwd,mobile,Room_number) values(?,?,?,?)");
        ps.setString(1,RoomName);
        ps.setString(2,pwd);
        ps.setString(3,moblie);
        ps.setInt(4,Room_number);
        int i = ps.executeUpdate();
        return i;
    }


}
