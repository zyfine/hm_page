package com.hm.hm_page.mapper;

import com.hm.hm_page.entity.HmBook;
import com.hm.hm_page.entity.HmBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HmBookMapper {
    int countByExample(HmBookExample example);

    int deleteByExample(HmBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HmBook record);

    int insertSelective(HmBook record);

    List<HmBook> selectByExample(HmBookExample example);

    HmBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HmBook record, @Param("example") HmBookExample example);

    int updateByExample(@Param("record") HmBook record, @Param("example") HmBookExample example);

    int updateByPrimaryKeySelective(HmBook record);

    int updateByPrimaryKey(HmBook record);
}