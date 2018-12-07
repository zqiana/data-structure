package com.baidu.phone;


import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.plaf.synth.SynthStyle;

import com.admaster.ad.cn.test.Base64;

public class cbh {
	
	
    private static final char[] Ndf;

    static {
        Ndf = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }
    
    
    public static void main(String[] args) {
		
		 String string = SaveReadFile("/Users/ZhangQian/Desktop/msg.txt");
		 System.out.println(string);
		 String checkStr  = checkStr(string);
		 System.out.println(checkStr);
	}
    
    
    
    
    
    
    public static String checkStr(String arg3) {
        int v1 = 50;
        if(arg3.length() > v1) {
            arg3 = arg3.substring(0, v1);
        }

        return "checkStr=" + cbh.a(arg3 + "AYUEJ1AWWHKTYENYUG1RP1B52SY5R1OJ");
    }

    
    public static String SaveReadFile(String filePath){
		 
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            String str = "";
            String tempStr = "";
            int count = 0;
            fis = new FileInputStream(filePath);
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
      
            while (((str = br.readLine()) != null)) {
            	tempStr += str;
            }
            return tempStr;
        }catch (Exception e){
        	
        	System.out.println("异常信息：" + e.getMessage());
        	return "";
        }
        
        }
	
	

    public static String a(String arg3) {
        String v0_1;
        try {
            v0_1 = cbh.c(arg3.getBytes("UTF-8"));
        }
        catch(UnsupportedEncodingException v0) {
            v0_1 = null;
        }

        return v0_1;
    }

    public static String a(InputStream arg4) {
        try {
            MessageDigest v0_2 = MessageDigest.getInstance("MD5");
            byte[] v1 = new byte[32768];
            while(true) {
                int v2 = arg4.read(v1);
                if(v2 == -1) {
                    break;
                }

                v0_2.update(v1, 0, v2);
            }

            String v0_3 = cbh.a(v0_2.digest());
            return v0_3;
        }
        
        catch(Exception v0_1) {
        }

        return null;
    }

    public static String a(byte[] arg4) {
        StringBuilder v1 = new StringBuilder(arg4.length * 2);
        int v0;
        for(v0 = 0; v0 < arg4.length; ++v0) {
            v1.append(cbh.Ndf[(arg4[v0] & 240) >>> 4]);
            v1.append(cbh.Ndf[arg4[v0] & 15]);
        }

        return v1.toString();
    }

    public static String b(String arg5) {
        Closeable v2_1;
        Throwable v0_1;
        FileInputStream v2;
        String v0 = null;
        File v1 = new File(arg5);
        if(!v1.exists()) {
            return v0;
        }

        try {
            v2 = new FileInputStream(v1);
            v0 = cbh.a(((InputStream)v2));
        }
       
        catch(Exception v1_2) {
           
        }
        return v0;
    }

    public static String b(byte[] arg1) {
        return Base64.encodeToString(arg1, 2);
    }

    public static String c(byte[] arg3) {
        String v0_2;
        try {
            MessageDigest v0_1 = MessageDigest.getInstance("MD5");
            v0_1.update(arg3);
            v0_2 = cbh.a(v0_1.digest());
        }
        catch(NoSuchAlgorithmException v0) {
            v0_2 = null;
        }

        return v0_2;
    }
}

