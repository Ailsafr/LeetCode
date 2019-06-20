package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-06-20
 * Medium
 * Question 22:Generate Parentheses.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
 */
public class GenerateParentheses {

	/**
	 * 我自己写的方法
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
	}
	
	/**
	 * 答案1--Brute Force
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
	
	/**
	 * 答案2--Backtracking
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
	
	/**
	 * 答案3--Closure Number
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis3(c))
                    for (String right: generateParenthesis3(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateParenthesis(n));
	}

}
