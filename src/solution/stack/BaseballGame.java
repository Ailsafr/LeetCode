package solution.stack;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-12-14
 * Easy
 * Question 682:Baseball Game.
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 * 1.Integer (one round's score): Directly represents the number of points you get in this round.
 * 2."+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * 3."D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * 4."C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * You need to return the sum of the points you could get in all the rounds.
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation: 
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.  
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 * Example 2:
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation: 
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.
 * Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.  
 * Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 */
public class BaseballGame {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) n is the length of ops.
	 * 空间复杂度：O(n) n is the length of ops.
	 * @param ops
	 * @return
	 */
	public static int calPoints(String[] ops) {
		int result = 0;
		if(ops==null||ops.length==0){
			return result;
		}
		int len = ops.length;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<len;i++){
			String s = ops[i];
			if("C".equals(s)){
				stack.pop();
			}else if("D".equals(s)){
				stack.push(stack.peek()*2);
			}else if("+".equals(s)){
				int last = stack.pop();
				int push = stack.peek() + last;
				stack.push(last);
				stack.push(push);
			}else{
				stack.push(Integer.parseInt(s));
			}
		}
		for(int n:stack){
			result += n;
		}
		return result;
    }
	
	
	/**
	 * 答案--Stack[Accepted]
	 * 时间复杂度：O(n) n is the length of ops.
	 * 空间复杂度：O(n) n is the length of ops.
	 * @param ops
	 * @return
	 */
	public int calPoints1(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }

	public static void main(String[] args) {
		//String ops[] = {"5","2","C","D","+"};
		String ops[] = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));
	}

}
