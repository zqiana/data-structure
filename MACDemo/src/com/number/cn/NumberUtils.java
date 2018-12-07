package com.number.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.admaster.ad.cn.Main;

public class NumberUtils {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		NumberUtils numberUtils = new NumberUtils();
		HashSet<String> hashSet = new HashSet<String>();
		StartTask(numberUtils, "/Users/ZhangQian/Desktop/number_value/black_00.txt", hashSet);
		
	}
	
	public static void StartTask(NumberUtils numberUtils,String filePath,HashSet<String> hashSet){
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				numberUtils.ReadFile(filePath, numberUtils, hashSet);
			}
		}).start();
	}
	
	//从文件中读取电话号码
	public void ReadFile(String filePath,NumberUtils numberUtils,HashSet<String> hashSet){

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
            	synchronized (Main.class) {
            		count++;
    			}
                //每次从文件中读取一个电话号码view-source:http://www.0597zp.com/nub/15710029999.html
            	//http://guishudi.jihaoba.com/15238572574.htm
            	//http://gujia.jihaoba.com/13865146640.htm
            	//https://txwz.qq.com/lib/index.php?m=check&a=run&issms=1&keys=18918115883&_=1535440393632&callback=Zepto1535440372329
//				Thread.sleep(5000);
            	System.out.println("电话号码个数统计：" + count);
            	numberUtils.getNumberInfo(str, filePath);
            }
        }catch (Exception e){

        }
       }
	
	//获取电话号码各个参数信息
    private void getNumberInfo(String number,String filePath){
    	filePath = filePath.replace("black", "new");
    	String url = "http://gujia.jihaoba.com/" + number +".htm";
    	try {
			Document document = Jsoup.connect(url).get();
			//根据标签找到属性值
			Elements elements = document.select(".uk-list").select(".xiangqing"); 
			String title = elements.text();

			if(elements.toString().length() == 0){
				//未识别的电话号码
				System.out.println("未识别的电话号码不做记录");
	        	return;
			}
        	//16602135005,1,知,2, 16601048952,,知,,
			for (Element headline : elements) {
				String local = "";
				String type = "";
				String carrieroperator = "";
	            Elements aNode = headline.getElementsByTag("li");//标签选择	            
	            for (Element head : aNode) {
	            	//15625009169,广州,中国联通,GSM卡,18
		            Elements Node = head.getElementsByTag("li");//标签选择
		            String temp = Node.text();
		            if(temp.contains("归属地")){
		            	local = temp.split("：")[1];
		            }else if (temp.contains("运营商")) {
		            	carrieroperator = temp.split("：")[1];
					}else if (temp.contains("卡类型")) {
		            	type = temp.split("：")[1];
					}else {
						//不对数据做处理
					}                        	            
				} 	           
	            	//获取号码评估值
	    			Elements value = document.select("h3[class=uk-panel-title]");
	    			String numberVaule = value.text();
//	    			System.out.println("网页解析信息号码价值：" + title);
	    			String tempValue = numberVaule.substring(6, numberVaule.length() - 11).trim();
//	    			System.out.println("网页解析信息号码价值：" + tempValue);
	            	String tempValues = number + "," + local.trim() + "," + carrieroperator.trim() + "," + type + "," + tempValue;            
	  				System.out.println("数组拼接完成：" + tempValues.trim());
	  				createFile(filePath, tempValues.getBytes());
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("未识别的电话号码");
				createFile("/Users/ZhangQian/Desktop/number_value/Unidentified.txt", number.getBytes());

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
