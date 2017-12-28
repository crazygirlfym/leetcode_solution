package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
//结果需要按升序排列
public class Solution_658 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
       List<Integer> result = new LinkedList<>();
       TreeMap<Integer, List<Integer>> map = new TreeMap<>();
       for(int i =0;i<arr.length;i++) {
    	   	int a = arr[i];
    	   	int abs = Math.abs(a-x);
    	   	if (!map.containsKey(abs)) map.put(abs, new LinkedList<>());
            map.get(abs).add(a);
       }
       for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
           for (int i : e.getValue()) {
               result.add(i);
               if (result.size() == k) break;
           }
           if (result.size() == k) break;
       }
       return result;
    }
	
	
	 
}
