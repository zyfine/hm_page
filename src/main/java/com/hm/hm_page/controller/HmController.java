package com.hm.hm_page.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.hm_page.entity.HmBook;
import com.hm.hm_page.entity.HmChapter;
import com.hm.hm_page.entity.HmPage;
import com.hm.hm_page.entity.User;
import com.hm.hm_page.service.HmBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: hm_page
 * @description:
 * @author: zyfine
 * @create: 2019-11-20 16:26
 **/
@RestController
@RequestMapping("/")
public class HmController {

    @Autowired
    private HmBookService hmBookService;

    /**
     * @param
     * @Description: 首页显示书目
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:02
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getMainTitle() throws Exception {
        ModelAndView mv = new ModelAndView("/hm/index");
        List<HmBook> booklist = hmBookService.getMainTitle(20);
        List<HmBook> newbooklist = hmBookService.getLastTitle(10);
        mv.addObject("booklist", booklist);
        mv.addObject("newbooklist", newbooklist);
        return mv;
    }
    /**
     * @param name 名称
     * @Description: 通过名称查询图书
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:08
     */
    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public ModelAndView getMainTitle(@PathVariable String name) throws Exception {
        ModelAndView mv = new ModelAndView("/hm/search");
        List<HmBook> booklist = hmBookService.getMainTitleByName(name);
        mv.addObject("booklist", booklist);
        return mv;
    }
    /**
     * @param
     * @Description: 列表显示全部book
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/21 10:32
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllTitle(@RequestParam(value = "pageNum",defaultValue="1") int pageNum ) throws Exception {
        PageHelper.startPage(pageNum,10);
        ModelAndView mv = new ModelAndView("/hm/search");
        List<HmBook> booklist = hmBookService.getAllTitle();
        PageInfo<User> pageInfo=new PageInfo(booklist,10);
        mv.addObject("booklist", booklist);
        return mv;
    }
    /**
     * @param id
     * @Description: 获得图书明细和章节
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:12
     */
    @RequestMapping(value = "/chapter/{id}", method = RequestMethod.GET)
    public ModelAndView getChapterList(@PathVariable int id) throws Exception {
        ModelAndView mv = new ModelAndView("/hm/chapterList");
        List<HmChapter> chapterlist = hmBookService.getHmChapterList(id);
        HmBook bookinfo = hmBookService.getHmBookDetail(id);
        mv.addObject("chapterlist", chapterlist);
        mv.addObject("bookinfo", bookinfo);
        return mv;
    }
    /**
     * @param id
     * @Description: 显示章节每页明细
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:31
     */
    @RequestMapping(value = "/pagede/{id}", method = RequestMethod.GET)
    public ModelAndView getPageList(@PathVariable int id,@RequestParam(value = "pageNum",defaultValue="1") int pageNum ) throws Exception {
        ModelAndView mv = new ModelAndView("/hm/pageInfo");
        PageHelper.startPage(pageNum,1);
        HmChapter chapterinfo = hmBookService.getHmChapterDetail(id);
        List<HmPage> pageList = hmBookService.getHmPageList(id);
        PageInfo<User> pageInfo=new PageInfo(pageList,3);
        mv.addObject("chapterinfo", chapterinfo);
        mv.addObject("pageList", pageList);
        return mv;
    }















}
