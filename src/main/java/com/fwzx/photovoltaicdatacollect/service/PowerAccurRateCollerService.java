package com.fwzx.photovoltaicdatacollect.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwzx.photovoltaicdatacollect.dao.AccuPassRateMapper;
import com.fwzx.photovoltaicdatacollect.dao.PhotoActDataMapper;
import com.fwzx.photovoltaicdatacollect.dao.PhotovoltaicBpMapper;
import com.fwzx.photovoltaicdatacollect.dao.ShortForecHisMapper;
import com.fwzx.photovoltaicdatacollect.dao.SuperaccuPassRateMapper;
import com.fwzx.photovoltaicdatacollect.dao.SupershortForecHisMapper;
import com.fwzx.photovoltaicdatacollect.pojo.AccuPassRate;
import com.fwzx.photovoltaicdatacollect.pojo.PhotoActData;
import com.fwzx.photovoltaicdatacollect.pojo.PhotovoltaicBp;
import com.fwzx.photovoltaicdatacollect.pojo.ShortForecHis;
import com.fwzx.photovoltaicdatacollect.pojo.SuperaccuPassRate;
import com.fwzx.photovoltaicdatacollect.pojo.SupershortForecHis;
import com.fwzx.photovoltaicdatacollect.util.IdWorker;

@Service
public class PowerAccurRateCollerService {
	
	@Autowired
	PhotoActDataMapper photoActDataMapper;
	
	@Autowired
	ShortForecHisMapper shortForecHisMapper;
	
	@Autowired
	PhotovoltaicBpMapper photovoltaicBpMapper;
	
	@Autowired
	AccuPassRateMapper accuPassRateMapper;
	
	@Autowired
	SupershortForecHisMapper supershortForecHisMapper;
	
	@Autowired
	SuperaccuPassRateMapper superaccuPassRateMapper;
	

	public void CalShortAccurRateByOneDay(String day) {
//		//得到开始时间
//		String beginDate=day+" 00:00:00";
//		//得到结束时间
//		String endDate=day+" 23:59:59";
		//日期格式化为字符串
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat hms = new SimpleDateFormat(" HH:mm:ss");
		//得到不同的时间点并拼接字符串
		String dayTemp=day+" 00:00:00";
		
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		String dateStr="";
		int dateStrFlag=0;
		for(int i=0;i<96;i++){
			dateStr+="'"+day+hms.format(new Date(cal.getTimeInMillis()))+"',";
			cal.add(Calendar.MINUTE, 15);
			dateStrFlag=1;
		}
		
		if(dateStrFlag==1){
			dateStr=dateStr.substring(0, dateStr.length()-1);
		}
		
		//得到实际功率
		List<PhotoActData> pADList= photoActDataMapper.selectPhotoActDataByStr(dateStr);
		System.out.println(pADList);
		
		//得到预测功率
		List<ShortForecHis> sFHList=shortForecHisMapper.selectShortForecHisByStr(dateStr);
		System.out.println(sFHList);
		
		//得到光伏电站装机总容量
		List<PhotovoltaicBp> pBList=photovoltaicBpMapper.queryAll();
		double capacity=0;
		for(PhotovoltaicBp pb:pBList){
			capacity+=pb.getpCapacity();
		}
		//算出准确率
		//计算各个时刻数据的准确率
		double shortQuali=0;
		double shortQualiNum=0;
		for(PhotoActData pad:pADList){
			for(ShortForecHis sfh:sFHList){
				if(df.format(pad.getGetTime()).equals(df.format(sfh.getDataTime()))){
					//shortQuali+=1.0-Math.abs(pad.getActPower()-sfh.getShortForec())/capacity;
					shortQuali+=Math.abs(pad.getActPower()-sfh.getShortForec());
					shortQualiNum++;
				}
			}
		}
		//计算一天的准确率
		//double oneDayShortQuali=shortQuali/shortQualiNum*100.0;
		double oneDayShortQuali=0;
		if(shortQualiNum!=0){
			oneDayShortQuali=(1-shortQuali/(shortQualiNum*capacity))*100.0;
		}
		System.out.println("准确率： "+oneDayShortQuali);
		//提取数据，如果为空则新增数据
		AccuPassRate apr=accuPassRateMapper.selectByDataTime(dayTemp);
		//赋值并入库
		if(apr==null){
			AccuPassRate aprTemp = new AccuPassRate();
			IdWorker id=new IdWorker();
			aprTemp.setId(id.nextId("15"));
			aprTemp.setAccuRate(oneDayShortQuali);
			try {
				aprTemp.setDataTime(df.parse(dayTemp));
				accuPassRateMapper.insert(aprTemp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(aprTemp.toString());
		}else{
			apr.setAccuRate(oneDayShortQuali);
			accuPassRateMapper.updateAccuRateByDateTime(apr);
			System.out.println(apr.toString());
		}
		
		
		
	}

	public void CalSuperShortAccurRateByOneDay(String day) {

//		//得到开始时间
//		String beginDate=day+" 00:00:00";
//		//得到结束时间
//		String endDate=day+" 23:59:59";
		//日期格式化为字符串
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat hms = new SimpleDateFormat(" HH:mm:ss");
		//得到不同的时间点并拼接字符串
		String dayTemp=day+" 00:00:00";
		
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		String dateStr="";
		int dateStrFlag=0;
		for(int i=0;i<96;i++){
			dateStr+="'"+day+hms.format(new Date(cal.getTimeInMillis()))+"',";
			cal.add(Calendar.MINUTE, 15);
			dateStrFlag=1;
		}
		
		if(dateStrFlag==1){
			dateStr=dateStr.substring(0, dateStr.length()-1);
		}
		
		//得到实际功率
		List<PhotoActData> pADList= photoActDataMapper.selectPhotoActDataByStr(dateStr);
		System.out.println(pADList);
		
		//得到预测功率
		List<SupershortForecHis> sFHList=supershortForecHisMapper.selectSuperShortForecHisByStr(dateStr);
		System.out.println(sFHList);
		
		//得到光伏电站装机总容量
		List<PhotovoltaicBp> pBList=photovoltaicBpMapper.queryAll();
		double capacity=0;
		for(PhotovoltaicBp pb:pBList){
			capacity+=pb.getpCapacity();
		}
		//算出准确率
		//计算各个时刻数据的准确率
		double shortQuali=0;
		double shortQualiNum=0;
		for(PhotoActData pad:pADList){
			for(SupershortForecHis sfh:sFHList){
				if(df.format(pad.getGetTime()).equals(df.format(sfh.getDataTime()))){
					//shortQuali+=1.0-Math.abs(pad.getActPower()-sfh.getShortForec())/capacity;
					shortQuali+=Math.abs(pad.getActPower()-sfh.getShortForec());
					shortQualiNum++;
					System.out.println("有相同的时间");
				}
			}
		}
		System.out.println("开始计算");
		//计算一天的准确率
		double oneDayShortQuali=0;
		if(shortQualiNum!=0){
			oneDayShortQuali=(1-shortQuali/(shortQualiNum*capacity))*100.0;
		}
		System.out.println("准确率： "+oneDayShortQuali);
		//提取数据，如果为空则新增数据
		SuperaccuPassRate apr=superaccuPassRateMapper.selectByDataTime(dayTemp);
		//赋值并入库
		if(apr==null){
			SuperaccuPassRate aprTemp = new SuperaccuPassRate();
			IdWorker id=new IdWorker();
			aprTemp.setId(id.nextId("15"));
			aprTemp.setAccuRate(oneDayShortQuali);
			try {
				aprTemp.setDataTime(df.parse(dayTemp));
				superaccuPassRateMapper.insert(aprTemp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(aprTemp.toString());
		}else{
			apr.setAccuRate(oneDayShortQuali);
			superaccuPassRateMapper.updateSuperAccuRateByDateTime(apr);
			System.out.println(apr.toString());
		}
		
			
	}
	
}
