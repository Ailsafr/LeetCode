package solution.string;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author By RuiCUI
 * 2019-11-01
 * Medium
 * Question 151:Reverse Words in a String.
 * Given an input string, reverse the string word by word.
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up:
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class ReverseWordsInAString {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		String result = "";
		String[] array = s.split(" ");
		int len = array.length;
		for (int i=len-1;i>=0;i--) {
			if (!"".equals(array[i])) {
				result +=  array[i] + " ";
			}
		}
		return result.trim();
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public String reverseWords1(String s) {
	    if (s == null) return null;
	    
	    char[] a = s.toCharArray();
	    int n = a.length;
	    
	    // step 1. reverse the whole string
	    reverse(a, 0, n - 1);
	    // step 2. reverse each word
	    reverseWords(a, n);
	    // step 3. clean up spaces
	    return cleanSpaces(a, n);
	}
	void reverseWords(char[] a, int n) {
	    int i = 0, j = 0;
	      
	    while (i < n) {
	    	while (i < j || i < n && a[i] == ' ') i++; // skip spaces
	    	while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
	    	reverse(a, i, j - 1);                      // reverse the word
	    }
	}
	// trim leading, trailing and multiple spaces
	String cleanSpaces(char[] a, int n) {
	    int i = 0, j = 0;
	    while (j < n) {
	    	while (j < n && a[j] == ' ') j++;             // skip spaces
	    	while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
	    	while (j < n && a[j] == ' ') j++;             // skip spaces
	    	if (j < n) a[i++] = ' ';                      // keep only one space
	    }
	    return new String(a).substring(0, i);
	}
	// reverse a[] from a[i] to a[j]
	private void reverse(char[] a, int i, int j) {
	    while (i < j) {
	    	char t = a[i];
	    	a[i++] = a[j];
	    	a[j--] = t;
	    }
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public String reverseWords2(String s) {
	    String[] words = s.trim().split(" +");
	    Collections.reverse(Arrays.asList(words));
	    return String.join(" ", words);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static String reverseWords3(String s) {
	    StringBuilder res = new StringBuilder();
	    for (int start = s.length() - 1; start >= 0; start--) {
	        if (s.charAt(start) == ' ') continue;
	        int end = start;
	        while (start >= 0 && s.charAt(start) != ' ') start--;
	        res.append(s.substring(start + 1, end + 1)).append(" ");
	    }
	    return res.toString().trim();
	}
	
	public static void main(String[] args){
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
	
}
