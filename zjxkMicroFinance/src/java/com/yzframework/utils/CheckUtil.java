package com.yzframework.utils;

public class CheckUtil {

	/**
	 * 文本内容校验共同方法类
	 */
	public CheckUtil() {}

	/**
	 * NULL CHECK
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isNull(String value) {
		return value == null;
	}

	/**
	 * 空 CHECK
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isEmpty(String value) {
		return value.length() == 0;
	}

	/**
	 * 项目校验【NULL或空】
	 * 
	 * @param value
	 * @return true：NULL或空   false：非空
	 */
	public static boolean isNullOrEmpty(String value) {
		return isNull(value) || isEmpty(value);
	}

	/**
	 * 必须项目校验
	 * 
	 * @param value
	 * @return true：验证内容非空   false：验证内容为空
	 */
	public static boolean isRequired(String value) {
		if (isNullOrEmpty(value)) {
			value = "";
		}
		if (isEmpty(value.trim())) {
			return false;
		}
		return true;
	}
	
}
