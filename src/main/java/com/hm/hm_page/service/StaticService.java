package com.hm.hm_page.service;

public interface StaticService {
    /**
     * 生成首页静态页面
     */
    void createIndexHtml(int pageNum,int pageSize);

    void createChapterList(int id);

    void createPageHtml(int id,int bookid,int pnum, int pageSize);


}
