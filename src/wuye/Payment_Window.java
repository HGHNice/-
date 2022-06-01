package wuye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Payment_Window extends JFrame {

	private JPanel contentPane;
	static Payment_Window frame3 = new Payment_Window();
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_9;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public void run() {
		try {
			frame3.init();
			frame3.setLocationRelativeTo(null);
			frame3.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void init() {
		setTitle("缴费情况");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel_9 = new JLabel("是否欠费：");
		lblNewLabel_9.setBounds(20, 5, 83, 30);
		contentPane.add(lblNewLabel_9);

		textField_9 = new JTextField();//是否欠费文本框
		textField_9.setBounds(102, 5, 155, 21);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		textField_9.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel = new JLabel("物业管理费：");
		lblNewLabel.setBounds(20, 40, 83, 30);
		contentPane.add(lblNewLabel);

		textField = new JTextField();//物业管理费文本框
		textField.setBounds(102, 40, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("水电煤气费：");
		lblNewLabel_1.setBounds(20, 75, 83, 30);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();//水电煤气费文本框
		textField_1.setBounds(102, 75, 155, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_2 = new JLabel("有线电视费：");
		lblNewLabel_2.setBounds(20, 110, 83, 30);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();//有线电视费文本框
		textField_2.setColumns(10);
		textField_2.setBounds(102, 110, 155, 21);
		contentPane.add(textField_2);
		textField_2.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_3 = new JLabel("供暖费：");
		lblNewLabel_3.setBounds(20, 145, 83, 30);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();//供暖费文本框
		textField_3.setColumns(10);
		textField_3.setBounds(102, 145, 155, 21);
		contentPane.add(textField_3);
		textField_3.setEditable(false);//文本框可否编辑

		JLabel lblNewLabel_4 = new JLabel("房款费：");
		lblNewLabel_4.setBounds(20, 180, 83, 30);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();//房款费文本框
		textField_4.setColumns(10);
		textField_4.setBounds(102, 180, 155, 21);
		contentPane.add(textField_4);
		textField_4.setEditable(false);//文本框可否编辑

		btnNewButton = new JButton("返回");//返回
		btnNewButton.setBounds(20, 220, 93, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

}
