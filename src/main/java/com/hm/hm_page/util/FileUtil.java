package com.hm.hm_page.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
	/**
	 * 
	 * Description: 读文件(默认1000条)
	 * @Title: BufferedReader
	 * @param path 文件路径
	 * @param num 每页读取条数
	 * @return
	 * @throws IOException String   
	 * @author zyfine
	 * @date Jan 10, 2011
	 *
	 */
    public List<String> BufferedReader(String path,String num) throws IOException{
    	Integer n = StrUtil.getNotNullIntValue(num,300);
    	List<String> list = new ArrayList<String>();
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        int i = 0;
        while(temp!=null&&i<n){
        	i++;
            sb.append("第"+i+"行："+temp+"\n  ");
            temp=br.readLine();
        	if(i==n){
        		list.add(sb.toString());
        		i = 0;
        		sb = new StringBuffer("");
        	}
        }
        if(!sb.toString().equals("")){
        	list.add(sb.toString());
        }
        return list;
    }
    /**
     * 
     * Description: 判断文件是否存在
     * @Title: CheckFileExist
     * @param path
     * @param fileName
     * @return boolean   
     * @author zyfine
     * @date Jun 28, 2011
     *
     */
    public static boolean CheckFileExist(String path,String fileName){
    	String line = File.separator;
    	File f = new File(path+line+fileName);
    	return f.exists();
    }
    public static boolean CheckFileExist(String filepath){
    	File f = new File(filepath);
    	return f.exists();
    }
    /**
     * 
     * Description: 从服务器下载文件
     * @Title: downloadFileFromFtp
     * @param filename 文件名
     * @param path 根路径
     * @return boolean   
     * @author zyfine
     * @date Aug 17, 2011
     * 
     * modify by qiuzq 20111227.增加ftp链接关闭
     *
     */
//    public boolean downloadFileFromFtp(String filename,String path){
//		//下载文件
//    	System.out.println("开始从ftp下载文件");
//    	System.out.println(filename);
//    	System.out.println(path);
//		FTPUpload ft1 =null;
//        FTPUpload ft2 = null;
//        
//        try{
//            ft1 = new FTPUpload(Constants.FILE_FTP_PATH1);
//            boolean a = ft1.get(filename, ft1.HOSTPATH,path);
//            if(a){
//                return true;
//            }
//            
//            ft2 = new FTPUpload(Constants.FILE_FTP_PATH2);
//            boolean b = ft2.get(filename, ft2.HOSTPATH,path);
//            if(b){
//                return true;
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            if(ft1!=null) ft1.stop();
//            if(ft2!=null) ft2.stop();
//        }
//		
//		return false;
//    }
    /**
     * @param filename
     * @Description: 活动文件大小
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/13 16:42
     */
    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }
    /**
    * 移动单个文件  add by qiuzq 20111227.
    * @param srcFileName 待移动的原文件名
    * @param destFileName 目标文件名
    * @param overlay 如果目标文件存在，是否覆盖
    * @return 文件移动成功返回true，否则返回false
    */
    public static boolean moveFile(String srcFileName, String destFileName, boolean overlay) {
       File srcFile = new File(srcFileName);
       // 如果源文件不存在或不是文件
       if(!srcFile.exists()) {
        System.out.println("移动文件失败：源文件" + srcFileName + "不存在！");
        return false;
       } else if(!srcFile.isFile()) {
        System.out.println("移动文件失败：" + srcFileName + "不是文件！");
        return false;
       }
      
       File destFile = new File(destFileName);
       // 如果目标文件存在
       if(destFile.exists()) {
        // 如果允许覆盖
        if(overlay) {
         // 删除已存在的目标文件，目论目标文件是目录还是文件
         System.out.println("目标文件存在，准备删除......");
         if(!DeleteFileUtil.deleteFile(destFile.getAbsolutePath())) {
          System.out.println("移动文件失败：删除目标文件" + destFileName + "失败！");
          return false;
         }
        } else {
         System.out.println("移动文件失败：目标文件" + destFileName + "已存在！");
         return false;
        }   
       } else {
        if(!destFile.getParentFile().exists()) {
         // 如果目标文件所在的目录不存在，则创建目录
         System.out.println("目标文件所在目录不存在，准备创建。。。。");
         if(!destFile.getParentFile().mkdirs()) {
          System.out.println("移动文件失败,创建目标文件所在目录失败！");
          return false;
         }
        }
       }
      
       // 移动源文件至目标文件
       if(srcFile.renameTo(destFile)) {
        System.out.println("移动单个文件" + srcFileName + " 到" + destFileName + "成功！");
        return true;
       } else {
        System.out.println("移动单个文件" + srcFileName + " 到" + destFileName + "失败！");
        return false;
       }
    }

    /**
    * 移动目录   add by qiuzq 20111227.
    * @param srcDirName 待移动的源目录名
    * @param destDirName 目标目录名
    * @param overlay 如果目标目录存在，是否覆盖
    * @return 目录移动成功返回true，否则返回false
    */
    public static boolean moveDirectory(String srcDirName, String destDirName, boolean overlay) {
       // 判断源目录是否存在
       File srcDir = new File(srcDirName);
       if(!srcDir.exists()) {
        System.out.println("移动目录失败：源目录" + srcDirName + "不存在!");
        return false;
       } else if(!srcDir.isDirectory()) {
        System.out.println("移动目录失败：" + srcDirName + "不是目录!");
        return false;
       }
       // 如果目标目录名不易文件分隔符结束，添加文件分隔符
       if(!destDirName.endsWith(File.separator))
        destDirName = destDirName + File.separator;
       File destDir = new File(destDirName);
       // 如果目标文件夹存在
       if(destDir.exists()) {
        // 如果允许覆盖，删除已存在的目标目录
        if(overlay) {
         System.out.println("目标目录已存在，准备删除。。。。");
         if(!DeleteFileUtil.delete(destDir.getAbsolutePath())) {
          System.out.println("移动目录失败：删除目标目录" + destDirName + "失败！");
          return false;
         }
        } else {
         System.out.println("移动目录失败：目标目录" + destDirName + "已存在！");
         return false;
        }
       }
       // 创建目标目录
       System.out.println("目标目录不存在，准备创建。。。。");
       if(!destDir.mkdirs()) {
        System.out.println("移动目录失败：创建目标目录失败！");
        return false;
       }
      
       boolean flag = true;
       // 移动源目录下的文件和子目录到目标目录下
       File[] files = srcDir.listFiles();
       for(int i = 0; i < files.length; i++) {
        //移动子文件
        if(files[i].isFile()) {
         flag = moveFile(files[i].getAbsolutePath(), destDirName + files[i].getName(), overlay);
         if(!flag)
          break;
        }
        // 移动子目录
        if(files[i].isDirectory()) {
         flag = moveDirectory(files[i].getAbsolutePath(), destDirName + files[i].getName(), overlay);
         if(!flag)
          break;
        }
       }
       if(!flag) {
        System.out.println("移动目录" + srcDirName + "至" + destDirName + "失败！");
        return false;
       }
      
       // 删除源目录
       if(DeleteFileUtil.delete(srcDirName)) {
        System.out.println("移动目录" + srcDirName + "至" + destDirName + "成功！");
        return true;
       } else {
        System.out.println("移动目录" + srcDirName + "至" + destDirName + "失败！");
        return false;
       }    
    }
    
     /*
      * 通过递归得到某一路径下所有的目录及其文件
      */
     static void getFiles(String filePath){
      File root = new File(filePath);
        File[] files = root.listFiles();
        for(File file:files){     
         if(file.isDirectory()){
             getFiles(file.getAbsolutePath());
             System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
         }else{
             System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
         }     
        }
     }

     /**
      * @param infile    源文件
      * @param outfile   复制文件
      * @Description: 复制文件到另一个目录
      * @return:
      * @Author: zyfine
      * @Date: 2019/12/18 15:25
      */
     public static void copyFile(String infile,String outfile) throws IOException {
         // 创建一个带缓冲区的输入流
         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(infile));
         // 创建一个带缓冲区的输出流
         BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outfile));

         // 定义一个字节数组，作为缓冲区
         byte[] buff = new byte[1024];
         long begintime = System.currentTimeMillis(); // 获取拷贝文件前的系统时间
         int len;
         while ((len = bis.read(buff)) != -1) {
             bos.write(buff, 0, len); // 从第一个字节开始，向文件写入len个字节
         }
         long endtime = System.currentTimeMillis(); // 获取文件拷贝结束时的系统时间
         System.out.println("拷贝文件所消耗的时间是：" + (endtime - begintime) + "毫秒");
         bis.close();
         bos.close();

     }













    public static void main(String[] args) throws IOException {
//    	File f = new File("D:/pro_syd/mininew/web/upload/img/101906403011106231241310000801_1.jpg");
//    	String filepath = "D:/pro_syd/mininew/web/upload/file/1313658621453.xls";
//    	String [] f = filepath.split("/");
//    	String filename = f[f.length-1];
//    	String [] p = filepath.split("upload");
//    	String path = p[0];
//    	System.out.println(path);
//    	System.out.println(filename);
//		String a = new FileUtil().BufferedReader("D:\\pro_syd\\mininew\\code\\web\\logs\\debug\\debug.log","10");
//		System.out.println(f.exists());
    	
    	
    	String filePath = "F:\\project-hdx\\gms\\code\\web\\report";
    	new FileUtil().getFiles(filePath);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
	}
    
    
}
