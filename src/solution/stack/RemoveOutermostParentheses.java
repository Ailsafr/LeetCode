package solution.stack;

/**
 * @author By RuiCUI
 * 2019-05-10
 * Easy
 * Question 1021:Remove Outermost Parentheses.
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, 
 * where A and B are valid parentheses strings, and + represents string concatenation.  
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string S is primitive if it is nonempty, 
 * and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, 
 * where P_i are primitive valid parentheses strings.
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * Example 1:
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation: 
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation: 
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 * Input: "()()"
 * Output: ""
 * Explanation: 
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * Note:
 * 1. S.length <= 10000
 * 2. S[i] is "(" or ")"
 * 3. S is a valid parentheses string.
 * Hint:
 * Can you find the primitive decomposition? The number of ( and ) characters must be equal.
 */
public class RemoveOutermostParentheses {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public static String removeOuterParentheses(String S) {
		StringBuilder result = new StringBuilder();
        int sum = 0;
        int leftIndex = 0;
        for (int i = 0; i < S.length() ; i++) {
            char c = S.charAt(i);
            if (c%2==0)
                sum ++;
            else
                sum --;

            if (sum == 0) {
                result.append(S.substring(leftIndex + 1, i));
                leftIndex = i + 1;
            }

        }
        return result.toString();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String removeOuterParentheses1(String S) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int leftIndex = 0;
        for (int i = 0; i < S.length() ; i++) {
            char c = S.charAt(i);
            if (c%2==0)
                sum ++;
            else
                sum --;

            if (sum == 0) {
                result.append(S.substring(leftIndex + 1, i));
                leftIndex = i + 1;
            }

        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		String S = "(()())(())";
		System.out.println(removeOuterParentheses(S));
	}

}
