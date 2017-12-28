package leetcode;

public class Solution_686 {
	public int repeatedStringMatch(String A, String B) {
        String as = A;
        for(int rep=1; rep<= B.length() /A.length() + 2; rep++, as += A) {
        		 if (as.indexOf(B)!= -1) return rep;
        }
        return -1;
    }
}
