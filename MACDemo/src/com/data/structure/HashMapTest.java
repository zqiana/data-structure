package com.data.structure;

import java.util.HashMap;


public class HashMapTest {
	
	
	public static void main(String[] args) {
		
		//HashMap的key如果相同的话，最新存入的value则会覆盖原来的value
		//我们需要关注hashMap key值不一样，但hashCode一样的情况，这种就是hash冲突，这时会在调用key的
		HashMap<String, String> hashMap = new HashMap<>();
		
		hashMap.put("a", "11");
		hashMap.put("b", "22");
		for(String key :hashMap.keySet()){
			
	         System.out.println("Key: "+key+" Value: "+hashMap.get(key));
	
		}

	
		   
	}

}
