package solution.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-01-24
 * Easy
 * Question 771:Jewels and Stones.
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. 
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * 1.S and J will consist of letters and have length at most 50.
 * 2.The characters in J are distinct.
 * Hint:
 * For each stone, check if it is a jewel.
 */
public class JewelsAndStones {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param J
	 * @param S
	 * @return
	 */
	public static int numJewelsInStones(String J, String S) {
		int len = S.length();
		int result = 0;
		for(int i=0;i<len;i++){
			char c = S.charAt(i);
			if(J.contains(c+"")){
				result += 1;
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones1(String J, String S) {
	    return S.replaceAll("[^" + J + "]", "").length();
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(m+n) 
	 * 空间复杂度：O(m)
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones2(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray()) setJ.add(j);
        for (char s: S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones3(String J, String S) {
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1)
                count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
	}

}
