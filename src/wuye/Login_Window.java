package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login_Window extends JFrame implements ActionListener {
	EstateSQL estateSQL;
	JComboBox comboBox;
	JButton btnNewButton_3;
	JButton btnNewButton_8;
	private JPanel contentPane;
	static Login_Window frame = new Login_Window();
	private JPasswordField passwordField;
	Login_Window(){
		estateSQL = new EstateSQL("hghnb","114514");
		estateSQL.initConnection();
	}
	Login_Window(EstateSQL es){
		estateSQL = es;
	}
	public static void run() {
		try {
			frame.init();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void init() {
		setTitle("物业管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setToolTipText("");
		panel.setBorder(
				new TitledBorder(null, "登录", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(201, 98, 400, 206);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("请输入账号");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(165, 10, 109, 38);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel.setBounds(66, 66, 96, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(66, 112, 96, 25);
		panel.add(lblNewLabel_2);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(estateSQL.getOwnerIde()));
		comboBox.setForeground(Color.BLACK);
		comboBox.setToolTipText("");
		comboBox.setBounds(138, 66, 123, 25);
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("<注册");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setBounds(10, 181, 66, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("确认>");
		lblNewLabel_4.setBounds(357, 181, 58, 15);
		panel.add(lblNewLabel_4);

		passwordField = new JPasswordField();//密码文本框
		passwordField.setBounds(138, 114, 123, 21);
		panel.add(passwordField);

		btnNewButton_3 = new JButton("");//注册按钮
		btnNewButton_3.setBounds(68, 275, 97, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register_Window zhuce = new Register_Window(estateSQL);
				zhuce.run();
				frame.dispose();
			}
		});
		btnNewButton_8 = new JButton("");//确认按钮
		btnNewButton_8.setBounds(636, 278, 97, 23);
		contentPane.add(btnNewButton_8); // 每个按钮的功能以及监视器
		frame.setLocationRelativeTo(null);
		btnNewButton_8.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (String.valueOf(passwordField.getPassword()).equals("")){
				JOptionPane.showMessageDialog(null, "请输入密码");
			}else if (estateSQL.ownerLogin(String.valueOf(comboBox.getSelectedItem()),String.valueOf(passwordField.getPassword()))){     //如果登录成功打开新页面并且释放此页面
				Administrator_Main_Window administratorMain =new Administrator_Main_Window();
				User_Main_Window userMain =new User_Main_Window();
				JOptionPane.showMessageDialog(null,"登陆成功！");
				/*if(){
					userMain.run();
				}else{
					administratorMain.run();
				}*/
				userMain.run();
				//administratorMain.run();
				frame.dispose();
			}else if (estateSQL.ownerLogin(String.valueOf(comboBox.getSelectedItem()),String.valueOf(passwordField.getPassword()))==false){
				JOptionPane.showMessageDialog(null,"账号或密码错误！");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
