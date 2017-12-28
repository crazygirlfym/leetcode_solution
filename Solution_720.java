package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_720 {
	public String longestWord(String[] words) {
		Arrays.sort(words);
        Set<String> set = new HashSet<String>();
        String max = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1 || set.contains(words[i].substring(0, words[i].length() - 1))) {
                set.add(words[i]);
                if (max.length() < words[i].length()) max = words[i];
            }
        }
        return max;
    }
}
