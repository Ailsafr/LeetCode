package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-02-21
 * Easy
 * Question 830:Positions of Large Groups.
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * The final answer should be in lexicographic order.
 * Example 1:
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Note: 1 <= S.length <= 1000.
 */
public class PositionsOfLargeGroups {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public static List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(S.length()<2){
			return result;
		}
		int start=0;
		int end=1;
		char[] array = S.toCharArray();
		int len = array.length;
		while(end!=len){
			if(array[end]==array[start]){
				end++;
			}else{
				if(end-start>2){
					List<Integer> list = new ArrayList<Integer>();
					list.add(start);
					list.add(end-1);
					result.add(list);
				}
				start = end;
				end = start+1;
			}
		}
		if(end-start>2){
			List<Integer> list = new ArrayList<Integer>();
			list.add(start);
			list.add(end-1);
			result.add(list);
		}
		return result;
    }
	
	/**
	 * 答案--Two Pointer[Accepted]
	 * 时间复杂度：O(n) where n is the length of S.
	 * 空间复杂度：O(n) where n is the length of S.
	 * @param S
	 * @return
	 */
	public List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String S = "abcdddeeeeaabbbcd";
		System.out.println(largeGroupPositions(S));
	}

}
