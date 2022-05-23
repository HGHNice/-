package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainInterface extends JFrame implements ActionListener {
	JComboBox comboBox;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_8;
	private JPanel contentPane;
	static MainInterface frame = new MainInterface();
	private JPasswordField passwordField;

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
		EstateSQL estateSQL = new EstateSQL("hghnb","114514");
		estateSQL.initConnection();
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

		/*JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(38, 98, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(38, 159, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(38, 216, 97, 23);
		contentPane.add(btnNewButton_2);*/

		btnNewButton_3 = new JButton("");//注册按钮
		btnNewButton_3.setBounds(68, 275, 97, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register zhuce = new register();
				zhuce.run();
				frame.dispose();
			}
		});

		/*JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(636, 98, 97, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(636, 159, 97, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBounds(636, 216, 97, 23);
		contentPane.add(btnNewButton_6);*/

		btnNewButton_8 = new JButton("");
		btnNewButton_8.setBounds(636, 278, 97, 23);
		contentPane.add(btnNewButton_8); // 每个按钮的功能以及监视器

		frame.setLocationRelativeTo(null);

		btnNewButton_8.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EstateSQL estateSQL = new EstateSQL("hghnb","114514");
		estateSQL.initConnection();
		try {
			if (String.valueOf(passwordField.getPassword()).equals("")){
				JOptionPane.showMessageDialog(null, "请输入密码");
			}else if (estateSQL.ownerLogin(String.valueOf(comboBox.getSelectedItem()),String.valueOf(passwordField.getPassword()))){     //如果登录成功打开新页面并且释放此页面
				MainInterface1 mainInterface1=new MainInterface1();
				JOptionPane.showMessageDialog(null,"登陆成功！");
				mainInterface1.run();
				frame.dispose();
			}else if (estateSQL.ownerLogin(String.valueOf(comboBox.getSelectedItem()),String.valueOf(passwordField.getPassword()))==false){
				JOptionPane.showMessageDialog(null,"账号或密码错误！");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}

