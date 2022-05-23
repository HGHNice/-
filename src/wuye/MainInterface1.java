package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface1 extends JFrame {
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_7;
	static MainInterface1 frame1=new MainInterface1();
	private JPanel contentPane;
	public void run() {
		try {
			frame1.init();
			frame1.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void init(){
		setVisible(true);
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
			UserWindow user=new UserWindow();
			user.run();
			frame1.dispose();
			}
		});

		btnNewButton_1 = new JButton("");//抄表数据按钮
		btnNewButton_1.setBounds(80, 200, 108, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Watertable watertable=new Watertable();
				watertable.run();
				frame1.dispose();
			}
		});


		btnNewButton_2 = new JButton("");          //缴费情况按钮
		btnNewButton_2.setBounds(620, 100, 108, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Payment payment=new Payment();
				payment.run();
				frame1.dispose();
			}
		});

		/*btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(60, 310, 108, 35);
		contentPane.add(btnNewButton_3);*/

		btnNewButton_4 = new JButton("");  //总体统计按钮
		btnNewButton_4.setBounds(620, 200, 108, 35);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Alltable alltable=new Alltable();
				alltable.run();
				frame1.dispose();
			}
		});

		/*btnNewButton_5 = new JButton("");   //修改密码
		btnNewButton_5.setBounds(635, 138, 108, 35);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			ChangePassword changePassword=new ChangePassword();
			changePassword.run();
			frame1.dispose();
			}
		});

		btnNewButton_6 = new JButton("");   //历史数据
		btnNewButton_6.setBounds(635, 219, 108, 35);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Historicaldata historicaldata=new Historicaldata();
				historicaldata.run();
				frame1.dispose();
			}
		});*/

		btnNewButton_4 = new JButton("");//返回系统
		btnNewButton_4.setBounds(80, 300, 108, 35);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainInterface mainInterface1=new MainInterface();
				MainInterface.run();
				frame1.dispose();
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

		/*JLabel lblNewLabel_5 = new JLabel("\u5386\u53F2\u6570\u636E\u67E5\u8BE2\u300B");
		lblNewLabel_5.setBounds(285, 168, 84, 26);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u9000\u51FA\u7CFB\u7EDF\u300B");
		lblNewLabel_6.setBounds(297, 246, 72, 26);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u8BF7\u9009\u62E9\u76F8\u5E94\u529F\u80FD\uFF01");
		lblNewLabel_7.setBounds(133, 26, 96, 15);
		panel.add(lblNewLabel_7);*/

		frame1.setLocationRelativeTo(null);

	}



	}


