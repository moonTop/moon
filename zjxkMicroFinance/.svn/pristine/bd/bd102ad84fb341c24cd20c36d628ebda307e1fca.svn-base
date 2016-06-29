package com.yzframework.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {

	/**
	 * 类型转换共通方法类
	 */
	public ConvertUtil() {}


	/**
	 * 将object转换为整型
	 * @param value
	 * @return 整型数据,空的时候转换为0
	 */
	public static Integer objToInt(Object value) {
		Integer retInt = 0;
		try{
			retInt = Integer.valueOf(value.toString());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return retInt;
	}
	
	/**
	 * 字符串转换为整型
	 * @param value
	 * @return 整型数据
	 */
	public static Integer strToInt(String value) {
		Integer retInt = 0;
		try{
			retInt = Integer.valueOf(value);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return retInt;
	}
	
	/**
	 * 字符串转换为Double
	 * @param value
	 * @return 整型数据
	 */
	public static Double strToDouble(String value) {
		Double retDou = 0.0;
		try{
			retDou = Double.valueOf(value);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return retDou;
	}
	
	/**
	 * 字符串转换为BigDecimal
	 * @param value
	 * @return 整型数据
	 */
	public static BigDecimal strToDec(String value) {
		BigDecimal retDec = new BigDecimal(0);
		try{
			retDec = BigDecimal.valueOf(Double.valueOf(value));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return retDec;
	}
	
	/**
	 * 日期转换为指定格式字符串
	 * @param value
	 * @return 字符串
	 */
	public static String dateToYMDStr(Date value,String strFmt) {
		String retStr = "";
		if (value == null){
			return "";
		}
		if(CheckUtil.isNullOrEmpty(strFmt)){
			strFmt = "yyyy-MM-dd";
		}
		DateFormat dtFormat = new SimpleDateFormat(strFmt);

		try{
			return dtFormat.format(value);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return retStr;
	}
	
	/**
	 * 将字符串转换为日期
	 * 
	 * @param 日期型 字符串
	 * @return 日期
	 */
	public static Date strToDate(String value,String strFmt){
		Date retDate = null;
		if(CheckUtil.isNullOrEmpty(strFmt)){
			strFmt = "yyyy-MM-dd";
		}
		DateFormat dtFormat = new SimpleDateFormat(strFmt);

		try{
			retDate = dtFormat.parse(value);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return retDate;
	}
	
	/**
	 * 将字符串转换为数据库日期
	 * 
	 * @param 日期型 字符串
	 * @return 日期
	 */
	public static java.sql.Date strToSqlDate(String value){
		java.sql.Date retDate = null;
		try{
			return java.sql.Date.valueOf(value);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return retDate;
	}
	
	/**
     * TimeStamp格式化
     * 
     * @param TimeStamp 日期
     * @return 格式化日期
     */
    public static String formatTimeStamp(Timestamp date, String formatString){
        DateFormat df = new SimpleDateFormat(formatString);
        String str = "";
        try{
            str = df.format(date);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return str;
    }
	
	
}
