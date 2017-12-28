package leetcode_top100;

import java.util.HashMap;
import java.util.Map;

public class Solution_70Climbing_Stairs {
	Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	
	public int climbStairs(int n) {
		//递归超时了，说明有一些重复的部分，要记录一下
		
		
//        if(n==1 || n==0) return 1;
//        	return climbStairs(n-1) + climbStairs(n-2);
		
		if(count.containsKey(n)) {
			return count.get(n);
		}
		if(n==1 || n==0) return 1;
		
		int value =climbStairs(n-1) + climbStairs(n-2);
		count.put(n, value);
		return value;
		
		
		
    }
	public static void main(String[] args) {
		Solution_70Climbing_Stairs s = new Solution_70Climbing_Stairs();
		System.out.println(s.climbStairs(2));
	}
}
