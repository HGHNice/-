package wuye;

import Dao.user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//业主基本信息ADMINISTRATOR

public class User_Window_FA extends JFrame {
    static User user;
    EstateSQL estateSQL;
    private JPanel contentPane;
    private JTextField userName;
    private JTextField sex;
    private JTextField mobile;
    private JTextField FS;
    private JTextField find;
    private JTextField RommNumber;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

    User_Window_FA(EstateSQL estateSQL){
        this.estateSQL = estateSQL;
    }

    /**
     * Launch the application.
     */

    public void run() {
        setVisible(true);
        setLocationRelativeTo(null);
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
        lblNewLabel.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel.setBounds(250, 50, 100, 50);
        contentPane.add(lblNewLabel);

        userName = new JTextField();//姓名文本框
        userName.setBounds(350,63, 155, 25);
        contentPane.add(userName);
        userName.setColumns(10);
        userName.setText("");
        userName.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1 = new JLabel("业主性别：");
        lblNewLabel_1.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_1.setBounds(250, 100, 100, 50);
        contentPane.add(lblNewLabel_1);

        sex = new JTextField();
        sex.setBounds(350, 113, 155, 25);
        contentPane.add(sex);
        sex.setColumns(10);
        sex.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_2 = new JLabel("联系电话：");
        lblNewLabel_2.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_2.setBounds(250, 150, 100, 50);
        contentPane.add(lblNewLabel_2);

        mobile = new JTextField();
        mobile.setColumns(10);
        mobile.setBounds(350, 163, 155, 25);
        contentPane.add(mobile);
        mobile.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_3 = new JLabel("楼门牌号：");
        lblNewLabel_3.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_3.setBounds(250, 200, 100, 50);
        contentPane.add(lblNewLabel_3);

        RommNumber = new JTextField();
        RommNumber.setColumns(10);
        RommNumber.setBounds(350, 213, 155, 25);
        contentPane.add(RommNumber);
        RommNumber.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_4 = new JLabel("家庭成员：");
        lblNewLabel_4.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_4.setBounds(250, 250, 100, 50);
        contentPane.add(lblNewLabel_4);

        FS = new JTextField();//姓名文本框
        FS.setBounds(350, 263, 155, 25);
        contentPane.add(FS);
        FS.setColumns(10);
        FS.setEditable(false);//文本框可否编辑

        //设置文本框的文字
        userName.setText(user.getOwner_name());
        sex.setText(user.getSex());
        mobile.setText(user.getMobile_phone());
        RommNumber.setText(String.valueOf(user.getRoom_number()));
        FS.setText(user.getFamily_situation());

        JLabel lblNewLabel_5 = new JLabel("门牌号搜索：");
        lblNewLabel_5.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_5.setBounds(250, 300, 100, 50);
        contentPane.add(lblNewLabel_5);

        find = new JTextField();//搜索文本框
        find.setBounds(350, 313, 155, 25);
        contentPane.add(find);
        find.setColumns(10);
        find.setEditable(true);//文本框可否编辑

        btnNewButton_1 = new JButton("搜索");//搜索按钮
        btnNewButton_1.setBounds(550, 313, 93, 23);
        contentPane.add(btnNewButton_1);

        //搜索按钮监听
        btnNewButton_1.addActionListener(e -> {
            String find_str = find.getText();
            if(find_str.equals("")){
                JOptionPane.showMessageDialog(null, "请输入搜索内容！");
            }else{
                user = estateSQL.find_user(find_str);
                if(user == null){
                    JOptionPane.showMessageDialog(null, "没有找到该业主！");
                }else{
                    userName.setText(user.getOwner_name());
                    sex.setText(user.getSex());
                    mobile.setText(user.getMobile_phone());
                    RommNumber.setText(String.valueOf(user.getRoom_number()));
                    FS.setText(user.getFamily_situation());
            }
            }
        });


        btnNewButton = new JButton("返回");//返回
        btnNewButton.setBounds(20, 400, 100, 35);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrator_Main_Window administrator_main_window = new Administrator_Main_Window(estateSQL);
                administrator_main_window.init();
                administrator_main_window.run();
                User_Window_FA.super.dispose();
            }
        });
    }
}
