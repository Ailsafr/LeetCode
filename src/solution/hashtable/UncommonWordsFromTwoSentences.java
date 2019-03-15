package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-03-15
 * Easy
 * Question 884:Uncommon Words from Two Sentences.
 * We are given two sentences A and B. (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Return a list of all uncommon words. 
 * You may return the list in any order.
 * Example 1:
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * Note:
 * 1. 0 <= A.length <= 200
 * 2. 0 <= B.length <= 200
 * 3. A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsFromTwoSentences {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(M+N) where M, N are the lengths of A and B respectively.
	 * 空间复杂度：O(M+N) where M, N are the lengths of A and B respectively.
	 * @param A
	 * @param B
	 * @return
	 */
	public static String[] uncommonFromSentences(String A, String B) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		List<String> list = new ArrayList<String>();
		for(String s:A.split(" ")){
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		for(String s:B.split(" ")){
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		for(String s:map.keySet()){
			if(map.get(s)==1){
				list.add(s);
			}
		}
		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * 答案1--Counting
	 * 时间复杂度：O(M+N) where M, N are the lengths of A and B respectively.
	 * 空间复杂度：O(M+N) where M, N are the lengths of A and B respectively.
	 * @param A
	 * @param B
	 * @return
	 */
	public String[] uncommonFromSentences1(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
	
	public static void main(String[] args) {
		String A = "this apple is sweet";
		String B = "this apple is sour";
		System.out.println(uncommonFromSentences(A,B));
	}

}
