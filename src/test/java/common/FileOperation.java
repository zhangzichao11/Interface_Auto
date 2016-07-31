package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;

public class FileOperation {
	/**
	 * 创建文件
	 * 
	 * @param fileName
	 * @return flag
	 * @throws Exception
	 */
	public boolean createFile(File fileName) throws Exception {

		boolean flag = false;
		try {

			if (!fileName.exists()) {
				fileName.createNewFile();
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 读txt文件内容
	 * 
	 * @param fileName
	 * @return result
	 * @throws IOException
	 */
	public static String readTxtFile(File fileName) throws IOException {

		String result = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {

			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String read = null;
			try {

				while ((read = bufferedReader.readLine()) != null) {
					result = result + read + "\r\n";
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (bufferedReader != null) {

				bufferedReader.close();
			}

			if (fileReader != null) {

				fileReader.close();
			}
		}
		return result;
	}
	
	/**
	 * 写txt文件
	 * @param content
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public boolean writeTxtFile(String content, File fileName)
			throws Exception {
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("UTF-8"));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
		return flag;
	}
	
	/**
	 * 写txt文件,在原来的基础上增加文件
	 * @param filePath
	 * @param content
	 */
	public static void contentToTxt(String filePath, String content) {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		try {
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
			System.out.println(s1);
			input.close();
			s1 += content;

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	/**
	 * 获取绝对路径(工程根目录)
	 * 
	 * @param filepath
	 * @return
	 */
	@SuppressWarnings("static-access")
	public String getPath() throws Exception {
		
		String ph=FileOperation.class.getClassLoader().getParent().getSystemResource("").toString();
	//	System.out.println(path);
		URL absolutePath=new URL(ph);
		String parseUrl = new URL(absolutePath ,"../../.").toString(); //向上获取两级目录
		String path = parseUrl.replace("file:/", "").replace("bin/", "");//去掉开头和结尾
		if (!System.getProperty("os.name").toLowerCase().contains("windows")){
			path ="/"+path;
		}
		return path;
	}

}
