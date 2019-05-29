package solution.string;

/**
 * @author By RuiCUI
 * 2019-05-29
 * Medium
 * Question 5:Longest Palindromic Substring.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * Hint:
 * 1. How can we reuse a previously computed palindrome to compute a larger palindrome?
 * 2. If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
 * 3. Complexity based hint:If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2) start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.
 */
public class LongestPalindromicSubstring {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = helper(s, i, i);
	        int len2 = helper(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2; 
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int helper(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	
	/**
	 * 答案1--Expand Around Center
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2; 
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	
	/**
	 * 答案2--Dynamic Programming
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		int n = s.length();
		String res = null;
	    
		boolean[][] dp = new boolean[n][n];
	    
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
	            
				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}
	    
		return res;
	}
	
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome1(s));
	}

}
