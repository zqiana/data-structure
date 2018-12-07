package com.admaster.ad.cn;

import java.net.URL;

public class StringTest {
	
	
	public static void main(String[] args) {
		String testurl = "Abnlsk" ;

		String temp =testurl.split("0")[1].split("Z")[0];
		
		System.out.println(temp);
	}


}
