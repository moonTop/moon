package com.tw.sys.codeGenerate.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.tw.sys.codeGenerate.model.DBModel;
import com.tw.sys.codeGenerate.util.configUtil;

@SuppressWarnings("all")
public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -2818046268082166135L;
	JPanel contentPane = new JPanel();
	String db_Type = null;

	JLabel dbType_lab = new JLabel("数据库类型："),
		   dbUrl_lab = new JLabel("URL："),
	       userName_lab = new JLabel("用户名："),
	       password_lab = new JLabel("密码：");
	JTextField dbUrl_txt = new JTextField();
	JTextField userName_txt = new JTextField();
	JTextField password_txt = new JTextField();
	
	JComboBox dbType = new JComboBox();

	JButton button1 = new JButton("确 定"), button2 = new JButton("退出");

	public MainFrame() {
		setResizable(false);
		setBounds(100, 100, 479, 304);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("数据库连接配置");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("请输入下面相关信息："));
		
		dbUrl_lab.setBounds(30, 50, 120, 30);
		userName_lab.setBounds(30, 104, 120, 30);
		password_lab.setBounds(30, 158, 120, 30);
		dbUrl_txt.setBounds(97, 50, 350, 30);
		userName_txt.setBounds(97, 104, 350, 30);
		password_txt.setBounds(97, 158, 350, 30);
		button1.setBounds(200, 220, 100, 30);
		button2.setBounds(345, 220, 100, 30);
		
		contentPane.add(dbUrl_lab);
		contentPane.add(userName_lab);
		contentPane.add(password_lab);
		contentPane.add(dbUrl_txt);
		contentPane.add(userName_txt);
		contentPane.add(password_txt);
		contentPane.add(button1);
		contentPane.add(button2, BorderLayout.EAST);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		Map<String, String> connInfo = configUtil.getConnInfo();
		dbUrl_txt.setText(connInfo.get("url"));
		userName_txt.setText(connInfo.get("username"));
		password_txt.setText(connInfo.get("password"));
		this.db_Type = connInfo.get("dialect");
		
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			String db_url = dbUrl_txt.getText().trim() ; 
			String userName = userName_txt.getText().trim() ; 
			String password = password_txt.getText().trim() ; 
			if(!"".equals(userName) && !"".equals(password)) {
				DBModel model = new DBModel();
				model.setDBurl(db_url);
				model.setDBtype(db_Type);
				model.setDBuser(userName);
				model.setDBpwd(password);
				try {
					showTableFrame(model);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "系统出现异常..."+e1, "STAR提醒您", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println("success......");
				this.setVisible(false);
//				this.dispose();
			} else if ("".equals(userName) ){
				JOptionPane.showMessageDialog(null, "请输入用户名", "STAR提醒您", JOptionPane.ERROR_MESSAGE);
			} else{
				JOptionPane.showMessageDialog(null, "用户名密码不允许为空！！", "STAR提醒您",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == button2) System.exit(0);
	}

	public void showTableFrame(DBModel model) throws Exception{
		TableFrame tableF = new TableFrame(model);
		tableF.setResizable(false);
		tableF.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		tableF.setTitle("数据库表配置");
		tableF.setVisible(true);
	}
}