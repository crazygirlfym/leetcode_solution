package leetcode;

public class Solution_693 {
	public boolean hasAlternatingBits(int n) {
		int num = n;	
		int base = 2;
		int lastnum=2;
		while(num != 0) {
			int ss = (num % base);
			num = num /base;
			if(lastnum!=2) {
				if(ss==lastnum) return false;
					lastnum = ss;	
			}else {
				lastnum =ss;
			}
			
		}
		return true;
    }
    
    public static void main(String[] args) {
    		Solution_693 s = new Solution_693();
    		System.out.println(s.hasAlternatingBits(11));
	}
}
