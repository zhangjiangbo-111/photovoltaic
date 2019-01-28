package com.fwzx.photovoltaicdatacollect.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwzx.photovoltaicdatacollect.dao.PhotoActDataMapper;
import com.fwzx.photovoltaicdatacollect.dao.ShortForecHisMapper;
import com.fwzx.photovoltaicdatacollect.pojo.PhotoActData;

@Service
public class PowerQualiRateCollerService {
	
	@Autowired
	PhotoActDataMapper photoActDataMapper;
	
	@Autowired
	ShortForecHisMapper shortForecHisMapper;
	
	/**
	 * 计算短期预报合格率
	 * @param day 要计算合格率的日期
	 */
	public void CalShortQualiRateByOneDay(String day){
		//得到开始时间
		String beginDate=day+" 00:00:00";
		//得到结束时间
		String endDate=day+" 23:59:59";
		//得到实际功率
		System.out.println(beginDate+"     "+endDate);
		List<PhotoActData> pADList= photoActDataMapper.selectPhotoActData(beginDate, endDate);
		System.out.println(pADList);
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		for(PhotoActData pad:pADList){
			System.out.println();
			
		}
		System.out.println("没了");
		//得到预测功率
		
		//算出合格率
		
		//删除重复的数据
		
		//入库
		
	}
	
	
}
