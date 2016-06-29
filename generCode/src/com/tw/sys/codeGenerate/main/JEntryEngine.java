package com.tw.sys.codeGenerate.main;

import javax.swing.UnsupportedLookAndFeelException;

import com.tw.sys.codeGenerate.frame.FrameStyle;
import com.tw.sys.codeGenerate.frame.MainFrame;

/** 
 * @ClassName: JEntryEngine 
 * @Description: 入口引擎启动类
 
 * @author DHL
 * @date 2014-3-12 下午9:19:09 
 */ 
public class JEntryEngine {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		FrameStyle.loadingStyle();
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	/**
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @Title: run
	 * @Class: JEntryEngine.java
	 * @Package: com.tw.sys.codeGenerate.main
	 * @Description: 代码生成器入口
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-16 上午11:42:05
	 */
	public static void run() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		FrameStyle.loadingStyle();
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
