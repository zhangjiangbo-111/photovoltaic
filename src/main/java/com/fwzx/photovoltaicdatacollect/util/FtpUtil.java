package com.fwzx.photovoltaicdatacollect.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.SocketException;

/**
 * FTP使用工具
 * <p>
 * Title: FtpUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @author nst
 * @date 2017-4-14 上午10:04:07
 */
public class FtpUtil {

	private Logger logger = Logger.getLogger(FtpUtil.class);

	public FTPClient ftp;
	// private String LOCAL_CHARSET = "GBK";

	/**
	 * 获取ftp连接
	 *
	 * @param f
	 * @return
	 * @throws IOException
	 * @throws SocketException
	 * @throws Exception
	 */
	public boolean connectFtp(Ftp f) throws IOException {
		ftp = new FTPClient();
		boolean flag = false;
		int reply;
		if (f.getPort() == null) {
			ftp.connect(f.getIpAddr(), 21);
		} else {
			ftp.connect(f.getIpAddr(), f.getPort());
		}
		ftp.login(f.getUserName(), f.getPwd());
		ftp.setControlEncoding("GBK");
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return flag;
		}
//        if (FTPReply.isPositiveCompletion(ftp.sendCommand(
//                "OPTS UTF8", "ON"))) {// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
//            LOCAL_CHARSET = "UTF-8";
//        }
		// ftp.setControlEncoding(LOCAL_CHARSET);
		//  ftp.enterLocalPassiveMode();
		boolean b = ftp.changeWorkingDirectory(f.getPath());
		// System.out.println(b);
		if (!b) {
			//FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			// conf.setServerLanguageCode("zh");
			boolean b3 = ftp.changeWorkingDirectory(File.separator + f.getUserName() +
					f.getPath());
			if (!b3) {
				boolean b1 = ftp.changeWorkingDirectory(new String(f.getPath().getBytes("gbk"), "iso-8859-1"));
				if (!b1) {
					ftp.changeWorkingDirectory(new String((File.separator + f.getUserName() +
							f.getPath()).getBytes("gbk"), "iso-8859-1"));
				}
			}
		}
		// }
		// System.out.println("ssss"+changeWorkingDirectory);
		// 设置传输超时时间15分钟
		ftp.setDataTimeout(10 * 60 * 1000);
		ftp.setDefaultTimeout(10 * 60 * 1000);
		ftp.setSoTimeout(10 * 60 * 1000);
		//超时时间
		int defaultTimeoutSecond = 10 * 60 * 1000;
		ftp.setConnectTimeout(defaultTimeoutSecond);

		flag = true;
		return flag;
	}

	/**
	 * 关闭ftp连接
	 */
	public void closeFtp() {
		if (ftp != null && ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ftp上传文件
	 *
	 * @param f
	 * @throws IOException
	 * @throws Exception
	 */
	public void upload(File f) throws IOException {
		DemaonThread demaonThread = new DemaonThread(ftp);
//		demaonThread.setDaemon(true);
		demaonThread.start();

		boolean storeFile = false;
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		if (f.isDirectory()) {
			ftp.makeDirectory(f.getName());
			boolean b = ftp.changeWorkingDirectory(f.getName());
			if (!b) {
				ftp.changeWorkingDirectory(new String(f.getName().getBytes("gbk"), "iso-8859-1"));
			}
			String[] files = f.list();
			// 设置上传文件缓存区为5M
			ftp.setBufferSize(1024 * 1024 * 5);
			for (String fstr : files) {
				File file1 = new File(f.getPath() + "/" + fstr);
				if (file1.isDirectory()) {
					upload(file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(f.getPath() + "/" + fstr);
					FileInputStream input = new FileInputStream(file2);
					BufferedInputStream bis = new BufferedInputStream(input);
					ftp.enterLocalPassiveMode();
					storeFile = ftp.storeFile(new String(file2.getName().getBytes("gbk"), "iso-8859-1"), bis);
					input.close();
					bis.close();
				}
			}
		} else {
			File file2 = new File(f.getPath());
			FileInputStream input = new FileInputStream(file2);
			BufferedInputStream bis = new BufferedInputStream(input);
			ftp.setBufferSize(1024 * 1024 * 5);
			ftp.enterLocalPassiveMode();
			storeFile = ftp.storeFile(new String(file2.getName().getBytes("gbk"), "iso-8859-1"), bis);
			input.close();
			bis.close();
		}
		if (!storeFile) {
			throw new RuntimeException("未上传成功");
		}
	}

	/**
	 * 下载链接配置
	 *
	 * @param f
	 * @param localBaseDir  本地目录
	 * @param remoteBaseDir 远程目录
	 * @throws IOException
	 * @throws SocketException
	 * @throws Exception
	 */
	public void startDown(Ftp f, String localBaseDir, String remoteBaseDir) throws IOException {
		if (connectFtp(f)) {
			try {
				FTPFile[] files = null;
				boolean changedir = ftp.changeWorkingDirectory(remoteBaseDir);
				if (changedir) {
					ftp.setControlEncoding("GBK");
					files = ftp.listFiles();
					for (int i = 0; i < files.length; i++) {
						try {
							if (files[i].isFile()) {
								downloadFile(files[i], localBaseDir);
							} else {
								downloadFileOrDirectory(files[i], localBaseDir, remoteBaseDir);
							}
						} catch (Exception e) {
							logger.error(e.getMessage());
							logger.error("<" + files[i].getName() + ">下载失败");
						}
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
				logger.error("下载过程中出现异常");
			}
		} else {
			logger.error("链接失败！");
		}

	}

	/**
	 * 下载FTP文件 当你需要下载FTP文件的时候，调用此方法 根据<b>获取的文件名，本地地址，远程地址</b>进行下载
	 *
	 * @param ftpFile
	 * @param relativeLocalPath
	 */
	public void downloadFile(FTPFile ftpFile, String relativeLocalPath) {
		if (ftpFile.isFile()) {
			if (ftpFile.getName().indexOf("?") == -1) {
				BufferedOutputStream outputStream = null;
				try {
					// File locaFile = new File(relativeLocalPath +
					// ftpFile.getName());
					// 判断文件是否存在，存在则返回
					// if (locaFile.exists()) {
					// return;
					// } else {
					outputStream = new BufferedOutputStream(
							new FileOutputStream(relativeLocalPath + ftpFile.getName()));
					ftp.retrieveFile(ftpFile.getName(), outputStream);
					outputStream.flush();
					outputStream.close();
					// }
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.getMessage());
				} finally {
					try {
						if (outputStream != null) {
							outputStream.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
						logger.error("输出文件流异常");
					}
				}
			}
		}
	}

	/**
	 * 下载FTP文件 当你需要下载FTP文件的时候，调用此方法 根据<b>获取的文件名，本地地址，远程地址</b>进行下载
	 *
	 * @param ftpFile
	 * @param relativeLocalPath
	 * @param relativeRemotePath
	 */
	public void downloadFileOrDirectory(FTPFile ftpFile, String relativeLocalPath, String relativeRemotePath) {
		if (ftpFile.isFile()) {
			if (ftpFile.getName().indexOf("?") == -1) {
				BufferedOutputStream outputStream = null;
				try {
					// File locaFile = new File(relativeLocalPath +
					// ftpFile.getName());
					// 判断文件是否存在，存在则返回
					// if (locaFile.exists()) {
					// return;
					// } else {
					outputStream = new BufferedOutputStream(
							new FileOutputStream(relativeLocalPath + ftpFile.getName()));
					ftp.retrieveFile(ftpFile.getName(), outputStream);
					outputStream.flush();
					outputStream.close();
					// }
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.getMessage());
				} finally {
					try {
						if (outputStream != null) {
							outputStream.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
						logger.error("输出文件流异常");
					}
				}
			}
		} else {
			// + ftpFile.getName()
			String newlocalRelatePath = relativeLocalPath;
			String newRemote = new String(relativeRemotePath + ftpFile.getName().toString());
			File fl = new File(newlocalRelatePath);
			if (!fl.exists()) {
				fl.mkdirs();
			}
			try {
				newlocalRelatePath = newlocalRelatePath + '/';
				newRemote = newRemote + "/";
				String currentWorkDir = ftpFile.getName().toString();
				boolean changedir = ftp.changeWorkingDirectory(currentWorkDir);
				if (changedir) {
					FTPFile[] files = null;
					files = ftp.listFiles();
					for (int i = 0; i < files.length; i++) {
						downloadFileOrDirectory(files[i], newlocalRelatePath, newRemote);
					}
				}
				if (changedir) {
					ftp.changeToParentDirectory();
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * 监控ftpclient超时守护线程
	 */
	private class DemaonThread extends Thread {
		private FTPClient ftpClient;
		int num = 0;

		public DemaonThread(FTPClient ftpClient2) {
			this.ftpClient = ftpClient2;
		}

		@Override
		public void run() {
			while (num < 10 * 60 && ftpClient.isConnected()) {
				try {
					Thread.sleep(1000);//2 * 60 *
					num++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				if (ftpClient != null && ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}


}
