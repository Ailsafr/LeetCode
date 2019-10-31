package solution.stack;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-10-31
 * Medium
 * Question 150:Evaluate Reverse Polish Notation.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. 
 * That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation: 
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22.
 */
public class EvaluateReversePolishNotation {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param tokens
	 * @return
	 */
	public static int evalRPN(String[] tokens) {
		int result = 0;
		if (tokens==null || tokens.length==0) {
			return result;
		}
		if (tokens.length==1) {
			return Integer.parseInt(tokens[0]);
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			if ("+".equals(s)){
				int num1 = stack.pop();
				int num2 = stack.pop();
				result = num1 + num2;
				stack.add(result);
			} else if ("-".equals(s)) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				result = num2 - num1;
				stack.add(result);
			} else if ("*".equals(s)) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				result = num1 * num2;
				stack.add(result);
			} else if ("/".equals(s)) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				result = num2 / num1;
				stack.add(result);
			} else {
				stack.add(Integer.parseInt(s));
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param tokens
	 * @return
	 */
	public int evalRPN1(String[] tokens) {
        int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param tokens
	 * @return
	 */
	public int evalRPN2(String[] tokens) {
		int[] ls = new int[tokens.length/2+1];
		int index = 0;
		for (String token : tokens) {
	        switch (token) {
	            case "+":
	                ls[index - 2] = ls[index - 2] + ls[index - 1];
	                index--;
	                break;
	            case "-":
	                ls[index - 2] = ls[index - 2] - ls[index - 1];
	                index--;
	                break;
	            case "*":
	                ls[index - 2] = ls[index - 2] * ls[index - 1];
	                index--;
	                break;
	            case "/":
	                ls[index - 2] = ls[index - 2] / ls[index - 1];
	                index--;
	                break;
	            default:
	                ls[index++] = Integer.parseInt(token);
	                break;
	        }
	    }
	    return ls[0];
	}
	
	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));
	}

}
