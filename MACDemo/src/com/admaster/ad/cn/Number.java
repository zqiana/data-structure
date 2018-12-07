package com.admaster.ad.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Number {

	public static void main(String[] args) {
		
		Number number = new Number();
		number.ReadFile("/Users/ZhangQian/Desktop/123.txt");
		
	}
	
	
	
	  public void ReadFile(String filePath){

	        FileInputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	        try {
	            String str = "";
	            fis = new FileInputStream(filePath);
	            // 从文件系统中的某个文件中获取字节
	            isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);
	            while ((str = br.readLine()) != null) {
	                //每次从文件中读取一个电话号码
	            	String  temp = str.split(",")[1];
	            	createFile("/Users/ZhangQian/Desktop/black_number.txt", temp.getBytes());
	            	System.out.println(temp);
	            	
	            }

	        }catch (Exception e){

	        }
	        }
    //将byte数组写入文件
    public void createFile(String path, byte[] content) {

        try{
            FileOutputStream fos = new FileOutputStream(path,true);
            fos.write(content);
            fos.write("\r\n".getBytes());
            fos.close();
        }catch (Exception e){

        }


    }
}
