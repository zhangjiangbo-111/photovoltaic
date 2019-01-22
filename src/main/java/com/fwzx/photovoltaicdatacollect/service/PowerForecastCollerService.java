package com.fwzx.photovoltaicdatacollect.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fwzx.photovoltaicdatacollect.dao.CoefficientOfPowerpredictionmodelMapper;
import com.fwzx.photovoltaicdatacollect.dao.ForecastDataHisMapper;
import com.fwzx.photovoltaicdatacollect.dao.ForecastDataRtMapper;
import com.fwzx.photovoltaicdatacollect.dao.PhotoActDataMapper;
import com.fwzx.photovoltaicdatacollect.dao.PhotovoltaicBpMapper;
import com.fwzx.photovoltaicdatacollect.dao.ShortForecHisMapper;
import com.fwzx.photovoltaicdatacollect.dao.SupershortForecHisMapper;
import com.fwzx.photovoltaicdatacollect.pojo.CoefficientOfPowerpredictionmodel;
import com.fwzx.photovoltaicdatacollect.pojo.ForecastDataRt;
import com.fwzx.photovoltaicdatacollect.pojo.PhotoActData;
import com.fwzx.photovoltaicdatacollect.pojo.PhotovoltaicBp;
import com.fwzx.photovoltaicdatacollect.pojo.SupershortForecHis;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

@Service
public class PowerForecastCollerService {
	private static String wenJianQianZhui = "smb://administrator:zyt2304@172.18.33.198/fdfw/ZbgGF/HBCDEG-sun-";
	private static String wenJianHouZhui = "20.txt";
	
	@Autowired
	PhotoActDataMapper photoActDataMapper;

	@Autowired
	ForecastDataRtMapper forecastDataRtMapper;

	@Autowired
	ForecastDataHisMapper forecastDataHisMapper;

	@Autowired
	ShortForecHisMapper shortForecHisMapper;

	@Autowired
	CoefficientOfPowerpredictionmodelMapper coefficientOfPowerpredictionmodelMapper;

	@Autowired
	PhotovoltaicBpMapper photovoltaicBpMapper;
	
	@Autowired
	SupershortForecHisMapper supershortForecHisMapper;
	
	/***
	 * 对数据预报的入库操作 删除旧数据，添加新数据
	 */
	public void insertNumericalPre() {
		// 得到昨天的日期
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		// 数据格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dataTimeFormat = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dataTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		SimpleDateFormat dataTimeFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		String tempFileStr = dateFormat.format(new Date(calendar.getTimeInMillis()));
		String fileStr = wenJianQianZhui + tempFileStr + wenJianHouZhui;
		// 拼接数据字符串
		String dataSql = "";
		try {
			SmbFile smbFile = new SmbFile(fileStr);

			int length = smbFile.getContentLength();
			byte buffer[] = new byte[length];
			SmbFileInputStream in = new SmbFileInputStream(smbFile);
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			int tempNum = 0;

			while ((s = br.readLine()) != null) {
				String[] arr = s.split("\\s+");
				Date date = dataTimeFormat.parse(arr[0]);
				// System.out.println(dataTimeFormat2.format(date) + " " +
				// arr[1] + " " + arr[2] + " " + arr[3] + " "
				// + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " +
				// arr[8]);

				dataSql += "('" + dataTimeFormat2.format(date) + "'," + arr[1] + "," + arr[2] + "," + arr[3] + ","
						+ arr[4] + "," + arr[5] + "," + arr[6] + "," + arr[7] + "," + arr[8] + "),";
				tempNum++;
			}
			dataSql = dataSql.substring(0, dataSql.length() - 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}

		// 删除所有表数据
		forecastDataRtMapper.deleteAllData();

		// 添加新数据
		forecastDataRtMapper.insertDataByStr(dataSql);

	}

	/**
	 * 保存数值预报的历史记录 一般以当天的数值预报的第二天为准
	 */
	public void insertNumericalPreHis() {
		// 得到昨天的日期
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DAY_OF_MONTH, 1);
		// 数据格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dataTimeFormat = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dataTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		SimpleDateFormat dataTimeFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		String tempFileStr = dateFormat.format(new Date(calendar.getTimeInMillis()));
		String fileStr = wenJianQianZhui + tempFileStr + wenJianHouZhui;
		// 删除重复数据所用的字符串
		String saveDataTime = dataTimeFormat3.format(new Date(calendar2.getTimeInMillis()));
		// 拼接数据字符串
		String dataSql = "";
		try {
			SmbFile smbFile = new SmbFile(fileStr);

			int length = smbFile.getContentLength();
			byte buffer[] = new byte[length];
			SmbFileInputStream in = new SmbFileInputStream(smbFile);
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			int tempNum = 0;
			calendar.add(Calendar.DAY_OF_MONTH, 2);
			int flag = 0;
			while ((s = br.readLine()) != null) {
				String[] arr = s.split("\\s+");
				Date date = dataTimeFormat.parse(arr[0]);
				// System.out.println(dataTimeFormat2.format(date) + " " +
				// arr[1] + " " + arr[2] + " " + arr[3] + " "
				// + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " +
				// arr[8]);
				// System.out.println(arr[0].substring(0, 8)+"
				// "+dateFormat.format(new Date(calendar2.getTimeInMillis())));
				if (arr[0].substring(0, 8).equals(dateFormat.format(new Date(calendar2.getTimeInMillis())))) {
					dataSql += "('" + dataTimeFormat2.format(date) + "'," + arr[1] + "," + arr[2] + "," + arr[3] + ","
							+ arr[4] + "," + arr[5] + "," + arr[6] + "," + arr[7] + "," + arr[8] + "),";
					flag = 1;
					tempNum++;
				}

			}
			if (flag == 1) {
				dataSql = dataSql.substring(0, dataSql.length() - 1);
			} else {
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}

		// 如果表中出现重复数据先把重复数据删除
		forecastDataHisMapper.deleteRepeatDataByTime(saveDataTime);

		// 添加新数据
		forecastDataHisMapper.insertDataByStr(dataSql);

	}

	public void insertShortForecastDataHis() {
		// 存放数据的map
		Map<String, Double> dataMap = new LinkedHashMap<String, Double>();
		// 得到系数
		CoefficientOfPowerpredictionmodel cOP = coefficientOfPowerpredictionmodelMapper.getCoefficient();
		// 得到昨天的日期
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		// 得到今天的日期
		Calendar todayCal = Calendar.getInstance();
		// 数据格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dataTimeFormat = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat dataTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		SimpleDateFormat dataTimeFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		String tempFileStr = dateFormat.format(new Date(calendar.getTimeInMillis()));
		String fileStr = wenJianQianZhui + tempFileStr + wenJianHouZhui;
		// 删除重复数据所用的字符串
		String saveDataTime = dataTimeFormat3.format(new Date(todayCal.getTimeInMillis()));
		// 拼接数据字符串
		String dataSql = "";
		try {
			SmbFile smbFile = new SmbFile(fileStr);

			int length = smbFile.getContentLength();
			byte buffer[] = new byte[length];
			SmbFileInputStream in = new SmbFileInputStream(smbFile);
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);
			String s = null;
			calendar.add(Calendar.DAY_OF_MONTH, 2);
			int flag = 0;
			while ((s = br.readLine()) != null) {
				String[] arr = s.split("\\s+");
				Date date = dataTimeFormat.parse(arr[0]);
				// System.out.println(dataTimeFormat2.format(date) + " " +
				// arr[1] + " " + arr[2] + " " + arr[3] + " "
				// + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " +
				// arr[8]);
				// System.out.println(arr[0].substring(0, 8)+"
				// "+dateFormat.format(new Date(calendar2.getTimeInMillis())));
				if (arr[0].substring(0, 8).equals(dateFormat.format(new Date(todayCal.getTimeInMillis())))) {
					dataMap.put(dataTimeFormat2.format(date),
							Double.parseDouble(arr[1]) * Double.parseDouble(arr[1]) * cOP.getCoefficientOne()
									+ Double.parseDouble(arr[1]) * Double.parseDouble(arr[6]) * cOP.getCoefficientTwo()
									+ Double.parseDouble(arr[1]) * cOP.getCoefficientThree());
					// dataSql += "('" + dataTimeFormat2.format(date) + "'," +
					// arr[1] + "," + arr[2] + "," + arr[3] + ","
					// + arr[4] + "," + arr[5] + "," + arr[6] + "," + arr[7] +
					// "," + arr[8] + "),";

				}

			}

			for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
				dataSql += "('" + entry.getKey() + "'," + entry.getValue() + "),";
				flag = 1;
			}
			// 去除多余的逗号
			if (flag == 1) {
				dataSql = dataSql.substring(0, dataSql.length() - 1);
			} else {
				return;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
		System.out.println("123");
		System.out.println(dataSql);
		// 删除重复数据
		shortForecHisMapper.deleteRepeatDataByTime(saveDataTime);
		// 插入最新数据
		shortForecHisMapper.insertDataByStr(dataSql);
	}

	public void insertSuperShortForecastDataHis() {
		// 约定订正小时
		int revisionHour = 6;
		// 约定订正分钟
		int revisionMin = 45;
		// 功率预报存放的map
		Map<String, Double> dataMap = new LinkedHashMap<String, Double>();
		// 格式化日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		// 得到系数参数
		CoefficientOfPowerpredictionmodel cOP = coefficientOfPowerpredictionmodelMapper.getCoefficient();

		// 得到现在的时间
		Calendar calendar = Calendar.getInstance();
		int flag = 0;
		if (calendar.get(Calendar.HOUR_OF_DAY) == revisionHour) {
			if (calendar.get(Calendar.MINUTE) >= revisionMin) {
				flag = 1;
			}
		}
		if (calendar.get(Calendar.HOUR_OF_DAY) > revisionHour) {
			flag = 1;
		}

		// 得到预报开始时间和结束时间
		String beginDate = df.format(new Date(calendar.getTimeInMillis()));
		calendar.add(Calendar.HOUR_OF_DAY, 4);
		if (calendar.get(Calendar.MINUTE) % 15 != 0) {
			calendar.add(Calendar.MINUTE, 14);
		}
		String endDate = df.format(new Date(calendar.getTimeInMillis()));
		beginDate=endDate;
		// 得到今日的所有辐照度信息
		List<PhotoActData> pAD = photoActDataMapper.selectPhotoActDataByTime(
				"'" + df2.format(new Date(calendar.getTimeInMillis())) + " 00:00:00'",
				"'" + df2.format(new Date(calendar.getTimeInMillis())) + " 23:59:59'");

		// 得到数据预报指定期间的数据
		List<ForecastDataRt> fCDAll = forecastDataRtMapper.selectForecastDataRtByTime(
				"'" + df2.format(new Date(calendar.getTimeInMillis())) + " 00:00:00'",
				"'" + df2.format(new Date(calendar.getTimeInMillis())) + " 23:59:59'");

		if (flag == 0) {

			// 得到数据预报指定期间的数据
			List<ForecastDataRt> fCD = forecastDataRtMapper.selectForecastDataRtByTime("'" + beginDate + "'",
					"'" + endDate + "'");

			for (ForecastDataRt fr : fCD) {
				dataMap.put(df.format(fr.getDataTime()),
						fr.getTotalRadiation() * fr.getTotalRadiation() * cOP.getCoefficientOne()
								+ fr.getTotalRadiation() * fr.getTem() * cOP.getCoefficientTwo()
								+ fr.getTotalRadiation() * cOP.getCoefficientThree());
			}

			// 数据筛选，因正北沟数据有问题所以先注释掉
			// 筛选低于0的数据,找出预报功率的最大值
			double yuBaoGongLvZuiDaZhi = 0;
			for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
				// System.out.println("Key = " + entry.getKey() + ", Value = " +
				// entry.getValue());
				if (entry.getValue() < 0) {
					dataMap.put(entry.getKey(), 0d);
				}
				if (yuBaoGongLvZuiDaZhi < entry.getValue()) {
					yuBaoGongLvZuiDaZhi = entry.getValue();
				}
			}
			// 得到额定发电功率
			List<PhotovoltaicBp> pbAll = photovoltaicBpMapper.queryAll();
			double eDingFaDianGongLv = 0;
			for (PhotovoltaicBp pbp : pbAll) {
				eDingFaDianGongLv += pbp.getpCapacity();
			}
			if (eDingFaDianGongLv < yuBaoGongLvZuiDaZhi) {
				double tempBiLi = eDingFaDianGongLv / yuBaoGongLvZuiDaZhi;
				for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
					// System.out.println("Key = " + entry.getKey() + ", Value =
					// " +
					// entry.getValue());
					dataMap.put(entry.getKey(), entry.getValue() * tempBiLi);
				}

			}
		} else {
			// 得到数据预报指定期间的数据
			List<ForecastDataRt> fCD = forecastDataRtMapper.selectForecastDataRtByTime("'" + beginDate + "'",
					"'" + endDate + "'");
			// 用来订正的预报数据
			List<ForecastDataRt> fCDTemp = forecastDataRtMapper.selectForecastDataRtByTime(
					"'" + df2.format(new Date(calendar.getTimeInMillis())) + " 00:00:00'",
					"'" + df2.format(new Date(calendar.getTimeInMillis())) + " 23:59:59'");

			// 存放误差总和
			double wuCha = 0;
			double wuChaNum = 0;
			int wuChaFlag = 0;
			for (PhotoActData pad : pAD) {
				for (ForecastDataRt fcd : fCDTemp) {
					if (pad.getGetTime().equals(fcd.getDataTime())) {
						wuChaNum++;
						wuCha += pad.getInstRadiation() - fcd.getTotalRadiation();
						wuChaFlag = 1;
					}
				}
			}
			if (wuChaFlag == 1) {
				double wuChaAvg = wuCha / wuChaNum;
				System.out.println("wuChaAvg:" + wuChaAvg);
				// 遍历时间段内的数值预报加上均值
				for (ForecastDataRt fdr : fCD) {
					if (fdr.getTotalRadiation() != 0) {
						fdr.setTotalRadiation(fdr.getTotalRadiation() + wuChaAvg);
					}
				}
			}

			// 计算预报功率
			for (ForecastDataRt fr : fCD) {
				dataMap.put(df.format(fr.getDataTime()),
						fr.getTotalRadiation() * fr.getTotalRadiation() * cOP.getCoefficientOne()
								+ fr.getTotalRadiation() * fr.getTem() * cOP.getCoefficientTwo()
								+ fr.getTotalRadiation() * cOP.getCoefficientThree());
			}

			// 数据筛选，因正北沟数据有问题所以先注释掉
			// 筛选低于0的数据,找出预报功率的最大值
			double yuBaoGongLvZuiDaZhi = 0;
			for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
				// System.out.println("Key = " + entry.getKey() + ", Value = " +
				// entry.getValue());
				if (entry.getValue() < 0) {
					dataMap.put(entry.getKey(), 0d);
				}
				if (yuBaoGongLvZuiDaZhi < entry.getValue()) {
					yuBaoGongLvZuiDaZhi = entry.getValue();
				}
			}
			// 得到额定发电功率
			List<PhotovoltaicBp> pbAll = photovoltaicBpMapper.queryAll();
			double eDingFaDianGongLv = 0;
			for (PhotovoltaicBp pbp : pbAll) {
				eDingFaDianGongLv += pbp.getpCapacity();
			}
			if (eDingFaDianGongLv < yuBaoGongLvZuiDaZhi) {
				double tempBiLi = eDingFaDianGongLv / yuBaoGongLvZuiDaZhi;
				for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
					// System.out.println("Key = " + entry.getKey() + ", Value =
					// " +
					// entry.getValue());
					dataMap.put(entry.getKey(), entry.getValue() * tempBiLi);
				}

			}

		}		
		try {
			SupershortForecHis sFH=new SupershortForecHis();
			for (Map.Entry<String, Double> entry : dataMap.entrySet()) { 
				  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
				  sFH.setDataTime(df.parse(entry.getKey()));
				  sFH.setShortForec(entry.getValue());
				  supershortForecHisMapper.insert(sFH);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
