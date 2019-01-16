package com.fwzx.photovoltaicdatacollect.dao;

import com.fwzx.photovoltaicdatacollect.pojo.WindActData;
import com.fwzx.photovoltaicdatacollect.pojo.WindActDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WindActDataMapper {

    long countByExample(WindActDataExample example);

    int deleteByExample(WindActDataExample example);

    int insert(WindActData record);

    int insertSelective(WindActData record);

    List<WindActData> selectByExample(WindActDataExample example);

    int updateByExampleSelective(@Param("record") WindActData record, @Param("example") WindActDataExample example);

    int updateByExample(@Param("record") WindActData record, @Param("example") WindActDataExample example);
}