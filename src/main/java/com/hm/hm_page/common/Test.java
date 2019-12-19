package com.hm.hm_page.common;

import com.hm.hm_page.util.DeleteFileUtil;
import com.hm.hm_page.util.FileUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: hm_page
 * @description: 测试用
 * @author: zyfine
 * @create: 2019-12-11 14:51
 **/
public class Test {

//     img () 命名变更
//    public static void main(String[] args) {
////        String basePath = "/Volumes/zyfine/hm2/hm-final";
//        String basePath = "C:\\Users\\jslx\\Desktop\\hm-test";
//        String[] list=new File(basePath).list();
//        System.out.println("book个数："+list.length);
//        Arrays.sort(list);
//        if(list!=null&&list.length>0){
//            for (String str : list) {//循环book名称
//                String bookPath = basePath+File.separator+str;
//                File file = new File(bookPath);
//                if(file.isDirectory()){//判断是否文件夹
//                    //循环book子文件夹
//                    String[] chapterlist=new File(bookPath).list();
//                    //排序
//                    Arrays.sort(chapterlist);
//
//                    if(chapterlist!=null&&chapterlist.length>0){
//                        if (chapterlist[1].indexOf("img (")!=-1){
//                            for (int i=0;i<chapterlist.length; i++) {
//                                    String chapterPath = basePath + File.separator + str + File.separator + chapterlist[i];
//                                    String newname = chapterlist[i].replace("img (", "").replace(")", "");
//                                    if (newname.length() == 1) {
//                                        newname = "0" + newname;
//                                    }
//                                    String chapterPathNew = basePath + File.separator + str + File.separator + newname;
//                                    File file0 = new File(chapterPath);
//                                    file0.renameTo(new File(chapterPathNew));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

// 查看那些空目录
//    public static void main(String[] args) {
////        String basePath = "/Volumes/zyfine/hm2/hm-final";
//        String basePath = "D:\\hm-final_webp";
//        String[] list=new File(basePath).list();
//        System.out.println("book个数："+list.length);
//        Arrays.sort(list);
//        if(list!=null&&list.length>0){
//                for (int i = 0; i < list.length; i++) {
//                String bookPath = basePath+File.separator+list[i];
//                File file = new File(bookPath);
//                if(file.isDirectory()){//判断是否文件夹
//                    //循环book子文件夹
//                    String[] chapterlist=new File(bookPath).list();
//                    //排序
//                    Arrays.sort(chapterlist);
//                    if(chapterlist!=null&&chapterlist.length>0){
//                            for (int j=0;j<chapterlist.length; j++) {
//                                    String chapterPath = basePath + File.separator + list[i] + File.separator + chapterlist[j];
//                                    String[] pagelist=new File(chapterPath).list();
//                                    if (pagelist!=null&&pagelist.length>0){
//                                    }else{
//                                        System.out.println(chapterPath);
//                                    }
//                                }
//                    }
//                }
//            }
//        }
//    }

// 删除0kb文件
//    public static void main(String[] args)  {
////        String basePath = "/Volumes/zyfine/hm2/hm-final";
//        String basePath = "C:\\Users\\jslx\\Desktop\\hm-test";
//        String[] list=new File(basePath).list();
//        System.out.println("book个数："+list.length);
//        Arrays.sort(list);
//        if(list!=null&&list.length>0){
//                for (int i = 0; i < list.length; i++) {
//                String bookPath = basePath+File.separator+list[i];
//                File file = new File(bookPath);
//                if(file.isDirectory()){//判断是否文件夹
//                    //循环book子文件夹
//                    String[] chapterlist=new File(bookPath).list();
//                    //排序
//                    Arrays.sort(chapterlist);
//                    if(chapterlist!=null&&chapterlist.length>0){
//                        System.out.println("开始处理book："+list[i]);
//                        for (int j=0;j<chapterlist.length; j++) {
//                            String chapterPath = basePath + File.separator + list[i] + File.separator + chapterlist[j];
//                            File chapterFile = new File(chapterPath);
//                            if (chapterFile.isDirectory()) {
//                                String[] pagelist=new File(chapterPath).list();
//                                if (pagelist!=null&&pagelist.length>0){
//                                    for (int k = 0; k < pagelist.length; k++) {
//                                        String pagepath = chapterPath+ File.separator + pagelist[k];
//                                        if (FileUtil.getFileSize(pagepath)==0){
//                                            System.out.println(pagepath+":空文件");
//                                            DeleteFileUtil.deleteFile(pagepath);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }


//    public static void main(String[] args) throws IOException{
//        File picture = new File("C:\\Users\\jslx\\Desktop\\hm-test\\005-要交换吗\\05.PDF_img\\4.jpg");
//        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
//        System.out.println(String.format("%.1f",picture.length()/1024.0));// 源图大小
//        System.out.println(sourceImg.getWidth()); // 源图宽度
//        System.out.println(sourceImg.getHeight()); // 源图高度
//
//    }






}
