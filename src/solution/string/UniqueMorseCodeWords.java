package solution.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-01-31
 * Easy
 * Question 804:Unique Morse Code Words.
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, 
 * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", 
 * (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation: 
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 * 1.The length of words will be at most 100.
 * 2.Each words[i] will have length in range [1, 12].
 * 3.words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(S) where S is the sum of the lengths of words in words.
	 * 空间复杂度：O(S) where S is the sum of the lengths of words in words.
	 * @param words
	 * @return
	 */
	 public static int uniqueMorseRepresentations(String[] words) {
		 String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		 int result = 0;
		 if(words==null||words.length==0){
			 return result;
		 }
		 Set<String> set = new HashSet<String>();
		 int len = words.length;
		 for(int i=0;i<len;i++){
			 String str = words[i];
			 String s = "";
			 for(char c:str.toCharArray()){
				 s += morse[c-97];
			 }
			 set.add(s);
		 }
		 result = set.size();
		 return result;
	 }
	
	/**
	 * 答案--Hash Set[Accepted],跟我的答案一样
	 * 时间复杂度：O(S) where S is the sum of the lengths of words in words.
	 * 空间复杂度：O(S) where S is the sum of the lengths of words in words.
	 * @param words
	 * @return
	 */
	public int uniqueMorseRepresentations1(String[] words) {
		String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
		Set<String> seen = new HashSet();
		for (String word: words) {
			StringBuilder code = new StringBuilder();
			for (char c: word.toCharArray())
				code.append(MORSE[c - 'a']);
			seen.add(code.toString());
		}
		return seen.size();
	}
	
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"}; 
		System.out.println(uniqueMorseRepresentations(words));
	}

}
