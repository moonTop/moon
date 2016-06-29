package com.tw.sys.codeGenerate.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * @ClassName: FormatTool 
 * @Description: 格式化工具类（日期、数字、字符串）
 
 * @author DHL
 * @date 2014-3-12 下午8:56:34 
 */ 
@SuppressWarnings("all")
public class FormatUtil {
	public static final int H_M = 0;
	public static final int H_M_S = 1;
	public static final int Y_M_D = 2;
	public static final int Y_M_D_H_M = 3;
	public static final int Y_M_D_H_M_S = 4;
	public static final int MM = 5;
	public static final int yyyyMMdd = 6;
	public static final int MMdd = 7;
	public static final int MM_DD_YYYY = 8;
	public static final int DD_MM_YYYY = 9;
	
	private static SimpleDateFormat dateformat0;
	private static SimpleDateFormat dateformat1;
	private static SimpleDateFormat dateformat2;
	private static SimpleDateFormat dateformat3;
	private static SimpleDateFormat dateformat4;
	private static SimpleDateFormat dateformat5;
	private static SimpleDateFormat dateformat6;
	private static SimpleDateFormat dateformat7;
	private static SimpleDateFormat dateformat8;
	private static SimpleDateFormat dateformat9;
	
	public static final double RESERVEONE = 10.0;
	public static final double RESERVETWO = 100.0;
	public static final double RESERVETHREE = 1000.0;
	public static final double RESERVEFOUR = 10000.0;
	public static final String FORMATTWO = "###.00";
	public static final String FORMATTHREE = "##.000";
	public static final String FORMATFOUR = "##.0000";
	public static final String FORMAT_SPLIT = "#,###,###";
	public static final String FORMAT_TWO_SPLIT = "#,###,###.00";
	
	static{
		dateformat0 = new SimpleDateFormat("HH:mm");
		dateformat1 = new SimpleDateFormat("HH:mm:ss");
		dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
		dateformat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateformat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateformat5 = new SimpleDateFormat("MM");
		dateformat6 = new SimpleDateFormat("yyyyMMdd");
		dateformat7 = new SimpleDateFormat("MM-dd");
		dateformat8 = new SimpleDateFormat("MM-dd-yyyy");
		dateformat9 = new SimpleDateFormat("dd-MM-yyyy");
	}
	
	private static SimpleDateFormat getFormat(int num){
		SimpleDateFormat dateformat = null;
		switch(num){
			case H_M:
				dateformat = dateformat0;
				break;
			case H_M_S:
				dateformat = dateformat1;
				break;
			case Y_M_D:
				dateformat = dateformat2;
				break;
			case Y_M_D_H_M:
				dateformat = dateformat3;
				break;
			case Y_M_D_H_M_S:
				dateformat = dateformat4;
				break;
			case MM:
				dateformat = dateformat5;
				break;
			case yyyyMMdd:
				dateformat = dateformat6;
				break;
			case MMdd:
				dateformat = dateformat7;
				break;
			case MM_DD_YYYY:
				dateformat = dateformat8;
				break;
			case DD_MM_YYYY:
				dateformat = dateformat9;
				break;
			default:break;
		}
		return dateformat;
	}
	
	/**
	 * @Title: numberFormat
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 格式化数字
	 
	 *@param number		被格式化的数字
	 *@param splitor	间隔符号
	 *@param step		间隔数
	 *@return			被格式化后的字符串
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:57:57
	 */
	public static String numberFormat(String number,String splitor,int step){
		number = number.toString();
		int len = number.length();
		if(len > step) {
			 int l1 = len%step ; 
			 int l2 = len/step;
			 StringBuffer	arr = new StringBuffer();
			 String	first = number.substring(0, l1);
			 if(!"".equals(first)) {
				 arr.append(first);
			 }
			 for(int i=0; i<l2 ; i++) {
				 arr.append(number.substring(l1 + i*step, step));									 
			 }
			 if(number.indexOf(splitor) == -1){
				 number = arr.append(splitor).toString();
			 }
		 }
		 return number;
	}
	
	/**
	 * @Title: numberFormat
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 格式化数字
	 
	 *@param number			被格式化的数字
	 *@param reserveNumber	被保留小数点位数
	 *@return				被格式化后的double型的数字
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:59:15
	 */
	public static double numberFormat(double number,double reserveNumber){
		int numberDTI = (int)reserveNumber ;
		return (double) (Math.round(number*numberDTI)/reserveNumber);
	}
	
	/**
	 * @Title: numberFormat
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 格式化数字
	 
	 *@param number		被格式化的数字
	 *@param formatType	格式化类型
	 *@return			被格式化后的字符串
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:00:03
	 */
	public static String numberFormat(double number,String formatType){
		DecimalFormat df  = new DecimalFormat(formatType);
		return df.format(number);
	}
	
	/**
	 * @Title: getFormatLong
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 返回long(毫秒)
	 
	 *@param num
	 *@param stringDate
	 *@return
	 *@throws ParseException
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:01:22
	 */
	public static long getFormatLong(int num,String stringDate) throws ParseException{
		return getFormatDate(num,stringDate).getTime();
	}

	/**
	 * @Title: getDateByYearAndMonthAndDay
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 根据 制定的年月日得到日期对象。
	 * 注意：month是从0开始的，虽然得到的值是从1开始的。
	 
	 *@param year
	 *@param month
	 *@param day
	 *@return	根据指定的年月日返回日期对象
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:01:37
	 */
	public static Date getDateByYearAndMonthAndDay(int year,int month,int day){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	} 
	
	/**
	 * @Title: getFormatDate
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 返回格日期
	 
	 *@param num
	 *@param stringDate
	 *@return
	 *@throws ParseException
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:02:54
	 */
	public static Date getFormatDate(int num, String stringDate) throws ParseException{
		Date resultDate = null;
		SimpleDateFormat dateformat = getFormat(num);
		if(dateformat!=null)
		  resultDate = dateformat.parse(stringDate);
		return resultDate;
	}
	
	/**
	 * @Title: getDepartOfDate
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 得到时间的不同部分的值
	 * 分别返回:年、月、日、小时（按照24小时制显示），分、秒
	 * 对应数据库中的查询条件(w代表：一年中的第几个星期；
	 * 					E：星期几；
	 * 					W表示一个月中的第几个星期；
	 * 					D:年中第几天d一月中的第几天)
	 
	 *@param date 当前的日期
	 *@param type 类型
	 *@return	  指定部分的整数表示形式
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:03:26
	 */
	public static int getDepartOfDate(Date date, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy/MM/dd/HH/mm/ss/w/W/D/E/d");
		String dateString = sdf.format(date);
		String[] args = dateString.split("/");

		if ("YEAR".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[0]);
		}
		if ("MONTH".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[1]);
		}
		if ("DAY".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[2]);
		}
		if ("HOUR".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[3]);
		}
		if ("MINUTE".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[4]);
		}
		if ("SECOND".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[5]);
		}
		if ("WEEKOFYEAR".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[6]);
		}
		if ("WEEKOFMONTH".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[7]);
		}
		if ("DAYOFYEAR".equalsIgnoreCase(type)) {
			return Integer.parseInt(args[8]);
		}
		return -1;
	}
	
	/**
	 * @Title: getFormatString
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 返回格式化字符串型日期
	 
	 *@param num
	 *@param date
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:05:05
	 */
	public static String getFormatString(int num, Date date){
		if(date == null) 
			return "0000-00-00";
		else{
			SimpleDateFormat dateformat = getFormat(num);
			return dateformat==null?"0000-00-00":dateformat.format(date);
		}
	}
	
	/**
	 * @Title: timediff
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 获取时间差（日期类型）	
	 
	 *@param type
	 *@param begin
	 *@param end
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:05:20
	 */
	public static long timediff(String type,Date begin,Date end){
		long diff = end.getTime() - begin.getTime();
		if(type.equals("day")){
			diff = diff/86400000;
		}else if(type.equals("hour")){
			diff = diff/3600000;
		}else if(type.equals("minute")){
			diff = diff/60000;
		}else if(type.equals("month")) {
			int startmonth = Integer.parseInt(getFormatString(MM, begin));
			int endmonth = Integer.parseInt(getFormatString(MM, end));
			diff = endmonth - startmonth;
		}
		return diff;
	}
	
	/**
	 * @Title: timediff
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 获取时间差（字符串类型）
	 
	 *@param type
	 *@param num
	 *@param begin
	 *@param end
	 *@return
	 *@throws ParseException
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:05:39
	 */
	public static long timediff(String type,int num,String begin,String end) throws ParseException{
		Date sday = getFormatDate(num,begin);
		Date eday = getFormatDate(num,end);
		return timediff(type,sday,eday);
	}

	/**
	 * @Title: formatString
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 日期字符串格式化为另一种字符串日期
	 
	 *@param num		想要格式化成的格式
	 *@param oldformat	原本日期格式
	 *@param strdate	日期
	 *@return
	 *@throws ParseException
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:06:18
	 */
	public static String formatString(int num ,String oldformat,String strdate) throws ParseException {
		String datestring="";
		if(!"".equals(strdate)){
			java.text.DateFormat df1 = getFormat(num);
			java.text.DateFormat df2 = new SimpleDateFormat(oldformat);
			datestring= df1.format(df2.parse(strdate));
		}
		return datestring;
	}
	
	/**
	 * @Title: getCurrentDate
	 * @Class: FormatTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 获取系统当前日期
	 
	 *@param num 日期格式
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:06:44
	 */
	public static String getCurrentDate(int num ){
		Date date = new Date(); 
		java.text.DateFormat df = getFormat(num);
		String currentDate = df.format(date);
		return currentDate;
	}
	
	
//    /**
//     * 获取系统当前日期
//     * @param formatStr
//     * @return
//     */
//    public static String getCurrentDate(int num){
//    	SimpleDateFormat format = getFormat(num);
//    	String formatDate = format.format(Calendar.getInstance().getTime());
//    	return formatDate;
//    }
    
    /**
     * @Title: getTomorrowDate
     * @Class: FormatTool.java
     * @Package: com.tw.sys.createcode.tool
     * @Description: 获取明天的日期
     
     *@param num
     *@return
     *@throws ParseException
     
     * @AuthorOriginally DHL
     * @date 2014-3-12 下午9:07:06
     */
    public static String getTomorrowDate(int num) throws ParseException{
    	Calendar cal = Calendar.getInstance(); 
        Date date = new Date(); 
        SimpleDateFormat format = getFormat(num);
        date = format.parse(getCurrentDate(num)); 
        cal.setTime(date); 
        cal.add(cal.DATE, 1); 
        return format.format(cal.getTime());
    }
    
    /**
     * @Title: getYesterday
     * @Class: FormatTool.java
     * @Package: com.tw.sys.createcode.tool
     * @Description: 获取昨天的日期
     
     *@param num
     *@return
     *@throws ParseException
     
     * @AuthorOriginally DHL
     * @date 2014-3-12 下午9:07:18
     */
    public static String getYesterday(int num) throws ParseException{
    	Calendar cal = Calendar.getInstance(); 
    	Date date = new Date(); 
    	SimpleDateFormat format = getFormat(num);
    	date = format.parse(getCurrentDate(num)); 
    	cal.setTime(date); 
    	cal.add(cal.DATE, -1); 
    	return format.format(cal.getTime());
    }
    
    /**
     * @Title: getNextYearDate
     * @Class: FormatTool.java
     * @Package: com.tw.sys.createcode.tool
     * @Description: 获取一年以后的日期
     
     *@param num
     *@return
     *@throws ParseException
     
     * @AuthorOriginally DHL
     * @date 2014-3-12 下午9:07:43
     */
    public static String getNextYearDate(int num) throws ParseException{
    	Calendar cal = Calendar.getInstance(); 
    	Date date = new Date(); 
    	SimpleDateFormat format = getFormat(num);
    	date = format.parse(getCurrentDate(num)); 
    	cal.setTime(date); 
    	cal.add(cal.YEAR, 1); 
    	cal.add(cal.DATE,-1);
    	return format.format(cal.getTime());
    }
    
    /**
     * @Title: getNotTodayDate
     * @Class: FormatTool.java
     * @Package: com.tw.sys.createcode.tool
     * @Description: 获取当天以外的日期
     
     *@param num
     *@param year
     *@param month
     *@param day
     *@return
     *@throws ParseException
     
     * @AuthorOriginally DHL
     * @date 2014-3-12 下午9:07:53
     */
    public static String getNotTodayDate(int num,int year,int month,int day) throws ParseException{
    	Calendar cal = Calendar.getInstance(); 
    	Date date = new Date(); 
    	SimpleDateFormat format = getFormat(num);
    	date = format.parse(getCurrentDate(num)); 
    	cal.setTime(date); 
    	cal.add(cal.YEAR, year); 
    	cal.add(cal.MONTH,month);
    	cal.add(cal.DATE,day);
    	return format.format(cal.getTime());
    }
   
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatString(yyyyMMdd,"yyyy-MM-dd","2006-06-09"));
//		Date sday = getFormatDate(Y_M_D,"2011-03-17");
//		Date eday = getFormatDate(Y_M_D,"2012-03-17");
//		System.out.println(timediff("day",sday,eday));
//		System.out.println(numberFormat(1232.12321312312,RESERVETWO));
//		System.out.println(numberFormat(1233333333332.12321312312,FORMAT_SPLIT));
//		ActionListener time = new ActionListener() {  // 监听事件,不然实现不了动态改变时间
//			public void actionPerformed(ActionEvent e) { 
//			//date对象代表当前的系统时间(毫秒) 
//			Date date = new Date(); 
//			//format对象是用来以指定的时间格式格式化时间的 
//			SimpleDateFormat from = new SimpleDateFormat( 
//			"yyyy-MM-dd HH:mm:ss"); //这里的格式可以自己设置 
//			//format()方法是用来格式化时间的方法 
//			String times = from.format(date); 
//			System.out.println(times); }
//
//			}; 
//			Timer tim = new Timer(1000, time); //这里表示1000毫秒更新一下时间 
//			tim.start(); //启动
		System.out.println(getYesterday(Y_M_D));
		System.out.println(getTomorrowDate(Y_M_D));
		System.out.println(getNextYearDate(Y_M_D));
	}
}