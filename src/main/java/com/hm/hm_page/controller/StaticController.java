package com.hm.hm_page.controller;


import com.hm.hm_page.service.StaticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @program: hm_page
 * @description:
 * @author: zyfine
 * @create: 2019-11-20 16:26
 **/
@RestController
@RequestMapping("/")
public class StaticController {

    @Autowired
    private StaticService staticService;

    /**
     * @param
     * @Description: 生成静态页首页
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/11 16:49
     */
    @RequestMapping(value = "/staticIndex", method = RequestMethod.GET)
    public String staticIndex()  {
        try{
            staticService.createIndexHtml(1,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
    /**
     * @param 
     * @Description:生成章节列表静态页
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/11 18:07
     */
    @RequestMapping(value = "/staticChapterList", method = RequestMethod.GET)
    public String staticChapterList(int id)  {
        try{
            staticService.createChapterList(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
    /**
     * @param
     * @Description: 生成页面静态页
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/11 18:08
     */
    @RequestMapping(value = "/staticPageHtml", method = RequestMethod.GET)
    public String staticPageHtml(int id,int bookid)  {
        try{
            staticService.createPageHtml(id,bookid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }






}
