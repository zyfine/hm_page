package com.hm.hm_page.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	//当年
	public static String getThisYear(Date date) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat("yyyy").format(date);
		}
	}

	//当月
	public static String getThisMonth(Date date) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat("yyyy-MM").format(date);
		}
	}
	
	//标准时间格式
	public static String getBzDate(Date date) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
	}
	
	//月份
	public static String getMonth(Date date){
		if(date==null){
			return "";
		}
		else{
			return new SimpleDateFormat("MM").format(date);
		}
	}

	private static SimpleDateFormat formater = null;

	public static String getNowDateStr() {
		return getDateStr(new Date());
	}

	public static String getNowDatetimeStr() {
		return getDateStr(new Date(), Constants.DEFAULT_FULL_DATETIME_FORMAT);
	}

	public static String getDateStr(Date date) {
		if (date != null) {
			formater = new SimpleDateFormat(
					Constants.DEFAULT_SIMPLE_DATE_FORMATJAVA);
			return formater.format(date);
		}
		return Constants.DEFAULT_ERROR_DATETIME;
	}

	public static String getDateStr(Date date, String format) {
		if (date != null) {
			if (format != null && format.trim().length() > 0) {
				formater = new SimpleDateFormat(format);
				return formater.format(date);
			} else {
				formater = new SimpleDateFormat(
						Constants.DEFAULT_SIMPLE_DATE_FORMATJAVA);
				return formater.format(date);
			}
		}
		return Constants.DEFAULT_ERROR_DATETIME;
	}

	public static Date getDate(String dateStr, String format) {
		if (StringUtils.isNotEmpty(dateStr)) {
			try {
				return DateUtils.parseDate(dateStr, new String[] { format });
			} catch (ParseException e) {
				e.printStackTrace();
				return new Date();
			}
		}
		return new Date();
	}

	//年-月-日 时-分-秒格式
	public static String getNormalDate(Date date) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
		}
	}
	
	//	年-月-日 时-分-秒格式
	public static String getNormalDate11(Date date) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		}
	}

	public static long string2time(String date, String format) {
		if (date == null) {
			return 0;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date dt = null;

		try {
			dt = dateFormat.parse(date);
		} catch (ParseException excpt) {
			return 0;
		}
		return date2time(dt);
	}

	public static String time2string(long time, String format) {
		if (time == 0)
			return "";
		Date date = new Date(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	public static Date string2date(String date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date dt = null;

		try {
			dt = dateFormat.parse(date);
		} catch (ParseException excpt) {
			return null;
		}
		return dt;
	}
	
	public static String date2string(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static long date2time(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.getTimeInMillis();
	}
	
	/**
	 * 
	 * 获得当前时间的相差时间(天数) 
	 * @Title: getDifferenceNowdate 
	 * @param @param num
	 * @param @param format
	 * @param @return
	 * @author zyfine   
	 * @date 2013-6-5 下午04:05:21 
	 * @return String 
	 * @throws
	 */
	public static  String getDifferenceNowdate(int num,String format){
		  Date date = new Date();
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.DATE, num);
		  return (new SimpleDateFormat(format)).format(cal.getTime());
	}
	/**
	 * 
	 * 获得指定时间的相差时间(天数) 
	 * @Title: getDifferenceNowdate 
	 * @param @param num
	 * @param @param format
	 * @param @return
	 * @author zyfine   
	 * @date 2013-6-5 下午04:05:55 
	 * @return String 
	 * @throws
	 */
	public static  String getDifferenceDateStr(String dateStr,int num,String format){
		  Date date = getDate(dateStr,format);
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.add(Calendar.DATE, num);
		  return (new SimpleDateFormat(format)).format(cal.getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.getDifferenceDateStr("2013-09-05", -2, "yyyy-MM-dd"));
	}
	
}
