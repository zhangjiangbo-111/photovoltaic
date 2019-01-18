package com.fwzx.photovoltaicdatacollect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fwzx.photovoltaicdatacollect.service.PowerForecastCollerService;

@Controller
public class PowerForecastController {

	
	@Autowired
	PowerForecastCollerService powerForecastCollerService;
	
	//把原來的数值预报删除并添加新的数值预报数据
	//@Scheduled(cron ="0 56 9 1/1 * ?  ")
	public void insertNumericalPre(){
		powerForecastCollerService.insertNumericalPre();
		
	}
	
	//保存以当日为开始的第二天数值预报到数值预报历史记录中
	@Scheduled(cron ="0 35 14 1/1 * ?  ")
	public void insertNumericalPreHis(){
		powerForecastCollerService.insertNumericalPreHis();
	}
	
}
