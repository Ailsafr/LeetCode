package solution.string;

/**
 * @author By RuiCUI
 * 2019-08-14
 * Medium
 * Question 91:Decode Ways.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
		if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int numDecodings1(String s) {
		int n = s.length();
	    if (n == 0) return 0;
	    
	    int[] memo = new int[n+1];
	    memo[n]  = 1;
	    memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
	    
	    for (int i = n - 2; i >= 0; i--)
	        if (s.charAt(i) == '0') continue;
	        else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
	    
	    return memo[0];
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int numDecodings2(String s) {
		if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public int numDecodings3(String s) {
	    if (s.isEmpty() || s.charAt(0) - '0' == 0)
	    {
	        return 0;
	    }
	    
	    int[] waysToDecode = new int[s.length() + 1];
	    waysToDecode[0] = 1;
	    waysToDecode[1] = 1;
	    for (int i = 1; i < s.length(); i++)
	    {
	        int curr = s.charAt(i) - '0';
	        int prev = s.charAt(i - 1) - '0';
	        
	        // can't make progress, return 0
	        if (prev == 0 && curr == 0 || (curr == 0 && (prev * 10 + curr > 26)))
	        {
	            return 0;
	        }
	        // can't use the previous value, so can only get to this state from the previous
	        else if (prev == 0 || (prev * 10 + curr) > 26)
	        {
	            waysToDecode[i + 1] = waysToDecode[i];
	        }
	        // can't use current state, can only get to this state from i - 1 state
	        else if (curr == 0)
	        {
	            waysToDecode[i + 1] = waysToDecode[i - 1];
	        }
	        // can get to this state from the previous two states
	        else
	        {
	            waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
	        }
	    }
	    
	    return waysToDecode[waysToDecode.length - 1];
	}
	
	public static void main(String[] args){
		String s = "226";
		System.out.println(numDecodings(s));
	}
	
}
