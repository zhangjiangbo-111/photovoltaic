package com.fwzx.photovoltaicdatacollect.data;

import com.fwzx.photovoltaicdatacollect.dao.PowerDuanqiMapper;
import com.fwzx.photovoltaicdatacollect.pojo.PowerDuanqi;
import com.fwzx.photovoltaicdatacollect.util.FileUtils;
import com.fwzx.photovoltaicdatacollect.util.Ftp;
import com.fwzx.photovoltaicdatacollect.util.FtpUtil;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 牛松涛
 * @version 1.0
 * @Description: 短期预报入库
 * @Date 2019/2/21 15:57
 */
@Component
public class PowerDuanQi {

	@Autowired
	private PowerDuanqiMapper mapper;

	@Scheduled(cron = "0 20 8 * * ?")
	public void run() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String ftpAddress = "10.48.17.98";
		String ftpPath = "/glyc/duanqi/";
		Integer ftpPort = 21;
		String ftpPwd = "test@2018";
		String ftpUsername = "test";
		String localpath = "d://powerduanqi/";
		File file = new File(localpath);
		if (!file.exists()) {
			file.mkdirs();
		} else {
			try {
				FileUtils.deleteDir(file);
				file.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		FtpUtil ftpUtil = null;
		try {
			ftpUtil = new FtpUtil();
			Ftp f = new Ftp();
			f.setIpAddr(ftpAddress);
			f.setPort(ftpPort);
			f.setUserName(ftpUsername);
			f.setPwd(ftpPwd);
			f.setPath(ftpPath);
			ftpUtil.connectFtp(f);
			ftpUtil.ftp.enterLocalPassiveMode();
			ftpUtil.ftp.setControlEncoding("GBK");
			FTPFile[] listFiles;
			listFiles = ftpUtil.ftp.listFiles();
			for (FTPFile ftpFile : listFiles) {
				ftpUtil.downloadFile(ftpFile, localpath);

			}
			File[] files = file.listFiles();
			BufferedReader br = null;
			for (File file1 : files) {
				br = new BufferedReader(new FileReader(file1));
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] split = line.split(",");
					PowerDuanqi duanqi = new PowerDuanqi();
					duanqi.setStaname(split[0]);
					duanqi.setDatetime(format.parse(split[1]));
					duanqi.setShici(Integer.parseInt(split[2]));
					duanqi.setTem(Double.parseDouble(split[3]));
					duanqi.setHumi(Double.parseDouble(split[4]));
					duanqi.setWinds(Double.parseDouble(split[5]));
					duanqi.setWindd(Double.parseDouble(split[6]));
					duanqi.setPre(Double.parseDouble(split[7]));
					if (split[8] != " ") {
						duanqi.setWea(split[8]);
					}
					duanqi.setThour(split[9]);
					mapper.insertSelective(duanqi);
				}

				ftpUtil.ftp.deleteFile(file1.getName());
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
