package solution.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author By RuiCUI
 * 2018-10-15
 * Easy
 * Question 520:Detect Capital.
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
	
	/**
	 * 我自己写的方法--不让用Pattern类
	 * @param word
	 * @return
	 */
	public static boolean detectCapitalUse(String word) {
		Pattern pat = Pattern.compile("([A-Z])+|([a-z])+|[A-Z]([a-z])*");
		Matcher mat = pat.matcher(word);
		if(mat.matches()){
			return true;
		}
		return false;
    }
	
	/**
	 * 我自己写的方法
	 * @param word
	 * @return
	 */
	public static boolean detectCapitalUse1(String word) {
		return word.matches("([A-Z])+|([a-z])+|[A-Z]([a-z])*");
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse2(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的一样
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse3(String word) {
	    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的一样
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse4(String word) {
        return word.equals(word.toUpperCase()) || 
               word.equals(word.toLowerCase()) ||
               Character.isUpperCase(word.charAt(0)) && 
               word.substring(1).equals(word.substring(1).toLowerCase());
    }
	
	public static void main(String[] args) {
		String word = "USA";
		System.out.println(detectCapitalUse(word));
	}

}
