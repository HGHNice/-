package Dao.user;

public class User {
    private Integer  Room_number;
    private String   Room_name;
    private String   Owner_name;
    private String   Housing_situation;
    private String   Family_situation;
    private String   User_account;
    private String   setUser_password;
    private String   mobile_phone;
    private String   sex;

    //获取用户性别
    public String getOwner_name(){
        return Owner_name;
    }
    public void setOwner_name(String name){
        this.Owner_name = name;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getUser_account() {
        return User_account;
    }

    public void setUser_account(String user_account) {
        User_account = user_account;
    }

    public String getSetUser_password() {
        return setUser_password;
    }

    public void setSetUser_password(String setUser_password) {
        this.setUser_password = setUser_password;
    }

    public Integer getRoom_number() {
        return Room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.Room_number = room_number;
    }

    public String getRoom_name() {
        return Room_name;
    }

    public void setRoom_name(String room_name) {
        Room_name = room_name;
    }

    public String getHousing_situation() {
        return Housing_situation;
    }

    public void setHousing_situation(String housing_situation) {
        Housing_situation = housing_situation;
    }

    public String getFamily_situation() {
        return Family_situation;
    }

    public void setFamily_situation(String family_situation) {
        Family_situation = family_situation;
    }
}
