package leetcode_top100;

public class Solution_First_Unique_Character_in_a_String {
	// 找到第一个不重复的字符
	public int firstUniqChar(String s) {
		
		int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
        
    }
}
