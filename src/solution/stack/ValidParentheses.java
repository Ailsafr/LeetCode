package solution.stack;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-01-03
 * Easy
 * Question 020:Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	
	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(S)
	 * �ռ临�Ӷȣ�O(S)
	 * @param x
	 * @return
	 */
	private static boolean isValid(String s) {
		Stack<String> stack = new Stack();
		stack.push(s.substring(0,1));
		for(int i=1;i<s.length();i++){
			if(!stack.empty()&&isRight(stack.peek(),s.substring(i,i+1))){
				stack.pop();
			}else{
				stack.push(s.substring(i,i+1));
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
    }
	
	private static boolean isRight(String str,String str1){
		if("(".equals(str)&&")".equals(str1)||"[".equals(str)&&"]".equals(str1)||"{".equals(str)&&"}".equals(str1)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�,����ջ
	 * ʱ�临�Ӷȣ�O(S)
	 * �ռ临�Ӷȣ�O(S)
	 * @param x
	 * @return
	 */
	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�,����replace����
	 * ʱ�临�Ӷȣ�O(S)
	 * �ռ临�Ӷȣ�O(1)
	 * @param x
	 * @return
	 */
	public boolean isValid2(String s) {
        int length;
    
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while(length != s.length());
    
        return s.length() == 0;
    }
	
	

	public static void main(String[] args) {
		//String s = "()[]{}";
		String s = "([])";
		System.out.println(isValid(s));
	}

}
