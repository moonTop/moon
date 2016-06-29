package com.tw.sys.codeGenerate.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.tw.sys.codeGenerate.freemarker.TwFreemarker;
import com.tw.sys.codeGenerate.model.DBModel;
import com.tw.sys.codeGenerate.model.TableForm;

@SuppressWarnings("all")
public class TableFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -2818046268082166135L;
//	JPanel panel = new JPanel();
	DBModel model = null ;
	JLabel tablesLab = new JLabel("请选择表："),
		   columnsLab = new JLabel("所有字段"),
		   selectedLab = new JLabel("所选字段"),
		   storePathLab = new JLabel("存储路径："),
	   	   rootPathLab = new JLabel("根路径：");
	
	JComboBox tablesCombox = new JComboBox();
	JList jlistTables ;
	DefaultListModel jlistModelTables;
	JList jlistLeft ;
	DefaultListModel jlistModelLeft;
	JList jlistRight ;
	DefaultListModel jlistModelRight;

	JButton left = new JButton("<");
	JButton leftAll = new JButton("<<");
	JButton right = new JButton(">");
	JButton rightAll = new JButton(">>");
	
	JTextField basePathTxt = new JTextField();
	JTextField storePathTxt = new JTextField();
	JCheckBox isBean = new JCheckBox("生成Bean类");//是否生成Bean类
	JCheckBox isService = new JCheckBox("生成Service类及其子类");//是否生成Service类及其子类	
	JCheckBox isXml = new JCheckBox("生成xml文件");//是否生成xml文件	
	JCheckBox isJsp = new JCheckBox("生成Html文件");//是否生成jsp文件	
	JCheckBox isController = new JCheckBox("生成Controller类");//是否生成Controller文件	
	JCheckBox isJs = new JCheckBox("生成js文件");//是否生成Controller文件	
	JCheckBox isManager = new JCheckBox("生成Manager类");//是否生成Controller文件	
	
	JButton commit = new JButton("确 定");
	JButton back = new JButton("返回");

	public TableFrame(DBModel dmodel) throws Exception {
		super();
		initGUI(dmodel);
	}

	private void initGUI(DBModel dmodel) throws Exception{
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.model = dmodel;
			{
				tablesLab.setBounds(50, 20, 70, 30);
				getContentPane().add(tablesLab);
			}
			{
				tablesCombox = FrameItemUtil.tablesComboBox(dmodel);
				tablesCombox.setMaximumRowCount(10);
				tablesCombox.setBounds(130, 20, 430, 30);
				getContentPane().add(tablesCombox);
				tablesCombox.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    	  tablesComboxActionPerformed(actionEvent);
				      }
				});
			}
			{//没有选中事件
				jlistModelTables = new DefaultListModel();
				jlistTables = new JList(jlistModelTables);
				jlistTables.setVisibleRowCount(1);
				JScrollPane jspTables=new JScrollPane(jlistLeft);
				jspTables.setBounds(130, 20, 120, 30);
//				getContentPane().add(jspTables);
			}
			{
				columnsLab.setBounds(20, 70, 150, 30);
				getContentPane().add(columnsLab);
			}
			{
				jlistModelLeft = new DefaultListModel();
				jlistLeft = new JList(jlistModelLeft);
				jlistLeft.setVisibleRowCount(8);
				JScrollPane jspLeft=new JScrollPane(jlistLeft);
				jspLeft.setBounds(20, 100, 230, 315);
				getContentPane().add(jspLeft);
			}
			{
				selectedLab.setBounds(330, 70, 150, 30);
				getContentPane().add(selectedLab);
			}
			{
				jlistModelRight = new DefaultListModel();
				jlistRight = new JList(jlistModelRight);
				jlistRight.setVisibleRowCount(8);
				JScrollPane jspRight=new JScrollPane(jlistRight);
				jspRight.setBounds(330, 100, 230, 315);
				getContentPane().add(jspRight);
			}
			{
				rightAll.setBounds(260, 150, 60, 30);
				getContentPane().add(rightAll);
				rightAll.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    	  rightAllActionPerformed(actionEvent);
				      }
				});
			}
			{
				right.setBounds(260, 190, 60, 30);
				getContentPane().add(right);
				right.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    	  rightActionPerformed(actionEvent);
				      }
				});
			}
			{
				leftAll.setBounds(260, 230, 60, 30);
				getContentPane().add(leftAll);
				leftAll.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    	  leftAllActionPerformed(actionEvent);
				      }
				});
			}
			{
				left.setBounds(260, 270, 60, 30);
				getContentPane().add(left);
				left.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    	  leftActionPerformed(actionEvent);
				      }
				});
			}
			{
				rootPathLab.setBounds(20, 435, 120, 20);
				getContentPane().add(rootPathLab);
			}
			{
				basePathTxt.setBounds(80, 435, 480, 20);
				getContentPane().add(basePathTxt);
				ResourceBundle bundle = ResourceBundle.getBundle("config");
				String defaultRootPath = bundle.getString("defaultRootPath");
				basePathTxt.setText(defaultRootPath);
			}
			{
				isBean.setBounds(15, 470, 90, 20);
				getContentPane().add(isBean);
			}
			{
				isService.setBounds(120, 470, 110, 20);
				getContentPane().add(isService);
			}
			{
				isController.setBounds(240, 470, 110, 20);
				getContentPane().add(isController);
			}
			{
				isXml.setBounds(370, 470, 100, 20);
				getContentPane().add(isXml);
			}
			{
				isJsp.setBounds(470, 470, 110, 20);
				getContentPane().add(isJsp);
			}
			{
				isJs.setBounds(15, 520, 90, 20);
				getContentPane().add(isJs);
			}
			{
				isManager.setBounds(120, 520, 110, 20);
				getContentPane().add(isManager);
			}
			{
				commit.setBounds(340, 520, 100, 30);
				getContentPane().add(commit);
				commit.addActionListener(this);
			}
			{
				back.setBounds(460, 520, 100, 30);
				getContentPane().add(back);
				back.addActionListener(this);
			}
			
			
			pack();	
			setSize(585, 600);
			setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == commit) {
			String selecedTable = tablesCombox.getSelectedItem().toString().trim() ;
			if(!"请选择".equals(selecedTable)) {
				int rightSize = jlistRight.getMaxSelectionIndex();
				DefaultListModel dListModel = (DefaultListModel) jlistRight.getModel();
				Object rightAllValues[] = new Object[rightSize+1];//jlistRight.getSelectedValues();
				for (int i = 0; i <= rightSize; i++) {
					rightAllValues[i] = dListModel.get(i);
				}
				String basePath = basePathTxt.getText().trim();
				String storePath = storePathTxt.getText().trim();
				boolean isBeanBol = isBean.isSelected();
				boolean isServiceBol = isService.isSelected();
				boolean isXmlBol = isXml.isSelected();
				boolean isJspBol = isJsp.isSelected();
				boolean isControllerBol = isController.isSelected();
				boolean isJsBol = isJs.isSelected();
				boolean isManagerBol = isManager.isSelected();
				if(rightAllValues.length<= 0){
					JOptionPane.showMessageDialog(null,"至少要添加一个字段");
					return;
				}
				if("".equals(basePath)&&"".equals(storePath)){
					JOptionPane.showMessageDialog(null,"根路径和存储路径不可同时为空");
					return;
				}
				if(!isControllerBol&&!isJspBol&&!isXmlBol&&!isServiceBol&&!isBeanBol&&!isJsBol&&!isManagerBol){
					JOptionPane.showMessageDialog(null,"只是要选择一个生成文件类别");
					return;
				}
				try {
					TableForm tableForm = new TableForm();
					tableForm.setModel(model);
//					tableForm.setDbType(model.getDBtype());
					tableForm.setSelecedTable(selecedTable);
					tableForm.setBasePath(basePath);
					tableForm.setStorePath(storePath);
					tableForm.setRightAllValues(rightAllValues);
					tableForm.setBeanBol(isBeanBol);
					tableForm.setServiceBol(isServiceBol);
					tableForm.setXmlBol(isXmlBol);
					tableForm.setJspBol(isJspBol);
					tableForm.setControllerBol(isControllerBol);
					tableForm.setJsBol(isJsBol);
					tableForm.setManagerBol(isManagerBol);
					System.out.println("success......");
//					new FileGenerateAction().engineEntry(tableForm);
					new TwFreemarker().process(tableForm);
					JOptionPane.showMessageDialog(null,"已经成功生成\n\t"+getMessage(tableForm));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "系统出现异常..."+e1, "STAR提醒您", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "请选择表！", "STAR提醒您",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == back){
			this.setVisible(false);
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
//			System.exit(0);
		} 
	}
	
	/**
	 * 获取提示信息
	 * @param tableForm
	 * @return
	 */
	private String getMessage(TableForm tableForm){
		StringBuffer message = new StringBuffer();
		message.append("表："+tableForm.getSelecedTable()+"\n\t");
		if(tableForm.isBeanBol()){
			message.append("Bean文件  ");
		}
		if(tableForm.isServiceBol()){
			message.append("Service文件  ");
		}
		if(tableForm.isXmlBol()){
			message.append("Xml文件  ");
		}
		if(tableForm.isJspBol()){
			message.append("Jsp文件  ");
		}
		if (tableForm.isControllerBol()) {
			message.append("Controller文件");
		}
		if (tableForm.isJsBol()) {
			message.append("JS文件");
		}
		if (tableForm.isManagerBol()) {
			message.append("Manager文件");
		}
		return message.toString();
	}

	/**
	 * ">" 选择左边字段向右移
	 * @param evt
	 */
	private void rightActionPerformed(ActionEvent evt) {
		if (jlistLeft.getSelectedIndex() != -1) {
			jlistModelRight.addElement(jlistLeft.getSelectedValue());
			int i = jlistLeft.getSelectedIndex();
			jlistModelLeft.remove(i);
			jlistLeft.setSelectedIndex(i > 0 ? i - 1 : 0);
			jlistRight.setSelectedIndex(jlistModelRight.size() - 1);
		}
	}
	
	/**
	 * ">>"左边所选所有字段向右移
	 * @param evt
	 */
	private void rightAllActionPerformed(ActionEvent evt) {
		if (jlistLeft.getSelectedIndex() != -1) {
			Object leftAllValues[] =  jlistLeft.getSelectedValues();
			for (int i = 0; i < leftAllValues.length; i++) {
				jlistModelRight.addElement(leftAllValues[i]);
				int j = jlistLeft.getSelectedIndex();
				jlistRight.setSelectedIndex(i);
				jlistModelLeft.remove(j);
			}
		}
	}

	/**
	 * "<"选择右边字段向左移
	 * @param evt
	 */
	private void leftActionPerformed(ActionEvent evt) {
		if (jlistRight.getSelectedIndex() != -1) {
			jlistModelLeft.addElement(jlistRight.getSelectedValue());
			int i = jlistRight.getSelectedIndex();
			jlistModelRight.remove(i);
			jlistRight.setSelectedIndex(i > 0 ? i - 1 : 0);
			jlistLeft.setSelectedIndex(jlistModelLeft.size() - 1);
		}
	}
	
	/**
	 * "<<"右边所选所有字段向左移
	 * @param evt
	 */
	private void leftAllActionPerformed(ActionEvent evt) {
		if (jlistRight.getSelectedIndex() != -1) {
			Object rightAllValues[] =  jlistRight.getSelectedValues();
			for (int i = 0; i < rightAllValues.length; i++) {
				jlistModelLeft.addElement(rightAllValues[i]);
				int j = jlistRight.getSelectedIndex();
				jlistModelRight.remove(j);
			}
		}
	}

	/** tablesCombox 选中表后列出所有字段列  */
	private void tablesComboxActionPerformed(ActionEvent evt) {
		String selectedTable = tablesCombox.getSelectedItem().toString();
		if(model != null ){
			if("请选择".equals(selectedTable)){
				JOptionPane.showMessageDialog(null, "请选择表", "STAR提醒您", JOptionPane.ERROR_MESSAGE);
			}else{
				selectedTable = selectedTable.substring(0, selectedTable.indexOf("━"));
				jlistModelRight.clear();
				columnsLab.setText(selectedTable+"表字段");
				FrameItemUtil.columnsJList(jlistModelLeft,model, selectedTable);
				jlistLeft.setSelectedIndex(0);
			}
		}
	}
	

}