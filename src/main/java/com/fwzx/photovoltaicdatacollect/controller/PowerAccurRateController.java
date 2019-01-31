package com.fwzx.photovoltaicdatacollect.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fwzx.photovoltaicdatacollect.service.PowerAccurRateCollerService;

@Controller
public class PowerAccurRateController {

	@Autowired
	PowerAccurRateCollerService powerAccurRateCollerService;

	// 计算昨天的短期预报准确率
	//@Scheduled(cron = "0 17 13 1/1 * ? ")
	public void CalShortQualiRateByYesterDay() {
		// 格式化日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 得到现在的时间
		Calendar cal = Calendar.getInstance();
		// 日期减1
		cal.add(Calendar.DATE, -1);
		// 调用方法计算准确率并入库
		powerAccurRateCollerService.CalShortAccurRateByOneDay(dateFormat.format(new Date(cal.getTimeInMillis())));

	}

	// 计算昨天的超短期预报准确率
	@Scheduled(cron = "0 49 13 1/1 * ?  ")
	public void CalSuperShortQualiRateByYesterDay() {
		// 格式化日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 得到现在的时间
		Calendar cal = Calendar.getInstance();
		// 日期减1
		cal.add(Calendar.DATE, -1);
		// 调用方法计算准确率并入库
		powerAccurRateCollerService.CalSuperShortAccurRateByOneDay(dateFormat.format(new Date(cal.getTimeInMillis())));

	}

}
