package com.hm.hm_page.controller;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.hm.hm_page.common.CommonService;
import com.hm.hm_page.service.HmBookService;
import com.hm.hm_page.service.StaticService;

import com.hm.hm_page.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


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
    @Autowired
    private HmBookService hmBookService;
    @Autowired
    private CommonService commonService;
    /**
     * @param
     * @Description: 生成静态页首页及翻页
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/11 16:49
     */
    @RequestMapping(value = "/staticIndex", method = RequestMethod.GET)
    public String staticIndex()  {
        int pageSize = 10;
        try{
            String sql = " select * from hm_book  ";
            int sqlnum = commonService.pageDataNum(sql);
            int totalPage = (sqlnum/pageSize);
            if(sqlnum%pageSize!=0){
                totalPage = (sqlnum/pageSize)+1;
            }
            for (int i = 1; i < totalPage+1; i++) {
                staticService.createIndexHtml(i,pageSize);
            }
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
    public String staticChapterList()  {
        try{
            String sql = " select * from hm_book where id in (1,2)";
            List<HashMap> booklist = commonService.selectDataBySql(sql);
            if (booklist!=null&&booklist.size()>0){
                for (int i = 0; i < booklist.size(); i++) {
                    HashMap m = booklist.get(i);
                    int id = StrUtil.getNotNullIntValue(m.get("id")+"");
                    staticService.createChapterList(id);
                }
            }
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
    public String staticPageHtml()  {
        int pageSize = 3;
        try{
            String sql = " select * from hm_chapter  where book_id in (1,2)";
            List<HashMap> list = commonService.selectDataBySql(sql);
            if (list!=null&&list.size()>0){
                for (int i = 0; i < list.size(); i++) {
                    HashMap m = list.get(i);
                    int chapterId = StrUtil.getNotNullIntValue(m.get("id")+"");
                    int bookId = StrUtil.getNotNullIntValue(m.get("book_id")+"");
                    String sql0 = "select * from hm_page where chapter_id = "+chapterId;
                    int sqlnum = commonService.pageDataNum(sql0);
                    int totalPage = (sqlnum/pageSize);
                    if(sqlnum%pageSize!=0){
                        totalPage = (sqlnum/pageSize)+1;
                    }
                    for (int k = 1; k < totalPage+1; k++) {
                        staticService.createPageHtml(chapterId,bookId,k,1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }






}
