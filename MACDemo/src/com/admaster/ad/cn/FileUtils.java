package com.admaster.ad.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class FileUtils {
	
	public static void main(String[] args) {
		
		HashSet<String> hashSet = new HashSet<String>();
		FileUtils fileUtils = new FileUtils();
		
		fileUtils.DataMerge("/Users/ZhangQian/Desktop/number/black_number_value.txt");
//		String number = fileUtils.QueryNumber("19998666863", hashSet);
//		System.out.println(number);
//		String number1 = fileUtils.QueryNumber("19999318055", hashSet);
//		System.out.println(number1);
//		String number2 = fileUtils.QueryNumber("13309909829", hashSet);
//		System.out.println(number2);

	}
	
	public String QueryNumber(String number,HashSet<String> hashSet){
		
		if(hashSet.contains(number)){
			return number;
		}else {
			return "无此号码";
		}
	}
	
	
	 public void DataMerge(String filePath){

	        FileInputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	        try {
	            String str = "";
	            fis = new FileInputStream(filePath);
	            // 从文件系统中的某个文件中获取字节
	            isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);
	       	    String HTML;
	       	    
	            while ((str = br.readLine()) != null) {
	             String temp = str.split(":")[0];
	             System.out.println(temp);
	             createFile("/Users/ZhangQian/Desktop/number_value/Number.txt", temp.getBytes());
         	
	            }
	        }catch (Exception e){

	        }
	        }
	    
	
	 public void ReadFile(String filePath,String number_type){
		 
	        FileInputStream fis = null;
	        FileInputStream typeis = null;
	        InputStreamReader isr = null;
	        InputStreamReader typeisr = null;
	        BufferedReader br = null;
	        BufferedReader typeiser = null;
	        
	        try {
	            String str = "";
	            String str1 = "";
	            fis = new FileInputStream(filePath);
	            // 从文件系统中的某个文件中获取字节
	            isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);
	            
	            typeis = new FileInputStream(number_type);
	            typeisr  = new InputStreamReader(typeis);
	            typeiser = new BufferedReader(typeisr);
	            
	            while (((str = br.readLine()) != null) && ((str1 = typeiser.readLine()) != null)) {
	                //每次从文件中读取一个电话号码
	            	String[]  tempstr = str.split(":");
//	            	String  tempstr1 = str.split(":")[1];
	            	String  temp = str1.split(":")[1];
	            	String temp_value = tempstr[0].trim() +","+tempstr[1].trim() +","+ temp.trim() +","+ tempstr[2].trim() +","+tempstr[3].trim() ;
	            	System.out.println(temp_value);
	            	createFile("/Users/ZhangQian/Desktop/black_number_value.txt", temp_value.getBytes());
	            }
	        }catch (Exception e){
	        }
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
	            	String [] tempstr = str.split(",");
	            	String tempValue  = tempstr[0] + "," + tempstr[2] + "," + tempstr[3] + "," + tempstr[4] +"," +tempstr[5];
	            	System.out.println("个数：" + count +  "内容："+ str);

	            	createFile("/Users/ZhangQian/Desktop/number_value/black_new.txt", tempValue.getBytes());

//	            	if(tempstr[4] != null){
//	            	}
//	            	String templocal = tempstr[1].replace("-", ",").replace("移动", "中国移动");
//	            	String temp = tempstr[0] + "," + templocal;
//	            	
//	            	String [] dataStr = temp.split(",");
//	            	String tempValue = dataStr[0] + "," + dataStr[1] + "," + dataStr[3];

//	            	createFile("/Users/ZhangQian/Desktop/blacklist/130.txt", str.getBytes());
	            }
	        }catch (Exception e){
	        	
	        	System.out.println("异常信息：" + e.getMessage());
	        }
	        }
	 
	 public void ReadFile(String filePath){	
		 
	        FileInputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
	        int count = 0;
	        try {
	            String str = "";
	            fis = new FileInputStream(filePath);
	            // 从文件系统中的某个文件中获取字节
	            isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);	            
	            while (((str = br.readLine()) != null)) {
	            	count ++;
	                //每次从文件中读取一个电话号码
	            	System.out.println(str + "第多少个:"+ count);
	            	if( count > 0 && (count <= 10000)){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_00.txt", str.getBytes());
	            	}else if(count>10000 && count <= 20000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_11.txt", str.getBytes());
	            	}
	            	else if(count>20000 && count <= 30000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_22.txt", str.getBytes());
	            	}
	            	else if(count>30000 && count <= 40000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_33.txt", str.getBytes());

	            	}else if(count>40000 && count <= 50000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_44.txt", str.getBytes());

	            	}else if(count>50000 && count <= 60000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_55.txt", str.getBytes());
	            	}
	            	else if(count>60000 && count <= 70000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_66.txt", str.getBytes());

	            	}else if(count>70000 && count <= 80000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_77.txt", str.getBytes());

	            	}else if(count>80000 && count <= 90000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_88.txt", str.getBytes());

	            	}else if(count>90000 && count <= 100000){
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_99.txt", str.getBytes());
	            	}
	            	else {
		            	createFile("/Users/ZhangQian/Desktop/number_value/black_number_51.txt", str.getBytes());
					}
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
    
    private void createFileString(String path,byte[] content){
    	
    	try {
    		
    		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}
