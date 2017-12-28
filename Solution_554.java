package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_554 {
	public int leastBricks(List<List<Integer>> wall) {
        int row = wall.size();
        
        int max = 0;
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        for (int i=0 ;i<row;i++) {
       	 	int position = 0;
       	 	for(int j=0; j<wall.get(i).size();j++) {
       	 		position += wall.get(i).get(j);
       	 		if (count.containsKey(position)) {
       	 			int newvalue = count.get(position) + 1;
       	 			count.put(position, newvalue);
       	 			if (max < newvalue) {
       	 				if (j != wall.get(i).size()-1) {
       	 				max  = newvalue;
       	 				}
       	 			}
       	 		}else {
       	 			if(max < 1) {
       	 				max = 1;
       	 			}
       	 			count.put(position, 1);
       	 		}
       	 		
       	 	}
       	 	
       	 	
       	 
        }
        return row -max;
        
       
        
   }
	
	
	public static void main(String[] args) {
		Solution_554 s = new Solution_554();
		List l = new ArrayList<List>();
		List<Integer> l2 = new ArrayList();
		l2.add(1);
		l2.add(2);
		l2.add(2);
		l2.add(1);
		l.add(l2);
		
		List<Integer> l3 = new ArrayList();
		l3.add(3);
		l3.add(1);
		l3.add(2);
		
		l.add(l3);
		
		List<Integer> l4 = new ArrayList();
		l4.add(1);
		l4.add(3);
		l4.add(2);
		
		l.add(l4);
		
		List<Integer> l5 = new ArrayList();
		l5.add(2);
		l5.add(4);
		l.add(l5);
		
		List<Integer> l6 = new ArrayList();
		l6.add(1);
		l6.add(3);
		l6.add(2);
		l.add(l6);
		
		
		List<Integer> l7 = new ArrayList();
		l7.add(1);
		l7.add(3);
		l7.add(1);
		l7.add(1);
		l.add(l7);
		System.out.println(s.leastBricks(l));
		
		
	}
}
