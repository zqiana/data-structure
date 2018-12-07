package com.admaster.ad.cn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class HashTest {
	
	private String[] name;//关键字
	private int sum;//当前容量
	private static int count;
	public HashTest(){
		name=new String[4096];
		sum=0;
	}
	
	public static void main(String[] args) {
				HashTest t=new HashTest();
				HashSet<String> hashSet = new HashSet<String>();
				t.SaveHashFile("/Users/ZhangQian/Desktop/blacklist/133.txt", hashSet);
//				t.print();13393257578
			
			      for(int i = 0; i <=9; i++){
		                gene("1330"+i,1,hashSet);
		         }
			      

//				String teststr="13109419672:快递外卖";
//				if(t.contains(teststr)){
//					System.out.println("YES");
//				}else{
//					System.out.println("NO");
//				}

	}
	
	 public static String gene(String s,int level,HashSet<String> hashTest){
	        if(level == 7){
//	            result.add(s);
	        	//得到电话号码，去数据库中查询
//	        	decrypt.a(s);
	        	 String HTML;
	        	 count ++;
				try {
					
//					Thread.sleep(5000);
					if(hashTest.contains(s)){
		            	System.out.println("数据库中已有电话号码：" + s);
					}

//		            List<String> imgUrl = cm.getImageUrl(HTML,s);
//		        	cm.createFile("/Users/ZhangQian/Desktop/numbertest/tengxunceshi.txt", s.getBytes());

//	            	System.out.println(count);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             //获取图片标签
	            return s;
	        }
	        for (int i = 0; i <= 9 ; i++) {
	            gene(s+i,level+1,hashTest);
	        }
	        return  s;
	    }
	
	
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
	 

	 public void ReadFile(String filePath,LinkedList<String> linkedList){

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
	            
	            linkedList.add(str);
	            	         	
	            }
	        }catch (Exception e){

	        }
	        }
	
		//添加字符串到hash表
		public void add(String s){
			if(sum>=this.name.length/2){
				this.refresh();
			}
			int start=hash1(s);
			int i=start;
			while(name[i]!=null){
				if(name[i].equals(s)){
					return ;
				}
				i=(i+hash2(s))%name.length;
				if(i==start){
					return ;
				}
			}
			name[i]=s;
			sum++;		
		}
		
		//因为长度不够，扩充hash表
		public void refresh(){
			HashTest t=new HashTest();
			t.name=new String[this.name.length*30];
			int i=0;
			for(i=0;i<name.length;i++){
				if(this.name[i]!=null){
					t.add(this.name[i]);
				}
			}
			this.name=t.name;
			this.sum=t.sum;
		}
		
		//正常的hash函数
		public int hash1(String s){
			return Math.abs(s.hashCode()% name.length);
		}
		//处理冲突的hash函数
		public int hash2(String s){
			int result=Math.abs(s.hashCode()%(name.length-1));
			if(result%2==0){
				return result+1;
			}
			return result;
		}
		
		public boolean contains(String s){
			int start=hash1(s);
			int i=start;
			System.out.println("手机号的hash值：" + i);
			System.out.println("手机号的数组长度值：" + name.length);

			while(name[i]!=null){
				if(name[i].equals(s)){
					return true;
				}
				i=(i+hash2(s)%name.length);
				if(i==start){
					return false;
				}
			}

			return false;
		}

		//打印所有的hash键值对
		 public void print(){                       //输出哈希表中所有元素
		     for(int i = 0; i < name.length; i ++){
//		        System.out.println(i+":"+name[i]);
		    }
		  }





}
