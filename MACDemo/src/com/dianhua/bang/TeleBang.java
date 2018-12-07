package com.dianhua.bang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.HashSet;

import net.sf.json.JSONObject;

public class TeleBang {
	
	private static int tempCount = 0;
	public static void main(String[] args) {
//		StringBuffer buffer = new StringBuffer();
//		String apikey = "kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k";
//		String imei = "863908026773333";
//		String apiSecret = "d5BaQm0Pi0hK5bgLYyxj2utLGXQb8prcxfYJn97auhorpfdhymvXt2SbUzlk0llrukboftjPm5V3ayq9x3nguwwP0v8Eipsn6TrqqfhqVllgvpWYn9njbYmqgcUfqJcPtAb05sduGz5qggZQa1RphEugceNs6Au7nL4zt";
//		buffer.append(apiSecret.substring(0,27)).insert(6, imei).insert(imei.length() + 13, Util.trimTelNum("18810736678")).insert(imei.length() + 17 + Util.trimTelNum("18810736678").length(), imei).insert(imei.length() * 2 + 21 + Util.trimTelNum("18810736678").length(), "kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k").insert(buffer.toString().length(), Util.trimTelNum("18810736678"));
//	
//		try {
//			String url = "https://apis-android.dianhua.cn/".concat("resolvetel/").concat("?tel=").concat(URLEncoder.encode(Util.trimTelNum("18810736678"), "UTF-8")).concat("&uid=").concat(imei).concat("&apikey=").concat(apikey).concat("&sig=").concat(CipherUtil.bD(buffer.toString()).substring(5, 37)).concat("&v=2").concat("&mcc=").concat("460").concat("&mnc=").concat("0").concat("&lac=").concat("4530").concat("&cid=").concat("20648").concat("&app=").concat("android").concat("&auth_id=").concat("2b5c0c23a3dd0300528f515cd947c56f3b6328b9d8ea21ba6f068349d9c59915").concat("&ver=").concat("2.0-test");
//			
//			System.out.println("URL测试：" + url);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		TeleBang teleBang = new TeleBang();
		teleBang.SaveReadFile("/Users/ZhangQian/Desktop/number_value/black.txt");
		
	
		//示例
	
//		 url : https://apis-android.dianhua.cn/resolvetel/?tel=18600709865&uid=863908026773333&apikey=kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k&sig=aa9043bedfc03119c1b14fd42b7db622&v=2&mcc=-1&mnc=-1&lac=-1&cid=-1&app=android&auth_id=2b5c0c23a3dd0300528f515cd947c56f3b6328b9d8ea21ba6f068349d9c59915&ver=2.0-test&calltype=1
//		 url : https://apis-android.dianhua.cn/resolvetel/?tel=18810736678&uid=863908026773333&apikey=kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k&sig=e335e09af6cbf3fe5c6963336b3efb90&v=2&mcc=-1&mnc=-1&lac=-1&cid=-1&app=android&auth_id=2b5c0c23a3dd0300528f515cd947c56f3b6328b9d8ea21ba6f068349d9c59915&ver=2.0-test&calltype=1
//		 url : https://apis-android.dianhua.cn/resolvetel/?tel=13520774246&uid=863908026773333&apikey=kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k&sig=b5c80b4c6bf65ba8df011530374920d1&v=2&mcc=-1&mnc=-1&lac=-1&cid=-1&app=android&auth_id=2b5c0c23a3dd0300528f515cd947c56f3b6328b9d8ea21ba6f068349d9c59915&ver=2.0-test&calltype=1
//		 url : https://apis-android.dianhua.cn/resolvetel/?tel=15101037307&uid=863908026773333&apikey=kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k&sig=7ad49521f9017f0b2cb319502494ab11&v=2&mcc=-1&mnc=-1&lac=-1&cid=-1&app=android&auth_id=2b5c0c23a3dd0300528f515cd947c56f3b6328b9d8ea21ba6f068349d9c59915&ver=2.0-test&calltype=1

		
		
		
		
	}
	
	
	 public void SaveReadFile(String filePath){
		 
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
//	            	String tempValue  = tempstr[0] + "," + tempstr[2] + "," + tempstr[3] + "," + tempstr[4] +"," +tempstr[5];
	            	System.out.println("个数：" + count +  "内容："+ tempstr[0]);
	            	getJsonHtml("", tempstr[0]);
	            }
	        }catch (Exception e){
	        	
	        	System.out.println("异常信息：" + e.getMessage());
	        }
	        }
	
	 //获取HTML内容
    private String getJsonHtml(String url,String numberValue){
    	
    	JSONObject jsonObject = null;
    	StringBuffer buffer = new StringBuffer();
		String apikey = "kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k";
		String imei = "863908026772222";
		String apiSecret = "d5BaQm0Pi0hK5bgLYyxj2utLGXQb8prcxfYJn97auhorpfdhymvXt2SbUzlk0llrukboftjPm5V3ayq9x3nguwwP0v8Eipsn6TrqqfhqVllgvpWYn9njbYmqgcUfqJcPtAb05sduGz5qggZQa1RphEugceNs6Au7nL4zt";
		buffer.append(apiSecret.substring(0,27)).insert(6, imei).insert(imei.length() + 13, Util.trimTelNum(numberValue)).insert(imei.length() + 17 + Util.trimTelNum(numberValue).length(), imei).insert(imei.length() * 2 + 21 + Util.trimTelNum(numberValue).length(), "kq49MtFgDyNwuWtBxeyQqzfJhqOyW92k").insert(buffer.toString().length(), Util.trimTelNum(numberValue));
    	try {
			String tempurl = "https://apis-android.dianhua.cn/".concat("resolvetel/").concat("?tel=").concat(URLEncoder.encode(Util.trimTelNum(numberValue), "UTF-8")).concat("&uid=").concat(imei).concat("&apikey=").concat(apikey).concat("&sig=").concat(CipherUtil.bD(buffer.toString()).substring(5, 37)).concat("&v=2").concat("&mcc=").concat("460").concat("&mnc=").concat("0").concat("&lac=").concat("4530").concat("&cid=").concat("20648").concat("&app=").concat("android").concat("&auth_id=").concat("2b5c0c23a3dd0300528f515cd947c56f3b6328b9d8ea21ba6f068349d9c59915").concat("&ver=").concat("2.0-test")+ "&calltype=1";

    		 URL url1=new URL(tempurl);
    	        URLConnection connection=url1.openConnection();
    	        InputStream in=connection.getInputStream();
    	        
    	        InputStreamReader isr=new InputStreamReader(in);
    	        BufferedReader br=new BufferedReader(isr);
    	       

    	        String line;
    	        StringBuffer sb=new StringBuffer();
    	        while((line=br.readLine())!=null){
    	            sb.append(line,0,line.length());
    	            sb.append('\n');
    	        }
    	        br.close();
    	        isr.close();
    	        in.close();
    	        
//    	        String temp = sb.toString().split("\\(")[1];
//
//    	        String tempValue = temp.split("\\)")[0].trim();
//    	        System.out.println(sb.toString());
//
//    	     // 将获得的String对象转为JSON格式
    	        jsonObject = JSONObject.fromObject(sb.toString());
    	        String local = jsonObject.get("telloc").toString();
    	        String highrisk = jsonObject.get("highrisk").toString();
    	        String flag = jsonObject.get("flag").toString();
    	        if(flag.length() > 0){
        	        System.out.println("Flag:" + flag);
    	        	tempCount ++;
    	        	JSONObject teJsonObject = JSONObject.fromObject(flag);
    	        	String type = teJsonObject.get("type").toString();
    	        	String num = teJsonObject.get("num").toString();
    	   	        String dataValue = numberValue + "," + local + "," + highrisk +"," + type + "," + num ;

        	        createFile("/Users/ZhangQian/Desktop/numbertest/dianblack.txt", dataValue.toString().getBytes());

    	        }  	        
    	        System.out.println(flag + "黑名单个数第" + tempCount);
    	        return sb.toString();
		} catch (Exception e) {
			String local = jsonObject.get("telloc").toString();
 	        String highrisk = jsonObject.get("highrisk").toString();
			String tempdataValue = numberValue + "," + local + ","+ highrisk ;
			 createFile("/Users/ZhangQian/Desktop/numbertest/dianNormal.txt", tempdataValue.toString().getBytes());
//			if(e.getMessage()==null){
////				String number = jsonObject.get("data").toString();
////    	        String localnum = jsonObject.get("region").toString();
////    	        String tempdataValue = number + "," + localnum ;
////    	        createFile("/Users/ZhangQian/Desktop/numbertest/tengxunNormal.txt", tempdataValue.toString().getBytes());
//				System.out.println("正常请求：："+ "未存在被标识的号码标签，已存入白名单库");
//			}else {
//				System.out.println("异常信息：："+ e.getMessage());
////				createFile("/Users/ZhangQian/Desktop/numbertest/error.txt", numberValue.getBytes());
//			}
//		
		}
		return url;
       
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
