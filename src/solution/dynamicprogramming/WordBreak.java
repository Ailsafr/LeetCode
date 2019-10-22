package solution.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-10-22
 * Medium
 * Question 139:Word Break.
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false.
 */
public class WordBreak {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		boolean[] result = new boolean[len+1];
		result[0] = true;
		for (int i=1;i<=len;i++) {
			for (int j=0;j<i;j++) {
				if (result[j]&&wordDict.contains(s.substring(j, i))) {
					result[i] = true;
					break;
				}
			}
		}
		return result[len];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak1(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak2(String s, List<String> wordDict) {
	    // put all words into a hashset
	    Set<String> set = new HashSet<>(wordDict);
	    return wb(s, set);
	}
	private boolean wb(String s, Set<String> set) {
	    int len = s.length();
	    if (len == 0) {
	        return true;
	    }
	    for (int i = 1; i <= len; ++i) {
	        if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak3(String s, Set<String> wordDict) {
	    int maxWord = getMax(wordDict);
	    int len = s.length();
	    boolean[] dp = new boolean[len + 1];
	    dp[0] = true;
	    for (int i = 1; i <= len; i ++) {
	        int start = Math.max(1, i - maxWord);
	        for (int j = start; j <= i; j++) {
	            if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
	                dp[i] = true; 
	                break;
	            }
	        }
	    }
	    return dp[len];
	}
	private int getMax(Set<String> wordDict) {
	    int max = 0;
	    for (String str : wordDict) {
	        max = Math.max(max, str.length());
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak(s, wordDict));
	}

}
