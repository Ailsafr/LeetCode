package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-08-22
 * Easy
 * Question 438:Find All Anagrams in a String.
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

	/**
	 * 我自己写的方法-Time Limit Exceeded
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<p.length();i++){
			char c = p.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		for(int i=0;i<s.length()-p.length()+1;i++){
			Map<Character,Integer> map1 = new HashMap<Character,Integer>();
			for(char c:map.keySet()){
				map1.put(c, map.get(c));
			}
			for(int j=0;j<p.length();j++){
				char c = s.charAt(i+j);
				if(map1.containsKey(c)){
					if(map1.get(c)==1){
						map1.remove(c);
					}else{
						map1.put(c, map1.get(c)-1);
					}
					if(map1.isEmpty()){
						result.add(i);
					}
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(p.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == p.length()){
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams2(String s, String p) {
	    List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[256]; //character hash
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        if (hash[s.charAt(right++)]-- >= 1) count--; 
	        if (count == 0) list.add(left);
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
	    }
	    return list;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p == null || s == null || s.length() < p.length()) return res;
        int m = s.length(), n = p.length();
        for (int i = 0; i < m-n+1; i++) {
            String cur = s.substring(i, i+n);
            if (helper(cur, p)) res.add(i);
        }
        return res;
    }
    public boolean helper(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        int[] dict = new int[26];
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            dict[ch-'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            dict[ch-'a']--;
            if (dict[ch-'a'] < 0) return false;
        }
        return true;
    }
	
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @param p
	 * @return
	 */
    public List<Integer> findAnagrams4(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (p.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match++;
                }
            }
            if (i >= p.length()) {
                c = s.charAt(i - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		//String s = "cbaebabacd";
		//String p = "abc";
		String s = "abacbabc";
		String p = "abc";
		System.out.println(findAnagrams(s,p));
	}

}
