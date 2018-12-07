package com.jd.dx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import net.sf.json.JSONObject;

public class DingX {
	
	private static int tempCount = 0;
	
	
	public static void main(String[] args) {
		
		String Url = "https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce=1539674890626&is=460001041658238&model=HUAWEI+G750-T01&op=46000&signmd5=608291140&vendor=HUAWEI&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.14.0&h=1280&w=720&v=4001&ntt=WIFI&ie=863908026773333&lc=Ee8zFuXg48bpN86E&dpi=320&sdk=19&checkStr=101ea4b430d7675ff3b152f0115901ec&s=e0e17bebf3440fa7652632c94d50e605";
		DingX dingX = new DingX();
//		dingX.SaveReadFile("/Users/ZhangQian/Desktop/numbertest/dingxiang.txt");
		dingX.getJsonHtml("123", "123");
		
		
		
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
//            	String tempValue  = tempstr[0] + "," + tempstr[2] + "," + tempstr[3] + "," + tempstr[4] +"," +tempstr[5];
            	System.out.println("个数：" + count +  "内容："+ str);
//            	getJsonHtml("", str);
        	    createFile("/Users/ZhangQian/Desktop/numbertest/dingxiangmake.txt", tempstr[1].toString().getBytes());

            }
        }catch (Exception e){
        	
        	System.out.println("异常信息：" + e.getMessage());
        }
        }
	
	
	
	public static String JsonSMS(String postData, String postUrl) {
	    try {
	        //发送POST请求
	        URL url = new URL(postUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Connection", "Keep-Alive");
	        conn.setRequestProperty("Content-Encoding", "gzip");
            conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
//            conn.setRequestProperty("Charset", "UTF-8");


	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Length", "" + postData.length());
	        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	        out.write(postData);
	        out.flush();
	        out.close();
	        //获取响应状态
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            System.out.println("connect failed!");
	            return "";
	        }
	        //获取响应内容体
	        String line, result = "";
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	        while ((line = in.readLine()) != null) {
	            result += line + "\n";
	        }
	        in.close();
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace(System.out);
	    }
	    return "";
	}
	

	
//	https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce=1539338514363&is=460001041658238&model=MI+2S&op=46000&signmd5=608291140&vendor=Xiaomi&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.13.0&h=1280&w=720&v=3986&ntt=WIFI&ie=863908026773333&lc=OXCbcVGOdYPdO2Yz&dpi=320&sdk=19&checkStr=8a81e5c14a994ac78237e31d7d855d3a&s=7c9f76cb14ef823663d800e8cec4b7cd
	 //获取HTML内容
    private String getJsonHtml(String url,String numberValue){
    	String timestamp = System.currentTimeMillis() +"";
    	JSONObject jsonObject = null;
    	//https://way.jd.com/Dingxiang/phonequery?key=008613505691795&appkey=806af09941a56b23bae6003fecd175ed
    	//https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce=1539338514363&is=460001041658238&model=MI+2S&op=46000&signmd5=608291140&vendor=Xiaomi&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.13.0&h=1280&w=720&v=3986&ntt=WIFI&ie=863908026773333&lc=OXCbcVGOdYPdO2Yz&dpi=320&sdk=19&checkStr=8a81e5c14a994ac78237e31d7d855d3a&s=7c9f76cb14ef823663d800e8cec4b7cd
    	try {
//    		 String tempurl = "https://way.jd.com/Dingxiang/phonequery?key=0086"+ numberValue +"&appkey=806af09941a56b23bae6003fecd175ed";
    		 String tempurl = "https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce="+ timestamp +"&is=460001041658238&model=MI+2S&op=46000&signmd5=608291140&vendor=Xiaomi&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.13.0&h=1280&w=720&v=3986&ntt=WIFI&ie=863908026773333&lc=OXCbcVGOdYPdO2Yz&dpi=320&sdk=19&checkStr=8a81e5c14a994ac78237e31d7d855d3a&s=7c9f76cb14ef823663d800e8cec4b7cd";
 	        System.out.println( "百度手机卫士请求接口Url" + tempurl );
 	        
 	        	URL url1 = new URL(tempurl);
    	        URLConnection connection = url1.openConnection();
    	        
    	        InputStream in = connection.getInputStream();
    	        InputStreamReader isr = new InputStreamReader(in);
    	        BufferedReader br = new BufferedReader(isr);
    	        String line;
    	        StringBuffer sb = new StringBuffer();
    	        while((line=br.readLine())!=null){
    	            sb.append(line,0,line.length());
    	            sb.append('\n');
    	        }
    	        br.close();
    	        isr.close();
    	        in.close();
    	        // 将获得的String对象转为JSON格式
//    	        jsonObject = JSONObject.fromObject(sb.toString());
//    	        String result = jsonObject.get("result").toString();
//    	        JSONObject tempResult = JSONObject.fromObject(result);
//    	        String score = tempResult.getString("score");
//    	        String tempValue = numberValue +"," + score;
//    	        //解析成功，把手机号的分值记录到文件
//        	    createFile("/Users/ZhangQian/Desktop/numbertest/dingxiang.txt", tempValue.toString().getBytes());
    	        System.out.println( "百度手机卫士请求接口返回值" + sb.toString());
    	        return sb.toString();
		} catch (Exception e) {
 	        System.out.println( "百度手机卫士请求接口异常" + e.toString() );

				//解析失败把电话号码记录到失败日志
			 	createFile("/Users/ZhangQian/Desktop/numbertest/dingxiangError.txt", numberValue.toString().getBytes());
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
