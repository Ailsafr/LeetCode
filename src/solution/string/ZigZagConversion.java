package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-05-30
 * Medium
 * Question 6:ZigZag Conversion.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
	
	/**
	 * 答案1--Sort by Row
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
	
	/**
	 * 答案2--Visit by Row
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 5;
		System.out.println(convert(s, numRows));
	}

}
