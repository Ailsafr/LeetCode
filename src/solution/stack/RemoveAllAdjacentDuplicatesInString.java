package solution.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-05-24
 * Easy
 * Question 1047:Remove All Adjacent Duplicates In String.
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Note:
 * 1. 1 <= S.length <= 20000
 * 2. S consists only of English lowercase letters.
 * Hint:
 * Use a stack to process everything greedily.
 */
public class RemoveAllAdjacentDuplicatesInString {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public static String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<Character>();
		for(char c:S.toCharArray()){
			if(stack.isEmpty()){
				stack.push(c);
			}else{
				char item = stack.peek();
				if(c==item){
					stack.pop();
				}else{
					stack.push(c);
				}
			}
		}
		String result = "";
		for(Iterator<Character> iter = stack.iterator();iter.hasNext();){
			result += iter.next();
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String removeDuplicates1(String S) {
        char[] stack = S.toCharArray();
        int i = 0;
        for (int j = 0; j < S.length(); ++j)
            if (i > 0 && stack[i - 1] == S.charAt(j))
                --i;
            else
                stack[i++] = S.charAt(j);
        return new String(stack, 0, i);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String removeDuplicates2(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) { 
                dq.pollLast();
            }else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String removeDuplicates3(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) { 
                sb.deleteCharAt(size - 1); 
            }else { 
                sb.append(c); 
            }
        }
        return sb.toString();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String removeDuplicates4(String S) {
        char[] a = S.toCharArray();
        int end = -1;
        for (char c : a) {
            if (end >= 0 && a[end] == c) { 
                --end; 
            }else { 
                a[++end] = c; 
            }
        }
        return String.valueOf(a, 0, end + 1);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String removeDuplicates5(String s) {
		Stack<Character> S = new Stack<>();
		for (char c : s.toCharArray())
			if (S.isEmpty() || S.peek() != c)
				S.push(c);
			else
				S.pop();
		StringBuilder sb = new StringBuilder();
		for (char c : S) sb.append(c);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String S = "abbaca";
		System.out.println(removeDuplicates(S));
	}

}
