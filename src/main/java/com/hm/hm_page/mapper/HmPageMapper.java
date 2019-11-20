package com.hm.hm_page.mapper;

import com.hm.hm_page.entity.HmPage;
import com.hm.hm_page.entity.HmPageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HmPageMapper {
    int countByExample(HmPageExample example);

    int deleteByExample(HmPageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HmPage record);

    int insertSelective(HmPage record);

    List<HmPage> selectByExample(HmPageExample example);

    HmPage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HmPage record, @Param("example") HmPageExample example);

    int updateByExample(@Param("record") HmPage record, @Param("example") HmPageExample example);

    int updateByPrimaryKeySelective(HmPage record);

    int updateByPrimaryKey(HmPage record);
}