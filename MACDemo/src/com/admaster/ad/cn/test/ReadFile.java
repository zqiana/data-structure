package com.admaster.ad.cn.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Hex;

import com.admaster.ad.cn.Main;
import com.baidu.phone.cbn;

import net.sf.json.JSONObject;

public class ReadFile {
	
	public static void main(String[] args) {
		
		ReadSDFile("/Users/ZhangQian/Desktop/qianqian.txt");
		
		
	}
	
	
	
	public static String PostRequest(String postData, String postUrl) {
	    try {
	        //发送POST请求
	        URL url = new URL(postUrl);
	        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
//            conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
            conn.setRequestProperty("Charset", "UTF-8");
//	        conn.setRequestProperty("Content-Encoding", "gzip");
            conn.setRequestProperty("Ocp-Apim-Subscription-key", "c6afd336244849799ade59a29a0e4831");
	        conn.setRequestProperty("Connection", "Keep-Alive");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Content-Length", "" + postData.length());
	       
	        System.out.println("数据长度：" + postData.length());
	        conn.setUseCaches(false);
	        conn.setDoOutput(true);
	        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	        
	        DataOutputStream dos =  new DataOutputStream(conn.getOutputStream());
//            OutputStream out = conn.getOutputStream();

            byte[] buffer = postData.getBytes("UTF-8");
           
	        dos.write(cbn.a(buffer));
	        dos.flush();
	        dos.close();
//	        out.write(new String(buffer));
//	        out.flush();
//	        out.close();
	        
	        
			System.out.println("服务端响应码：" + conn.getResponseCode());
			
			 String hasGzip = conn.getContentEncoding();
			 
		     InputStream is = null;
		     byte[] response = null;


//             if (hasGzip.contains("gzip")) {
//                 // 使用GZIP解压
//     			is = new GZIPInputStream(conn.getInputStream());
//                response = writeToArr(is);
//                
//                String responeResult = new String(response);
//    			System.out.println("返回数据：" + responeResult);
//
//             }

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
	            System.out.println("服务器端返回值内容：" + result);
	        }
	        in.close();
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace(System.out);
	    }
	    return "";
	}
	
	
	public static  void ReadSDFile(String filePath){

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
            String HTML;
            Map<String, String> params = new HashMap<>();
            params.put("api_key", "mpt-weiboyi");
            params.put("nonce_str", "1543402324.5848");
            params.put("timestamp", "2018-11-28 18:44:47");
            params.put("source", "wby");
            String tempbody = "";
            while ((str = br.readLine()) != null) {
                String arr[] = str.split(",");
                

                String orderid = arr[0];
                String test = "\"" +orderid  + "\""+ "";

                String priceId = arr[1];
                String test1 = "\"" +priceId  + "\""+ "";

                String articleLink = arr[2];
                
                String test3 = "\"" +articleLink  + "\""+ "";

                
//                String platformId = "1";
//                String impression = "100";
                //post请求时添加

                    count ++;
                    if(count!=2){
                        tempbody += "{\n" +
                                "    \"confirmData\":[\n" +
                                "        {\n" +
                                "            \"orderId\":"+test+",\n" +
                                "            \"priceId\":"+test1+",\n" +
                                "            \"postData\":[\n" +
                                "                {\n" +
                                "                \t\"platformId\":\"1\",\n" +
                                "                \t\"articleLink\":"+test3+",\n" +
                                "                \t\"impression\":100\n" +
                                "                }\n" +
                                "            ]\n" +
                                "        }\n" +
                                "    ]\n" +
                                "},";
                    }else {

                        tempbody += "{\n" +
                                "    \"confirmData\":[\n" +
                                "        {\n" +
                                "            \"orderId\":"+test+",\n" +
                                "            \"priceId\":"+test1+",\n" +
                                "            \"postData\":[\n" +
                                "                {\n" +
                                "                \t\"platformId\":\"1\",\n" +
                                "                \t\"articleLink\":"+test3+",\n" +
                                "                \t\"impression\":100\n" +
                                "                }\n" +
                                "            ]\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}";
                    }

            }


            params.put("body",tempbody  );

            String signStr = sign(params);
            
            String postUrl = "https://transitsharedqaapim0.azure-api.cn/mpt-social-planning-tool-api/social/post_collector/10?api_key=mpt-weiboyi&nonce_str=1543402324.5848&timestamp=2018-11-28 18:44:47&source=wby&sign="+ signStr;
            
        	JSONObject jsonObject = null;
        	
        	 // 将获得的String对象转为JSON格式
	        jsonObject = JSONObject.fromObject(tempbody);

            PostRequest(tempbody, postUrl);
            System.out.println("XXXXX"+ jsonObject.toString()+ "XXXXX");
            
            System.out.println(signStr);


        }catch (Exception e){
        		System.out.println("异常信息" + e.toString());
        }
    }
	
	//签名
	 public static String sign(Map<String, String> params) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	        final String exampleSecret = "7483ed7f187d49e5a7026a37eee81df5";
	        List<String> paramList = new ArrayList<>();
	        for (Map.Entry<String, String> entry : params.entrySet()) {
	            paramList.add(entry.getKey() + "=" + entry.getValue());
	        }
	        Collections.sort(paramList);
	        StringBuilder sb = new StringBuilder();
	        sb.append(exampleSecret);
	        for (String paramStr : paramList) {
	            sb.append(paramStr);
	            sb.append("&");
	        }
	        sb.replace(sb.length() - 1, sb.length(), exampleSecret);
//	        System.out.println(sb.toString());
	        MessageDigest instance = MessageDigest.getInstance("SHA-256");
	        byte[] bytes = instance.digest(sb.toString().getBytes("UTF-8"));
	        return Hex.encodeHexString(bytes).toUpperCase();
//	        return  "";
	    }
	
	 public static void ReadFile(String filePath){
//			System.out.println("http://gujia.jihaoba.cohtm");

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
	            
	            	String temp = str.split("	")[1];
	            	String temp1 = str.split("	")[0];

	            	String temp2 = str.split("	")[3];
	            	
	            	String tempValue = temp +","+ temp1+ ","+temp2;
	            	
	            	createFile("/Users/ZhangQian/Desktop/qianqian.txt",tempValue.getBytes());

	            	System.out.println(temp + temp1+ temp2);

//	                     	
	            }
	        }catch (Exception e){

	        }
	        }
	 
	  //将byte数组写入文件
	    public static void createFile(String path, byte[] content) {

	        try{
	            FileOutputStream fos = new FileOutputStream(path,true);
	            fos.write(content);
	            fos.write("\r\n".getBytes());
	            fos.close();
	        }catch (Exception e){

	        }


	    }


}
