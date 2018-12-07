package com.data.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeArray {
	
	
	public static void main(String[] args) {
		
		int [] arr = new int[]{-1, 0, 1, 2, -1, -4};
		ThreeArray threeArray = new ThreeArray();
		List<List<Integer>> list =  threeArray.getthreeSum(arr);

		for(List<Integer> list2 : list){

			 System.out.println(list2);
		}
	}
	
	

	    public List<List<Integer>> getthreeSum(int[] nums) {
	        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        for (int i = 0; i < nums.length; ++i) {
	            int l = i + 1, r = nums.length - 1;
	            while (l < r) {
	                ArrayList<Integer> stepRes = new ArrayList<Integer>();
	                int sum = nums[i] + nums[l] + nums[r];
	                if (sum == 0) {
	                    stepRes.add(nums[i]);
	                    stepRes.add(nums[l]);
	                    stepRes.add(nums[r]);
	                    if (!res.contains(stepRes)) // 去重
	                        res.add(stepRes);
	                }
	                if (sum <= 0) ++l;
	                else --r;
	            }
	        }
	        return res;
	    }
	

	
	 public List<List<Integer>> threeSum(int[] nums) {
		 ArrayList<List<Integer>> arrayList = new ArrayList<>();
		 HashSet<List<Integer>> hashSet = new HashSet<>();
		 int [] arr = new int[]{0,0,0};
		 for(int i = 0; i < nums.length; i++){			 
			 for(int j = i + 1; j < nums.length; j ++){
				 
				 for(int k = j + 1; k < nums.length; k ++){
					 
					 if(nums[i] + nums[j] + nums[k] == 0){
						 arr[0] = nums[i];
						 arr[1] = nums[j];
						 arr[2] = nums[k];
						 ArrayList<Integer> tempList = new ArrayList<>();
						 ArrayList<Integer> tempList1 = new ArrayList<>();

						 tempList.add(0, arr[0]);
						 tempList.add(1, arr[1]);
						 tempList.add(2, arr[2]);
						 tempList1 = tempList;
						 Collections.sort(tempList1);
						
						 if(hashSet.add(tempList1)){
							 arrayList.add(tempList);
						 }
						 tempList = null; 
//						 System.out.println(Arrays.toString(arr));
					 }			 
				 }
			 }
		 }
		return arrayList;
	        
	    }

}
