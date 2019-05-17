package brainteaser;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-05-17
 * Easy
 * Question 1033:Moving Stones Until Consecutive.
 * Three stones are on a number line at positions a, b, and c.
 * Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone), 
 * and move it to an unoccupied position between those endpoints.  
 * Formally, let's say the stones are currently at positions x, y, z with x < y < z.  
 * You pick up the stone at either position x or position z, and move that stone to an integer position k, 
 * with x < k < z and k != y.
 * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
 * When the game ends, what is the minimum and maximum number of moves that you could have made?  
 * Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
 * Example 1:
 * Input: a = 1, b = 2, c = 5
 * Output: [1,2]
 * Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
 * Example 2:
 * Input: a = 4, b = 3, c = 2
 * Output: [0,0]
 * Explanation: We cannot make any moves.
 * Example 3:
 * Input: a = 3, b = 5, c = 1
 * Output: [1,2]
 * Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.
 * Note:
 * 1. 1 <= a <= 100
 * 2. 1 <= b <= 100
 * 3. 1 <= c <= 100
 * 4. a != b, b != c, c != a.
 * Hint:
 * For the minimum: We can always do it in at most 2 moves, by moving one stone next to another, 
 * then the third stone next to the other two. When can we do it in 1 move? 0 moves? 
 * For the maximum: Every move, the maximum position minus the minimum position must decrease by at least 1.
 */
public class MovingStonesUntilConsecutive {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int[] numMovesStones(int a, int b, int c) {
		int[] array = new int[]{a,b,c};
		Arrays.sort(array);
		int diff1 = array[1] - array[0] -1;
		int diff2 = array[2] - array[1] -1;
		if(diff1==0&&diff2==0){
			return new int[]{0,0};
		}else if(diff1==0||diff2==0){
			return new int[]{1,Math.max(diff1, diff2)};
		}
		return new int[]{Math.min(2, Math.min(diff1, diff2)), diff1+diff2};
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int[] numMovesStones1(int a, int b, int c) {
        int sum = a + b + c;
        int l = Math.min(a, Math.min(b, c));
        int r = Math.max(a, Math.max(b, c));
        int m = sum - l - r;
        int gap1 = m - l - 1;
        int gap2 = r - m - 1;
        int gap_min = Math.min(gap1, gap2);
        int[] ans = new int[2];
        ans[1] = gap1 + gap2;
        if(gap1 == 0 && gap2 == 0) ans[0] = 0;
        else if(gap_min <= 1) ans[0] = 1;
        else ans[0] = 2;
        return ans;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int[] numMovesStones2(int a, int b, int c) {
        if(a > c) {
            return numMovesStones2(c, b, a);
        } else if(a > b) {
            return numMovesStones2(b, a, c);
        } else if(b > c) {
            return numMovesStones2(a, c, b);
        }
        if(a + 1 == b && b + 1 == c) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        res[0] = a + 1 == b || b + 1 == c || a + 2 == b || b + 2 == c ? 1 : 2;
        res[1] = b - a - 1 + c - b - 1;
        return res;
    }
	
	public static void main(String[] args) {
		int a = 1;
		int b = 9;
		int c = 5;
		System.out.println(Arrays.toString(numMovesStones(a,b,c)));
	}

}
