package com.admaster.ad.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class NumberUtils {
	
	static HashSet<String> hashGsm = new HashSet<>();
	static HashSet<String> hashCmcc = new HashSet<>();
	static HashSet<String> hashCDMA = new HashSet<>();
	static HashSet<String> hashQIta = new HashSet<>();
	static HashSet<String> blackhashSet = new HashSet<>();

	public static void main(String[] args) {
		
		NumberUtils nUtils = new NumberUtils();
		nUtils.SaveHashFile("/Users/ZhangQian/Desktop/RiskModle/blacklist/black.txt", blackhashSet);
		//存放31个省市
		HashMap<String, HashSet<String>> hashMap = new HashMap<>();
		HashSet<String> heibei =  new  HashSet<>();
		HashSet<String> heinan =  new  HashSet<>();
		HashSet<String> anhui =  new  HashSet<>();
		HashSet<String> zhixiashi =  new  HashSet<>();
		HashSet<String> fujian =  new  HashSet<>();
		HashSet<String> gansu =  new  HashSet<>();
		HashSet<String> guangdong =  new  HashSet<>();
		HashSet<String> guangxi =  new  HashSet<>();
		HashSet<String> guizhou =  new  HashSet<>();
		HashSet<String> hainan =  new  HashSet<>();
		HashSet<String> heilongjiang =  new  HashSet<>();
		HashSet<String> hubei =  new  HashSet<>();
		HashSet<String> hunan =  new  HashSet<>();
		HashSet<String> jiangsu =  new  HashSet<>();
		HashSet<String> jiangxi =  new  HashSet<>();
		HashSet<String> jilin =  new  HashSet<>();
		HashSet<String> liaoning =  new  HashSet<>();
		HashSet<String> neimenggu =  new  HashSet<>();
		HashSet<String> ningxia =  new  HashSet<>();
		HashSet<String> qinghai =  new  HashSet<>();
		HashSet<String> shandong =  new  HashSet<>();
		HashSet<String> shanxi =  new  HashSet<>();
		HashSet<String> shanxixi =  new  HashSet<>();
		HashSet<String> sichuan =  new  HashSet<>();
		HashSet<String> xinjiang =  new  HashSet<>();
		HashSet<String> xizang =  new  HashSet<>();
		HashSet<String> yunan =  new  HashSet<>();
		HashSet<String> zhejiang =  new  HashSet<>();
		
		//号码归属地判断
		hashGsm.add("1703");
		hashGsm.add("1705");
		hashGsm.add("1706");

		hashCmcc.add("1704");
		hashCmcc.add("1707");
		hashCmcc.add("1708");
		hashCmcc.add("1709");
		hashCmcc.add("1710");
		hashCmcc.add("1711");
		hashCmcc.add("1712");
		hashCmcc.add("1713");
		hashCmcc.add("1714");
		hashCmcc.add("1715");
		hashCmcc.add("1716");
		hashCmcc.add("1717");
		hashCmcc.add("1718");
		hashCmcc.add("1719");

		hashCDMA.add("1700");
		hashCDMA.add("1701");
		hashCDMA.add("1702");

		hashQIta.add("1707");
		hashQIta.add("1708");
		hashQIta.add("1709");
		hashQIta.add("1711");
		hashQIta.add("1712");
		hashQIta.add("1713");
		hashQIta.add("1717");
		hashQIta.add("1718");
		hashQIta.add("1719");

		NumberUtils numberUtils = new NumberUtils();
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/anhui.txt", anhui);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/beijing.txt", zhixiashi);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/fujian.txt", fujian);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/gansu.txt", gansu);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/gouangdong.txt", guangdong);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/guangxi.txt", guangxi);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/guizhou.txt", guizhou);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/hainan.txt", hainan);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/heilongjiang.txt", heilongjiang);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/henan.txt", heinan);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/hubei.txt", hubei);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/hunan.txt", hunan);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/jiangsu.txt", jiangsu);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/jiangxi.txt", jiangxi);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/jilin.txt", jilin);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/liaoning.txt", liaoning);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/neimenggu.txt", neimenggu);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/ningxia.txt", ningxia);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/qinghai.txt", qinghai);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/shandong.txt", shandong);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/shanxi.txt", shanxi);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/shanxii.txt", shanxixi);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/sichuan.txt", sichuan);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/tangshan.txt", heibei);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/xinjiang.txt", xinjiang);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/xizang.txt", xizang);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/yunnan.txt", yunan);
		numberUtils.SaveReadFile("/Users/ZhangQian/Desktop/RiskModle/LocationClerad/zhejiang.txt", zhejiang);
		
		hashMap.put("安徽省", anhui);
		hashMap.put("直辖市", zhixiashi);
		hashMap.put("福建省", fujian);
		hashMap.put("甘肃省", gansu);
		hashMap.put("广东省", guangdong);
		hashMap.put("广西省", guangxi);
		hashMap.put("贵州省", guizhou);
		hashMap.put("海南省", hainan);
		hashMap.put("黑龙江省", heilongjiang);
		hashMap.put("河南省", heinan);
		hashMap.put("湖北省", hubei);
		hashMap.put("湖南省", hunan);
		hashMap.put("江苏省", jiangsu);
		hashMap.put("江西省", jiangxi);
		hashMap.put("吉林省", jilin);
		hashMap.put("辽宁省", liaoning);
		hashMap.put("内蒙古", neimenggu);
		hashMap.put("宁夏省", ningxia);
		hashMap.put("青海省", qinghai);
		hashMap.put("山东省", shandong);
		hashMap.put("山西省", shanxi);
		hashMap.put("陕西省", shanxixi);
		hashMap.put("四川省", sichuan);
		hashMap.put("河北省", heibei);
		hashMap.put("新疆省", xinjiang);
		hashMap.put("西藏省", xizang);
		hashMap.put("云南省", yunan);
		hashMap.put("浙江省", zhejiang);

		numberUtils.CheckFromNumber("/Users/ZhangQian/Desktop/RiskModle/number_value/black.txt", hashMap);
	
	}

	
	 public void SaveReadFile(String filePath ,HashSet<String> hashset){
		 
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
	            	String  tempstr = str.trim();
//	            	System.out.println("个数：" + count +  "内容："+ str);            		            	
	            	hashset.add(tempstr); 	
//	            	createFile("/Users/ZhangQian/Desktop/blacklist/tencent_jice_15k_tels_decode.txt", str.getBytes());
//	            	createFile("/Users/ZhangQian/Desktop/blacklist/130.txt", str.getBytes());
	            }
	        }catch (Exception e){
	        	System.out.println("异常信息：" + e.getMessage());
	        }
	        }
	 
	 public void CheckFromNumber(String filePath ,HashMap<String, HashSet<String>> hashMap){
		 
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
	            	System.out.println("个数：" + count +  "内容："+ str);
	            	
	            	if(tempstr[2].equals("知")){
	            		continue;
	            	}
	            	String local = tempstr[1] + "市";
	            	String SimMobile = tempstr[2];
	            	String SimType = tempstr[3];
	            	int i = 0;
	            	//循环遍历map集合
	        		for (Entry<String, HashSet<String>> entry : hashMap.entrySet()) {
	        			i++;
	        			String province = entry.getKey();
	        			HashSet<String> tempHashSet  = entry.getValue();
	        			if(tempHashSet.contains(local)){
	        				System.out.println(tempHashSet);
	        				//归属地判断
	        				if(SimMobile.contains("移动")){
	        					SimMobile = "中国移动";
	        				}else if (SimMobile.contains("联通")) {
	        					SimMobile = "中国联通";
							}else if (SimMobile.contains("电信")) {
	        					SimMobile = "中国电信";

							}else if (hashGsm.contains(tempstr[0].substring(0, 4))) {
	        					SimMobile = "virtual-移动";

							}else if (hashCmcc.contains(tempstr[0].substring(0, 4))) {
	        					SimMobile = "virtual-联通";

							}else if (hashCDMA.contains(tempstr[0].substring(0, 4))) {
	        					SimMobile = "virtual-电信";
	        					
							}else if (hashQIta.contains(tempstr[0].substring(0, 4))) {
	        					SimMobile = "virtual-其他";
							}else {
	        					SimMobile = "其他";
							}
	        				//卡类型判断
	        				if(SimType.contains("神州行")){
	        					SimType = "神州行";
	        				}else if (SimType.contains("动感地带")) {
	        					SimType = "动感地带";

							}else if (SimType.contains("全球通")) {
	        					SimType = "全球通";
	        					
							}else if (SimType.contains("GSM") || SimType.contains("中国联通")) {
								SimType = "GSM卡";
							}else if (SimType.contains("CDMA卡") || SimType.contains("中国电信")) {
								SimType = "CDMA卡";

							}else if (SimType.contains("天翼")) {
								SimType = "天翼";

							}else {
								if(SimType != null){
									SimType = "其它";

								}else {
									SimType = "未知";
								}
							}
	        				String numberTag = "未知";
	        				if(blackhashSet.contains(tempstr[0] +":疑似诈骗")){
	        					numberTag = "sogou,疑似诈骗";
	        				}else if (blackhashSet.contains(tempstr[0] +":疑似推销")) {
	        					numberTag = "sogou,疑似推销";

							}else if (blackhashSet.contains(tempstr[0] +":疑似骚扰")) {
	        					numberTag = "sogou,疑似骚扰";

							}else if (blackhashSet.contains(tempstr[0] +":快递外卖")) {
	        					numberTag = "sogou,快递外卖";

							}else {
	        					numberTag = "其它,其它";

							}	        				
	        				String tempValue  = tempstr[0] +"," + MD5Utils.getMD5(tempstr[0]) + "," + province+ "," + local + ","+ SimMobile +"," +SimType +"," + tempstr[4]+ "," + numberTag;
	        				       								
	    	            	createFile("/Users/ZhangQian/Desktop/RiskModle/number_value/black_new.txt", tempValue.getBytes());
	        				break;
	        			}if(i == hashMap.size()){
		    	            	createFile("/Users/ZhangQian/Desktop/RiskModle/number_value/black_new_no.txt", str.getBytes());
	        			}
	        		}
	            }
	        }catch (Exception e){
            	createFile("/Users/ZhangQian/Desktop/RiskModle/number_value/black_new_no.txt", e.getMessage().getBytes());

	        	System.out.println("异常信息：" + e.getMessage());
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
	            
	            hashTest.add(str);
	            System.out.println(str);
	            	         	
	            }
	        }catch (Exception e){

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
