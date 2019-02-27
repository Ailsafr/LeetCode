package solution.stack;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-02-27
 * Easy
 * Question 844:Backspace String Compare.
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * 1. 1 <= S.length <= 200
 * 2. 1 <= T.length <= 200
 * 3. S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(M+N) 
	 * 空间复杂度：O(1)
	 * @param S
	 * @param T
	 * @return
	 */
	public static boolean backspaceCompare(String S, String T) {
		String resultS = "";
		String resultT = "";
		for(char c:S.toCharArray()){
			if(c=='#'){
				resultS = resultS.length()>0?resultS.substring(0, resultS.length()-1):resultS;
			}else{
				resultS += c;
			}
		}
		for(char c:T.toCharArray()){
			if(c=='#'){
				resultT = resultT.length()>0?resultT.substring(0, resultT.length()-1):resultT;
			}else{
				resultT += c;
			}
		}
		return resultS.equals(resultT);
    }
	
	
	/**
	 * 答案1--Build String[Accepted]
	 * 时间复杂度：O(M+N) where M, N are the lengths of S and T respectively.
	 * 空间复杂度：O(M+N) where M, N are the lengths of S and T respectively.
	 * @param S
	 * @param T
	 * @return
	 */
	public boolean backspaceCompare1(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
	
	/**
	 * 答案2--Two Pointer[Accepted]
	 * 时间复杂度：O(M+N) where M, N are the lengths of S and T respectively.
	 * 空间复杂度：O(1) 
	 * @param S
	 * @param T
	 * @return
	 */
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		String S = "a#c";
		String T = "b";
		System.out.println(backspaceCompare(S,T));
	}

}
