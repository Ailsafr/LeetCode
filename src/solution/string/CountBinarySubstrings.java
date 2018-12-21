package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2018-12-21
 * Easy
 * Question 696:Count Binary Substrings.
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, 
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 * 1.s.length will be between 1 and 50,000.
 * 2.s will only consist of "0" or "1" characters.
 * Hint:
 * How many valid binary substrings exist in "000111", and how many in "11100"? What about "00011100"?
 */
public class CountBinarySubstrings {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int countBinarySubstrings(String s) {
		int result = 0;
		if(s.length()<2){
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();
		int len = s.length();
		int n = 1;
		for(int i=0;i<len-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				n++;
			}else{
				list.add(n);
				n=1;
			}
		}
		list.add(n);
		int lenL = list.size();
		for(int i=0;i<lenL-1;i++){
			result += Math.min(list.get(i), list.get(i+1));
		}
		return result;
	}
	
	/**
	 * 答案1-- Group By Character[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n) 
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings1(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
	
	/**
	 * 答案2--Linear Scan[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings2(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
	
	public static void main(String[] args) {
		//String s = "00110011";
		String s = "10101";
		System.out.println(countBinarySubstrings(s));
	}

}
