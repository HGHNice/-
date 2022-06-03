package wuye;

import Dao.user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//业主基本信息USER

public class User_Window_FU extends JFrame {
	User user;
	EstateSQL estateSQL;
	private JPanel contentPane;
	private JTextField userName;
	private JTextField sex;
	private JTextField mobile;
	private JTextField FS;
	private JTextField RommNumber;
	private JButton btnNewButton;

	User_Window_FU(EstateSQL estateSQL){
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
		userName.setText(user.getOwner_name());
		userName.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("业主性别：");
		lblNewLabel_1.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_1.setBounds(250, 100, 100, 50);
		contentPane.add(lblNewLabel_1);

		sex = new JTextField();
		sex.setBounds(350, 113, 155, 25);
		contentPane.add(sex);
		sex.setColumns(10);
		sex.setText(user.getSex());
		sex.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_2 = new JLabel("联系电话：");
		lblNewLabel_2.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_2.setBounds(250, 150, 100, 50);
		contentPane.add(lblNewLabel_2);

		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(350, 163, 155, 25);
		contentPane.add(mobile);
		mobile.setText(user.getMobile_phone());
		mobile.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_3 = new JLabel("楼门牌号：");
		lblNewLabel_3.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_3.setBounds(250, 200, 100, 50);
		contentPane.add(lblNewLabel_3);

		RommNumber = new JTextField();
		RommNumber.setColumns(10);
		RommNumber.setBounds(350, 213, 155, 25);
		contentPane.add(RommNumber);
		RommNumber.setText(String.valueOf(user.getRoom_number()));
		RommNumber.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_4 = new JLabel("家庭成员：");
		lblNewLabel_4.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_4.setBounds(250, 250, 100, 50);
		contentPane.add(lblNewLabel_4);

		FS = new JTextField();//姓名文本框
		FS.setBounds(350, 263, 155, 25);
		contentPane.add(FS);
		FS.setColumns(10);
		FS.setText(user.getFamily_situation());
		FS.setEditable(false);//文本框可否编辑


		btnNewButton = new JButton("返回");//返回
		btnNewButton.setBounds(20, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User_Main_Window user_main_window = new User_Main_Window(estateSQL);
				user_main_window.init();
				user_main_window.user = user;
				user_main_window.run();
				User_Window_FU.super.dispose();
			}
		});
	}
}
