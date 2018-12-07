package com.admaster.ad.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLTest {

    private URLConnection connection = null;
    
    public String getDoucument(String url) throws IOException {
        
        URL newUrl = new URL(url);
        connection = newUrl.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String line = "";
        StringBuffer sb = new StringBuffer();
        
        while( (line =  br.readLine()) != null) {
            sb.append(line +"\n");
        }
        
        return sb.toString();
        
    }
    
    public String MyFilter( String string ) {//内容过滤器-获取网页上的电话，没有去重
        
        String regex = "1[\\d]{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        
        String result = "xxx";
        while(matcher.find()) {
            result += matcher.group()+"\n";
        }
        
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        
        URLTest test = new URLTest();
        FileInputStream in =  new FileInputStream("/Users/ZhangQian/Desktop/number/url.txt");
        InputStreamReader ios = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ios);
        String str;
        while ((str = br.readLine()) != null) {
        	 String page = test.getDoucument("http://www.0597zp.com/mobile/yichang_1580720.html");
             String result = test.MyFilter(page);
           }

        String page = test.getDoucument("http://www.0597zp.com/mobile/yichang_1580720.html");
        String result = test.MyFilter(page);
//        System.out.println(page);
        
        if ( result != null ) {
            System.out.println("从该网页上找到的号码：\n"+result);
        }
        else {
            System.out.println("该网页上没有电话号码");
        }
        
    }
}