package solution.string;

/**
 * @author By RuiCUI
 * 2018-12-13
 * Easy
 * Question 680:Valid Palindrome II.
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n is the length of the string.
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public static boolean validPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
	public static boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
	
	/**
	 * 答案1--Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(n^2) n is the length of the string.
	 * 空间复杂度：O(n) n is the length of the string.
	 * @param s
	 * @return
	 */
	public boolean validPalindrome1(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if (isPalindrome(sb)) return true;
            sb.insert(i, c);
        }
        return isPalindrome(s);
    }
	
	public boolean isPalindrome(CharSequence s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * 答案2--Greedy[Accepted]
	 * 时间复杂度：O(n) n is the length of the string.
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public boolean validPalindrome2(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange1(s, i+1, j) ||
                        isPalindromeRange1(s, i, j-1));
            }
        }
        return true;
    }
	public boolean isPalindromeRange1(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    
	
	public static void main(String[] args) {
		//String s = "aba";
		//String s = "abca";
		String s = "ebcbbececabbacecbbcbe";
		System.out.println(validPalindrome(s));
	}

}
