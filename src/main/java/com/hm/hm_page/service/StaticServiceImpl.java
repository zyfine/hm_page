package com.hm.hm_page.service;

import com.hm.hm_page.common.CommonService;
import com.hm.hm_page.entity.HmChapter;
import com.hm.hm_page.entity.HmPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/**
 * @program: hm_page
 * @description: 静态化
 * @author: zyfine
 * @create: 2019-12-11 16:35
 **/

@Service
public class StaticServiceImpl implements StaticService {

    @Autowired
    private HmBookService hmBookService;
    @Autowired
    private CommonService commonService;

    /**
     * 生成首页静态页面
     */
    @Override
    public void createIndexHtml(int pageNum,int pageSize) {
        try {
            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setPrefix("templates/");
            resolver.setSuffix(".html");
            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);

            Context context = new Context();
            String sql = " (select * from hm_book ) as a  ";
            List<HashMap> booklist = commonService.selectDataBySql(sql,pageNum,pageSize);
            int sqlnum = commonService.pageDataNum(sql);
            int totalPage = (sqlnum/pageSize);
            if(sqlnum%pageSize!=0){
                totalPage = (sqlnum/pageSize)+1;
            }
            context.setVariable("booklist", booklist);
            context.setVariable("sqlnum", sqlnum);
            context.setVariable("currpage", pageNum);
            context.setVariable("totalNum", totalPage);

            /**获取输出目标文件输出流------开始*/
            String filepath = this.getClass().getResource("/").toURI().getPath() + "static/hm_html/";
            System.out.println(filepath);
            File folder = new File(filepath);
            //如果文件夹不存在
            if (!folder.exists()) {
                folder.mkdir();
            }
            String indexFileName = "index.html";
            File indexHtml = new File(folder, indexFileName);
            //如果html文件不存在
            if (!indexHtml.exists()) {
                indexHtml.createNewFile();
            }
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexHtml), "UTF-8"));
            /**获取输出目标文件输出流------结束*/

            templateEngine.process("hm/chapterlist", context, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void createChapterList(int id){
        try {
            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setPrefix("templates/");
            resolver.setSuffix(".html");
            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);

            Context context = new Context();
            context.setVariable("chapterlist", hmBookService.getHmChapterList(id));
            context.setVariable("bookinfo", hmBookService.getHmBookDetail(id));

            /**获取输出目标文件输出流------开始*/
            String filepath = this.getClass().getResource("/").toURI().getPath() + "static/hm_html/"+id+"/";
            System.out.println(filepath);
            File folder = new File(filepath);
            //如果文件夹不存在
            if (!folder.exists()) {
                folder.mkdir();
            }
            String indexFileName = "index.html";
            File indexHtml = new File(folder, indexFileName);
            //如果html文件不存在
            if (!indexHtml.exists()) {
                indexHtml.createNewFile();
            }
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexHtml), "UTF-8"));
            /**获取输出目标文件输出流------结束*/

            templateEngine.process("hm/chapterlist", context, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void createPageHtml(int chapterId,int bookid){
        try {
            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setPrefix("templates/");
            resolver.setSuffix(".html");
            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);

            Context context = new Context();
            List<HmPage> pageList = hmBookService.getHmPageList(chapterId);
            context.setVariable("pageList", pageList);

            /**获取输出目标文件输出流------开始*/
            String filepath = this.getClass().getResource("/").toURI().getPath() + "static/hm_html/"+bookid+"/"+chapterId+"/";
            System.out.println(filepath);
            File folder = new File(filepath);
            //如果文件夹不存在
            if (!folder.exists()) {
                folder.mkdir();
            }
            String indexFileName = "index.html";
            File indexHtml = new File(folder, indexFileName);
            //如果html文件不存在
            if (!indexHtml.exists()) {
                indexHtml.createNewFile();
            }
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexHtml), "UTF-8"));
            /**获取输出目标文件输出流------结束*/

            templateEngine.process("hm/chapterlist", context, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }




}
