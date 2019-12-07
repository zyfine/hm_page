package com.hm.hm_page.util;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;

public class ExcelUtil {

	/**
	 * 
	 * Description: 生成Excel文件
	 * @Title: writeExcel
	 * @param os 输出流
	 * @param rowname 列表名
	 * @param rowvalue 列表字段名
	 * @param list 列表数据
	 * @param title 标题
	 * @throws Exception void   
	 * @author zyfine
	 * @date Jun 23, 2010
	 *
	 */
	public void writeExcel(OutputStream os, String [] rowname,String[] rowvalue,List<HashMap> list,String title) throws Exception {
		
	    jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);
	    int sheetCount = 10000;
	    int sheetsize = 0;
	    if(list!=null&&list.size()>0){
	    	sheetsize = list.size()/sheetCount+1;
	    }
	    System.out.println("导出sheet数："+sheetsize);
	    if(sheetsize>1){//有多个sheet
		    for(int k=0;k<sheetsize-1;k++){
			    jxl.write.WritableSheet ws = wwb.createSheet(title+(k+1), k);
			    if(rowname!=null&&rowname.length>0){
			    	for(int i=0;i<rowname.length;i++){
			    		String name = rowname[i];
			    		Label l =  new Label( i , 0 ,name); 
			    		ws.addCell(l);
			    	}
			    }
			    	
					for(int i=sheetCount*k;i<sheetCount*(k+1);i++){
						if(rowvalue!=null&&rowvalue.length>0){
							for(int j=0;j<rowvalue.length;j++){
								HashMap map = (HashMap)list.get(i);
								String value = StrUtil.getNotNullStrValue(map.get(rowvalue[j].trim().toUpperCase()));
								Label l = new Label(  j,i+1-sheetCount*k ,value);
								ws.addCell(l);
								}
							}
						}
					System.out.println("写完第"+k+"页");
		    	}
		    //最后一页
		    for(int k=sheetsize-1;k<sheetsize;k++){
			    jxl.write.WritableSheet ws = wwb.createSheet(title+(k+1), k);
			    if(rowname!=null&&rowname.length>0){
			    	for(int i=0;i<rowname.length;i++){
			    		String name = rowname[i];
			    		Label l =  new Label( i , 0 ,name); 
			    		ws.addCell(l);
			    	}
			    }
					for(int i=sheetCount*k;i<list.size();i++){
						if(rowvalue!=null&&rowvalue.length>0){
							for(int j=0;j<rowvalue.length;j++){
								HashMap map = (HashMap)list.get(i);
								String value = StrUtil.getNotNullStrValue(map.get(rowvalue[j].trim().toUpperCase()));
								Label l = new Label(  j,i+1-sheetCount*k ,value);
								ws.addCell(l);
								}
							}
						}
					
		    	}
		    
		    //写入Exel工作表
		    wwb.write();
		    //关闭Excel工作薄对象
		    wwb.close();
		    wwb = null;
		    //只有一个sheet
		    }else if(sheetsize==1){
		    	
			    for(int k=sheetsize-1;k<sheetsize;k++){
			    	jxl.write.WritableSheet ws = wwb.createSheet(title, k);
				    if(rowname!=null&&rowname.length>0){
				    	for(int i=0;i<rowname.length;i++){
				    		String name = rowname[i];
				    		Label l =  new Label( i , 0 ,name); 
				    		ws.addCell(l);
				    	}
				    }
					for(int i=0;i<list.size();i++){
						if(rowvalue!=null&&rowvalue.length>0){
							for(int j=0;j<rowvalue.length;j++){
								HashMap map = (HashMap)list.get(i);
								String value = StrUtil.getNotNullStrValue(map.get(rowvalue[j].trim().toUpperCase()));
								Label l = new Label(  j,i+1 ,value);
								ws.addCell(l);
								}
							}
						}
					
			    }
			    
			    //写入Exel工作表
			    wwb.write();
			    //关闭Excel工作薄对象
			    wwb.close();
			    wwb = null;
		    }	
	    }

	}
