package solution.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-07-10
 * Medium
 * Question 49:Group Anagrams.
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
 * Note:
 * 1. All inputs will be in lowercase.
 * 2. The order of your output does not matter.
 */
public class GroupAnagrams {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(NKlogK) where N is the length of strs, and K is the maximum length of a string in strs.
	 * 空间复杂度：O(NK) where N is the length of strs, and K is the maximum length of a string in strs.
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(strs==null||strs.length==0){
			return result;
		}
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(String str:strs){
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String s = String.valueOf(array);
			List<String> list = map.getOrDefault(s, new ArrayList<String>());
			list.add(str);
			map.put(s, list);
		}
		result.addAll(map.values());
		return result;
    }
	
	/**
	 * 答案1--Categorize by Sorted String
	 * 时间复杂度：O(NKlogK) where N is the length of strs, and K is the maximum length of a string in strs.
	 * 空间复杂度：O(NK) where N is the length of strs, and K is the maximum length of a string in strs.
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
	
	/**
	 * 答案2--Categorize by Count
	 * 时间复杂度：O(NK) where N is the length of strs, and K is the maximum length of a string in strs.
	 * 空间复杂度：O(NK) where N is the length of strs, and K is the maximum length of a string in strs.
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}

}
