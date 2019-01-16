package com.fwzx.photovoltaicdatacollect.service;

import com.fwzx.photovoltaicdatacollect.dao.WindActDataMapper;
import com.fwzx.photovoltaicdatacollect.pojo.WindActData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WindDataCollectService {

   // @Autowired
   // WindActDataMapper WADMapper;

    //插入数据
    public void insertData(WindActData data){
        //WADMapper.insertSelective(data);
    }

}
