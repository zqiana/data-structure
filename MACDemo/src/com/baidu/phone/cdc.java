package com.baidu.phone;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class cdc {
	
	
	public static void main(String[] args) {
		
		String url = "https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce=1539832512781&is=460001041658238&model=HUAWEI+G750-T01&op=46000&signmd5=608291140&vendor=HUAWEI&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.14.0&h=1280&w=720&v=4001&ntt=WIFI&ie=863908026773333&lc=Ee8zFuXg48bpN86E&dpi=320&sdk=19&checkStr=796f9e9de5286716b17e3d7e43688f7d";
		URI uri = URI.create(url);
		try {
			List<Pair<String, String>> list = a(uri, "UTF-8");
			
			for(Pair<String, String> temp : list){
				
				System.out.println(temp.getHead() + temp.getTail());


			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	
    public static List a(URI arg7, String arg8) throws Exception {
        int v6 = 2;
        ArrayList v1 = new ArrayList();
        Scanner v2 = new Scanner(arg7.getRawQuery());
        v2.useDelimiter("&");
        if(arg8 ==null) {
            arg8 = "UTF-8";
        }

        while(true) {
            if(!v2.hasNext()) {
            	return ((List)v1);
            }

            String[] v3 = v2.next().split("=");
            
//			System.out.println(v3[0]);
//			System.out.println(v3[1]);

            
            if(v3.length != 0 && v3.length <= v6) {
                String v4 = URLDecoder.decode(v3[0], arg8);
//                Object v0 = null; 此处修改
                Object v0 = v3[1];

                if(v3.length == v6) {
                    String v0_1 = URLDecoder.decode(v3[1], arg8);
                }

                ((List)v1).add(new Pair(v4, v0));
                continue;
            }

            break;
        }
		return v1;
       
    }
}

