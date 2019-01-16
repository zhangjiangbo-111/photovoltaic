package com.fwzx.photovoltaicdatacollect;

import com.fwzx.photovoltaicdatacollect.controller.WindDataCollectController;
import com.fwzx.photovoltaicdatacollect.controller.WindSDataCollectController;
import com.fwzx.photovoltaicdatacollect.service.WindSDataCollectService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
//扫描mybatis mapper包路径
@MapperScan(basePackages = "com.fwzx.photovoltaicdatacollect.dao")
//扫描所有需要的包，包含一些自用的工具类包所在的路径
@ComponentScan(basePackages={"com.fwzx.photovoltaicdatacollect","org.n3r.idworker"})
//开启定时任务
@EnableScheduling
public class PhotovoltaicDataCollectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotovoltaicDataCollectApplication.class, args);
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");
        Date date = new Date();

        System.out.println(sf.format(date) + " 光伏/风电数据采集系统启动成功！");

    }


}

