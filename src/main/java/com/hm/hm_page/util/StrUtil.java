package com.hm.hm_page.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class StrUtil {
	private static final Log logger = LogFactory.getLog(StrUtil.class);

	/**
	 * 
	 * Description: 去掉字符串的下划线
	 * 
	 * @Title: getNotLineStr
	 * @param str
	 * @return String
	 * @author zyfine
	 * @date Oct 10, 2010
	 * 
	 */
	public static String getNotLineStr(String str) {
		String result = "";
		char s[] = str.toCharArray();
		if (s.length > 0) {
			for (int i = 0; i < s.length; i++) {
				if ('_' != s[i]) {
					result += s[i];
				}
			}
		}
		return result;
	}

	/**
	 * @param args 传入数组按数字名称排序，不按字符串排序
	 *                例如  （1.jpg,11.jpg,2.jpg,22.jpg）
	 *                转换后（1.jpg,2.jpg,11.jpg,22.jpg）
	 * @Description: 将字符串数组按照 数字名称排序
	 * @return:
	 * @Author: zyfine
	 * @Date: 2019/12/7 14:31
	 */
	public static String[] ArraySortStr(String[] args){
		String[] str = new String[args.length];
		Map<Integer,String> map = new TreeMap<Integer,String>();
		if(args!=null&&args.length>0){
			for (int j=0;j<args.length; j++){
				String[] oldname = args[j].split("\\.");
				String name = oldname[0];
				String backname = oldname[1];
				int key = StrUtil.getNotNullIntValue(name);
				String value = StrUtil.getNotNullStrValue(backname);
				map.put(key,value);
			}
		}
		int i = 0;
		for (HashMap.Entry<Integer, String> entry  : map.entrySet()) {
			Integer key = entry .getKey();
			String val = entry .getValue();
			str[i] = key+"."+val;
			++i;
		}
		return str;
	}
	/**
	 * 
	 * Description: 定量划分字符串
	 * @Title: getArrayByNum
	 * @param str 字符串
	 * @param type 分隔符
	 * @param n 划分长度
	 * @return String[]
	 * @author zyfine
	 * @date Oct 10, 2010
	 * 
	 */
	public static String[] getArrayByNum(String str, String type, int n) {

		if ("".equals(str) || str == null) {
			return null;
		}
		str = StrUtil.getSplitString(str, type);
		String[] arr = str.split(type);
		int len = arr.length;
		int time = len / n;
		String result[] = new String[time + 1];
		if (arr.length > 0) {
			if (arr.length < n) {
				result[0] = str;
			} else {
				for (int i = 1; i <= time; i++) {
					String a = "";
					for (int j = (i - 1) * n; j < n * i; j++) {
						a += type + arr[j];
					}
					a = StrUtil.getSplitString(a, type);
					result[i - 1] = a;
				}
				String b = "";
				for (int i = time * n; i <= len - 1; i++) {
					b += type + arr[i];
					b = StrUtil.getSplitString(b, type);
				}
				result[time] = b;
			}
		}
		return result;
	}
	/**
	 * 
	 * escription: 定量分割List
	 * @Title: getArrayByNum 
	 * @param @param list
	 * @param @param n
	 * @param @return
	 * @author zyfine   
	 * @date 2013-7-28 上午11:11:29 
	 * @return List<String>[] 
	 * @throws
	 */
	public static List<String>[] getArrayByNum(List<String> list, int n) {
		if (list == null ||list.size()<1) {
			return null;
		}
		int len = list.size();
		int time = len / n;
		List<String> result[] = new ArrayList[time + 1];
		if (len > 0) {
			if (len < n) {
				result[0] = list;
			} else {
				for (int i = 1; i <= time; i++) {
					List<String> a = new ArrayList<String>();
					for (int j = (i - 1) * n; j < n * i; j++) {
						a.add(list.get(j));
					}
					result[i - 1] = a;
				}
				List<String> b = new ArrayList<String>();
				for (int i = time * n; i <= len - 1; i++) {
					b.add(list.get(i));
				}
				result[time] = b;
			}
		}
		return result;
	}
	/**
	 * 
	 * Description: 规范只有一个空格
	 * 
	 * @Title: getStringByBlank
	 * @param str
	 * @return String
	 * @author zyfine
	 * @date Oct 11, 2010
	 * 
	 */
	public static String getStringByBlank(String str) {
		String a = "";
		if (!"".equals(str) && str != null) {
			StringTokenizer s = new StringTokenizer(str.trim());
			while (s.hasMoreTokens()) {
				a += " " + s.nextToken();
			}
		}
		return a.trim();
	}

	/**
	 * 
	 * Description: 判断字符串str0是否在str里
	 * 
	 * @Title: checkStr
	 * @param str
	 * @param str0
	 * @return boolean false 没有 TRUE 有
	 * @author zyfine
	 * @date Sep 17, 2010
	 * 
	 */
	public static boolean checkStr(String str, String str0) {
		boolean result = false;
		if (str != null && !"".equals(str)) {
			str = getSplitString(str, ",");
			String[] a = str.split(",");
			if (a.length > 0) {
				for (int i = 0; i < a.length; i++) {
					String b = a[i];
					if (str0.equals(b)) {
						result = true;
						break;
					}
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * Description: oracle 转义字符
	 * 
	 * @Title: filtSqlStr
	 * @param str
	 * @return String
	 * @author zyfine
	 * @date Sep 17, 2010
	 * 
	 */
	public static String filtSqlStr(String str) {
		try {
			if ((str != null) && (!str.trim().equals(""))) {
				str = str.replaceAll("'", "''"); // '号
			}
			return str;
		} catch (Exception e) {
			return "";
		}
	}

	public static String filtrateStringToHtmlBYLOG(String str) {
		try {
			if ((str != null) && (!str.trim().equals(""))) {
				str = str.replaceAll("&", "&"); // &号
				str = str.replaceAll("\"", "&quot;"); // "号
				str = str.replaceAll("<", "&lt;"); // 正括号
				str = str.replaceAll(">", "&gt;"); // 反括号
				str = str.replaceAll("\n", "<br>"); // 回车
				str = str.replaceAll(" ", " "); // 空格
				str = str.replaceAll("\t", "    "); // TAB键
			}
			return str;
		} catch (Exception e) {
			return "";
		}
	}

	public static String filtrateStringToHtml(String str) {
		try {
			if ((str != null) && (!str.trim().equals(""))) {
				str = str.replaceAll("&", "&amp;"); // &号
				str = str.replaceAll("\"", "&quot;"); // "号
				str = str.replaceAll("<", "&lt;"); // 正括号
				str = str.replaceAll(">", "&gt;"); // 反括号
				str = str.replaceAll("\n", "<br>"); // 回车
				str = str.replaceAll(" ", "&nbsp;"); // 空格
				str = str.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;"); // TAB键
				
				str = str.replaceAll("'","‘"); 
				str = str.replaceAll(",","，"); 
			}
			return str;
		} catch (Exception e) {
			return "";
		}
	}

	public static String filtrateHtmlToString(String str) {
		try {
			if ((str != null) && (!str.trim().equals(""))) {
				str = str.replaceAll("&amp;", "&"); // &号
				str = str.replaceAll("&quot;", "\""); // "号
				str = str.replaceAll("&lt;", "<"); // 正括号
				str = str.replaceAll("&gt;", ">"); // 反括号
				str = str.replaceAll("<br>", "\n"); // 回车
				str = str.replaceAll("&nbsp;", " "); // 空格
				str = str.replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;", "\t"); // TAB键
				
				str = str.replaceAll("‘","'"); 
				str = str.replaceAll("，",","); 
			}
			return str;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 
	 * Description: 转化为单引号 字符串
	 * 
	 * @Title: getSqlStrBySlist
	 * @param str
	 * @return String
	 * @author zyfine
	 * @date Oct 11, 2010
	 * 
	 */
	public static String getSqlStrBySlist(String str) {
		String result = "";
		if ("".equals(str.trim()) || str == null) {
			return result;
		} else {
			String a[] = str.split(",");
			if (a.length > 0) {
				result += "'" + a[0] + "'";
				for (int i = 1; i < a.length; i++) {
					result += ",'" + a[i] + "'";
				}
			}
		}
		return result;
	}

	public static String getSqlNotNullStrValue(String str) {
		String r = "";
		if (str != null && !"".equals(str)) {

		}
		return r;
	}

	public static String getNotNullStrValue(String str) {
		if (str == null || "null".equals(str)) {
			return "";
		} else {
			return getNotNullStrValue(str, "");
		}
	}

	public static String getNotNullStrValue(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return getNotNullStrValue(obj.toString());
		}
	}

	public static String getNullStrToZero(String str) {
		return getNotNullStrValue(str, "0");
	}

	public static String getNotNullStrValue(String str, String defStr) {
		if (StringUtils.isNotEmpty(str) && !str.trim().equals("") && !str.trim().equals("null"))
			return str.trim();
		return defStr;
	}

	public static int getNotNullIntValue(String str) {
		int intNum = 0;
		try {
			intNum = Integer.parseInt(str);
		} catch (NumberFormatException numForExc) {
			intNum = 0;
		}
		return intNum;
	}

	public static int getNotNullIntValue(String str, int defValue) {
		int intNum = getNotNullIntValue(str);
		if (intNum == 0)
			intNum = defValue;
		return intNum;
	}

	public static long getNotNullLongValue(String str) {
		long longNum = 0;
		try {
			if (StringUtils.isNotEmpty(str) && StringUtils.isNumeric(str))
				longNum = Long.parseLong(str);
		} catch (NumberFormatException numForExc) {
			longNum = 0;
		}
		return longNum;
	}

	public static BigDecimal getNotNullBigDecimalValue(String str) {
		if (StringUtils.isNotEmpty(str) && NumberUtils.isNumber(str)) {
			return new BigDecimal(str);
		}
		return new BigDecimal(0);
	}

	public static long getNotNullLongValue(String str, long defValue) {
		long longNum = getNotNullLongValue(str);
		if (longNum == 0)
			longNum = defValue;
		return longNum;
	}

	public static String getDecimalFormartNum(Number number) {
		DecimalFormat formater = new DecimalFormat("###.##");
		return formater.format(number);
	}

	// 若BigDecimal值为null,则默认为0
	public static BigDecimal getBigDecimalNotNull(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return new BigDecimal(0);
		} else {
			return bigDecimal;
		}
	}

	public static BigDecimal formatNumber(BigDecimal number) {
		DecimalFormat formater = new DecimalFormat("###.##");
		return new BigDecimal(formater.format(number));
	}

	/**
	 * 
	 * Description: 去除数组重复元素
	 * 
	 * @Title: getStringArray
	 * @param a
	 *            主数组
	 * @param b
	 *            对比数组
	 * @return String[]
	 * @author zyfine
	 * @date Aug 22, 2010
	 * 
	 */
	public static String[] getStringArray(String[] a, String[] b) {
		if (a != null && b != null) {
			if (b.length > a.length) {
				throw new IllegalArgumentException("索引出界");
			} else {
				for (int i = 0; i < b.length; i++) {
					a = delArr(a, b[i]);
				}
			}
		}
		return a;
	}


	/**
	 * 
	 * Description: 删除数组指定元素
	 * 
	 * @Title: delArr
	 * @param arr
	 * @param index
	 * @return String[]
	 * @author zyfine
	 * @date Aug 22, 2010
	 * 
	 */
	public static String[] delArr(String[] arr, String index) {
		index = getNotNullStrValue(index);
		String[] result = null;
		if (arr != null) {
			if (arr.length == 1) {
				return result;
			} else {
				String[] a = new String[arr.length];
				int temp = 0;
				if (arr.length > 0 && arr != null) {
					for (int i = 0; i < arr.length; i++) {
						if (getNotNullStrValue(arr[i]).equals(index))
							continue;
						a[temp++] = arr[i];
					}
				}
				result = a;
			}
		}
		return result;
	}

	/**
	 * 
	 * Description: 除去逗号分隔字符串中 指定字符
	 * 
	 * @Title: delIndex
	 * @param str
	 * @param ind
	 * @return String
	 * @author zyfine
	 * @date Aug 3, 2011
	 * 
	 */
	public static String delIndex(String str, String ind) {
		String a[] = str.split(",");
		a = delArr(a, ind);
		return getStrByArr(a);
	}

	/**
	 * 
	 * Description: 将字符串数组转化为逗号分隔字符串
	 * 
	 * @Title: getStrByArr
	 * @param arr
	 * @return String
	 * @author zyfine
	 * @date Aug 22, 2010
	 * 
	 */
	public static String getStrByArr(String[] arr) {
		String result = "";
		if (arr == null) {
			return result;
		} else if (arr.length > 0 && arr != null) {
			result = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != null) {
					result += "," + arr[i];
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * Description: 截取指定长度字符串,并替换尾字符
	 * @Title: substring
	 * @param str 原字符串
	 * @param toCount 长度
	 * @param more 替换符号
	 * @return String
	 * @author zyfine
	 * @date Jun 10, 2010
	 * 
	 */
	public static String substring(String str, int toCount, String more) {
		int reInt = 0;
		String reStr = "";
		if (str == null) {
			return "";
		}
		char tempChar[] = str.toCharArray();
		if (more != null) {
			toCount -= more.length();
		}
		for (int kk = 0; kk < tempChar.length && toCount > reInt; kk++) {
			String s1 = String.valueOf(tempChar[kk]);
			byte b[] = s1.getBytes();
			reInt += b.length;
			reStr = (new StringBuilder(String.valueOf(reStr))).append(tempChar[kk]).toString();
		}

		if (toCount == reInt || toCount == reInt - 1) {
			reStr = (new StringBuilder(String.valueOf(reStr))).append(more).toString();
		}
		return reStr;
	}
	/**
	 * 
	 * Description: 将字符串转化为分隔符 的字符串（去重复无顺序）
	 * 
	 * @Title: getSplitString
	 * @param str
	 *            字符串
	 * @param type
	 *            分隔符
	 * @return String
	 * @author zyfine
	 * @date Sep 13, 2010
	 * 
	 */
	public static String getSplitString(String str, String type) {
		String c = "";
		if ("".equals(type) || type == null) {
			type = ",";
		}
		if (str == null && "".equals(str)) {
			return "";
		} else {
			str = getSigleStr(str, type);
			String[] b = str.split(type);
			List<String> list = new LinkedList<String>();
			for (int i = 0; i < b.length; i++) {
				if (b[i] != null && !"".equals(b[i])) {
					list.add(b[i]);
				}
			}
			if (list.size() > 0) {
				c = (String) list.get(0);
				for (int i = 1; i < list.size(); i++) {
					c += type + list.get(i);
				}
			}
		}
		return c;
	}
	/**
	 * 
	 * Description: 判断数组里是否有指定字符串 0没有 1有
	 * @Title: checkStr
	 * @param a
	 * @param str
	 * @return int   
	 * @author zyfine
	 * @date Jul 14, 2010
	 *
	 */
	public static int checkStr(String a[],String str){
		int rs = 0;
		if(a!=null){
			for(int i =0;i<a.length;i++){
				String b= a[i];
				if(b.equals(str)){
					rs = 1;
					break;
				}
			}
		}
		return rs;
	}
	/**
	 * 
	 * Description: 分隔字符串 去重复
	 * 
	 * @Title: getSigleStr
	 * @param Str
	 * @param type
	 * @return String
	 * @author zyfine
	 * @date Sep 13, 2010
	 * 
	 */
	public static String getSigleStr(String Str, String type) {
		if ("".equals(type) || type == null) {
			type = ",";
		}
		if (Str == null || "".equals(Str)) {
			return "";
		}
		String result = "";
		String s[] = Str.split(type);
		Map<String, Object> map = new HashMap<String, Object>();
		if (s.length > 0) {
			for (int i = 0; i < s.length; i++) {
				map.put(s[i], null);
			}
		}
		List<String> list = new ArrayList<String>();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String ob = (String) it.next();
			list.add(ob);
		}
		Iterator<String> its = list.iterator();
		while (its.hasNext()) {
			String ob = (String) its.next();
			result += type + ob;
		}
		return result;
	}

	public static String filterXml(String value) {
		if (value == null)
			return null;
		char content[] = new char[value.length()];
		value.getChars(0, value.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++)
			switch (content[i]) {
			case 60: // '<'
				result.append("&lt;");
				break;
			case 62: // '>'
				result.append("&gt;");
				break;
			case 38: // '&'
				result.append("&amp;");
				break;
			case 34: // '"'
				result.append("&quot;");
				break;
			case 39: // '\''
				result.append("&#39;");
				break;
			default:
				result.append(content[i]);
				break;
			}
		return result.toString();
	}

//	/**
//	 * 将oracle blob字段转为字符串
//	 *
//	 * @param BlobContent
//	 * @return
//	 */
//	public static String ConvertBLOBtoString(oracle.sql.BLOB content) {
//		byte[] base64;
//		String newStr = ""; // 返回字符串
//
//		try {
//			base64 = org.apache.commons.io.IOUtils.toByteArray(content.getBinaryStream());
//			newStr = new String(base64);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return newStr;
//	}
//
//	/**
//	 * 将oracle clob字段转为字符串
//	 *
//	 * @param BlobContent
//	 * @return
//	 */
//	public static String ConvertCLOBtoString(oracle.sql.CLOB content) {
//		byte[] base64;
//		String newStr = ""; // 返回字符串
//
//		try {
//			base64 = org.apache.commons.io.IOUtils.toByteArray(content.getCharacterStream());
//			newStr = new String(base64);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return newStr;
//	}

	public static boolean isNumeric(String str){
		if("".equals(str)||str==null){
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches()){
			return false;
		}
		return true;
	}
	
	/**
     * 获取字符串的长度，中文占一个字符,英文数字占半个字符
     *
     * @param value  指定的字符串          
     * @return 字符串的长度
     */
    public static double length(String value) {
        double valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < value.length(); i++) {
            // 获取一个字符
            String temp = value.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 1;
            } else {
                // 其他字符长度为0.5
                valueLength += 0.5;
            }
        }
        //进位取整
        return  Math.ceil(valueLength);
    }
    
	public static Object mapToBean(Map mpFrom, Object objTo) {
		Object[] objKeys = mpFrom.keySet().toArray();
		String strFieldName = "";

		try {
			for (Object objkey : objKeys) {
				strFieldName = objkey.toString();

				Field objField = objTo.getClass().getDeclaredField(strFieldName);
				objField.setAccessible(true);

				objField.set(objTo, mpFrom.get(strFieldName));
			}
		} catch (Exception e) {
			logger.error("map转为Bean失败：" + e.getMessage());
		}
		return objTo;
	}
	
	public static String encoderStr(String str,String type){
		String resultStr = "";
		try{
			resultStr = URLEncoder.encode(str,type);
		}catch (Exception e) {
			logger.error("字符串加密失败：", e);
		}
		return resultStr;
	}
	
	public static String encoderStringDefault(String str){
		return encoderStr(str,Constants.SYS_ENCODE);
	}
	
	public static String decoderStr(String str,String type){
		String resultStr = "";
		try{
			resultStr = URLDecoder.decode(str,type);
		}catch (Exception e) {
			logger.error("字符串解码失败：", e);
		}
		return resultStr;
	}
	
	public static String decoderStringDefault(String str){
		return decoderStr(str,Constants.SYS_ENCODE);
	}
	
	public static String getFormatDateStr(String datestr){
		String result = "";
		if(datestr.indexOf("-")!=-1){
			return datestr;
		}else{
			char s[] = datestr.toCharArray();
			if (s.length > 0) {
				for (int i = 0; i < s.length; i++) {
					result += s[i];
					if (i==3||i==5) {
						result += "-";
					}
				}
			}
			return result;
		}
	}
	
	
	
	
}
