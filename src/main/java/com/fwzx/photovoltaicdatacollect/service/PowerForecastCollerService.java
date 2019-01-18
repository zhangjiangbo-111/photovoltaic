package com.fwzx.photovoltaicdatacollect.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwzx.photovoltaicdatacollect.dao.ForecastDataHisMapper;
import com.fwzx.photovoltaicdatacollect.dao.ForecastDataRtMapper;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

@Service
public class PowerForecastCollerService {
	private static String wenJianQianZhui = "smb://administrator:zyt2304@172.18.33.198/fdfw/ZbgGF/HBCDEG-sun-";
	private static String wenJianHouZhui = "20.txt";

	@Autowired
	ForecastDataRtMapper forecastDataRtMapper;
	
	@Autowired
	ForecastDataHisMapper forecastDataHisMapper;

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
		//删除重复数据所用的字符串
		String saveDataTime=dataTimeFormat3.format(new Date(calendar2.getTimeInMillis()));
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
			int flag=0;
			while ((s = br.readLine()) != null) {
				String[] arr = s.split("\\s+");
				Date date = dataTimeFormat.parse(arr[0]);
				// System.out.println(dataTimeFormat2.format(date) + " " +
				// arr[1] + " " + arr[2] + " " + arr[3] + " "
				// + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " +
				// arr[8]);
				//System.out.println(arr[0].substring(0, 8)+" "+dateFormat.format(new Date(calendar2.getTimeInMillis())));
				if(arr[0].substring(0, 8).equals(dateFormat.format(new Date(calendar2.getTimeInMillis())))){
					dataSql += "('" + dataTimeFormat2.format(date) + "'," + arr[1] + "," + arr[2] + "," + arr[3] + ","
							+ arr[4] + "," + arr[5] + "," + arr[6] + "," + arr[7] + "," + arr[8] + "),";
					flag=1;
					tempNum++;
				}
				
			}
			if(flag==1){
				dataSql = dataSql.substring(0, dataSql.length() - 1);
			}else{
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

}
