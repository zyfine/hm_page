package com.hm.hm_page.common;

import com.hm.hm_page.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hm_page
 * @description: 公共service类
 * @author: zyfine
 * @create: 2019-11-22 17:06
 **/
@Service
public class CommonService {

    @Autowired
    CommonMapper commonMapper;

    public List<HashMap> selectDataBySql(String sql){
        return commonMapper.selectDataBySql(sql);
    }
    public List<HashMap> selectDataBySql(String sql,int currIndex,int pageSize){
        Map map = new HashMap();
        map.put("sql", sql);
        map.put("currIndex", (currIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        return commonMapper.pageDataListMysql(map);
    }
    public List<HashMap> pageDataListOracle(String sql,int pn,int pageSize){
        Map map = new HashMap();
        map.put("sql", sql);
        map.put("from", (pn - 1) * pageSize);
        map.put("to", pn*pageSize);
        return commonMapper.pageDataListOracle(map);
    }
    public int pageDataNum(String sql){
        return commonMapper.pageDataNum(sql);
    }
    public void deleteData(String sql){
        commonMapper.deleteData(sql);
    }
    public void updateData(String sql){
        commonMapper.updateData(sql);
    }
















}
