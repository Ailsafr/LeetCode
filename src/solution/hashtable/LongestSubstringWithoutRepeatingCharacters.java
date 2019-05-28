package solution.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-05-28
 * Medium
 * Question 3:Longest Substring Without Repeating Characters.
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int max = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int len = s.length();
		for(int i=0;i<len;i++){
			char c = s.charAt(i);
			if(map.get(c)!=null){
				max = map.size();
				result = Math.max(max, result);
				i = map.get(c);
				map.clear();
			}else{
				map.put(c, i);
			}
		}
		max = map.size();
		result = Math.max(max, result);
		return result;
    }
	
	/**
	 * 答案1--Brute Force
	 * 时间复杂度：O(n^3) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
	
	/**
	 * 答案2--Sliding Window
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    
    /**
	 * 答案3--Sliding Window Optimized(Using HashMap)
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
    /**
	 * 答案4--Sliding Window Optimized(Assuming ASCII 128)
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    
	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
