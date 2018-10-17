package solution.string;

import java.util.HashMap;

/**
 * @author By RuiCUI
 * 2018-10-17
 * Easy
 * Question 521:Longest Uncommon Subsequence I.
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. 
 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. 
 * Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. 
 * If the longest uncommon subsequence doesn't exist, return -1.
 * Example 1:
 * Input: "aba", "cdc"
 * Output: 3
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
 * because "aba" is a subsequence of "aba", 
 * but not a subsequence of any other strings in the group of two strings. 
 * Note:
 * 1.Both strings' lengths will not exceed 100.
 * 2.Only letters from a ~ z will appear in input strings.
 */
public class LongestUncommonSubsequenceI {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public static int findLUSlength(String a, String b) {
		if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
	
	/**
	 * 答案1--Brute Force [Time Limit Exceeded]
	 * 时间复杂度：O(2^x+2^y) where x and y are the lengths of strings aa and bb respectively.
	 * 空间复杂度：O(2^x+2^y)
	 * @param a
	 * @param b
	 * @return
	 */
	public int findLUSlength1(String a, String b) {
        HashMap < String, Integer > map = new HashMap < > ();
        for (String s: new String[] {a, b}) {
            for (int i = 0; i < (1 << s.length()); i++) {
                String t = "";
                for (int j = 0; j < s.length(); j++) {
                    if (((i >> j) & 1) != 0)
                        t += s.charAt(j);
                }
                if (map.containsKey(t))
                    map.put(t, map.get(t) + 1);
                else
                    map.put(t, 1);
            }
        }
        int res = -1;
        for (String s: map.keySet()) {
            if (map.get(s) == 1)
                res = Math.max(res, s.length());
        }
        return res;
    }
	
	/**
	 * 答案2--Simple Solution[Accepted]
	 * 时间复杂度：O(min(x,y)) where x and y are the lengths of strings aa and bb respectively.
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public static int findLUSlength2(String a, String b) {
		if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
	
	public static void main(String[] args) {
		String a = "aba";
		String b = "cdc";
		System.out.println(findLUSlength(a,b));
	}

}
