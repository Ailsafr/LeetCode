package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-02-01
 * Easy
 * Question 806:Number of Lines To Write String.
 * We are to write the letters of a given string S, from left to right into lines. 
 * Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, 
 * it is written on the next line. We are given an array widths, an array where widths[0] is the width of 'a', 
 * widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * Now answer two questions: how many lines have at least one character from S, and what is the width used by the last such line? 
 * Return your answer as an integer list of length 2.
 * Example :
 * Input: 
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation: 
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 * Example :
 * Input: 
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * Output: [2, 4]
 * Explanation: 
 * All letters except 'a' have the same length of 10, and 
 * "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
 * For the last 'a', it is written on the second line because
 * there is only 2 units left in the first line.
 * So the answer is 2 lines, plus 4 units in the second line.
 * Note:
 * 1.The length of S will be in the range [1, 1000].
 * 2.S will only contain lowercase letters.
 * 3.widths is an array of length 26.
 * 4.widths[i] will be in the range of [2, 10].
 */
public class NumberOfLinesToWriteString {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(S.length)
	 * 空间复杂度：O(1)
	 * @param widths
	 * @param S
	 * @return
	 */
	public static int[] numberOfLines(int[] widths, String S) {
		int line = 1;
		int res = 0;
		for(char c:S.toCharArray()){
			int n = widths[c-'a'];
			if(res+n>100){
				line += 1;
				res = n;
			}else{
				res += n;
			}
		}
		return new int[]{line,res};
    }
	
	/**
	 * 答案--Insert Each Character[Accepted]，跟我的答案一样 
	 * 时间复杂度：O(S.length)
	 * 空间复杂度：O(1)
	 * @param widths
	 * @param S
	 * @return
	 */
	public int[] numberOfLines1(int[] widths, String S) {
        int lines = 1, width = 0;
        for (char c: S.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }
        return new int[]{lines, width};
    }
	
	public static void main(String[] args) {
		int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String S = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(Arrays.toString(numberOfLines(widths,S)));
	}

}
