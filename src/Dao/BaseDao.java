package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://houzimc.top:3306/Estate?useUnicode=true&characterEncoding=utf8&useSSL=true";
        username = "hghnb";
        password = "114514";
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    //释放资源。
    public static  boolean closeResourse(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;

        if (resultSet != null){
            try {
                resultSet.close();
                //GC回收
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
                //GC回收
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (connection != null){
            try {
                connection.close();
                //GC回收
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        return false;
    }
}
