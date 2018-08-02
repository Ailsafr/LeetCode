package solution.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-08-02
 * Easy
 * Question 387:First Unique Character in a String.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	 public static int firstUniqChar(String s) {
		 Map<Character,Integer> map = new HashMap<Character,Integer>();
		 for(int i=0;i<s.length();i++){
			 char c = s.charAt(i);
			 if(map.get(c)!=null){
				 map.put(c, map.get(c)+1);
			 }else{
				 map.put(c,1);
			 }
		 }
		 for(int i=0;i<s.length();i++){
			 char c = s.charAt(i);
			 if(map.get(c)==1){
				 return i;
			 }
		 }
		 return -1;
	 }
	
	/**
	 * 官网没有solution,这是其他人的答案,用的数组,跟我的思路一样
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public int firstUniqChar1(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,遍历一次
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,用两个指针
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public int firstUniqChar3(String s) {
        if (s==null || s.length()==0) return -1;
        int len = s.length();
        if (len==1) return 0;
        char[] cc = s.toCharArray();
        int slow =0, fast=1;
        int[] count = new int[256];
        count[cc[slow]]++;
        while (fast < len) {
            count[cc[fast]]++;
            // if slow pointer is not a unique character anymore, move to the next unique one
            while (slow < len && count[cc[slow]] > 1) slow++;  
            if (slow >= len) return -1; // no unique character exist
            if (count[cc[slow]]==0) { // not yet visited by the fast pointer
                count[cc[slow]]++; 
                fast=slow; // reset the fast pointer
            }
            fast++;
        }
        return slow;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,借助IndexOf和lastIndexOf方法，很巧妙
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int firstUniqChar4(String s) {
		char[] a = s.toCharArray();
		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}

}
