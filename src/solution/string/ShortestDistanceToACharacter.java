package solution.string;

/**
 * @author By RuiCUI
 * 2019-02-19
 * Easy
 * Question 821:Shortest Distance to a Character.
 * Given a string S and a character C, 
 * return an array of integers representing the shortest distance from the character C in the string.
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * Note:
 * 1.S string length is in [1, 10000].
 * 2.C is a single character, and guaranteed to be in string S.
 * 3.All letters in S and C are lowercase.
 */
public class ShortestDistanceToACharacter {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @param C
	 * @return
	 */
	public static int[] shortestToChar(String S, char C) {
		int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
	
	/**
	 * 答案--Min Array[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @param C
	 * @return
	 */
	public int[] shortestToChar1(String S, char C) {
		int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
	
	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';
		System.out.println(shortestToChar(S,C));
	}

}
