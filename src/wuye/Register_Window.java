package wuye;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Register_Window extends JFrame {
	EstateSQL estateSQL;
	private JPanel contentPane;
	private JTextField name;
	private JTextField pwd;
	private JTextField mobile;
	private JTextField Room_number;
	private JTextField sextext;
	private JButton btnNewButton;
	Register_Window(EstateSQL es){
		estateSQL = es;
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
	void init() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("业主姓名：");
		lblNewLabel.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel.setBounds(250, 50, 100, 50);
		contentPane.add(lblNewLabel);

		name = new JTextField();//姓名文本框
		name.setBounds(350,63, 155, 25);
		contentPane.add(name);
		name.setColumns(10);
		name.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_1.setBounds(250, 100, 100, 50);
		contentPane.add(lblNewLabel_1);

		pwd = new JTextField();
		pwd.setBounds(350, 113, 155, 25);
		contentPane.add(pwd);
		pwd.setColumns(10);
		pwd.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_2 = new JLabel("联系电话：");
		lblNewLabel_2.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_2.setBounds(250, 150, 100, 50);
		contentPane.add(lblNewLabel_2);

		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(350, 163, 155, 25);
		contentPane.add(mobile);
		mobile.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_3 = new JLabel("楼门牌号：");
		lblNewLabel_3.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_3.setBounds(250, 200, 100, 50);
		contentPane.add(lblNewLabel_3);

		Room_number = new JTextField();
		Room_number.setColumns(10);
		Room_number.setBounds(350, 213, 155, 25);
		contentPane.add(Room_number);
		Room_number.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_4 = new JLabel("性别：");
		lblNewLabel_4.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_4.setBounds(250, 250, 100, 50);
		contentPane.add(lblNewLabel_4);

		sextext = new JTextField();
		sextext.setColumns(10);
		sextext.setBounds(350, 263, 155, 25);
		contentPane.add(sextext);
		sextext.setEditable(true);//文本框可否编辑

		//返回按钮
		btnNewButton = new JButton("返回");
		btnNewButton.setBounds(20, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login_Window login_window = new Login_Window(estateSQL);
				login_window.init();
				login_window.run();
				Register_Window.super.dispose();
			}
		});

		//保存按钮
		btnNewButton = new JButton("保存");
		btnNewButton.setBounds(650, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag=JOptionPane.showConfirmDialog(null,"是否确认保存","提示窗口",JOptionPane.WARNING_MESSAGE);
				if (flag==1){
					name.setEditable(false);
					pwd.setEditable(false);
					mobile.setEditable(false);
					Room_number.setEditable(false);
				}else if (flag==0){
					estateSQL = new EstateSQL("hghnb","114514");
					estateSQL.initConnection();
					if (estateSQL.addOwner(Integer.parseInt(Room_number.getText()),pwd.getText(),name.getText(),mobile.getText(),sextext.getText())){
						JOptionPane.showMessageDialog(null,"保存成功","提示窗口",JOptionPane.WARNING_MESSAGE);
						estateSQL.closeConnection();
					}else{
						JOptionPane.showMessageDialog(null,"添加失败","提示窗口",JOptionPane.WARNING_MESSAGE);
						estateSQL.closeConnection();
					}
				}
			}
		});

		//清空按钮
		btnNewButton = new JButton("清空");
		btnNewButton.setBounds(650, 300, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag1=JOptionPane.showConfirmDialog(null,"是否确认清空","提示窗口",JOptionPane.WARNING_MESSAGE);
				if(flag1 == 0){
					name.setText("");
					pwd.setText("");
					mobile.setText("");
					Room_number.setText("");
				}
			}
		});
	}

}
