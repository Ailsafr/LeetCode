package solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-08-10
 * Easy
 * Question 409:Longest Palindrome.
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int longestPalindrome(String s) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] array = s.toCharArray();
		int result = 0;
		for(int i=0;i<array.length;i++){
			if(map.get(array[i])!=null){
				map.remove(array[i]);
				result += 2;
			}else{
				map.put(array[i], 1);
			}
		}
		if(map.size()!=0){
			result += 1;
		}
		return result;
    }
	
	/**
	 * 答案1--Greedy
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public int longestPalindrome1(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String s = "abccccdsddsd";
		System.out.println(longestPalindrome(s));
	}

}
