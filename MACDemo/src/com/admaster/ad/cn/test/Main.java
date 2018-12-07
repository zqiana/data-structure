package com.admaster.ad.cn.test;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.sf.json.JSONObject;

public class Main {

    // 地址
    private static final String URL = "http://gujia.jihaoba.com/15710029999.htm";
    // 获取img标签正则
    private static final String IMGURL_REG = "<a href=.*</a>";
    
    private static final String Url_regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    // 获取src路径的正则
    private static final String Numeber = "归属地：.*";
    private static final String Localtion = "卡类型：.*";
    private static final String TPeValue = "评估价格.*";
    private static final String SimValue = "运营商：.*";
    
    private static final String LocalValue = "[\u2E80-\u9FFF]* </span>";
//^[\u4E00-\u9FA5]+$

    private  static int count = 0;

    public static void main(String[] args) {
        try {
            Main cm=new Main();
            HashSet<String> hashSet = new HashSet<String>();
            cm.SaveHashFile("/Users/ZhangQian/Desktop/blacklist/black.txt", hashSet);
            Main cm1=new Main();
            Main cm2=new Main();
            Main cm3=new Main();
            Main cm4=new Main();
            Main cm5=new Main();
            Main cm6=new Main();
            Main cm7=new Main();
            Main cm8=new Main();
            Main cm9=new Main();
////            
//            Main cm10=new Main();
//            Main cm11=new Main();
//            Main cm12=new Main();
//            Main cm13=new Main();
//            Main cm14=new Main();
//            Main cm15=new Main();
//            Main cm16=new Main();
//            Main cm17=new Main();
//            Main cm18=new Main();
//            Main cm19=new Main();
            
//            
            startTask(cm,"/Users/ZhangQian/Desktop/numbertest/black_00.txt",hashSet);
            startTask(cm1,"/Users/ZhangQian/Desktop/numbertest/black_11.txt",hashSet);
            startTask(cm2,"/Users/ZhangQian/Desktop/numbertest/black_22.txt",hashSet);
            startTask(cm3,"/Users/ZhangQian/Desktop/numbertest/black_33.txt",hashSet);
            startTask(cm4,"/Users/ZhangQian/Desktop/numbertest/black_44.txt",hashSet);
            startTask(cm5,"/Users/ZhangQian/Desktop/numbertest/black_55.txt",hashSet);
            startTask(cm6,"/Users/ZhangQian/Desktop/numbertest/black_66.txt",hashSet);
            startTask(cm7,"/Users/ZhangQian/Desktop/numbertest/black_77.txt",hashSet);
            startTask(cm8,"/Users/ZhangQian/Desktop/numbertest/black_88.txt",hashSet);
            startTask(cm9,"/Users/ZhangQian/Desktop/numbertest/black_99.txt",hashSet);
            
            //新开10个线程
            startTask(cm,"/Users/ZhangQian/Desktop/numbertest/black_aa.txt",hashSet);
            startTask(cm1,"/Users/ZhangQian/Desktop/numbertest/black_bb.txt",hashSet);
            startTask(cm2,"/Users/ZhangQian/Desktop/numbertest/black_cc.txt",hashSet);
            startTask(cm3,"/Users/ZhangQian/Desktop/numbertest/black_dd.txt",hashSet);
            startTask(cm4,"/Users/ZhangQian/Desktop/numbertest/black_ee.txt",hashSet);
            startTask(cm5,"/Users/ZhangQian/Desktop/numbertest/black_ff.txt",hashSet);
            startTask(cm6,"/Users/ZhangQian/Desktop/numbertest/black_gg.txt",hashSet);
            startTask(cm7,"/Users/ZhangQian/Desktop/numbertest/black_hh.txt",hashSet);
            startTask(cm8,"/Users/ZhangQian/Desktop/numbertest/black_ii.txt",hashSet);
            startTask(cm9,"/Users/ZhangQian/Desktop/numbertest/black_jj.txt",hashSet);
            

        
            //获得html文本内容
           
//            System.out.println("Url 的个数：" + imgUrl.size());
//            	for(int i = 0; i < linkedList.size(); i++){
//            		gene(linkedList.get(i),1,cm,hashSet);
////            		System.out.println(linkedList.get(i));
//
//            	}
//            
            
//            for(int i = 0; i <=9; i++){
//                gene("1330"+i,1,cm,hashSet);
//         }


            //获取图片src地址
//           List<String> imgSrc = cm.getImageSrc(imgUrl);
//            //下载图片
//            cm.Download(imgSrc);

        }catch (Exception e){
            System.out.println("发生错误");
        }

    }
    
    
    
    //存储黑名单号码到数据库
    public void SaveHashFile(String filePath,HashSet<String> hashTest){

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
            
            hashTest.add(temp);
            System.out.println(temp);
            	         	
            }
        }catch (Exception e){

        }
        }
 
    
    public static void startTask(Main main,String filePath,HashSet<String> hashSet){
    	
    	new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				main.ReadFile(filePath, main,hashSet);
				
			}
		}).start();
    }
    
    public static String gene(String s,int level,Main cm,HashSet<String> hashTest,String filePath){
        if(level == 5){
//            result.add(s);
        	//得到电话号码，去数据库中查询
//        	decrypt.a(s);
        	 String HTML;
			try {
				synchronized (Main.class) {
					count ++;
				}
//				Thread.sleep(5000);
				if(!hashTest.contains(s)){
	            	System.out.println("数据库中没有的电话号码：" + s);
	            	HTML = cm.getJsonHtml("https://txwz.qq.com/lib/index.php?m=check&a=run&issms=1&keys=" + s +"&_=1535440393632&callback=Zepto1535440372329",s,filePath);
				}
            	System.out.println("电话号码的个数：" + count);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return s;
        }
        for (int i = 0; i <= 9 ; i++) {
            gene(s+i,level+1,cm,hashTest,filePath);
        }
        return  s;
    }
    
    public void ReadFile(String filePath,Main cm,HashSet<String> hashSet){
//		System.out.println("http://gujia.jihaoba.cohtm");

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
            
            	gene(str,1,cm,hashSet,filePath);
                //每次从文件中读取一个电话号码view-source:http://www.0597zp.com/nub/15710029999.html
            	//http://guishudi.jihaoba.com/15238572574.htm
            	//http://gujia.jihaoba.com/13865146640.htm
            	//https://txwz.qq.com/lib/index.php?m=check&a=run&issms=1&keys=18918115883&_=1535440393632&callback=Zepto1535440372329
//				Thread.sleep(5000);
//            	HTML = cm.getJsonHtml("https://txwz.qq.com/lib/index.php?m=check&a=run&issms=1&keys=" + str +"&_=1535440393632&callback=Zepto1535440372329",str);
//            	System.out.println("电话号码个数统计：" + count);
//	            List<String> imgUrl = cm.getImageUrl(HTML,str,filePath);            	
            }
        }catch (Exception e){

        }
        }
    
   


    
    //获取网路请求内容
    private String getJsonHtml(String url,String numberValue,String filePath){
    	filePath = filePath.replace("black", "new");
    	String normal_File_Path = filePath.replace("new", "normal");
//    	String normal = filePath.replace("new", "normal");
    	JSONObject jsonObject = null;
    	try {
    		 URL url1=new URL(url);
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
    	        
    	        String temp = sb.toString().split("\\(")[1];

    	        String tempValue = temp.split("\\)")[0].trim();
//    	        System.out.println(tempValue);

    	     // 将获得的String对象转为JSON格式
    	        jsonObject = JSONObject.fromObject(tempValue);
    	        String discrible = jsonObject.get("uTagName").toString();
    	        String local = jsonObject.get("region").toString();
    	        String number = jsonObject.get("data").toString();
    	        
    	        String dataValue = number + "," + local + "," + discrible;

    	        createFile(filePath, dataValue.toString().getBytes());
    	        System.out.println(jsonObject.toString());
    	        return sb.toString();
		} catch (Exception e) {
			if(e.getMessage()==null){
				String number = jsonObject.get("data").toString();
    	        String localnum = jsonObject.get("region").toString();
    	        String tempdataValue = number + "," + localnum ;
    	        createFile(normal_File_Path, tempdataValue.toString().getBytes());
				System.out.println("正常请求：："+ "未存在被标识的号码标签，已存入白名单库" + ":::请求线程的ID："+ Thread.currentThread().getId());
			}else {
				System.out.println("异常信息：："+ e.getMessage());
				createFile("/Users/ZhangQian/Desktop/numbertest/error.txt", numberValue.getBytes());
			}
		
		}
		return url;
       
    }
    

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