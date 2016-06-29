package com.tw.sys.codeGenerate.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class StringUtil {
	private static DecimalFormat df = new DecimalFormat("#.0");

	/**
	 * @Title: isNum
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 判断指定的字符串是否为数字
	 
	 *@param str 字符串
	 *@return	 返回boolean
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:10:44
	 */
	public static boolean isNum(String str) {
		String regex = "9";
		if (str == null)
			return false;
		if (str.length() == 0)
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (regex.indexOf(str.charAt(i)) == -1)
				return false;
		}
		return true;
	}

	/**
	 * @Title: convertQuot
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 把字符串中的带‘与"转成\'与\"
	 
	 *@param orgStr
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:11:08
	 */
	public static String convertQuot(String orgStr) {
		return orgStr.replace("'", "\\'").replace("\"", "\\\"");
	}
	
	/**
	 * @Title: convertPoint
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 把字符串中的带.与"转成\
	 
	 *@param orgStr
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:11:22
	 */
	public static String convertPoint(String orgStr) {
		return orgStr.replace(".", "\\").replace(";", "\\");
	}
	
	/**
	 * @Title: convertUnderLine
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 把字符串中的带"_"转成空字符串,"_"后面首字母大写
	 
	 *@param orgStr
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:11:37
	 */
	public static String convertUnderLine(String orgStr) {
		String[] split = orgStr.split("_");
		orgStr = "";
		for (int i = 0; i < split.length; i++) {
			if (i==0) {
				orgStr += initialStrToLower(split[i]);
			}else {
				orgStr += initialStrToUpper(split[i]);
			}
		}
		return orgStr;
	}
	
	/**
	 * @Title: htmlEntityToString
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: HTML实体编码转成普通的编码
	 
	 *@param dataStr
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:11:48
	 */
	public static String htmlEntityToString(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			int system = 10;// 进制
			if (start == 0) {
				int t = dataStr.indexOf("&#");
				if (start != t)
					start = t;
			}
			end = dataStr.indexOf(";", start + 2);
			String charStr = "";
			if (end != -1) {
				charStr = dataStr.substring(start + 2, end);
				// 判断进制
				char s = charStr.charAt(0);
				if (s == 'x' || s == 'X') {
					system = 16;
					charStr = charStr.substring(1);
				}
			}
			// 转换
			try {
				char letter = (char) Integer.parseInt(charStr, system);
				buffer.append(new Character(letter).toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			// 处理当前unicode字符到下一个unicode字符之间的非unicode字符
			start = dataStr.indexOf("&#", end);
			if (start - end > 1) {
				buffer.append(dataStr.substring(end + 1, start));
			}
			// 处理最后面的非unicode字符
			if (start == -1) {
				int length = dataStr.length();
				if (end + 1 != length) {
					buffer.append(dataStr.substring(end + 1, length));
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * @Title: stringToHtmlEntity
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 把String转成html实体字符
	 
	 *@param str
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:12:07
	 */
	public static String stringToHtmlEntity(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case 0x0A:
				sb.append(c);
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			default:
				if ((c < ' ') || (c > 0x7E)) {
					sb.append("&#x");
					sb.append(Integer.toString(c, 16));
					sb.append(';');
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * @Title: stringToUnicode
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: String转unicode
	 
	 *@param s
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:12:24
	 */
	public static String stringToUnicode(String s) {
		String unicode = "";
		char[] charAry = new char[s.length()];
		for (int i = 0; i < charAry.length; i++) {
			charAry[i] = (char) s.charAt(i);
			unicode += "\\u" + Integer.toString(charAry[i], 16);
		}
		return unicode;
	}

	/**
	 * @Title: unicodeToString
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: unicode转String
	 
	 *@param unicodeStr
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:12:45
	 */
	public static String unicodeToString(String unicodeStr) {
		StringBuffer sb = new StringBuffer();
		String str[] = unicodeStr.toUpperCase().split("\\\\U");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(""))
				continue;
			char c = (char) Integer.parseInt(str[i].trim(), 16);
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * @Title: html2Text
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: html转文本
	 
	 *@param inputString
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:13:01
	 */
	public static String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script>]*?>[\s\S]*?<\/script>
			// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style>]*?>[\s\S]*?<\/style>
			// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = java.util.regex.Pattern.compile(regEx_script,
			java.util.regex.Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = java.util.regex.Pattern.compile(regEx_style,
			java.util.regex.Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = java.util.regex.Pattern.compile(regEx_html,
			java.util.regex.Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}

	/**
	 * @Title: escape
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: escape编码
	 
	 *@param src
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:13:17
	 */
	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(
					src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(
					src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * @Title: formatDou2Str
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: Double转String
	 
	 *@param d
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:13:44
	 */
	public static String formatDou2Str(Double d) {
		if (d == null)
			return "0";
		return df.format(d);
	}

	public static String decodeStr(String encodeparam) {
		try {
			if (encodeparam == null || "".equalsIgnoreCase(encodeparam)) {
				return null;
			}
			return java.net.URLDecoder.decode(encodeparam, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Title: initialStrToUpper
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 首字母大写
	 
	 *@param str
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:14:02
	 */
	public static String initialStrToUpper(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1);
//		return str.replace(str.charAt(0), (char)(str.charAt(0)-32));
	}
	
	/**
	 * @Title: initialStrToLower
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 首字母小写
	 
	 *@param str
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:14:21
	 */
	public static String initialStrToLower(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
//		return str.replace(str.charAt(0), (char)(str.charAt(0)-32));
	}
	
	/**
	 * @Title: replaceSlash
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 替换斜杠
	 
	 *@param str
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:14:49
	 */
	public static String replaceSlash(String str){
		String result = str.replaceAll("//", ".");
		result = result.replaceAll("/", ".");
		result = result.replaceAll("\\\\", ".");
		return result;
	}
	
	/**
	 * @Title: addPoint
	 * @Class: StringUtil.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 是否加“.”
	 
	 *@param str
	 *@param addStr
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:15:01
	 */
	public static String addPoint(String str,String addStr){
		String result = str ;
		if(str.endsWith(".")){
			result += addStr;
		}else{
			result += "."+addStr;
		}
		return result; 
	}
	
	public static void main(String[] args) {
		System.out.println(addPoint("com.afbd.","model"));
	}
}
