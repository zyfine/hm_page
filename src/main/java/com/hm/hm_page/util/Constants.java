package com.hm.hm_page.util;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	// 系统默认的货币格式
	public static final String MONEY_FORMAT = "###.##";
	public static final int DECIMAL_NUM = 2;
	

	// 日期时间格式
	public static final String DEFAULT_FULL_DATETIME_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_FULL_DATETIME_FORMAT1 = "yyyy-MM";
	public static final String DEFAULT_SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH24:mi:ss";
	public static final String DEFAULT_SIMPLE_DATE_FORMATJAVA = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_ERROR_DATETIME = "0000-00-00";

	//系统状态变量
	/**
	 * 可用
	 */
	public static final String ENABLED = "0";
	/**
	 * 不可用
	 */
	public static final String UNENABLED = "1";
	/**
	 * 新增
	 */
	public static final String CREATE = "0";
	/**
	 * 修改
	 */
	public static final String UPDATE = "1";
	/**
	 * 删除
	 */
	public static final String DELETE = "2";
	/**
	 * 未删除
	 */
	public static final String AVAILABLE = "0,1";
	/**
	 * 默认密码
	 */
	public static final String DEFAULT_PASSWORD = "000000";

	/**
	 * 3相不平衡 参数
	 */
	public static final String PARAM_BPHTYPE = "1";
	/**
	 * 过负荷参数
	 */
	public static final String PARAM_FHTYPE = "1";
	/**
	 * 省份编码
	 */
	public static final String PROVINCE_CODE   = "14101";
	
	
	//编码
	public static final String SYS_ENCODE = "utf-8"; 
	//ajax编码
	public static final String SYS_CONTECTTYPE_JSON = "text/json;charset=UTF-8";
	public static final String SYS_CONTECTTYPE_HTML = "text/html;charset=UTF-8";
	
	// 分页每页显示的页数
	public static final int ROW_COUNT = 10;	
	//session名称
	public static final String USER_SESSION_NAME = "user"; 
	public static final String USER_SESSION_MODULE = "muduleName";

//	public static String HM_PATH = "C:\\Users\\jslx\\Desktop\\hm_html";
//	public static String HM_PATH = "/Users/zyfine/Desktop/hm_html";
	public static String HM_PATH = "C:\\Apache24\\htdocs\\hm_html";


	public static String SITE_PATH = "http://111.229.182.162/hm";

	
	//文件存放路径
	public static final String SYS_LINE = File.separator;
	public static final String FILE_SAVE_PATH = "upload"+SYS_LINE+"svg";
    public static final String FILE_IDENTIFY_PATH = "upload"+SYS_LINE+"svg";	
	public static final String FILE_FTP_PATH1 = "resources.ftp1";
//	public static final String FILE_FTP_PATH2 = "resources.ftp2";
	//树节点显示的图片
	public static Map<String, String> getTreeImgMap(){
		Map<String, String> imgMap = new HashMap<String, String>();
		imgMap.put("1", " im0='iconText.gif' im1='folderOpen.gif' im2='folderClosed.gif' ");
		imgMap.put("2", " im0='iconText.gif' im1='bdzfolderOpen.gif' im2='bdzfolderClosed.gif' ");
		imgMap.put("3", " im0='iconText.gif' im1='linefolderOpen.gif' im2='linefolderClosed.gif' ");
		imgMap.put("4", " im0='iconText.gif' im1='folderOpen.gif' im2='folderClosed.gif' ");
		return imgMap;
	}

	

	
	
	
	
	
	
	
	

}