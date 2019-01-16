package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.WindActSData;
import com.fwzx.photovoltaicdatacollect.pojo.WindActSDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface WindActSDataMapper {
    long countByExample(WindActSDataExample example);

    int deleteByExample(WindActSDataExample example);

    int insert(WindActSData record);

    int insertSelective(WindActSData record);

    List<WindActSData> selectByExample(WindActSDataExample example);

    int updateByExampleSelective(@Param("record") WindActSData record, @Param("example") WindActSDataExample example);

    int updateByExample(@Param("record") WindActSData record, @Param("example") WindActSDataExample example);
}