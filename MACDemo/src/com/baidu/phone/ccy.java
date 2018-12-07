package com.baidu.phone;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.net.ssl.HttpsURLConnection;

import com.admaster.ad.cn.test.Base64;
import org.apache.commons.codec.binary.Hex;

import net.sf.json.JSONObject;

public class ccy {
	
	
	
	public static void main(String[] args) {
		
		
		String sign = "f6bfadb0a20cf8472ba9f63222ff7e50";
		long timestmap = System.currentTimeMillis();
	    Long timetest = 1539856600915L;
		String string2 = "{\"address\":\"中国北京市海淀区\",\"cell\":{\"id\":20648,\"mcc\":\"460\",\"lac\":4530,\"mnc\":\"00\"},\"province\":\"北京市\",\"iccid\":\"898600660115f0142502\",\"type\":\"floatingview_incoming\",\"district\":\"海淀区\",\"wf\":[{\"wifi\":\"AdMaster|04:40:a9:ff:3e:f0\"},{\"wifi\":\"AdMaster-Guest|04:40:a9:ff:3e:f1\"},{\"wifi\":\"峥峥的 iPhone X|ae:1f:74:8f:23:fc\"},{\"wifi\":\"HUAWEI-D94FTB|b8:08:d7:6c:2e:ec\"},{\"wifi\":\"AdMaster-Guest|04:40:a9:ff:7f:31\"},{\"wifi\":\"chunming|2a:cf:5e:f8:25:5a\"},{\"wifi\":\"AdMaster|04:40:a9:ff:7f:30\"},{\"wifi\":\"bamboog|78:31:c1:d0:25:8e\"},{\"wifi\":\"小怪兽|32:63:6b:a1:a4:9f\"},{\"wifi\":\"HUAWEI-5|94:77:2b:22:0b:84\"},{\"wifi\":\"ops_portal|04:40:a9:ff:7f:32\"},{\"wifi\":\"Qunar-CXB|54:4a:00:c8:77:f8\"},{\"wifi\":\"Qunar|54:4a:00:c8:77:f5\"},{\"wifi\":\"Qunar-Guest|e4:aa:5d:2d:23:60\"},{\"wifi\":\"Qunar|e4:aa:5d:0a:91:e5\"},{\"wifi\":\"Qunar-Guest|e4:aa:5d:0a:91:e0\"},{\"wifi\":\"Qunar-CXB|e4:aa:5d:0a:91:e8\"},{\"wifi\":\"Qunar-CXB|00:e1:6d:4e:57:50\"},{\"wifi\":\"Qunar-Inter|54:4a:00:c8:77:f1\"},{\"wifi\":\"Qunar-Inter|e4:aa:5d:0a:91:e1\"},{\"wifi\":\"FUWU_TOUCH|d4:ee:07:11:ac:42\"},{\"wifi\":\"Qunar|e4:aa:5d:2d:23:65\"},{\"wifi\":\"Qunar-CXB|e4:aa:5d:2d:23:68\"},{\"wifi\":\"Office_2.4G|94:d9:b3:3a:12:50\"},{\"wifi\":\"Qunar-Inter|e4:aa:5d:2d:23:61\"},{\"wifi\":\"jybd|d4:c8:b0:2e:a7:00\"},{\"wifi\":\"Qunar-Guest|54:4a:00:c8:77:f0\"},{\"wifi\":\"yxq|2a:e3:47:c5:30:1a\"}],\"phones\":[\"13366396982\"],\"city\":\"北京市\"}";
		String data = cbh.SaveReadFile("/Users/ZhangQian/Desktop/data.txt");
    	JSONObject json = JSONObject.fromObject(data.toString());
    	

		System.out.println(data);
		try {
			String result = a(sign, timetest, data);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("msg", result);
			jsonObject.put("createTime", timetest);
			String postData = cbh.SaveReadFile("/Users/ZhangQian/Desktop/msg.txt");
			String checkStr = cbh.checkStr(postData).split("=")[1];
			
			System.out.println(jsonObject.toString());
			System.out.println(checkStr);
			
		    
		    String tempStr  = "appkey50c82132bb394901f151ad96auth_ver2checkStr"+checkStr+"dpi320h1280ie863908026773333is460001041658238lcEe8zFuXg48bpN86Elocalezh_CNlocatetruemodelHUAWEI G750-T01nonce"+timetest+"nttWIFIop46000pkgcn.opda.a.phonoalbumshoushousdk19signmd5608291140tkVD4IuNmbXJUkWi8TfTBIhw==v4001vendorHUAWEIvn9.14.0w720f6bfadb0a20cf8472ba9f63222ff7e50";
		   
//		    String s = cbh.a(tempStr);
		    String s = "f0fa711025082096c43fb482a1f7a62f";

		    
		    String url = "https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce="+timetest+"&is=460001041658238&model=HUAWEI+G750-T01&op=46000&signmd5=608291140&vendor=HUAWEI&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.14.0&h=1280&w=720&v=4001&ntt=WIFI&ie=863908026773333&lc=Ee8zFuXg48bpN86E&dpi=320&sdk=19&checkStr="+ checkStr+"&s="+s;

		    String testUrl = "https://mobsec-dianhua.baidu.com/dianhua_api/5.0/report/query?locate=true&auth_ver=2&appkey=50c82132bb394901f151ad96&nonce=1539941581153&is=460001041658238&model=HUAWEI+G750-T01&op=46000&signmd5=608291140&vendor=HUAWEI&locale=zh_CN&pkg=cn.opda.a.phonoalbumshoushou&tk=VD4IuNmbXJUkWi8TfTBIhw%3D%3D&vn=9.14.0&h=1280&w=720&v=4001&ntt=WIFI&ie=863908026773333&lc=Ee8zFuXg48bpN86E&dpi=320&sdk=19&checkStr=57674353683f87c60ca90bbfbd57859b&s=8c827786a53ba455752b66adf983516d";
			System.out.println(url);
			
			
			String httpResult = JsonSMS(postData, testUrl);

			System.out.println(httpResult);




		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	/**
     * 把byte 通过GZipStream封装
     * @param content
     * @return
     */
    private static byte[] eGzip(byte[] content) {
        GZIPOutputStream gos = null;
        try {
            // 通过一个缓冲的byte[] 对标准输出流进行封装,不需要主动close
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            gos = new GZIPOutputStream(baos);
            gos.write(content);
            gos.finish();
            gos.close();
            gos = null;
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (gos != null) {
                try {
                    gos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gos = null;
            }
        }
        return null;
    }
	
	public static String JsonSMS(String postData, String postUrl) {
	    try {
	        //发送POST请求
	        URL url = new URL(postUrl);
	        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
            conn.setRequestProperty("Charset", "UTF-8");
	        conn.setRequestProperty("Content-Encoding", "gzip");
            conn.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4.4; MI 2S MIUI/5.3.27)");
            conn.setRequestProperty("Host", "mobsec-dianhua.baidu.com");
	        conn.setRequestProperty("Connection", "Keep-Alive");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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


             if (hasGzip.contains("gzip")) {
                 // 使用GZIP解压
     			is = new GZIPInputStream(conn.getInputStream());
                response = writeToArr(is);
                
                String responeResult = new String(response);
    			System.out.println("百度卫士返回数据：" + responeResult);

             }

	        //获取响应状态
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            System.out.println("connect failed!");
	            return "";
	        }
	        //获取响应内容体
	        String line, result = "";
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	        while ((line = in.readLine()) != null) {
				System.out.println("BBBBB");

	            result += line + "\n";
	        }
	        in.close();
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace(System.out);
	    }
	    return "";
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
	
	
	
	 /**
     * 读取到Buffer内，转换成byte[]数组
     */
    private static byte[] writeToArr(final InputStream is) throws IOException {
        if (is == null) {
            return null;
        }
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[8192];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        // buffer.close();
        return buffer.toByteArray();
    }

	
	
	
	
    public static String a(String arg3, long arg4, String arg6) throws UnsupportedEncodingException {
    	System.out.println(arg4);
        return Base64.encodeToString(ccy.a(arg3.getBytes("utf-8"), ccy.a(arg4), arg6.getBytes("utf-8")), 0);
    }

    public static byte[] a(byte[] arg4, byte[] arg5, byte[] arg6) {
        try {
            Cipher v0_1 = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            v0_1.init(1, SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(arg4)), new IvParameterSpec(arg5));
            return v0_1.doFinal(arg6);
        }
        catch(Exception v0) {
            throw new SecurityException(((Throwable)v0));
        }
    }

    public static byte[] a(long arg2) {
        ByteBuffer v0 = ByteBuffer.allocate(8);
        v0.order(ByteOrder.BIG_ENDIAN);
        v0.putLong(arg2);
        return v0.array();
    }

    public static byte[] a(int arg2) {
        byte[] v0 = new byte[arg2];
        new SecureRandom().nextBytes(v0);
        return v0;
    }

    public static String b(String arg3, long arg4, String arg6) throws UnsupportedEncodingException {
        return Base64.encodeToString(ccy.a(arg3.getBytes("utf-8"), ccy.a(arg4), arg6.getBytes("utf-8")), 0);
    }

    static byte[] b(byte[] arg4, byte[] arg5, byte[] arg6) {
        try {
            Cipher v0_1 = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            v0_1.init(2, SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(arg4)), new IvParameterSpec(arg5));
            return v0_1.doFinal(arg6);
        }
        catch(Exception v0) {
            throw new SecurityException(((Throwable)v0));
        }
    }

    public static String c(String arg3, long arg4, String arg6) throws UnsupportedEncodingException {
        return new String(ccy.d(arg3, arg4, arg6), "utf-8");
    }

    public static byte[] d(String arg3, long arg4, String arg6) throws UnsupportedEncodingException {
        return ccy.b(arg3.getBytes("utf-8"), ccy.a(arg4), Base64.decode(arg6, 0));
    }
}

