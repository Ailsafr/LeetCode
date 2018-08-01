package solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-08-01
 * Easy
 * Question 383:Ransom Note.
 * Given an arbitrary ransom note string and another string containing letters from all the magazines.
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<magazine.length();i++){
			char c = magazine.charAt(i);
			if(map.get(c)!=null){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c,1);
			}
		}
		for(int i=0;i<ransomNote.length();i++){
			char c = ransomNote.charAt(i);
			if(map.get(c)==null){
				return false;
			}else if(map.get(c)==1){
				map.remove(c);
			}else{
				map.put(c, map.get(c)-1);
			}
		}
		return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct1(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的一样
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> magM = new HashMap<>();
        for (char c:magazine.toCharArray()){
            int newCount = magM.getOrDefault(c, 0)+1;
            magM.put(c, newCount);
        }
        for (char c:ransomNote.toCharArray()){
            int newCount = magM.getOrDefault(c,0)-1;
            if (newCount<0)
                return false;
            magM.put(c, newCount);
        }
        return true;
    }
	
	public static void main(String[] args){
		String a = "aa";
		String b = "aab";
		System.out.println(canConstruct(a,b));
	}
	
}
