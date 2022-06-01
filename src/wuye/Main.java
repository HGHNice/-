package wuye;

public class Main {
    public static void main(String[] args)  {
        EstateSQL estateSQL = new EstateSQL("hghnb","114514");
        estateSQL.initConnection();
        Login_Window login_window = new Login_Window(estateSQL);
        login_window.init();
        login_window.run();
    }
}
