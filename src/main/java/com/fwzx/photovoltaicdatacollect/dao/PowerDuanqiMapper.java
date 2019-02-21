package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.PowerDuanqi;

public interface PowerDuanqiMapper {
    int deleteByPrimaryKey(String id);

    int insert(PowerDuanqi record);

    int insertSelective(PowerDuanqi record);

    PowerDuanqi selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PowerDuanqi record);

    int updateByPrimaryKey(PowerDuanqi record);
}