package com.hm.hm_page.mapper;

import com.hm.hm_page.entity.HmBook;
import com.hm.hm_page.entity.HmBookExample;
import com.hm.hm_page.entity.HmChapter;
import com.hm.hm_page.entity.HmPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommonMapper {

    int pageDataNum(String sql);

    List<HashMap> selectDataBySql(String sql);

    List<HashMap> pageDataListOracle(Map map);

    List<HashMap> pageDataListMysql(Map map);

    void deleteData(String sql);

    void updateData(String sql);

    void insertChapterBatch(List<HmChapter> list);

    void insertPageBatch(List<HmPage> list);



}
