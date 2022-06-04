package wuye;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
//抄表窗口
public class Water_Table extends JFrame {

	EstateSQL estateSQL;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField Property_management_fees;
	private JTextField WEG_Charges;
	private JTextField TV_fee;
	private JTextField Heating_cost;
	private JTextField house_payment_information;
	private JTextField room_number;
	Water_Table(EstateSQL estateSQL){
		this.estateSQL = estateSQL;
	}
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public void run() {
			setLocationRelativeTo(null);
			setVisible(true);
	}
	void init() {
		setTitle("费用抄表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel_5 = new JLabel("房间号：");
		lblNewLabel_5.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_5.setBounds(250, 25, 100, 50);
		contentPane.add(lblNewLabel_5);

		room_number = new JTextField();//房款费文本框
		room_number.setColumns(10);
		room_number.setBounds(350, 33, 155, 25);
		contentPane.add(room_number);
		room_number.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel = new JLabel("物业管理费：");
		lblNewLabel.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel.setBounds(250, 50, 100, 50);
		contentPane.add(lblNewLabel);

		Property_management_fees = new JTextField();//物业管理费文本框
		Property_management_fees.setBounds(350,63, 155, 25);
		contentPane.add(Property_management_fees);
		Property_management_fees.setColumns(10);
		Property_management_fees.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("水电煤气费：");
		lblNewLabel_1.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_1.setBounds(250, 100, 100, 50);
		contentPane.add(lblNewLabel_1);

		WEG_Charges = new JTextField();//水电煤气费文本框
		WEG_Charges.setBounds(350, 113, 155, 25);
		contentPane.add(WEG_Charges);
		WEG_Charges.setColumns(10);
		WEG_Charges.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_2 = new JLabel("有线电视费：");
		lblNewLabel_2.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_2.setBounds(250, 150, 100, 50);
		contentPane.add(lblNewLabel_2);

		TV_fee = new JTextField();//有线电视费文本框
		TV_fee.setColumns(10);
		TV_fee.setBounds(350, 163, 155, 25);
		contentPane.add(TV_fee);
		TV_fee.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_3 = new JLabel("供暖费：");
		lblNewLabel_3.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_3.setBounds(250, 200, 100, 50);
		contentPane.add(lblNewLabel_3);

		Heating_cost = new JTextField();//供暖费文本框
		Heating_cost.setColumns(10);
		Heating_cost.setBounds(350, 213, 155, 25);
		contentPane.add(Heating_cost);
		Heating_cost.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_4 = new JLabel("房款费：");
		lblNewLabel_4.setFont(new Font("宋体",Font.BOLD,15));
		lblNewLabel_4.setBounds(250, 250, 100, 50);
		contentPane.add(lblNewLabel_4);

		house_payment_information = new JTextField();//房款费文本框
		house_payment_information.setColumns(10);
		house_payment_information.setBounds(350, 263, 155, 25);
		contentPane.add(house_payment_information);
		house_payment_information.setEditable(true);//文本框可否编辑



		btnNewButton = new JButton("返回");//返回按钮
		btnNewButton.setBounds(20, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Administrator_Main_Window administrator_main_window = new Administrator_Main_Window(estateSQL);
				administrator_main_window.init();
				administrator_main_window.run();
				Water_Table.super.dispose();
			}
		});

		btnNewButton = new JButton("保存");//保存按钮
		btnNewButton.setBounds(650, 400, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag=JOptionPane.showConfirmDialog(null,"是否确认保存","提示窗口",JOptionPane.WARNING_MESSAGE);
				if (flag==0){
					String id=room_number.getText();
					boolean insert=estateSQL.insert_fee(id,Property_management_fees.getText(),WEG_Charges.getText(),TV_fee.getText(),Heating_cost.getText(),house_payment_information.getText());
					if (insert){
						JOptionPane.showMessageDialog(null,"保存成功","提示窗口",JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"保存失败","提示窗口",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		btnNewButton = new JButton("清空");//清空按钮
		btnNewButton.setBounds(650, 300, 100, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag1=JOptionPane.showConfirmDialog(null,"是否确认清空","提示窗口",JOptionPane.WARNING_MESSAGE);
				if(flag1 == 0){
					Property_management_fees.setText("");
					WEG_Charges.setText("");
					TV_fee.setText("");
					Heating_cost.setText("");
					house_payment_information.setText("");
				}
			}
		});

	}

}
