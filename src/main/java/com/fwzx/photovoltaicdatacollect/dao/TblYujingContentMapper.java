package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.TblYujingContent;

public interface TblYujingContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TblYujingContent record);

    int insertSelective(TblYujingContent record);

    TblYujingContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TblYujingContent record);

    int updateByPrimaryKey(TblYujingContent record);
}