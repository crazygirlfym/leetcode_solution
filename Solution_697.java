package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_697 {
	// 首先应该要知道最大的频率是多少， 和频率最大的数字？  一遍通过 开心
		ArrayList<Integer> l = new ArrayList<Integer>();
	 	public int findShortestSubArray(int[] nums) {
	        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	        int maxcount = 0;
	        for(int num:nums) {
	        		if (count.containsKey(num)) {
	        			count.put(num, count.get(num) + 1);
	        			
	        		}else {
	        			count.put(num, 1);
	        		}
	        		maxcount = Math.max(count.get(num), maxcount);
	        }
	        
	        for(int key: count.keySet()) {
	        	 int value = count.get(key);
	        	 if(value == maxcount) {
	        		 l.add(key);
	        	 }
	        	 
	        }
	        int minlength = nums.length;
	        int i = 0;
	        int j = nums.length-1;
	        for(int k=0;k<l.size();k++) {
	        		while(i<nums.length) {
	        			if(nums[i]!= l.get(k)) i++;
	        			else break;
	        		}
	        		while(j>=0) {
	        			if(nums[j]!= l.get(k)) j++;
	        			else break;
	        		}
	        		minlength = Math.min(minlength, j-i+1);
	        	}
	        
	        
	        return minlength;
	    }
}
