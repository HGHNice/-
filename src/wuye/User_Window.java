package wuye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class User_Window extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField sex;
	private JTextField mobile;
	private JTextField RommNumber;
	private JButton btnNewButton;
	static User_Window frame3 = new User_Window();
	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			frame3.init();
			frame3.setVisible(true);
			frame3.setLocationRelativeTo(null);
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
		userName.setBounds(102, 50, 155, 21);
		contentPane.add(userName);
		userName.setColumns(10);
		userName.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("业主性别：");
		lblNewLabel_1.setBounds(20, 100, 100, 50);
		contentPane.add(lblNewLabel_1);

		sex = new JTextField();
		sex.setBounds(102, 89, 155, 21);
		contentPane.add(sex);
		sex.setColumns(10);
		sex.setEditable(false);//文本框可否编辑
		
		JLabel lblNewLabel_1_1 = new JLabel("联系电话：");
		lblNewLabel_1_1.setBounds(20, 150, 100, 50);
		contentPane.add(lblNewLabel_1_1);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(102, 136, 155, 21);
		contentPane.add(mobile);
		mobile.setEditable(false);//文本框可否编辑
		
		JLabel lblNewLabel_1_2 = new JLabel("楼门牌号：");
		lblNewLabel_1_2.setBounds(20, 200, 100, 50);
		contentPane.add(lblNewLabel_1_2);
		
		RommNumber = new JTextField();
		RommNumber.setColumns(10);
		RommNumber.setBounds(102, 176, 155, 21);
		contentPane.add(RommNumber);
		RommNumber.setEditable(false);//文本框可否编辑

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
				frame3.dispose();
			}
		});
	}
}
