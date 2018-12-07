package com.data.structure;

import java.util.HashSet;
import java.util.LinkedList;

public class SubStringTest {
	
	
	public static void main(String[] args) {
		
		SubStringTest stringTest = new SubStringTest();
//		stringTest.getSubString("abcabcbb");
		int  num = stringTest.getMaxIndex("dvdf");
		System.out.println("最长子字符串的长度："+ num);
	}
	
	public String getSubString(String paramers){
		
		
		HashSet<String > hashSet = new HashSet<String>();
		for(int i = 0; i < paramers.length(); i++){
			for(int j = i+1; j <paramers.length(); j++){				
				String temp = paramers.substring(i,j);
				boolean flag = getChars(temp);
				if(!flag){
					hashSet.add(temp);
				}
				
			}
			
		}
		
		
		for(String str : hashSet){
			System.out.println(str);
		}
		
		
		
		return "";
	}
	
	/**
	     * 判断字符串是否包含重复字符
	     * @param str
	     * @return
	     */
	
	public static boolean getChars(String str){
		if(str == null || str.isEmpty()){
			return false;
		}
		char [] elements = str.toCharArray();
		for(char e : elements){
			if(str.indexOf(e) != str.lastIndexOf(e)){
				return true;
			}
		}
		
		return false;
	}
	
	//字符串最大子串检索
	public int getMaxIndex(String str){
		
		LinkedList<Character> linkedList = new LinkedList<Character>();
		int nun = 0;
		int current = 0;
		char[] arr = str.toCharArray();
		for(int i=0; i<arr.length; i++){
			if(linkedList.contains(arr[i])){
				
				linkedList.add(arr[i]);
				int first=linkedList.indexOf(arr[i]);//得到字符在链表中首次出现的位置
				for(int j = 0; j <= first; j++){
					//循环删除出现位置之前的子串
					linkedList.remove();
				}
			}else {
				//链表中不存在此字符，添加字符到链表
				linkedList.add(arr[i]);
				current = linkedList.size();
				//实时更新链表的长度
				if(current > nun){
					nun = current;
				}
			}
			
		}
		for(Character c:linkedList){
			System.out.println("字符串"+ c);
		}
		return nun;
		
	}

	
	 public int lengthOfLongestSubstring(String s)
	    {
	        int num=0;//记录最长子串长度
	        int current=0;//记录当前子串长度
	        char[] arr=s.toCharArray();
	        LinkedList<Character> temp=new LinkedList<>();

	        for (int i=0;i<arr.length ;i++ )
	        {
	            if (!temp.contains(arr[i]))
	            {
	                temp.add(arr[i]);
	                current=temp.size();
	                if (current>num)
	                    num=current;
	            }
	            else//如果新增字符与原子串中字符有重复的，删除原子串中重复字符及在它之前的字符，与新增字符组成新的子串
	            {
	                temp.add(arr[i]);
	                int first=temp.indexOf(arr[i]);

	                for (int j=0;j<first ;j++ )
	                    temp.remove();
	                
//	                temp.remove();    
	            }
	        }
	        return num;
	    }



}
