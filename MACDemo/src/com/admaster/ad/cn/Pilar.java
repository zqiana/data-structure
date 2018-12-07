package com.admaster.ad.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pilar {
	
public static void main(String[] args) {
	 // 从键盘接收数据	
	 Scanner scan = new Scanner(System.in);    
     int totalNum = scan.nextInt();
     int countNum = scan.nextInt()-1;
     int start  = scan.nextInt();
     Pilar t  = new Pilar();
     t.getPilars(totalNum,countNum,start);
    }
	//约瑟夫环算法
	public int getPilars(int totalNum, int countNum, int k){
		int result = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i =1; i <= totalNum; i++){
			list.add(i);
		}
		while(list.size() > 0){
			//第K个人开始计数
			countNum =  countNum + k ;
			//第m人的索引位置
			countNum = countNum % (list.size()) -1;
			//判断是否到队尾
			if(countNum < 0){					        
                result =  list.get(list.size() - 1);
                list.remove(list.size() - 1);
                countNum = 0;
			}else {
		  //如果未到队尾，这时候删除元素后，链表的长度会-1，之后的所有元素位置都会前移一位，所以下一个开始的位置的index会-1，
		  //因为链表长度已经-1，所以不用对链表做任何操作
				list.remove(countNum);
			}					
		}	
        System.out.println(result);
		return result;
	}
}
