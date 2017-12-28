package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_551 {
	    public boolean checkRecord(String s) {
	        
	    Map<String, Integer> map = new HashMap<String,Integer>();
	    map.put("A", 0);
	    map.put("L", 0);
	    map.put("P", 0);
	    for(int i=0;i<s.length();i++) {
	    		String key = s.charAt(i) + "";
	    		if (map.containsKey(key)) {
	    			map.put(key, map.get(key)+1);
	    		}else {
	    			map.put(key, 1);
	    		}
	    		
	    	
	    }
	    if (map.get("A") <=1 && map.get("L") <=2) {
	    	 return true;
	    }else {
	    	return false;
	    }
	    
	    
	    }
	    public static void main(String[] args) {
	    	Solution_551 s = new Solution_551();
	    	System.out.println(s.checkRecord("PPALLP"));
		}
	
}
