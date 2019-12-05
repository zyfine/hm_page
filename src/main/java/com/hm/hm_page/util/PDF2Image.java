package com.hm.hm_page.util;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.hm.hm_page.service.HmBookService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 提取PDF中的图片
 * pdfbox 版本 1.8.13
 * @author Charlie Wu
 * 2018/05/24
 */
public class PDF2Image {


	@Autowired
	private HmBookService hmBookService;

	/**
	 * 提取
	 * @param file			PDF文件
	 * @param targetFolder 	图片存放目录
	 * @return 
	 */
	public static boolean extractImages(File file, String targetFolder) {  
		boolean result = true;
		
		try{
			PDDocument document = null;
			document = PDDocument.load(file);
			 
		 	List<PDPage> pages = null;
			pages = document.getDocumentCatalog().getAllPages();
			Iterator<PDPage> iter = null;
			iter = pages.iterator();
			int count = 0;
			while( iter.hasNext()){
			    PDPage page = (PDPage)iter.next();
			    PDResources resources = page.getResources();
			    if(resources==null){//获得资源为空跳过
			    	continue;
			    }
			    Map<String, PDXObjectImage> images = resources.getImages();
			    if(images != null)
			    {
					Iterator<String> imageIter = null;
					imageIter = images.keySet().iterator();
			        while(imageIter.hasNext())
			        {
			        	count++;
			            String key = (String)imageIter.next();
			            PDXObjectImage image = null;
			            image = (PDXObjectImage)images.get( key );
			            String name = count+"";	// 图片文件名
			            try{
				            System.out.println("保存图片地址："+targetFolder + name);
							image.write2file(targetFolder + name);		// 保存图片
							File file0 = null;
							file0 = new File(targetFolder + name+".png");
							if(file0.length()<18583 ){//小于18583字节的就删除
								DeleteFileUtil.deleteFile(targetFolder + name+".png");
							}
							file0 = null;
			            }catch(Exception ex){
			            	continue;
			            }
						image = null;
			        }
			    }
				resources = null;
			}
		} catch(IOException ex){
			ex.printStackTrace();
			return false;
		}
		return result;
    } 
	
	/** 
	* @Title: getAllImg 
	* @Description: TODO(解析双层文件夹，将pdf文件里的图片提取出来保存到新建文件夹里面) 
	* @param   
	* @author zyfine  
	* @return void    返回类型 
	* @throws
	 */
	public void getAllImg(String basePath){
		String[] list=new File(basePath).list();
		System.out.println("文件夹个数："+list.length);
		if(list!=null&&list.length>0){
			for (String str : list) {//循环子文件夹
				String cbasePath = basePath+File.separator+str;
				File file = null;
				file = new File(cbasePath);
				if(file.isDirectory()){//判断是否文件夹
					System.out.println("开始处理（"+str+"）文件夹");
					String[] list2=new File(cbasePath).list();
					if(list2!=null&&list2.length>0){
						System.out.println("开始循环pdf文件"+"文件个数："+list2.length);
						for (String name : list2) {//循环文件
							System.out.println("开始处理："+str+"文件夹"+name+"文件");
							if(name.toUpperCase().endsWith(".PDF")){//包含结尾pdf文件
								//创建文件夹"pdf文件名_img"
								File jpgpath = new File(cbasePath+File.separator+name+"_img");
								if(!jpgpath.exists()){//不存在则创建
									jpgpath.mkdirs();
									File pdffile = null;
									pdffile = new File(cbasePath+File.separator+name);
									String targerFolder = cbasePath+File.separator+name+"_img"+File.separator;
									System.out.println("pdf路径："+cbasePath+File.separator+name);
									System.out.println("保存文件夹路径："+targerFolder);
									extractImages(pdffile, targerFolder);
									pdffile = null;
								}else{
									System.out.println(name+"_img已经提取过图片");
								}
							}
						}
					}
				}
				file = null;
			}
		}
	}
	/**
	 * 复制双层文件夹文件转换webp
	 * @param
	 */
	public void copyAllFolderWebp(String basePath){
		//同路径复制主文件夹
		File markpath = new File(basePath+"_webp");
		if(!markpath.exists()){//不存在则创建
			markpath.mkdirs();
		}
		String[] list=new File(basePath).list();
		System.out.println("文件夹个数："+list.length);
		if(list!=null&&list.length>0){
			for (String str : list) {//循环子文件夹
				String cbasePath = basePath+File.separator+str;
				File file = new File(cbasePath);
				if(file.isDirectory()){//判断是否文件夹
					System.out.println("开始处理（"+str+"）文件夹");
					//复制文件夹
					File markchildpath = new File(basePath+"_webp"+File.separator+str);
					if(!markchildpath.exists()){
						markchildpath.mkdirs();
					}
					String[] list2=new File(cbasePath).list();
					if(list2!=null&&list2.length>0){
						for (String name : list2) {//循环文件夹	
							List<String> imgl = getAllImgTitle(basePath+File.separator+str+File.separator+name);
							//创建文件夹
							File markimgpath = new File(basePath+"_webp"+File.separator+str+File.separator+name);
							if(!markimgpath.exists()){
								markimgpath.mkdirs();
							}
							try{
								if(imgl!=null&&imgl.size()>0){
									for (int i = 0; i < imgl.size(); i++) {
										String w = imgl.get(i);
										System.out.println("文件名："+w);
								        String inputJpgPath = basePath+File.separator+str+File.separator+name+File.separator+w;
								        String outputWebpPath = basePath+"_webp"+File.separator+str+File.separator+name+File.separator+w+".webp";
								        Jar2Webp.getWebpImg(inputJpgPath, outputWebpPath);
								        
								        System.out.println(inputJpgPath);
								        System.out.println(outputWebpPath);
									}
								}

							}catch(Exception ex){
				            	continue;
				            }	
						}
					}
				}
			}
		}
	}
	//获得文件夹里所有文件名称
	public List<String> getAllImgTitle(String basePath){
		System.out.println("开始解析文件夹文件："+basePath);
		String[] list=new File(basePath).list();
		List<String> l = new ArrayList<String>(); 
		if(list!=null&&list.length>0){
			System.out.println("文件个数："+list.length);
			for (String str : list) {//循环子文件夹
				String cbasePath = basePath+File.separator+str;
				File file = new File(cbasePath);
				if(!file.isDirectory()){//判断是否文件
					l.add(str);
//					System.out.println(str);
				}
			}
		}	
		return l;
	}
	//获得目录下所有文件夹名称
	public void getAllFolder(String basePath){
		String[] list=new File(basePath).list();
		System.out.println("文件个数："+list.length);
		if(list!=null&&list.length>0){
			List<String> listname = new ArrayList<String>();
			for (String str : list) {//循环子文件夹
				String cbasePath = basePath+File.separator+str;
				File file = new File(cbasePath);
				if(file.isDirectory()){//判断是否文件夹
					listname.add(str);
				}
			}
			//排序
//			Collections.sort(listname);
			for(String str : listname){
				System.out.println(str);
			}
		}	
	}
	
	/**
	 * 复制双层文件夹文件并添加水印
	 * @param
	 */
	public void copyAllFolderMark(String basePath){
		//同路径复制主文件夹
		File markpath = new File(basePath+"_mark");
		if(!markpath.exists()){//不存在则创建
			markpath.mkdirs();
		}
		String[] list=new File(basePath).list();
		System.out.println("文件夹个数："+list.length);
		if(list!=null&&list.length>0){
			for (String str : list) {//循环子文件夹
				String cbasePath = basePath+File.separator+str;
				File file = new File(cbasePath);
				if(file.isDirectory()){//判断是否文件夹
					System.out.println("开始处理（"+str+"）文件夹");
					//复制文件夹
					File markchildpath = new File(basePath+"_mark"+File.separator+str);
					if(!markchildpath.exists()){
						markchildpath.mkdirs();
					}
					String[] list2=new File(cbasePath).list();
					if(list2!=null&&list2.length>0){
						for (String name : list2) {//循环文件夹	
							List<String> imgl = getAllImgTitle(basePath+File.separator+str+File.separator+name);
							//创建文件夹
							File markimgpath = new File(basePath+"_mark"+File.separator+str+File.separator+name);
							if(!markimgpath.exists()){
								markimgpath.mkdirs();
							}
							try{
								if(imgl!=null&&imgl.size()>0){
									for (int i = 0; i < imgl.size(); i++) {
										String w = imgl.get(i);
										System.out.println("文件名："+w);
								        String srcImgPath = basePath+File.separator+str+File.separator+name+File.separator+w;
								        String targerTextPath = basePath+"_mark"+File.separator+str+File.separator+name+File.separator+w;
								        System.out.println(srcImgPath);
								        System.out.println(targerTextPath);
								        String logoText = "欢迎观看app";
								        System.out.println("给图片添加水印文字开始...");
								        // 给图片添加水印文字
								        ImageRemarkUtil.markImageByText(logoText, srcImgPath, targerTextPath);
								        System.out.println("给图片添加水印文字结束...");
									}
								}
							}catch(Exception ex){
				            	continue;
				            }	
						}
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
//		new  PDF2Image().getAllImg("F:\\mh\\hm-new-pdf");
//		new  PDF2Image().copyAllFolderWebp("/Users/zyfine/Desktop/hm-test");

		new  PDF2Image().getAllFolder("F:\\hm2\\hm-final\\186-我的秘密女友");



	}





	
	
	
	
	
	
	
}
