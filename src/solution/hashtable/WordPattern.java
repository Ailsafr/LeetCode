package solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-07-16
 * Easy
 * Question 290:Word Pattern.
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static boolean wordPattern(String pattern, String str) {
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> map1 = new HashMap<String,String>();
		String[] strs = str.split(" ");
		int len = strs.length;
		if(len!=pattern.length()){
			return false;
		}
		for(int i=0;i<len;i++){
			if(map.get(strs[i])==null){
				map.put(strs[i],pattern.substring(i,i+1));
			}else{
				if(!map.get(strs[i]).toString().equals(pattern.substring(i,i+1))){
					return false;
				}
			}
		}
		for(int i=0;i<len;i++){
			if(map1.get(pattern.substring(i,i+1))==null){
				map1.put(pattern.substring(i,i+1),strs[i]);
			}else{
				if(!map1.get(pattern.substring(i,i+1)).equals((strs[i]).toString())){
					return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,巧妙的用了map的put方法返回值
	 * Map集合的key是唯一的，如果使用put方法存储，当key重复时，put方法返回原来的value值。
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param pattern
	 * @param str
	 * @return
	 */
	public boolean wordPattern1(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map<Object, Integer> index = new HashMap<Object, Integer>();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,巧妙的用了map的containsValue这个方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param pattern
	 * @param str
	 * @return
	 */
	public boolean wordPattern2(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }    
        }
        return true;
    }
	
	public static void main(String[] args) {
		String t = "dog cat cat dog";
		String s = "abba";
		System.out.println(wordPattern(s,t));
	}

}
