package com.tw.sys.codeGenerate.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.UnsupportedLookAndFeelException;

import com.tw.sys.codeGenerate.frame.FrameStyle;
import com.tw.sys.codeGenerate.frame.MainFrame;
import com.tw.sys.codeGenerate.model.FieldModel;
import com.tw.sys.codeGenerate.model.TableForm;
import com.tw.sys.codeGenerate.util.FileUtil;
import com.tw.sys.codeGenerate.util.FormatUtil;
import com.tw.sys.codeGenerate.util.StringUtil;
import com.tw.sys.codeGenerate.util.configUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SuppressWarnings("all")
public class TwFreemarker {
	private Configuration configuration;
	private Template template;
	
	BufferedWriter bw; 
	
	File directory = new File("");
	
	/**
	 * @throws IOException 
	 * @Title: init
	 * @Class: TwFreemarker.java
	 * @Package: com.tw.sys.codeGenerate.freemarker
	 * @Description:初始化方法
	 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 上午9:50:32
	 */
	public void init(String templateName) throws IOException {
		String tempPath = directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + "template";
		//获取freemarker的Configuration实例
		configuration = new Configuration();
		//设置模板文件目录
		configuration.setDirectoryForTemplateLoading(new File(tempPath));
		configuration.setLocale(Locale.CHINA);
		configuration.setDefaultEncoding("UTF-8");
		//取得模板文件
		template = configuration.getTemplate(templateName);
		template.setEncoding("UTF-8");
	}
	
	/**
	 * @Title: process
	 * @Class: TwFreemarker.java
	 * @Package: com.tw.sys.codeGenerate.freemarker
	 * @Description:引擎入口
	 
	 *@param tableForm
	 * @throws Exception 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 上午10:15:18
	 */
	public void process(TableForm tableForm) throws Exception {
		Map map = new HashMap();
		map.put("authorOriginally", configUtil.getValue("authorOriginally"));
		String writeFilePath = "";
		String tableName = tableForm.getSelecedTable();
		
		tableName = tableName.toLowerCase();
		String objectName = StringUtil.convertUnderLine(tableName);
	   	       objectName = StringUtil.initialStrToUpper(objectName);
	           objectName = objectName.substring(0, objectName.indexOf("━"));
	           objectName = objectName.replace("OwnSys", "");
	    map.put("beanNameLower", StringUtil.initialStrToLower(objectName));
	    map.put("namespace", StringUtil.initialStrToLower(objectName));
	    map.put("beanName", StringUtil.initialStrToUpper(objectName));
	    String[] tabInfo = tableName.split("━");
	    String tableRemark = "";
	    if (tabInfo.length == 2) {
	    	tableRemark = tabInfo[1];
		}
	    map.put("tableName", tabInfo[0].toUpperCase());
	    map.put("tableRemark", tableRemark);
	    
	    String currentTime = FormatUtil.getCurrentDate(FormatUtil.Y_M_D_H_M);
	    map.put("currentTime", currentTime);
	    
	    //生成Bean文件
		if(tableForm.isBeanBol()){
			String packageName =  StringUtil.addPoint(tableForm.getBasePath(),"model");
			tableForm.setPackageName(packageName);
			
			map.put("packageName", packageName);
			
			packageName = StringUtil.convertPoint(packageName);
			String fileName = StringUtil.addPoint(StringUtil.initialStrToUpper(objectName),"java");
			writeFilePath =directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + packageName+"/"+fileName;
			tableForm.setWriteFilePath(writeFilePath);
			init("Bean.ftl");
			Map filteMap = new FilteBean().filteBeanFile(tableForm);
			
			map.put("fields", filteMap.get("list"));
			map.put("fieldStr", filteMap.get("fieldStr"));
			
			writeFile(tableForm,map);
		}
		//生成XML
		if(tableForm.isXmlBol()){
			String tabName = tableForm.getSelecedTable().split("━")[0];
			map.put("tabName", tabName);
			String packageName =  StringUtil.addPoint(tableForm.getBasePath(),"model");
			tableForm.setPackageName(packageName);
			
			map.put("packageName", packageName);
			
			packageName =  StringUtil.addPoint(tableForm.getBasePath(),"mapper");
			
			packageName = StringUtil.convertPoint(packageName);
			String fileName = StringUtil.addPoint(StringUtil.initialStrToUpper(objectName)+"Mapper","xml");
			writeFilePath =directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + packageName+"/"+fileName;
			tableForm.setWriteFilePath(writeFilePath);
			init("xml.ftl");
			Map filteMap = new FilteBean().filteBeanFile(tableForm);
			
			map.put("fields", filteMap.get("list"));
			map.put("fieldStr", filteMap.get("fieldStr"));
			
			
			writeFile(tableForm,map);
		}
		
		//生成Service及其实现类
		if(tableForm.isServiceBol()){
			String packageName =  StringUtil.addPoint(tableForm.getBasePath(),"service");
			tableForm.setPackageName(packageName);
			
			map.put("packageName", packageName);
			map.put("importPackage", packageName);
			
			packageName = StringUtil.convertPoint(packageName);
			String fileName = "I"+StringUtil.initialStrToUpper(objectName)+"Service.java";//StringUtil.addPoint(objectName,"java");
			writeFilePath =directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + packageName+"/"+fileName;
			tableForm.setWriteFilePath(writeFilePath);
			init("IService.ftl");
			writeFile(tableForm,map);
			
			{//Service实现类
				packageName =  StringUtil.addPoint(tableForm.getPackageName(),"Impl");
				map.put("packageName", packageName);
				packageName = StringUtil.convertPoint(packageName);
				fileName = StringUtil.initialStrToUpper(objectName)+"Service.java";
				writeFilePath =directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + packageName+"/"+fileName;
				tableForm.setWriteFilePath(writeFilePath);
				init("Service.ftl");
				writeFile(tableForm,map);
			}
		}
		
		//生成Controller文件
		if(tableForm.isControllerBol()){
			map.put("beanPackage", tableForm.getBasePath()+".model."+StringUtil.initialStrToUpper(objectName));
			map.put("servicePackage", tableForm.getBasePath()+".service.I"+StringUtil.initialStrToUpper(objectName)+"Service");
			String packageName =  StringUtil.addPoint(tableForm.getBasePath(),"controller");
			tableForm.setPackageName(packageName);
			
			map.put("packageName", packageName);
			
			packageName = StringUtil.convertPoint(packageName);
			String fileName = StringUtil.initialStrToUpper(objectName)+"Controller.java";
			writeFilePath =directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + packageName+"/"+fileName;
			tableForm.setWriteFilePath(writeFilePath);
			init("Controller.ftl");
			Map filteMap = new FilteBean().filteBeanFile(tableForm);
			
			map.put("fields", filteMap.get("list"));
			map.put("fieldStr", filteMap.get("fieldStr"));
			
			writeFile(tableForm,map);
		}
		/*//生成Jsp文件
		if(tableForm.isJspBol()){
			String fileName = StringUtil.initialStrToUpper(objectName)+".jsp";
			map.put("jspRootPath", configUtil.getValue("JspRootPath"));
			writeFilePath =directory.getCanonicalPath() + "/src/main/webapp/" + configUtil.getValue("JspRootPath") +fileName;
			tableForm.setWriteFilePath(writeFilePath);
			init("jsp.ftl");
			Map filteMap = new FilteBean().filteBeanFile(tableForm);
			
			map.put("fields", filteMap.get("list"));
			map.put("fieldStr", filteMap.get("fieldStr"));
			
			writeFile(tableForm,map);
			
			{
				fileName = StringUtil.initialStrToUpper(objectName)+"Form.jsp";
				writeFilePath =directory.getCanonicalPath() + "/src/main/webapp/" + configUtil.getValue("JspRootPath") +fileName;
				tableForm.setWriteFilePath(writeFilePath);
				init("jspForm.ftl");
				writeFile(tableForm,map);
			}
		}*/
		
		//生成Manager
		if(tableForm.isManagerBol()){
			String packageName =  StringUtil.addPoint(tableForm.getBasePath(),StringUtil.initialStrToLower(objectName)+"Manager");
			tableForm.setPackageName(packageName);
			
			map.put("packageName", packageName);
			map.put("importPackage", packageName);
			
			packageName = StringUtil.convertPoint(packageName);
			String fileName = StringUtil.initialStrToUpper(objectName)+"Manager.java";
			writeFilePath =directory.getCanonicalPath() + "/src/" + configUtil.getValue("defaultStartPath") + packageName+"/"+fileName;
			tableForm.setWriteFilePath(writeFilePath);
			init("bpms_Manager.ftl");
			Map filteMap = new FilteBean().filteBeanFile(tableForm);
			map.put("fields", filteMap.get("list"));
			map.put("fieldStr", filteMap.get("fieldStr"));
			writeFile(tableForm,map);
		}
		//生成js
			if(tableForm.isJsBol()){
				String fileName = StringUtil.initialStrToLower(objectName)+".js";
//				map.put("jspRootPath", configUtil.getValue("JspRootPath"));
				map.put("jspRootPath", StringUtil.initialStrToLower(objectName));
				
				writeFilePath =directory.getCanonicalPath() + "/src/"+StringUtil.convertPoint(tableForm.getBasePath())+"/"+StringUtil.initialStrToLower(objectName)+"/"+configUtil.getValue("JsRootPath")+fileName;
				tableForm.setWriteFilePath(writeFilePath);
				init("bpms_js.ftl");
				Map filteMap = new FilteBean().filteBeanFile(tableForm);
				map.put("fields", filteMap.get("list"));
				map.put("fieldStr", filteMap.get("fieldStr"));
				writeFile(tableForm,map);
			}//生成Html文件
			if(tableForm.isJspBol()){
				String fileName = objectName.toUpperCase()+".htm";
//				map.put("jspRootPath", configUtil.getValue("JspRootPath"));
				map.put("jspRootPath", StringUtil.initialStrToLower(objectName));
				writeFilePath =directory.getCanonicalPath() + "/src/"+StringUtil.convertPoint(tableForm.getBasePath())+"/" +StringUtil.initialStrToLower(objectName)+"/"+fileName;
				tableForm.setWriteFilePath(writeFilePath);
				init("bpms_html.ftl");
				Map filteMap = new FilteBean().filteBeanFile(tableForm);
				
				map.put("fields", filteMap.get("list"));
				map.put("fieldStr", filteMap.get("fieldStr"));
				
				writeFile(tableForm,map);
			}
	}
	
	/**
	 * @Title: writeFile
	 * @Class: TwFreemarker.java
	 * @Package: com.tw.sys.codeGenerate.freemarker
	 * @Description:根据不同模版生成所需文件
	 
	 *@param tableForm
	 * @throws IOException 
	 * @throws TemplateException 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 上午10:29:18
	 */
	public void writeFile(TableForm tableForm,Map dataMap) throws TemplateException, IOException {
		String writeFilePath = tableForm.getWriteFilePath();
		if (FileUtil.createFile(writeFilePath)) {
			File outFile = new File(writeFilePath);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
			
			template.process(dataMap, bw);
			bw.close();
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		/*FrameStyle.loadingStyle();
		MainFrame frame = new MainFrame();
		frame.setVisible(true);*/
		
		StringUtil.initialStrToUpper("APPLEAUDIT");
		System.out.println(StringUtil.initialStrToLower(StringUtil.convertUnderLine("own_sys_sqcz_ddk")));
	}
}
