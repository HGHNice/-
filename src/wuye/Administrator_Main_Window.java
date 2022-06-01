package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrator_Main_Window extends JFrame {
	EstateSQL estateSQL;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_4;
	Administrator_Main_Window(EstateSQL estateSQL){
		this.estateSQL = estateSQL;
	}
	private JPanel contentPane;
	public void run() {
			setVisible(true);
	}
	void init(){
		setTitle("物业管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("");   //业主基本信息按钮
		btnNewButton.setBounds(80, 100, 108, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_1 = new JButton("");//抄表数据按钮
		btnNewButton_1.setBounds(80, 200, 108, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				All_Table all_table = new All_Table(estateSQL);
				all_table.init();
				all_table.run();
				Administrator_Main_Window.super.dispose();
			}
		});


		btnNewButton_2 = new JButton("");          //缴费情况按钮
		btnNewButton_2.setBounds(620, 100, 108, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4 = new JButton("");  //总体统计按钮
		btnNewButton_4.setBounds(620, 200, 108, 35);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4 = new JButton("");//返回系统
		btnNewButton_4.setBounds(80, 300, 108, 35);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4E3B\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(221, 53, 369, 293);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("<业主基本信息");
		lblNewLabel.setBounds(7, 50, 100, 35);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<抄表数据");
		lblNewLabel_1.setBounds(7, 150, 150, 35);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("缴费情况>");
		lblNewLabel_2.setBounds(297, 50, 100, 35);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("总体统计>");
		lblNewLabel_3.setBounds(297, 150, 100, 35);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("<返回");
		lblNewLabel_4.setBounds(7, 250, 72, 26);
		panel.add(lblNewLabel_4);
	}
}


