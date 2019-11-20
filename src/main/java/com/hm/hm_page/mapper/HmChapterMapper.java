package com.hm.hm_page.mapper;

import com.hm.hm_page.entity.HmChapter;
import com.hm.hm_page.entity.HmChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HmChapterMapper {
    int countByExample(HmChapterExample example);

    int deleteByExample(HmChapterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HmChapter record);

    int insertSelective(HmChapter record);

    List<HmChapter> selectByExample(HmChapterExample example);

    HmChapter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HmChapter record, @Param("example") HmChapterExample example);

    int updateByExample(@Param("record") HmChapter record, @Param("example") HmChapterExample example);

    int updateByPrimaryKeySelective(HmChapter record);

    int updateByPrimaryKey(HmChapter record);
}