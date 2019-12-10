package com.hm.hm_page.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.hm_page.common.CommonService;
import com.hm.hm_page.entity.HmBook;
import com.hm.hm_page.entity.HmChapter;
import com.hm.hm_page.entity.HmPage;
import com.hm.hm_page.entity.User;
import com.hm.hm_page.service.HmBookService;
import com.hm.hm_page.util.SqlInjectionTool;
import com.hm.hm_page.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

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
    @Autowired
    private CommonService commonService;
    /**
     * @param
     * @Description: 首页显示书目
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:02
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getMainTitle() {
        ModelAndView mv = new ModelAndView("hm/index");
        try{
            List<HmBook> booklist = hmBookService.getMainTitle(20);
            List<HmBook> newbooklist = hmBookService.getLastTitle(10);
            mv.addObject("booklist", booklist);
            mv.addObject("newbooklist", newbooklist);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    /**
     * @param
     * @Description: 跳转登录
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/9 16:30
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("hm/manage/login");
        try{
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public ModelAndView getMainTitle(@RequestParam(value = "pageNum",defaultValue="1") int pageNum,@PathVariable String name)  {
        ModelAndView mv = new ModelAndView("hm/search");
        int pageSize = 10;
        name = SqlInjectionTool.filter(name);
        try{
            String sql = " (select * from hm_book where tilte like '%"+name+"%') as a  ";
            List<HashMap> booklist = commonService.selectDataBySql(sql,pageNum,pageSize);
            int sqlnum = commonService.pageDataNum(sql);
            mv.addObject("booklist", booklist);
            mv.addObject("sqlnum", sqlnum);
            mv.addObject("currpage", pageNum);
            int totalPage = (sqlnum/pageSize);
            if(sqlnum%pageSize!=0){
                totalPage = (sqlnum/pageSize)+1;
            }
            mv.addObject("totalNum", totalPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

//    /**
//     * @param
//     * @Description: pagehelper分页列表显示全部book
//     * @return:
//     * @Author: zyfine
//     * @Date: 2019/11/21 10:32
//     */
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public ModelAndView getAllTitle(@RequestParam(value = "pageNum",defaultValue="1") int pageNum )  {
//        ModelAndView mv = new ModelAndView("hm/search");
//        try{
//            PageHelper.startPage(pageNum,10);
//            List<HmBook> booklist = hmBookService.getAllTitle();
//            PageInfo<User> pageInfo=new PageInfo(booklist,10);
//            mv.addObject("booklist", booklist);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mv;
//    }

    /**
     * @param
     * @Description: 翻页显示所有book
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/2 11:26
     */
    @RequestMapping(value = "/allpage", method = RequestMethod.GET)
    public ModelAndView getAllTitleByPage(@RequestParam(value = "pageNum",defaultValue="1") int pageNum )  {
        ModelAndView mv = new ModelAndView("hm/search");
        int pageSize = 10;
        try{
            String sql = " (select * from hm_book ) as a  ";
            List<HashMap> booklist = commonService.selectDataBySql(sql,pageNum,pageSize);
            int sqlnum = commonService.pageDataNum(sql);

            mv.addObject("booklist", booklist);
            mv.addObject("sqlnum", sqlnum);
            mv.addObject("currpage", pageNum);
            int totalPage = (sqlnum/pageSize);
            if(sqlnum%pageSize!=0){
                totalPage = (sqlnum/pageSize)+1;
            }
            mv.addObject("totalNum", totalPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * @param
     * @Description: 获得图书明细和章节
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:12
     */
    @RequestMapping(value = "/chapter/{id}", method = RequestMethod.GET)
    public ModelAndView getChapterList(@PathVariable int id)  {
        ModelAndView mv = new ModelAndView("hm/chapterList");
        try{
            List<HmChapter> chapterlist = hmBookService.getHmChapterList(id);
            HmBook bookinfo = hmBookService.getHmBookDetail(id);
            mv.addObject("chapterlist", chapterlist);
            mv.addObject("bookinfo", bookinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public ModelAndView getPageList(@PathVariable int id,@RequestParam(value = "pageNum",defaultValue="1") int pageNum )  {
        ModelAndView mv = new ModelAndView("hm/pageInfo");
        try{
            PageHelper.startPage(pageNum,1);
            HmChapter chapterinfo = hmBookService.getHmChapterDetail(id);
            List<HmPage> pageList = hmBookService.getHmPageList(id);
            PageInfo<User> pageInfo = new PageInfo(pageList,3);
            mv.addObject("chapterinfo", chapterinfo);
            mv.addObject("pageList", pageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * @param
     * @Description: 插入book和章节信息
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/6 16:50
     */
    @RequestMapping(value = "/ins", method = RequestMethod.GET)
    public String insertHmChapter()  {
        try{
            String basePath = "/Volumes/zyfine/hm2/hm-final";
//            String basePath = "C:\\Users\\jslx\\Desktop\\hm-test";
            String[] list=new File(basePath).list();
            System.out.println("book个数："+list.length);
            Arrays.sort(list);
            if(list!=null&&list.length>0){
                for (String str : list) {//循环book名称
                    String bookPath = basePath+File.separator+str;
                    File file = new File(bookPath);
                    if(file.isDirectory()){//判断是否文件夹
                        HmBook record0 = new HmBook();
                        record0.setTitle(str);
                        record0.setAuthor("zyfine");
                        record0.getChapterLast();
                        record0.getChapterLastId();
                        record0.setComment(str);
                        record0.setCreatePerson("admin");
                        record0.setCreateTime(new Date());
                        record0.setHot(new BigDecimal("10"));
                        record0.setIsEnd("1");
                        record0.setLabel("");
                        record0.setLatestTime(new Date());
                        record0.setTitlePic(str+".jpg");
                        record0.setType("都市");
                        hmBookService.insertHmBook(record0);
                        HmBook book = hmBookService.getHmBookByName(str);
                        //循环book子文件夹
                        String[] chapterlist=new File(bookPath).list();
                        List<HmChapter> chapters = new ArrayList<HmChapter>();
                        //排序
                        Arrays.sort(chapterlist);
                        if(chapterlist!=null&&chapterlist.length>0){
                            for (int i=0;i<chapterlist.length; i++){
                                String chapterPath = basePath+File.separator+str+File.separator+chapterlist[i];
                                File chapterfile = new File(chapterPath);
                                if(chapterfile.isDirectory()){//判断是否文件夹
                                    HmChapter hmChapter = new HmChapter();
                                    hmChapter.setBookId(book.getId());
                                    hmChapter.setChapterName(chapterlist[i]);
                                    hmChapter.setCreatePerson("admin");
                                    hmChapter.setCreateTime(new Date());
                                    String flag = "0";
                                    if(i==(chapterlist.length-1)){
                                        flag = "1";
                                        hmBookService.updateHmBookById(book.getId(),chapterlist[i],(i+1));
                                    }
                                    hmChapter.setIsEnd(flag);
                                    hmChapter.setChapterNum(i+1);
                                    hmChapter.setPagenum(chapterlist.length);
                                    chapters.add(hmChapter);
                                }
                            }
                            hmBookService.insertChapterBatch(chapters);
                            chapters = null;
                            System.out.println(str+"处理完");

                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * @param
     * @Description: 获取所有章节page插入
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/6 17:08
     */
    @RequestMapping(value = "/inspage", method = RequestMethod.GET)
    public String insertHmChapterPage()  {
        try{
//            String path = "C:\\Users\\jslx\\Desktop\\hm-test";
            String path = "/Volumes/zyfine/hm2/hm-final";
            String sql = "SELECT c.title,d.* FROM `hm_book` c,hm_chapter d where c.id=d.book_id order by d.id";
            List<HashMap> chapterlist = commonService.selectDataBySql(sql);
            if (chapterlist!=null&&chapterlist.size()>0){
                for (int i=0;i<chapterlist.size(); i++){
                    String bookname = StrUtil.getNotNullStrValue(chapterlist.get(i).get("title"));
                    String chaptername = StrUtil.getNotNullStrValue(chapterlist.get(i).get("chapter_name"));
                    int bookid = StrUtil.getNotNullIntValue(chapterlist.get(i).get("book_id")+"");
                    int chapterid = StrUtil.getNotNullIntValue(chapterlist.get(i).get("id")+"");
                    String pagepath = path + File.separator + bookname+ File.separator + chaptername;
                    String[] pagelist=new File(pagepath).list();
                    //排序
                    pagelist = StrUtil.ArraySortStr(pagelist);
                    List<HmPage> pages = new ArrayList<HmPage>();
                    if(pagelist!=null&&pagelist.length>0){
                        for (int j=0;j<pagelist.length; j++){
                            String pageName = StrUtil.getNotNullStrValue(pagelist[j]);
                            HmPage record = new HmPage();
                            record.setBookId(bookid);
                            record.setBookName(bookname);
                            record.setChapterId(chapterid);
                            record.setChapterName(chaptername);
                            record.setCreatePerson("admin");
                            record.setCreateTime(new Date());
                            String flag = "0";
                            if(j==(pagelist.length-1)){
                                flag = "1";
                            }
                            record.setIsEnd(flag);
                            record.setSorting(j+1);
                            record.setUrl(pageName);
                            pages.add(record);
                        }
                    }
                    hmBookService.insertPageBatch(pages);
                    pages = null;
                    System.out.println("完成"+bookname+"-"+chaptername);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }


//    public static void main(String[] args) {
//        String basePath = "/Volumes/zyfine/hm2/hm-final";
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
//                            System.out.println(str+chapterlist[1]);
//                            for (int i=0;i<chapterlist.length; i++) {
//                                if (file.isDirectory()) {
//                                    String chapterPath = basePath + File.separator + str + File.separator + chapterlist[i];
//                                    String newname = chapterlist[i].replace("img (", "").replace(")", "");
//                                    if (newname.length() == 1) {
//                                        newname = "0" + newname;
//                                    }
//                                    String chapterPathNew = basePath + File.separator + str + File.separator + newname;
//                                    File file0 = new File(chapterPath);
//                                    file0.renameTo(new File(chapterPathNew));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }






}
