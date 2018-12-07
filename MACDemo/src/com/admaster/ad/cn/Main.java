package com.admaster.ad.cn;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.PUBLIC_MEMBER;

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
    
//    private static final String LocalValue = "[\u2E80-\u9FFF]* </span>";
//^[\u4E00-\u9FA5]+$

    private  static int count = 0;

    public static void main(String[] args) {
        try {
            Main cm=new Main();
            HashTest hashTest =  new HashTest();
            HashSet<String> hashSet = new HashSet<String>();
            LinkedList<String> linkedList = new LinkedList<String>();
//            hashTest.SaveHashFile("/Users/ZhangQian/Desktop/blacklist/black.txt", hashSet);
//            hashTest.ReadFile("/Users/ZhangQian/Desktop/numbertest/beijing.txt", linkedList);
//            Main cm1=new Main();
//            Main cm2=new Main();
//            Main cm3=new Main();
//            Main cm4=new Main();
//            Main cm5=new Main();
//            Main cm6=new Main();
//            Main cm7=new Main();
//            Main cm8=new Main();
//            Main cm9=new Main();
//            
//            
            startTask(cm,"/Users/ZhangQian/Desktop/number_value/black_00.txt",hashSet);
//            startTask(cm1,"/Users/ZhangQian/Desktop/number_value/black_11.txt",hashSet);
//            startTask(cm2,"/Users/ZhangQian/Desktop/number_value/black_22.txt",hashSet);
//            startTask(cm3,"/Users/ZhangQian/Desktop/number_value/black_33.txt",hashSet);
//            startTask(cm4,"/Users/ZhangQian/Desktop/number_value/black_44.txt",hashSet);
//            startTask(cm5,"/Users/ZhangQian/Desktop/number_value/black_55.txt",hashSet);
//            startTask(cm6,"/Users/ZhangQian/Desktop/number_value/black_66.txt",hashSet);
//            startTask(cm7,"/Users/ZhangQian/Desktop/number_value/black_77.txt",hashSet);
//            startTask(cm8,"/Users/ZhangQian/Desktop/number_value/black_88.txt",hashSet);
//            startTask(cm9,"/Users/ZhangQian/Desktop/number_value/black_99.txt",hashSet);
            

        
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
    
    
    
    

    public static void startTask(Main main,String filePath,HashSet<String> hashSet){
    	
    	new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				main.ReadFile(filePath, main,hashSet);
				
			}
		}).start();
    }
    
    public static String gene(String s,int level,Main cm,HashSet<String> hashTest){
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
	            	HTML = cm.getJsonHtml("https://txwz.qq.com/lib/index.php?m=check&a=run&issms=1&keys=" + s +"&_=1535440393632&callback=Zepto1535440372329",s);
				}
            	System.out.println("电话号码的个数：" + count);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             //获取图片标签
            return s;
        }
        for (int i = 0; i <= 9 ; i++) {
            gene(s+i,level+1,cm,hashTest);
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
            
            	String temp = str.split(",")[0];
//            	gene(str,1,cm,hashSet);
                //每次从文件中读取一个电话号码view-source:http://www.0597zp.com/nub/15710029999.html
            	//http://guishudi.jihaoba.com/15238572574.htm
            	//http://gujia.jihaoba.com/13865146640.htm
            	//https://txwz.qq.com/lib/index.php?m=check&a=run&issms=1&keys=18918115883&_=1535440393632&callback=Zepto1535440372329
//				Thread.sleep(5000);
            	HTML = cm.getHtml("http://gujia.jihaoba.com/" + temp +".htm");
//            	System.out.println("电话号码个数统计：" + count);
	            List<String> imgUrl = cm.getImageUrl(HTML,str,filePath);            	
            }
        }catch (Exception e){

        }
        }
    
    //获取ImageUrl地址
    private List<String> getImageUrl(String html,String number,String filePath){
    	filePath = filePath.replace("black", "new");
        Matcher matcher=Pattern.compile(Numeber).matcher(html);
        Matcher matcher1=Pattern.compile(Localtion).matcher(html);
        Matcher matcher2=Pattern.compile(TPeValue).matcher(html);
        Matcher matcher3=Pattern.compile(SimValue).matcher(html);
        
//       System.out.println("AAAAA");
        
        List<String>listimgurl=new ArrayList<String>();
        while (matcher.find() && matcher1.find() && matcher2.find() && matcher3.find() ){
//            System.out.println("BBBBB");
        	synchronized (Main.class) {
        		count++;
			}
            listimgurl.add(matcher.group() +"\n");
            
            String temp = matcher.group();
            String temp1 = matcher1.group();
            String temp2 = matcher2.group();
            String temp3 = matcher3.group();
            
//        	System.out.println("归属地：" +temp.substring(4,temp.length() -5));
//        	System.out.println("卡类型：" + temp1.substring(4, temp1.length() -5));
//        	System.out.println("运营商：" + temp2.substring(12, temp2.length() - 14));
//        	System.out.println("卡价值：" + temp3.substring(5, temp3.length() -5));
//          String tempValue = number + ","+ temp.substring(0, temp.length() -8).trim();

           System.out.println("电话号码价值：" + number + "::" + temp + "::" +"当前线程ID："+ Thread.currentThread().getId() + "条数：" +  count);
           String tempValue = number +"," +temp.substring(4, temp.length() -5).trim() + "," +
           temp3.substring(5, temp3.length() -5).trim() + ","+ temp1.substring(4, temp1.length() -5).trim() +","+temp2.substring(12, temp2.length() - 14).trim() ;
            
            
//        	createFile("/Users/ZhangQian/Desktop/number/number_local60.txt", tempValue.getBytes());
        	createFile(filePath, tempValue.getBytes());



//            String [] strings = temp.split("</li><li>");
//            String url = "";
//            for(int i = 0; i < strings.length; i++ ){
//            	url = strings[i].substring(strings[i].length() - 11,strings[i].length() - 4);
////            	url = "http://www.0597zp.com/"+ url;
//           	createFile("/Users/ZhangQian/Desktop/number/新疆克拉玛依.txt", url.getBytes());
//           	    System.out.println("UrlTTT 的个数：" + url +"\n");
//            	url = "";
//
//            }
            
     	    System.out.println("Url 的个数：" + "归属地：" + "卡类型：" + tempValue +"\n");       	   
       	    
       	  


        }
        return listimgurl;
    }

   //获取HTML内容
    private String getHtml(String url){
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
    	        return sb.toString();
		} catch (Exception e) {
			System.out.println("异常信息：："+ e.getMessage());
			createFile("/Users/ZhangQian/Desktop/numbertest/error.txt", url.getBytes());
		}
		return url;
       
    }
    
    //获取HTML内容
    private String getJsonHtml(String url,String numberValue){
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

    	        createFile("/Users/ZhangQian/Desktop/numbertest/tengxunceshi.txt", dataValue.toString().getBytes());
    	        System.out.println(jsonObject.toString());
    	        return sb.toString();
		} catch (Exception e) {
			if(e.getMessage()==null){
				String number = jsonObject.get("data").toString();
    	        String localnum = jsonObject.get("region").toString();
    	        String tempdataValue = number + "," + localnum ;
    	        createFile("/Users/ZhangQian/Desktop/numbertest/tengxunNormal.txt", tempdataValue.toString().getBytes());
				System.out.println("正常请求：："+ "未存在被标识的号码标签，已存入白名单库");
			}else {
				System.out.println("异常信息：："+ e.getMessage());
				createFile("/Users/ZhangQian/Desktop/numbertest/error.txt", numberValue.getBytes());
			}
		
		}
		return url;
       
    }
    
    private String getHref(String str) {
        Pattern pattern = Pattern.compile("<a href=.*</a>");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            return matcher.group(0);
        return null;
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

   

    //获取ImageSrc地址
//    private List<String> getImageSrc(List<String> listimageurl){
//        List<String> listImageSrc=new ArrayList<String>();
//        for (String image:listimageurl){
//            Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(image);
//            while (matcher.find()){
//                listImageSrc.add(matcher.group().substring(0, matcher.group().length()-1));
//            }
//        }
//        return listImageSrc;
//    }

    //下载图片
    private void Download(List<String> listImgSrc) {
        try {
            //开始时间
            Date begindate = new Date();
            for (String url : listImgSrc) {
                //开始时间
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                FileOutputStream fo = new FileOutputStream(new File("src/res/"+imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
                //结束时间
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("耗时：" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("总耗时：" + time / 1000 + "s");
        } catch (Exception e) {
            System.out.println("下载失败");
        }
    }
    
    
    
    
    
}