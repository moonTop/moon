package com.tw.sys.codeGenerate.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {
	private  final static Log log = LogFactory.getLog(FileUtil.class);
	/**
	 * @Title: createFile
	 * @Class: FileUtil.java
	 * @Package: com.tw.sys.codeGenerate.util
	 * @Description:创建单个文件
	 
	 *@param destFileName 文件名
	 *@return 创建成功返回true，否则返回false
	 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 上午10:26:10
	 */
	public static boolean createFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists()) {
			log.info("创建单个文件" + destFileName + "失败，目标文件已存在！");
			return false;
		}
		if (destFileName.endsWith(File.separator)) {
			log.info("创建单个文件" + destFileName + "失败，目标不能是目录！");
			return false;
		}
		if (!file.getParentFile().exists()) {
			log.info("目标文件所在路径不存在，准备创建。。。");
			if (!file.getParentFile().mkdirs()) {
				log.info("创建目录文件所在的目录失败！");
				return false;
			}
		}
		// 创建目标文件
		try {
			if (file.createNewFile()) {
				log.info("创建单个文件" + destFileName + "成功！");
				return true;
			} else {
				log.info("创建单个文件" + destFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.info("创建单个文件" + destFileName + "失败！");
			return false;
		}
	}
}
