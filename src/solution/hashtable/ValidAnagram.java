package solution.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author By RuiCUI
 * 2018-07-05
 * Easy
 * Question 242:Valid Anagram.
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()){
			return false;
		}
		HashMap<Character,Integer> map = new HashMap();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		for(int i=0;i<t.length();i++){
			char c = t.charAt(i);
			if(map.containsKey(c)){
				if(map.get(c)==1){
					map.remove(c);
				}else{
					map.put(c,map.get(c)-1);
				}
			}else{
				return false;
			}
		}
		return true;
    }
	
	/**
	 * 答案1--Sorting
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(nlogn)
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram1(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    char[] str1 = s.toCharArray();
	    char[] str2 = t.toCharArray();
	    Arrays.sort(str1);
	    Arrays.sort(str2);
	    return Arrays.equals(str1, str2);
	}
	
	/**
	 * 答案2--Hash Table
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram2(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] counter = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        counter[s.charAt(i) - 'a']++;
	        counter[t.charAt(i) - 'a']--;
	    }
	    for (int count : counter) {
	        if (count != 0) {
	            return false;
	        }
	    }
	    return true;
	}
	public boolean isAnagram3(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] table = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        table[s.charAt(i) - 'a']++;
	    }
	    for (int i = 0; i < t.length(); i++) {
	        table[t.charAt(i) - 'a']--;
	        if (table[t.charAt(i) - 'a'] < 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		System.out.println(isAnagram(s,t));
	}

}
