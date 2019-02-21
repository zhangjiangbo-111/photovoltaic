package com.fwzx.photovoltaicdatacollect.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: 文件操作工具类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author nst
 * @date 2017-4-10 上午9:59:06
 */
public class FileUtils {

	/**
	 * 新建文件.
	 * 
	 * @param f
	 *            文件
	 * @throws IOException
	 * 
	 */
	public static void createFile(File f) throws IOException {
		if (f.exists()) {
			return;
		}
		// 如果路径不存在,则创建
		if (!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		f.createNewFile();
	}

	/**
	 * 删除空目录
	 * 
	 * @param dir
	 *            将要删除的目录路径
	 */
	public static void doDeleteEmptyDir(String dir) {
		boolean success = (new File(dir)).delete();
		if (success) {
			System.out.println("Successfully deleted empty directory: " + dir);
		} else {
			System.out.println("Failed to delete empty directory: " + dir);
		}
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 *            将要删除的文件目录
	 * @return boolean Returns "true" if all deletions were successful. If a
	 *         deletion fails, the method stops attempting to delete and returns
	 *         "false".
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	/**
	 * 得到目录中的文件
	 * 
	 * @return 文件
	 */
	public File getData(String oldPath) {
		// String oldPath = "V://swanproducts/LOCAL/swan/warning";
		File file = new File(oldPath);
		return file;
	}

	/**
	 * 将两次扫描的文件，去重，得到新添加的文件集合
	 * 
	 * @param oldFile
	 *            旧文件
	 * @param newFile
	 *            新文件
	 * @return 新文件集合
	 */
	public static List<File> getNewFile(File[] oldFile, File[] newFile) {
		// System.out.println("jinru");
		List<File> listOld = new ArrayList<File>();
		List<File> listNew = new ArrayList<File>();
		if (oldFile != null) {
			for (File f : oldFile) {
				listOld.add(f);
			}
		}
		if (newFile != null) {
			for (File f : newFile) {
				listNew.add(f);
			}
		}
		// System.out.println(listOld.size() + "---" + listNew.size());
		listNew.removeAll(listOld);
		// System.out.println("新的文件个数："+listNew.size());
		return listNew;
	}

	/**
	 * 将新增的文件复制出来
	 * 
	 * @param list
	 *            文件集合
	 * @param newPath
	 *            要复制出来的临时地址
	 * @throws IOException
	 */
	public void copyFile(List<File> list, String newPath) throws IOException {
		FileInputStream input = null;
		FileOutputStream output = null;
		File file1;
		for (File file : list) {
			try {
				input = new FileInputStream(file);
				file1 = new File(newPath + "/" + file.getName());
				if (!file1.exists()) {
					createFile(file1);
				}
				output = new FileOutputStream(file1);
				byte[] b = new byte[1024];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
					output.flush();
				}
			} finally {
				if (output != null) {
					output.close();
				}
				if (input != null) {
					input.close();
				}
			}
		}
	}

}
