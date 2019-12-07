package com.hm.hm_page.util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtil {
		 
		 //设置中文字体
		 private static BaseFont bfChinese = null;
		 //设置各种文本格式
		 private static Font f0 = null;
		 private static Font f1 = null;
		 private static Font f2 = null;
		 static{
			 try {				 
				  //打印出中文。
				  bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				  f0 = new Font(bfChinese,20,Font.NORMAL);
				  f1 = new Font(bfChinese, 10, Font.NORMAL);
				  f2 = new Font(bfChinese, 12, Font.BOLD);
			  } catch (DocumentException e) {
				  e.printStackTrace();
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		 }
		 public static void exportPdf(List<HashMap> list,String[] title,String[] titlecode,float [] widths,OutputStream outputStream,HashMap<String, String> m){
			  Rectangle rectPageSize = new Rectangle(PageSize.A4);// 定义A4页面大小
			  rectPageSize = rectPageSize.rotate();// 加上这句可以实现A4页面的横置
			  Document document = new Document(rectPageSize,10,10,10,10);//4个参数，设置了页面的4个边距
			  try {
				   PdfWriter.getInstance(document, outputStream);
				   document.open();
//				   document.add(new Paragraph("就是开发商是开放式好好lsjdfjsjf sfk", f0));
				   document.add(PdfUtil.createPdfPTable(title,titlecode,widths,list,m));
				   System.out.println("完毕!");
			  } catch (DocumentException e) {
				   e.printStackTrace();
			  }finally{
				  document.close();
			  }  
		 }
		
		 /**
		  * 
		  * 创建PdfPTable（创建表格）
		  * @Title: createPdfPTable 
		  * @param @param title 汉字标题
		  * @param @param titlecode 标题字段
		  * @param @param widths 标题宽度
		  * @param @param list 数据
		  * @param @param m 复杂表头数据
		  * @param @return
		  * @param @throws DocumentException
		  * @author zyfine   
		  * @date 2013-7-16 上午11:29:19 
		  * @return PdfPTable 
		  * @throws
		  */
		 private static PdfPTable createPdfPTable(String[] title,String[] titlecode,float [] widths,List<HashMap> list,HashMap<String, String> m) throws DocumentException{
			  int first = 1; 
			  PdfPTable pdfpTable = new PdfPTable(title.length);
			  //有数据的话设置表头
			  if(list!=null&&list.size()>0){
				  if(m!=null){
					  first = 2;
				  }
				  pdfpTable.setHeaderRows(first);
			  }
			  pdfpTable.setHorizontalAlignment(pdfpTable.ALIGN_CENTER);
			  //设置table的title
			  PdfUtil.setTitle(title,pdfpTable,m);
			  //列宽
			  if(widths!=null){
				  pdfpTable.setWidths(widths);
			  }
			  //设置table的正文
			  PdfUtil.setContext(list,titlecode,pdfpTable);
			  return pdfpTable;
		 }
		 //设置table的title
		 private static PdfPTable setTitle(String[] title,PdfPTable pdfpTable ,HashMap<String, String> m){
			  PdfPCell cell = new PdfPCell();
			  cell.setBackgroundColor(new BaseColor(213,141,69));
			  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			  if(m!=null){
				  String titleM[] = m.get("titleM").split(",");
				  String titleC[] = m.get("titleC").split(",");
				  String titleP[] = m.get("titleP").split(",");
				  if(titleM.length>0){
					  cell.setRowspan(2);
					  for (int i = 0; i < titleM.length; i++) {
						  cell.setPhrase(new Paragraph(titleM[i],PdfUtil.f2));
						  pdfpTable.addCell(cell);
					}
				  }
				  if(titleP.length>0){
					  cell.setRowspan(1);
					  for (int j = 0; j < titleP.length; j++) {
						    String name = titleP[j].split(":")[0];
						    String len = titleP[j].split(":")[1];
						  	cell.setPhrase(new Paragraph(name,PdfUtil.f2));
							cell.setColspan(Integer.parseInt(len));
							pdfpTable.addCell(cell);
					}
				  }
				  if(titleC.length>0){
				  	  cell.setRowspan(1);
				  	  cell.setColspan(1);
					  for (int k = 0; k < titleC.length; k++) {
						  cell.setPhrase(new Paragraph(titleC[k],PdfUtil.f2));
						  pdfpTable.addCell(cell);
						}
					  }	  
				  
			  }else{
				  for(int i = 0; i < title.length; i++){
					  cell.setPhrase(new Paragraph(title[i],PdfUtil.f2));
					  pdfpTable.addCell(cell);
				  }
			  }
			  return pdfpTable;
		 }
		 //设置table的正文
		 private static PdfPTable setContext(List<HashMap> list,String[] titlecode,PdfPTable pdfpTable){
			  PdfPCell cell = new PdfPCell();
			  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			  if((list != null)&& list.size()>0){
				   for(int i = 0; i<list.size();i++){
						HashMap m = list.get(i);
						if(titlecode.length>0){
							for (int j = 0; j < titlecode.length; j++) {
								String title = StrUtil.getNotNullStrValue(titlecode[j].toUpperCase());
								cell.setPhrase(new Paragraph(StrUtil.getNotNullStrValue(m.get(title)),f1));
								pdfpTable.addCell(cell);
							}
						}
				   }
			  }
			  return pdfpTable;
			 }
		 
		 public static void main(String[] args) throws FileNotFoundException {
			 List<HashMap> list = new ArrayList<HashMap>();
			 String title[] = {"部门名称","供电所名称","报警类型","配变总数","台数","占总数比","台数","占总数比","台数","占总数比","台数","占总数比"};//
			 String titlecode[] = {"bmmc","gdsmc","warndatatype_name","countbyq","countwarn1","rote1","countwarn2","rote2","countwarn3","rote3","countwarn4","rote4"};//
			 float widths [] = {90,100,60,60,60,60,60,60,60,60,60,60};//
			 HashMap<String, String> map = new HashMap<String, String>(); 
			 map.put("titleM", "部门名称,供电所名称,报警类型,配变总数");
			 map.put("titleP", "小于15%:2,15%-25%:2,25%-40%:2,大于40%:2");//
			 map.put("titleC", "台数,占总数比,台数,占总数比,台数,占总数比,台数,占总数比");//
			 HashMap<String, String> m = new HashMap<String, String>(); 
			 m.put("BMMC", "111");
			 m.put("GDSMC", "111");
			 m.put("WARNDATATYPE_NAME", "111");
			 m.put("COUNTBYQ", "111");
			 m.put("COUNTWARN1", "111");
			 m.put("ROTE1", "111");
			 m.put("COUNTWARN2", "111");
			 m.put("ROTE2", "111");
			 m.put("COUNTWARN3", "111");
			 m.put("ROTE3", "111");
			 m.put("COUNTWARN4", "111");
			 m.put("ROTE4", "111");
			 for (int i = 0; i < 100; i++) {
				 list.add(m);
			 }
			 FileOutputStream file = new FileOutputStream("d:/hao.pdf");
			 PdfUtil.exportPdf(list,title,titlecode,widths,file,map);
		}
}		 
