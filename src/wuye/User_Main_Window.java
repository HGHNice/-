package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Main_Window extends JFrame {
    JButton btnNewButton;
    JButton btnNewButton_1;
    JButton btnNewButton_2;
    JButton btnNewButton_4;
    static User_Main_Window frame2=new User_Main_Window();
    private JPanel contentPane;
    public void run() {
        try {
            frame2.init();
            frame2.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void init(){
        setVisible(true);
        setTitle("物业管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 511);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton = new JButton("");   //业主基本信息按钮
        btnNewButton.setBounds(80, 100, 108, 35);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User_Window user=new User_Window();
                user.run();
                frame2.dispose();
            }
        });

        btnNewButton_2 = new JButton("");          //缴费情况按钮
        btnNewButton_2.setBounds(620, 100, 108, 35);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment_Window paymentWindow =new Payment_Window();
                paymentWindow.run();
                frame2.dispose();
            }
        });

        btnNewButton_4 = new JButton("");//返回系统
        btnNewButton_4.setBounds(80, 300, 108, 35);
        contentPane.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_Window mainInterface1=new Login_Window();
                Login_Window.run();
                frame2.dispose();
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

        frame2.setLocationRelativeTo(null);
    }
}
