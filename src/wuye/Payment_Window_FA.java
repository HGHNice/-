package wuye;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//缴费情况
public class Payment_Window_FA extends JFrame {
    EstateSQL estateSQL;
    private JPanel contentPane;
    private JButton btnNewButton;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    Payment_Window_FA(EstateSQL estateSQL){
        this.estateSQL = estateSQL;
    }
    public void run() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void init() {
        setTitle("缴费情况");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("是否欠费：");
        lblNewLabel.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel.setBounds(250, 50, 100, 50);
        contentPane.add(lblNewLabel);

        textField = new JTextField();//是否欠费文本框
        textField.setBounds(350,63, 155, 25);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_1 = new JLabel("物业管理费：");
        lblNewLabel_1.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_1.setBounds(250, 100, 100, 50);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();//物业管理费文本框
        textField_1.setBounds(350, 113, 155, 25);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_2 = new JLabel("水电煤气费：");
        lblNewLabel_2.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_2.setBounds(250, 150, 100, 50);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();//水电煤气费文本框
        textField_2.setBounds(350, 163, 155, 25);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        textField_2.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_3 = new JLabel("有线电视费：");
        lblNewLabel_3.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_3.setBounds(250, 200, 100, 50);
        contentPane.add(lblNewLabel_3);

        textField_3 = new JTextField();//有线电视费文本框
        textField_3.setColumns(10);
        textField_3.setBounds(350, 213, 155, 25);
        contentPane.add(textField_3);
        textField_3.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_4 = new JLabel("供暖费：");
        lblNewLabel_4.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_4.setBounds(250, 250, 100, 50);
        contentPane.add(lblNewLabel_4);

        textField_4 = new JTextField();//供暖费文本框
        textField_4.setColumns(10);
        textField_4.setBounds(350, 263, 155, 25);
        contentPane.add(textField_4);
        textField_4.setEditable(false);//文本框可否编辑

        JLabel lblNewLabel_5 = new JLabel("房款费：");
        lblNewLabel_5.setFont(new Font("宋体",Font.BOLD,15));
        lblNewLabel_5.setBounds(250, 300, 100, 50);
        contentPane.add(lblNewLabel_5);

        textField_5 = new JTextField();//房款费文本框
        textField_5.setColumns(10);
        textField_5.setBounds(350, 313, 155, 25);
        contentPane.add(textField_5);
        textField_5.setEditable(false);//文本框可否编辑

        //返回按钮
        btnNewButton = new JButton("返回");
        btnNewButton.setBounds(20, 400, 100, 35);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrator_Main_Window administrator_main_window = new Administrator_Main_Window(estateSQL);
                administrator_main_window.init();
                administrator_main_window.run();
                Payment_Window_FA.super.dispose();
            }
        });
    }
}
