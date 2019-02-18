package solution.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-02-18
 * Easy
 * Question 819:Most Common Word.
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  
 * The answer is in lowercase.
 * Example:
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Note:
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWord {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param paragraph
	 * @param banned
	 * @return
	 */
	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.toLowerCase();
		String[] words = paragraph.split("[ !?',;.]");
		Map<String,Integer> map = new HashMap<String,Integer>();
		String result = "";
		for(String word:words){
			word = word.trim();
			if("".equals(word)){
				continue;
			}
			map.put(word, map.getOrDefault(word, 0)+1);
			if(map.getOrDefault(word,0)>map.getOrDefault(result, 0)&&!Arrays.asList(banned).contains(word)){
				result = word;
			}
		}
		return result;
    }
	
	/**
	 * 答案--Counting[Accepted]
	 * 时间复杂度：O(P+B), where P is the size of paragraph and B is the size of banned.
	 * 空间复杂度：O(P+B), where P is the size of paragraph and B is the size of banned.
	 * @param paragraph
	 * @param banned
	 * @return
	 */
	public String mostCommonWord1(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
	
	public static void main(String[] args) {
		String paragraph = "Bob. hIt, baLl";
		String[] banned = {"bob", "hit"};
		System.out.println(mostCommonWord(paragraph,banned));
	}

}
