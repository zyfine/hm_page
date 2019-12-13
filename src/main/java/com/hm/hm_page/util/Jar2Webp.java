package com.hm.hm_page.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import com.luciad.imageio.webp.WebPWriteParam;
 
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;



public class Jar2Webp {

	
	/**
	 * 转换成webp格式
	 * @param inputJpgPath 原图路径
	 * @param outputWebpPath 生成图路径
	 * @throws IOException
	 */
	public static void getWebpImg(String inputJpgPath,String outputWebpPath) throws IOException{
 
        // Obtain an image to encode from somewhere
        BufferedImage image = ImageIO.read(new File(inputJpgPath));
 
        // Obtain a WebP ImageWriter instance
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();
 
        // Configure encoding parameters
        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        writeParam.setCompressionMode(WebPWriteParam.MODE_DEFAULT);
 
        // Configure the output on the ImageWriter
        writer.setOutput(new FileImageOutputStream(new File(outputWebpPath)));
 
        // Encode
        long st = System.currentTimeMillis();
        writer.write(null, new IIOImage(image, null, null), writeParam);
        System.out.println("耗时: " + (System.currentTimeMillis() - st));
	}
	
	
	
	 public static void main(String args[]) throws IOException {

	        String inputJpgPath = "/Users/zyfine/Desktop/pic_001.jpg";
	        String outputWebpPath = "/Users/zyfine/Desktop/pic_001.jpg.webp";
	        Jar2Webp.getWebpImg(inputJpgPath, outputWebpPath);
	       
	    }


	
}
