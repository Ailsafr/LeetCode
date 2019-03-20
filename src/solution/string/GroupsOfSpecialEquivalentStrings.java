package solution.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-03-20
 * Easy
 * Question 893:Groups of Special-Equivalent Strings.
 * You are given an array A of strings.
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 * Return the number of groups of special-equivalent strings from A.
 * Example 1:
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 * Example 2:
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 * Example 3:
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 * Example 4:
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 * Note:
 * 1. 1 <= A.length <= 1000
 * 2. 1 <= A[i].length <= 20
 * 3. All A[i] have the same length.
 * 4. All A[i] consist of only lowercase letters.
 */
public class GroupsOfSpecialEquivalentStrings {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(a1+a2+...+an) ai为A中第i项的length
	 * 空间复杂度：O(n) A的length
	 * @param A
	 * @return
	 */
	public static int numSpecialEquivGroups(String[] A) {
		Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

	
	/**
	 * 答案--Counting
	 * 时间复杂度：O(a1+a2+...+an) ai为A中第i项的length
	 * 空间复杂度：O(n) A的length
	 * @param A
	 * @return
	 */
	public int numSpecialEquivGroups1(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
	
	public static void main(String[] args) {
		String[] A = {"a","b","c","a","c","c"};
		System.out.println(numSpecialEquivGroups(A));
	}

}
