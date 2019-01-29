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
	//@Scheduled(cron ="0 37 9 1/1 * ?  ")
	public void insertNumericalPre(){
		powerForecastCollerService.insertNumericalPre();
		
	}
	
	//保存以当日为开始的第二天数值预报到数值预报历史记录中
	//@Scheduled(cron ="0 34 10 1/1 * ?  ")
	public void insertNumericalPreHis(){
		powerForecastCollerService.insertNumericalPreHis();
	}
	
	//用来录入当日的短期预报，会删除重复数据然后录入数据
	//@Scheduled(cron ="0 27 11 1/1 * ?  ")
	public void insertShortForecastDataHis(){
		powerForecastCollerService.insertShortForecastDataHis();
	}
	
	//每15分钟录入一次未来第4个小时后的超短期预报数据
	//@Scheduled(cron ="0 0/15 * * * ? ")
	public void insertSuperShortForecastDataHis(){
		powerForecastCollerService.insertSuperShortForecastDataHis();
	}
	
	//录入未来7天短期预报数据到数据库中
	//@Scheduled(cron ="0 36 14 1/1 * ?  ")
	public void insertShortForecastFutureData(){
		powerForecastCollerService.insertShortForecastFutureData();
	}
	
	
}
