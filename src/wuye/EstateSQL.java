package wuye;
import Dao.user.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstateSQL {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowdate = dateFormat.format(new Date());
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
    boolean addOwner(int RoomNumber,String Password,String Name,String Mobile,String sex,String housing_situation,String house_person,String house_name){ //添加业主
        boolean tag = true;
        String sql = "INSERT INTO owner (Room_number, pwd,mobile,ownerName,sex,Housing_situation,Family_situation,Room_name,flag) VALUES ("+RoomNumber+", '"+Password+"','"+Mobile+"','"+Name+"','"+sex+"','"+housing_situation+"','"+house_person+"','"+house_name+"',0)";
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
    public User getinfo(String id){
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
                user.setOwner_name(rs.getString("ownerName"));
                user.setMobile_phone(rs.getString("mobile"));
                user.setFamily_situation(rs.getString("Family_situation"));
                user.setHousing_situation(rs.getString("Housing_situation"));
                user.setRoom_number(Integer.valueOf(rs.getString("Room_number")));
                user.setRoom_number(Integer.valueOf(rs.getString("Room_number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    //获取管理员信息
    public User getAdInfo(String id){
        ResultSet rs = null;
        String sql = "SELECT * FROM Property_management_personnel WHERE number = '"+id+"'";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User();
        try {
            while (rs.next()) {
                user.setUser_account(rs.getString("number"));
                user.setSex(rs.getString("sex"));
                user.setOwner_name(rs.getString("name"));
                user.setMobile_phone(rs.getString("mobile"));
                user.setDepartment(rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    //管理员登录
    boolean AdLogin(String id, String pwd) throws SQLException {
        boolean tag = false;
        ResultSet rs = null;
        User user = new User();
        String sql = "SELECT * FROM Property_management_personnel WHERE number = '"+id+"' AND pwd = '"+pwd+"'";
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
    public boolean isAdministrator(String id){
        ResultSet rs = null;
        int flag = 0;
        String sql = "SELECT flag FROM owner WHERE Room_number = '"+id+"'";
        try {
            rs = stmt.executeQuery(sql);
            rs.next();
            flag = rs.getInt("flag");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag == 1;
    }
    //查询业主所有物业费项
    public String[] find_payment(String find_str) {
        String[] str = new String[6];
        ResultSet rs = null;
        String sql = "SELECT * FROM notice WHERE Room_number = '"+find_str+"'";
        try {
            rs = stmt.executeQuery(sql);
            rs.next();
            str[0] = rs.getString("Total_property_management_fee");
            str[1] = rs.getString("WEG_Charges");
            str[2] = rs.getString("TV_fee");
            str[3] = rs.getString("Heating_cost");
            str[4] = rs.getString("house_payment_information");

        } catch (SQLException e) {
            System.out.println(("查询失败！"));
        }
        return str;
    }
    //查找业主
    public User find_user(String find_str) {
        ResultSet rs = null;
        String sql = "SELECT * FROM owner WHERE Room_number = '"+find_str+"'";
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
                user.setOwner_name(rs.getString("ownerName"));
                user.setMobile_phone(rs.getString("mobile"));
                user.setFamily_situation(rs.getString("Family_situation"));
                user.setHousing_situation(rs.getString("Housing_situation"));
                user.setRoom_number(Integer.valueOf(rs.getString("Room_number")));
                user.setRoom_number(Integer.valueOf(rs.getString("Room_number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    //查询业主余额
    public int find_banlance(String find_str) {
        ResultSet rs = null;
        int banlance = 0;
        String sql = "SELECT * FROM owner WHERE Room_number = '"+find_str+"'";
        try {
            rs = stmt.executeQuery(sql);
            rs.next();
            banlance = rs.getInt("balance");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banlance;
    }
    //插入各种费用信息
    public boolean insert_fee(String id, String PMF, String WEG_Charges, String TV_fee, String Heating_cost, String HPI) {
        ResultSet rs = null;
        boolean tag = false;
        String sql = "INSERT INTO notice(Room_number,Total_property_management_fee,WEG_Charges,TV_fee,Heating_cost,house_payment_information,start_time) VALUES('"+id+"','"+PMF+"','"+WEG_Charges+"','"+TV_fee+"','"+Heating_cost+"','"+HPI+"','"+nowdate+"')";
        try {
            stmt.executeUpdate(sql);
            tag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag;
    }

    public boolean isowner(String id) {
        ResultSet rs = null;
        boolean tag = false;
        String sql = "SELECT * FROM owner WHERE Room_number = '"+id+"'";
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                tag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag;
    }

    public Object[][] getMonthTable() {
        ResultSet rs = null;
        String sql = "SELECT * FROM notice where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(start_time)";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = 0;
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[i][60];
        try {
            rs.beforeFirst();
            while (rs.next()) {
                data[i-1][0] = rs.getString("Room_number");
                data[i-1][1] = rs.getString("WEG_Charges");
                data[i-1][2] = rs.getString("Total_property_management_fee");
                data[i-1][3] = rs.getString("TV_fee");
                data[i-1][4] = rs.getString("Heating_cost");
                data[i-1][5] = rs.getString("house_payment_information");
                data[i-1][6] = rs.getString("start_time");
                i--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Object[] getMonthTableTitle() {
        Object[] title = {"房间号","水电费","物业费","电视费","供暖费","房屋缴费信息","缴费时间"};
        return title;
    }

    public Object[][] getQuarterTable() {
        ResultSet rs = null;
        String sql = "SELECT * FROM notice where DATE_SUB(CURDATE(), INTERVAL 90 DAY) <= date(start_time)";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = 0;
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[i][60];
        try {
            rs.beforeFirst();
            while (rs.next()) {
                data[i-1][0] = rs.getString("Room_number");
                data[i-1][1] = rs.getString("WEG_Charges");
                data[i-1][2] = rs.getString("Total_property_management_fee");
                data[i-1][3] = rs.getString("TV_fee");
                data[i-1][4] = rs.getString("Heating_cost");
                data[i-1][5] = rs.getString("house_payment_information");
                data[i-1][6] = rs.getString("start_time");
                i--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Object[][] getYearTable() {
        ResultSet rs = null;
        String sql = "SELECT * FROM notice where DATE_SUB(CURDATE(), INTERVAL 365 DAY) <= date(start_time)";
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = 0;
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[i][60];
        try {
            rs.beforeFirst();
            while (rs.next()) {
                data[i-1][0] = rs.getString("Room_number");
                data[i-1][1] = rs.getString("WEG_Charges");
                data[i-1][2] = rs.getString("Total_property_management_fee");
                data[i-1][3] = rs.getString("TV_fee");
                data[i-1][4] = rs.getString("Heating_cost");
                data[i-1][5] = rs.getString("house_payment_information");
                data[i-1][6] = rs.getString("start_time");
                i--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
