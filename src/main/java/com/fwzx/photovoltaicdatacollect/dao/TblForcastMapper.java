package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.TblForcast;

public interface TblForcastMapper {
    int deleteByPrimaryKey(String id);

    int insert(TblForcast record);

    int insertSelective(TblForcast record);

    TblForcast selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblForcast record);

    int updateByPrimaryKey(TblForcast record);
}