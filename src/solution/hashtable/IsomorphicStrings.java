package solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-05-22
 * Easy
 * Question 205:Isomorphic Strings.
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

	/**
	 * 我自己写的方法-Time Limit Exceeded
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isIsomorphic(String s, String t) {
		Map<String,Integer> maps = new HashMap<String,Integer>();
		Map<String,Integer> mapt = new HashMap<String,Integer>();
		String results = "";
		String resultt = "";
		int ints = 0;
		int intt = 0;
		for(int i=0;i<s.length();i++){
			if(maps.get(s.substring(i,i+1))==null){
				maps.put(s.substring(i,i+1), ints);
				results += ""+ints;
				ints++;
			}else{
				results += ""+maps.get(s.substring(i,i+1));
			}
		}
		for(int i=0;i<t.length();i++){
			if(mapt.get(t.substring(i,i+1))==null){
				mapt.put(t.substring(i,i+1), intt);
				resultt += ""+intt;
				intt++;
			}else{
				resultt += ""+mapt.get(t.substring(i,i+1));
			}
		}
		if(results.equals(resultt)){
			return true;
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic1(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                	continue;
                else
                	return false;
            }else{
                if(!map.containsValue(b))
                	map.put(a,b);
                else 
                	return false;
            }
        }
        return true;
    }
	
	/**
	 * 官网没有solution
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic2(String s, String t) {

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        int length = schar.length;
        if(length != tchar.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = schar[i];
            char tc = tchar[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案(Map集合的key是唯一的，如果使用put方法存储，当key重复时，put方法返回原来的value值。)
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isIsomorphic3(String s, String t) {
	    Map m = new HashMap();
	    for (Integer i=0; i<s.length(); ++i)
	        if (m.put(s.charAt(i), i) != m.put(t.charAt(i)+"", i)){
	        	Object ss = m.put(s.charAt(i), i);
	            return false;
	        }
	    return true;
	}
	
	public static void main(String[] args) {
		String s = "ads";
		String t = "egg";
		System.out.println(isIsomorphic3(s,t));
	}

}
