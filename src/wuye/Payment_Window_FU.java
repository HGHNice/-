package wuye;

import Dao.user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//缴费情况USER
public class Payment_Window_FU extends JFrame {
	EstateSQL estateSQL;
	User user;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField Arrearage;
	private JTextField Property_management_fee;
	private JTextField WEG_Charges;
	private JTextField TV_fee;
	private JTextField Heating_cost;
	private JTextField house_payment_information;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	Payment_Window_FU(EstateSQL estateSQL){
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

		Arrearage = new JTextField();//是否欠费文本框
		Arrearage.setBounds(350,63, 155, 25);
		contentPane.add(Arrearage);
		Arrearage.setColumns(10);
		Arrearage.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("物业管理费：");
		lblNewLabel_1.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_1.setBounds(250, 100, 100, 50);
		contentPane.add(lblNewLabel_1);

		Property_management_fee = new JTextField();//物业管理费文本框
		Property_management_fee.setBounds(350, 113, 155, 25);
		contentPane.add(Property_management_fee);
		Property_management_fee.setColumns(10);
		Property_management_fee.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_2 = new JLabel("水电煤气费：");
		lblNewLabel_2.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_2.setBounds(250, 150, 100, 50);
		contentPane.add(lblNewLabel_2);

		WEG_Charges = new JTextField();//水电煤气费文本框
		WEG_Charges.setBounds(350, 163, 155, 25);
		contentPane.add(WEG_Charges);
		WEG_Charges.setColumns(10);
		WEG_Charges.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_3 = new JLabel("有线电视费：");
		lblNewLabel_3.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_3.setBounds(250, 200, 100, 50);
		contentPane.add(lblNewLabel_3);

		TV_fee = new JTextField();//有线电视费文本框
		TV_fee.setColumns(10);
		TV_fee.setBounds(350, 213, 155, 25);
		contentPane.add(TV_fee);
		TV_fee.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_4 = new JLabel("供暖费：");
		lblNewLabel_4.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_4.setBounds(250, 250, 100, 50);
		contentPane.add(lblNewLabel_4);

		Heating_cost = new JTextField();//供暖费文本框
		Heating_cost.setColumns(10);
		Heating_cost.setBounds(350, 263, 155, 25);
		contentPane.add(Heating_cost);
		Heating_cost.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_5 = new JLabel("房款费：");
		lblNewLabel_5.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_5.setBounds(250, 300, 100, 50);
		contentPane.add(lblNewLabel_5);

		house_payment_information = new JTextField();//房款费文本框
		house_payment_information.setColumns(10);
		house_payment_information.setBounds(350, 313, 155, 25);
		contentPane.add(house_payment_information);
		house_payment_information.setEditable(false);//文本框可否编辑
		//显示缴费情况
		btnNewButton = new JButton("显示");
		btnNewButton.setBounds(650, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(e -> {
			String find_str = String.valueOf(user.getRoom_number());
			int balance =estateSQL.find_banlance(find_str);
			String str[] = estateSQL.find_payment(find_str);
			Property_management_fee.setText(str[0]);
			WEG_Charges.setText(str[1]);
			TV_fee.setText(str[2]);
			Heating_cost.setText(str[3]);
			house_payment_information.setText(str[4]);
			if (0>(balance-Integer.parseInt(Property_management_fee.getText())+Integer.parseInt(WEG_Charges.getText())+Integer.parseInt(TV_fee.getText())+Integer.parseInt(Heating_cost.getText()))){
				Arrearage.setText("-"+balance+"元");
			}
			else {
				Arrearage.setText("正常");
			}
		});
		//返回按钮
		btnNewButton = new JButton("返回");
		btnNewButton.setBounds(20, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User_Main_Window user_main_window = new User_Main_Window(estateSQL);
				user_main_window.user=user;
				user_main_window.init();
				user_main_window.run();
				Payment_Window_FU.super.dispose();
			}
		});
	}
}
