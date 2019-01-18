package solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-01-18
 * Easy
 * Question 748:Shortest Completing Word.
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. 
 * Such a word is said to complete the given string licensePlate
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * The license plate might have the same letter occurring multiple times. 
 * For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, 
 * but the word "supper" does.
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * 1. licensePlate will be a string with length in range [1, 7].
 * 2. licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * 3. words will have a length in the range [10, 1000].
 * 4. Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 * Hint:
 * Count only the letters (possibly converted to lowercase) of each word. 
 * If a word is shorter and the count of each letter is at least the count of that letter in the licensePlate, 
 * it is the best answer we've seen yet.
 */
public class ShortestCompletingWord {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param licensePlate
	 * @param words
	 * @return
	 */
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		licensePlate = licensePlate.toLowerCase();
		char[] license = licensePlate.toCharArray();
		Map<Character,Integer> licenseMap = new HashMap<Character,Integer>();
		for(char c:license){
			if(c>='a'&&c<='z'){
				int n = licenseMap.getOrDefault(c, 0);
				licenseMap.put(c, n+1);
			}
		}
		String result = "";
		for(String str:words){
			boolean ok = true;
			for(char c:licenseMap.keySet()){
				int n = licenseMap.get(c);
				if(str.length()-str.replaceAll(c+"", "").length()<n){
					ok = false;
					break;
				}
			}
			if(ok){
				if("".equals(result)){
					result = str;
				}else{
					result = result.length()>str.length()?str:result;
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param licensePlate
	 * @param words
	 * @return
	 */
	private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}; 
    public String shortestCompletingWord1(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                    shortest = word;
        return shortest;
    }
    private long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25) 
                product *= primes[index];
        }
        return product;
    }

	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param licensePlate
	 * @param words
	 * @return
	 */
    public String shortestCompletingWord2(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        int [] charMap = new int[26];
        // Construct the character map
        for(int i = 0 ; i < target.length(); i++){
            if(Character.isLetter(target.charAt(i))) charMap[target.charAt(i) - 'a']++;
        }
        int minLength = Integer.MAX_VALUE;
        String result = null;
        for (int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            if(matches(word, charMap) && word.length() < minLength) {
                minLength = word.length();
                result  = words[i];
            }
        }
        return result;
    }
    private boolean matches(String word, int[] charMap){
        int [] targetMap = new int[26];
        for(int i = 0; i < word.length(); i++){
            if(Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(charMap[i]!=0 && targetMap[i]<charMap[i]) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String licensePlate = "1s3 PSt";
		String[] words = {"step", "steps", "stripe", "stepple"};
		System.out.println(shortestCompletingWord(licensePlate,words));
	}

}
