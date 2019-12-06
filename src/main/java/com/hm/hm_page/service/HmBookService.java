package com.hm.hm_page.service;

import com.hm.hm_page.entity.*;
import com.hm.hm_page.mapper.CommonMapper;
import com.hm.hm_page.mapper.HmBookMapper;
import com.hm.hm_page.mapper.HmChapterMapper;
import com.hm.hm_page.mapper.HmPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Service
public class HmBookService {

    @Autowired
    HmBookMapper hmBookMapper;
    @Autowired
    HmChapterMapper hmChapterMapper;
    @Autowired
    HmPageMapper hmPageMapper;
    @Autowired
    CommonMapper commonMapper;
    
    /**
     * @param num 数量
     * @Description: 首页列表
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 15:52
     */
    public List<HmBook> getMainTitle(int num){
        HmBookExample e = new HmBookExample();
        List<HmBook> list = hmBookMapper.selectByExample(e);
        e.setOrderByClause(" hot desc limit "+num);
        return list;
    }

    /**
     * @param name 搜索名
     * @Description: 名称模糊查询列表
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 15:52
     */
    public List<HmBook> getMainTitleByName(String name){
        HmBookExample e = new HmBookExample();
        e.createCriteria().andTitleLike(name);
        List<HmBook> list = hmBookMapper.selectByExample(e);
        e.setOrderByClause(" hot desc ");
        return list;
    }
    /**
     * @param
     * @Description: 获得所有book
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/21 10:30
     */
    public List<HmBook> getAllTitle(){
        HmBookExample e = new HmBookExample();
        List<HmBook> list = hmBookMapper.selectByExample(e);
        e.setOrderByClause(" latest_time desc ");
        return list;
    }

    /**
     * @param num 数量
     * @Description: 获得最近更新列表
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 15:55
     */
    public List<HmBook> getLastTitle(int num){
        HmBookExample e = new HmBookExample();
        List<HmBook> list = hmBookMapper.selectByExample(e);
        e.setOrderByClause(" latest_time desc limit "+num);
        return list;
    }
    /**
     * @param id 1
     * @Description: 通过id获得图书明细
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 15:58
     */
    public HmBook getHmBookDetail(int id){
        HmBookExample e = new HmBookExample();
        HmBook book = hmBookMapper.selectByPrimaryKey(id);
        return book;
    }
    /**
     * @param id 1
     * @Description: 通过id获得图书章节列表
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 16:02
     */
    public List<HmChapter> getHmChapterList(int id){
        HmChapterExample e = new HmChapterExample();
        e.createCriteria().andBookIdEqualTo(id);
        List<HmChapter> list = hmChapterMapper.selectByExample(e);
        e.setOrderByClause(" chapter_num ");
        return list;
    }
    /**
     * @param id
     * @Description: 获得章节明细
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 17:16
     */
    public HmChapter getHmChapterDetail(int id){
        HmChapterExample e = new HmChapterExample();
        HmChapter chapterinfo = hmChapterMapper.selectByPrimaryKey(id);
        return chapterinfo;
    }
    /**
     * @param id 1
     * @Description: 通过章节id获得章节明细页列表
     * @return:
     * @Author: zyfine
     * @Date: 2019/11/20 16:09
     */
    public List<HmPage> getHmPageList(int id){
        HmPageExample e = new HmPageExample();
        e.createCriteria().andChapterIdEqualTo(id);
        List<HmPage> list = hmPageMapper.selectByExample(e);
        e.setOrderByClause(" sorting ");
        return list;
    }

    public  void insertHmBook(HmBook record){
        hmBookMapper.insert(record);
    }
    public HmBook getHmBookByName(String name){
        HmBookExample e = new HmBookExample();
        e.createCriteria().andTitleEqualTo(name);
        return hmBookMapper.selectByExample(e).get(0);
    }

    public void insertHmChapter(HmChapter record){
        hmChapterMapper.insert(record);
    }

    public void insertChapterBatch(List<HmChapter> list){
        commonMapper.insertChapterBatch(list);
    }

    public void insertPageBatch(List<HmPage> list){
        commonMapper.insertPageBatch(list);
    }

    public void updateHmBookById(int id,String chapterName,int chapterNum){
        HmBookExample e = new HmBookExample();
        e.createCriteria().andIdEqualTo(id);
        HmBook record = new HmBook();
        record.setChapterLast(chapterName);
        record.setChapterLastId(chapterNum);
        hmBookMapper.updateByExampleSelective(record,e);
    }




    /**
     * @param basePath
     * @Description: 通过主目录，导入book名称和章节名称
     * @return:
     * @Author: zyfine
     * @Date: 2019/12/5 16:58
     */
    public void insertHmByFolder(String basePath){
        String[] list=new File(basePath).list();
        System.out.println("book个数："+list.length);
        List<String> booklist = new ArrayList<String>();
        if(list!=null&&list.length>0){
            for (String str : list) {//循环book名称
                String bookPath = basePath+File.separator+str;
                File file = new File(bookPath);
                if(file.isDirectory()){//判断是否文件夹
                    booklist.add(str);
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
                    record0.setType("");
                    new HmBookService().insertHmBook(record0);
                    HmBook book = new HmBookService().getHmBookByName(str);
                    //循环book子文件夹
                    String[] chapterlist=new File(bookPath).list();
                    List<HmChapter> chapters = new ArrayList<HmChapter>();
                    if(chapterlist!=null&&chapterlist.length>0){
                        for (int i=0;i<chapterlist.length; i++){
                            if(file.isDirectory()){//判断是否文件夹
                                HmChapter hmChapter = new HmChapter();
                                hmChapter.setBookId(book.getId());
                                hmChapter.setChapterName(chapterlist[i]);
                                hmChapter.setCreatePerson("admin");
                                hmChapter.setCreateTime(new Date());
                                String flag = "0";
                                if(i==(chapterlist.length-1)){
                                    flag = "1";
                                }
                                hmChapter.setIsEnd(flag);
                                hmChapter.setPagenum(chapterlist.length);
                                chapters.add(hmChapter);
                            }
                        }
                        commonMapper.insertChapterBatch(chapters);
                    }
                }
            }
        }
    }








}
