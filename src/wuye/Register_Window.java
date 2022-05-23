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
	Register_Window(){
	}
	static Register_Window frame5 = new Register_Window();
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			frame5.init();
			frame5.setLocationRelativeTo(null);
			frame5.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	void init() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("业主姓名：");
		lblNewLabel.setBounds(20, 45, 83, 30);
		contentPane.add(lblNewLabel);

		name = new JTextField();//姓名文本框
		name.setBounds(102, 50, 155, 21);
		contentPane.add(name);
		name.setColumns(10);
		name.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(20, 84, 83, 30);
		contentPane.add(lblNewLabel_1);

		pwd = new JTextField();
		pwd.setBounds(102, 89, 155, 21);
		contentPane.add(pwd);
		pwd.setColumns(10);
		pwd.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_1_1 = new JLabel("联系电话：");
		lblNewLabel_1_1.setBounds(20, 131, 83, 30);
		contentPane.add(lblNewLabel_1_1);

		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(102, 136, 155, 21);
		contentPane.add(mobile);
		mobile.setEditable(true);//文本框可否编辑

		JLabel lblNewLabel_1_2 = new JLabel("楼门牌号：");
		lblNewLabel_1_2.setBounds(20, 171, 83, 30);
		contentPane.add(lblNewLabel_1_2);

		Room_number = new JTextField();
		Room_number.setColumns(10);
		Room_number.setBounds(102, 176, 155, 21);
		contentPane.add(Room_number);
		Room_number.setEditable(true);//文本框可否编辑

		JLabel sex = new JLabel("性别：");
		sex.setBounds(46, 190, 83, 30);
		contentPane.add(sex);

		sextext = new JTextField();
		sextext.setColumns(10);
		sextext.setBounds(102, 200, 155, 21);
		contentPane.add(sextext);
		sextext.setEditable(true);//文本框可否编辑

		btnNewButton = new JButton("返回");//返回
		btnNewButton.setBounds(20, 230, 93, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login_Window mainInterface=new Login_Window(estateSQL);
				mainInterface.run();
				frame5.dispose();
			}
		});
		btnNewButton = new JButton("保存");//保存按钮
		btnNewButton.setBounds(300, 230, 93, 23);
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

		btnNewButton = new JButton("清空");//清空按钮
		btnNewButton.setBounds(300, 200, 93, 23);
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
