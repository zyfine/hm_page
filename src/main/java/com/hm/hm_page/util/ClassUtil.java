package com.hm.hm_page.util;

import java.lang.reflect.Method;
import java.util.HashMap;


/*
 * FileName:ClassUtil.java
 *
 * Copyright 2010 Sunnada Co.,Ltd
 * All Rights Reserved.
 * v1.0.0 Sep 9, 2010 11:21:29 AM created by hp
 * Confidential and for internal user only.
 */
/**
 * 
 *
 * @author hp
 * @version $Revision: 1.0.0 $
 * @since 1.0.0
 */
public class ClassUtil {

	private static ClassUtil classUtil = null;
	
	public static ClassUtil getInstance(){
		if(classUtil == null)
			classUtil = new ClassUtil();
		return classUtil;
	}
	
	
	/**
	 * 
	 * Description: 通过类名 方法名获得结果(参数HashMap类型,返回HashMap)
	 * @Title: getInvoke
	 * @param classname
	 * @param method
	 * @param m
	 * @return
	 * @throws Exception HashMap   
	 * @author zyfine
	 * @date Sep 9, 2010
	 *
	 */
	@SuppressWarnings("unchecked")
	public HashMap getInvoke(String classname,String method,HashMap m)throws Exception{
		Class[] paramType = new Class[]{ Class.forName("java.util.HashMap") };
		Class classObj = Class.forName(classname); 
		Method mt = classObj.getMethod(method, paramType);
		Object[] paramValue = new Object[]{ m };
		Object o = mt.invoke(classObj.newInstance(), paramValue);
		return (HashMap)o;
	}
	
	
//	public HashMap getValue(HashMap m){
//		HashMap map = new HashMap();
//		map.put("123", m.get("1"));
//		return map;
//	}
//	
	public static void main(String[] args) throws Exception{
		ClassUtil a = new ClassUtil();
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("1", "sbsfb");
		String classname="com.sunnada.common.util.ClassUtil";
		String method="getValue";
		HashMap b = (HashMap)a.getInvoke(classname, method, m);
		System.out.println(b.get("123"));
	}
	
	
}