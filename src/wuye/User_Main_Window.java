package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Main_Window extends JFrame {
    JButton btnNewButton;
    JButton btnNewButton_2;
    JButton btnNewButton_4;
    private JPanel contentPane;
    EstateSQL estateSQL;
    User_Main_Window(EstateSQL estateSQL){
        this.estateSQL = estateSQL;
    }
    public void run() {
        setVisible(true);
        setLocationRelativeTo(null);
    }
    void init(){
        setTitle("物业管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //业主基本信息按钮
        btnNewButton = new JButton("");
        btnNewButton.setBounds(80, 100, 108, 35);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Window_FU user_window_fu = new User_Window_FU(estateSQL);
                user_window_fu.init();
                user_window_fu.run();
                User_Main_Window.super.dispose();
            }
        });

        //缴费情况按钮
        btnNewButton_2 = new JButton("");
        btnNewButton_2.setBounds(620, 100, 108, 35);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment_Window_FU payment_window_fu = new Payment_Window_FU(estateSQL);
                payment_window_fu.init();
                payment_window_fu.run();
                User_Main_Window.super.dispose();
            }
        });

        btnNewButton_4 = new JButton("");//返回系统
        btnNewButton_4.setBounds(80, 300, 108, 35);
        contentPane.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_Window login_window = new Login_Window(estateSQL);
                login_window.init();
                login_window.run();
                User_Main_Window.super.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u4E3B\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panel.setToolTipText("");
        panel.setBounds(221, 53, 369, 293);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("<业主基本信息");
        lblNewLabel.setBounds(7, 50, 100, 35);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("缴费情况>");
        lblNewLabel_2.setBounds(297, 50, 100, 35);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_4 = new JLabel("<返回");
        lblNewLabel_4.setBounds(7, 250, 72, 26);
        panel.add(lblNewLabel_4);
    }
}
