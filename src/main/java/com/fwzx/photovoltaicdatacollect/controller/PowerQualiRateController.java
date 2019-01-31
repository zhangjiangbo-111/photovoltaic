package com.fwzx.photovoltaicdatacollect.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fwzx.photovoltaicdatacollect.service.PowerQualiRateCollerService;

@Controller
public class PowerQualiRateController {
	@Autowired
	PowerQualiRateCollerService powerQualiRateCollerService;

	// 计算昨天的短期预报合格率
	//@Scheduled(cron = "0 14 17 1/1 * ?  ")
	public void CalShortQualiRateByYesterDay() {
		// 格式化日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 得到现在的时间
		Calendar cal = Calendar.getInstance();
		// 日期减1
		cal.add(Calendar.DATE, -1);
		// 调用方法计算合格率并入库
		powerQualiRateCollerService.CalShortQualiRateByOneDay(dateFormat.format(new Date(cal.getTimeInMillis())));

	}

	// 计算昨天的超短期预报合格率
	//@Scheduled(cron = "0 34 12 1/1 * ?  ")
	public void CalSuperShortQualiRateByYesterDay() {
		// 格式化日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 得到现在的时间
		Calendar cal = Calendar.getInstance();
		// 日期减1
		cal.add(Calendar.DATE, -1);
		// 调用方法计算合格率并入库
		powerQualiRateCollerService.CalSuperShortQualiRateByOneDay(dateFormat.format(new Date(cal.getTimeInMillis())));

	}

}
