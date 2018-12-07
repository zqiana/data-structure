package com.admaster.ad.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class DataDecode {
	//城市等级划分
	private static HashSet<String> first_City = new HashSet<>();
	private static HashSet<String> second_City = new HashSet<>();
	private static HashSet<String> three_City = new HashSet<>();
	private static HashSet<String> four_City = new HashSet<>();
	//城市区域代码
	private static HashMap<String, String> hashMap = new HashMap<>();

	
	public static void main(String[] args) {
		DataDecode dataDecode = new DataDecode();
		//城市等级
		dataDecode.SaveReadFile("/Users/ZhangQian/Desktop/number_value/city_grade1.txt", first_City);
		dataDecode.SaveReadFile("/Users/ZhangQian/Desktop/number_value/city_grade2.txt", second_City);
		dataDecode.SaveReadFile("/Users/ZhangQian/Desktop/number_value/city_grade3.txt", three_City);
		dataDecode.SaveReadFile("/Users/ZhangQian/Desktop/number_value/city_grade4.txt", four_City);
		//城市区域代码
		dataDecode.CityReadFile("/Users/ZhangQian/Desktop/number_value/localid.txt", hashMap);
		

		
	}
	
	
	 public void SaveReadFile(String filePath ,HashSet<String> hashset){
		 
	        FileInputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	        try {
	            String str = "";
	            int count = 0;
	            fis = new FileInputStream(filePath);
	            // 从文件系统中的某个文件中获取字节
	            isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);
	            while (((str = br.readLine()) != null)) {
	            	count ++;
	                //每次从文件中读取一个电话
	            	String  tempstr = str.trim();
	            	System.out.println("个数：" + count +  "内容："+ str);            		            	
	            	hashset.add(tempstr); 	
	            }
	        }catch (Exception e){
	        	System.out.println("异常信息：" + e.getMessage());
	        }
	        }
	 
	 public void CityReadFile(String filePath ,HashMap<String, String> hashMap){
		 
	        FileInputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	        try {
	            String str = "";
	            int count = 0;
	            fis = new FileInputStream(filePath);
	            // 从文件系统中的某个文件中获取字节
	            isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);
	            while (((str = br.readLine()) != null)) {
	            	count ++;
	                //每次从文件中读取一个电话
	            	String  tempstr = str.trim();
	            	String[] tString = tempstr.split(",");
	            	hashMap.put(tString[2], tempstr);
	            	System.out.println("个数：" + count +  "内容："+ str);            		            	
	            }
	        }catch (Exception e){
	        	System.out.println("异常信息：" + e.getMessage());
	        }
	        }

}
