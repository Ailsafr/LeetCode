package solution.hashtable;

/**
 * @author By RuiCUI
 * 2019-04-12
 * Easy
 * Question 953:Verifying an Alien Dictionary.
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', 
 * where '∅' is defined as the blank character which is less than any other character (More info).
 * Note:
 * 1. 1 <= words.length <= 100
 * 2. 1 <= words[i].length <= 20
 * 3. order.length == 26
 * 4. All characters in words[i] and order are english lowercase letters.
 */
public class VerifyingAnAlienDictionary {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param words
	 * @param order
	 * @return
	 */
	public static boolean isAlienSorted(String[] words, String order) {
		int len = words.length;
		for(int j=0;j<len-1;j++){
			for(int i=0;i<20;i++){
				if(words[j].length()>j&&words[j+1].length()==i){
					return false;
				}
				if(order.indexOf(words[j].charAt(i))<order.indexOf(words[j+1].charAt(i))){
					break;
				}else if(order.indexOf(words[j].charAt(i))==order.indexOf(words[j+1].charAt(i))){
					continue;
				}else{
					return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * 答案--Check Adjacent Words
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param words
	 * @param order
	 * @return
	 */
	public boolean isAlienSorted1(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
	
	public static void main(String[] args) {
		String[] words = {"apple","app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words,order));
	}

}
