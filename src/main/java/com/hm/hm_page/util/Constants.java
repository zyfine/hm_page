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
	
	//默认排序字段
	public static final String ORDER_DRFAULT = "BMBH,ZGSBH,GDSBH,KXBH";	
	
	// 数据库表主键序列 KEY
	public static final String SEQ_S_SYSROLE = "SEQ_S_SYSROLE";
	public static final String SEQ_S_SYSUSERLOG = "SEQ_S_SYSUSERLOG";
	public static final String SEQ_S_SYSUSER = "SEQ_S_SYSUSER";
	public static final String SEQ_S_SYSROLEUSER = "SEQ_S_SYSROLEUSER";
	public static final String SEQ_S_SYSMODULEROLE = "SEQ_S_SYSMODULEROLE";
	public static final String SEQ_S_SYSMODULE = "SEQ_S_SYSMODULE";
	public static final String SEQ_S_SYSDICTIONARYPROPETRY = "SEQ_S_SYSDICTIONARYPROPETRY";
	public static final String SEQ_S_SYSDICTIONARYINFO = "SEQ_S_SYSDICTIONARYINFO";
	public static final String SEQ_S_SYSDEPT = "SEQ_S_SYSDEPT";
	public static final String SEQ_S_SYSUSERVIEW = "SEQ_S_SYSUSERVIEW";
	public static final String SEQ_D_BYQTZ = "SEQ_D_BYQTZ";
	
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
	//获得比较方式
	public static Map<String, String> getConditonMap(){
		Map<String, String> conMap = new HashMap<String, String>();
		conMap.put("0", " = ");
		conMap.put("1", " >= ");
		conMap.put("2", " <= ");
		conMap.put("3", " like ");
		return conMap;
	}
	//各区域区号
	public static Map<String, String> getAreaCodeMap(){
		Map<String, String> conMap = new HashMap<String, String>();
		conMap.put("14401", "0351");
		conMap.put("14402", "0353");
		conMap.put("14403", "0352");
		conMap.put("14404", "0355");
		conMap.put("14405", "0354");
		conMap.put("14406", "0357");
		conMap.put("14407", "0359");
		conMap.put("14408", "0350");
		conMap.put("14409", "0358");
		conMap.put("14410", "0349");
		conMap.put("14411", "0356");
		return conMap;
	}
	
	//根据容量，求额定电流
	public static BigDecimal getEDDL(int str){
		double i=Math.round(str/(Math.sqrt(3)*0.4)*100)/100.00;
		BigDecimal bd1 = new BigDecimal(i);
		return bd1;
	}

	public static Map<Integer, String> getcontinuetype1Map(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(1, "过负荷阀值：≥80%; ");
		conMap.put(2, "过负荷阀值：≥90%; ");
		conMap.put(3, "过负荷阀值：≥100%; ");
		return conMap;
	}
	public static Map<Integer, String> getcontinuetype2Map(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(1, "过电压类型：越上限; ");
		conMap.put(2, "过电压类型：越下限; ");
		return conMap;
	}
	public static Map<Integer, String> getcontinuetype3Map(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(1, "不平衡阀值：≥15%; ");
		conMap.put(2, "不平衡阀值：≥25%; ");
		conMap.put(3, "不平衡阀值：≥40%; ");
		return conMap;
	}
	public static Map<Integer, String> getcontinuetypeMap(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(1, "不平衡同期负载率：≥15%; ");
		conMap.put(2, "不平衡同期负载率：≥25%; ");
		conMap.put(3, "不平衡同期负载率：≥35%; ");
		return conMap;
	}
	public static Map<Integer, String> getfhcxMap(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(60, "过负荷持续：60分钟; ");
		conMap.put(90, "过负荷持续：90分钟; ");
		conMap.put(120, "过负荷持续：120分钟; ");
		return conMap;
	}
	public static Map<Integer, String> getgdycxMap(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(60, "过电压持续：60分钟; ");
		conMap.put(90, "过电压持续：90分钟; ");
		conMap.put(120, "过电压持续：120分钟; ");
		return conMap;
	}
	public static Map<Integer, String> getbphcxMap(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(60, "不平衡持续：60分钟; ");
		conMap.put(90, "不平衡持续：90分钟; ");
		conMap.put(120, "不平衡持续：120分钟; ");
		return conMap;
	}
	public static Map<Integer, String> getsGLYSMap(){
		Map<Integer, String> conMap = new HashMap<Integer, String>();
		conMap.put(80, "功率因数阀值：﹤0.8; ");
		conMap.put(90, "功率因数阀值：﹤0.9; ");
		return conMap;
	}
	
	
	
	
	
	
	
	

}