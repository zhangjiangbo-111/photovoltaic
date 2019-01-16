package com.fwzx.photovoltaicdatacollect.service;


import com.fwzx.photovoltaicdatacollect.dao.WindActSDataMapper;
import com.fwzx.photovoltaicdatacollect.pojo.WindActSData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WindSDataCollectService {

     @Autowired
     WindActSDataMapper WASDMapper;
    //插入数据
    public void insertData(WindActSData data){
           // System.out.println(data);
        WASDMapper.insertSelective(data);

    }

}
