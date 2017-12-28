package leetcode_top100;

public class Solution_Count_and_Say {
	
	public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev ;
        int count;
        char say;
        for(int i=1;i<n;i++) {
        		prev = curr;
        		curr = new StringBuilder();
        		count = 1;
        		say = prev.charAt(0);
        		for(int j =1, len= prev.length(); j<len;j++) {
        				if(prev.charAt(j) != say) {
        					curr.append(count).append(say);
        					count =1;
        					say = prev.charAt(j);
        				}else count ++;
        			
        		}
        		curr.append(count).append(say);
        		System.out.println(curr.toString());
        }
        return curr.toString();
    }
	public static void main(String[] args) {
		Solution_Count_and_Say s = new Solution_Count_and_Say();
		System.out.println(s.countAndSay(4));
	}
}
