package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrators_User_Window extends JFrame {

    private JPanel contentPane;
    private JTextField userName;
    private JTextField sex;
    private JTextField mobile;
    private JTextField RommNumber;
    private JTextField FS;
    private JTextField find;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    static User_Window frame4 = new User_Window();
    /**
     * Launch the application.
     */

    public void run() {
        try {
            frame4.init();
            frame4.setVisible(true);
            frame4.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Create the frame.
     */
    void init(){
        setTitle("业主信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("业主姓名：");
        lblNewLabel.setBounds(20, 50, 100, 50);
        contentPane.add(lblNewLabel);

        userName = new JTextField();//姓名文本框
        userName.setBounds(102, 67, 155, 21);
        contentPane.add(userName);
        userName.setColumns(10);
        userName.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1 = new JLabel("业主性别：");
        lblNewLabel_1.setBounds(20, 100, 100, 50);
        contentPane.add(lblNewLabel_1);

        sex = new JTextField();
        sex.setBounds(102, 117, 155, 21);
        contentPane.add(sex);
        sex.setColumns(10);
        sex.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1_1 = new JLabel("联系电话：");
        lblNewLabel_1_1.setBounds(20, 150, 100, 50);
        contentPane.add(lblNewLabel_1_1);

        mobile = new JTextField();
        mobile.setColumns(10);
        mobile.setBounds(102, 167, 155, 21);
        contentPane.add(mobile);
        mobile.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1_2 = new JLabel("楼门牌号：");
        lblNewLabel_1_2.setBounds(20, 200, 100, 50);
        contentPane.add(lblNewLabel_1_2);

        RommNumber = new JTextField();
        RommNumber.setColumns(10);
        RommNumber.setBounds(102, 216, 155, 21);
        contentPane.add(RommNumber);
        RommNumber.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1_3 = new JLabel("家庭成员：");
        lblNewLabel_1_3.setBounds(20, 250, 100, 50);
        contentPane.add(lblNewLabel_1_3);

        FS = new JTextField();//姓名文本框
        FS.setBounds(102, 267, 155, 21);
        contentPane.add(FS);
        FS.setColumns(10);
        FS.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1_4 = new JLabel("门牌号搜索：");
        lblNewLabel_1_4.setBounds(20, 300, 100, 50);
        contentPane.add(lblNewLabel_1_4);

        find = new JTextField();//搜索文本框
        find.setBounds(102, 267, 155, 21);
        contentPane.add(find);
        find.setColumns(10);
        find.setEditable(true);//文本框可否编辑

        btnNewButton_1 = new JButton("搜索");//搜索按钮
        btnNewButton_1.setBounds(470, 267, 93, 23);
        contentPane.add(btnNewButton_1);

        //获取用户信息
//		User user = new User();
//		EstateSQL estateSQL = new EstateSQL("hghnb","114514");
//		estateSQL.getinfo(String.valueOf("1"));
//		userName.setText(user.getRoom_name());
//		mobile.setText(user.getMobile_phone());
//		sex.setText(user.getSex());
//		RommNumber.setText(String.valueOf(user.getRoom_number()));

        btnNewButton = new JButton("返回");//返回
        btnNewButton.setBounds(20, 400, 93, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrator_Main_Window administratorMain =new Administrator_Main_Window();
                administratorMain.run();
                frame4.dispose();
            }
        });
    }
}
