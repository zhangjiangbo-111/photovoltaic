package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.PhotoActData;
import com.fwzx.photovoltaicdatacollect.pojo.PhotoActDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoActDataMapper {
    long countByExample(PhotoActDataExample example);

    int deleteByExample(PhotoActDataExample example);

    int insert(PhotoActData record);

    int insertSelective(PhotoActData record);

    List<PhotoActData> selectByExample(PhotoActDataExample example);

    int updateByExampleSelective(@Param("record") PhotoActData record, @Param("example") PhotoActDataExample example);

    int updateByExample(@Param("record") PhotoActData record, @Param("example") PhotoActDataExample example);
}