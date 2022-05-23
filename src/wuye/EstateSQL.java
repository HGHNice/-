package wuye;
import Dao.user.User;

import java.sql.*;
public class EstateSQL {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_URL;
    String USER;
    String PASS;
    Connection conn = null;
    Statement stmt = null;
    EstateSQL(String USER,String PASS,String TABLE){
        this.USER = USER;
        this.PASS = PASS;
        this.DB_URL = "jdbc:mysql://houzimc.top:3306/"+TABLE+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }
    EstateSQL(String USER,String PASS){
        this.USER = USER;
        this.PASS = PASS;
        this.DB_URL = "jdbc:mysql://houzimc.top:3306/Estate?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }
    boolean initConnection(){
        boolean tag = true;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            tag = false;
            e.printStackTrace();
        }
        // 打开链接
        System.out.println("连接数据库...");
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            tag = false;
            e.printStackTrace();
        }
        // 执行查询
        System.out.println("实例化Statement对象...");
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            tag = false;
            e.printStackTrace();
        }
        System.out.println("连接成功！");
        return tag;
    }
    ResultSet execStatement(String sql){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    boolean closeConnection() {
        boolean tag = true;
        try {
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            tag = false;
            se.printStackTrace();
        } catch (Exception e) {
            tag = false;
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("连接关闭！");
        return tag;
    }
    ResultSet getNotice(){
        ResultSet rs = null;
        String sql = "SELECT * FROM notice";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getNoticeByRoomNumber(int RoomNumber){
        ResultSet rs = null;
        String sql = "SELECT * FROM notice Where Room_number = "+RoomNumber;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getOwner(){
        ResultSet rs = null;
        String sql = "SELECT * FROM owner";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getOwnerByRoomNumber(int RoomNumber){
        ResultSet rs = null;
        String sql = "SELECT * FROM owner Where Room_number = "+RoomNumber;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getOwnerId(){
        ResultSet rs = null;
        String sql = "SELECT Room_number FROM owner";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getOwnerByRoomName(String RoomName){
        ResultSet rs = null;
        String sql = "SELECT * FROM owner Where Room_name = '"+RoomName+"'";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getManagementPerson(){
        ResultSet rs = null;
        String sql = "SELECT * FROM Property_management_personnel";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getManagementPersonByName(String Name){
        ResultSet rs = null;
        String sql = "SELECT * FROM Property_management_personnel Where name = '"+Name+"'";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    ResultSet getManagementPersonByNumber(String Number){
        ResultSet rs = null;
        String sql = "SELECT * FROM Property_management_personnel Where number = '"+Number+"'";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    boolean addManager(String Number,String Name,String Sex){ //添加管理员
        boolean tag = true;
        String sql = "INSERT INTO Property_management_personnel (name, sex, number) VALUES ('"+Name+"', '"+Sex+"', '"+Number+"')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            tag = false;
            System.out.println("Manager添加失败！");
        }
        return tag;
    }
    boolean addOwner(int RoomNumber,String Password,String Name,String Mobile,String sex){ //添加业主
        boolean tag = true;
        String sql = "INSERT INTO owner (Room_number, pwd,mobile,Room_name,sex) VALUES ("+RoomNumber+", '"+Password+"','"+Mobile+"','"+Name+",'"+sex+"')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            tag = false;
            System.out.println("Owner添加失败！");
            e.printStackTrace();
        }
        return tag;
    }
    String[] getOwnerIde(){   //获取所有房东的ID
        String[] id = new String[10];
        int i = 0;
        ResultSet rs = getOwnerId();
        try {
            while (rs.next()){
                id[i] = rs.getString("Room_number");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    //业主登录
    boolean ownerLogin(String id, String pwd) throws SQLException {
        boolean tag = false;
        ResultSet rs = null;
        User user = new User();
        String sql = "SELECT * FROM owner WHERE Room_number = '"+id+"' AND pwd = '"+pwd+"'";
        rs = stmt.executeQuery(sql);
        try {
            if (rs.next()){
                if (rs.getString("pwd").equals(pwd)){
                    tag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag;
    }
    //获取业主信息
    public void getinfo(String id){
        ResultSet rs = null;
        String sql = "SELECT * FROM owner WHERE Room_number = '"+id+"'";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User();
        try {
            while (rs.next()) {
                user.setUser_account(rs.getString("Room_name"));
                user.setSex(rs.getString("sex"));
                user.setMobile_phone("mobile");
                user.setRoom_number(Integer.valueOf("Room_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
