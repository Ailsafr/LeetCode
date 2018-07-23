package solution.string;

/**
 * @author By RuiCUI
 * 2018-07-23
 * Easy
 * Question 344:Reverse String.
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
	
	/**
	 * 我自己写的方法[Time Limit Exceeded]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		String result = "";
		for(int i=s.length()-1;i>=0;i--){
			result += s.charAt(i);
		}
		return result;
    }
	
	/**
	 * 我自己写的方法[Time Limit Exceeded]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public static String reverseString1(String s) {
		return new StringBuffer(s).reverse().toString();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public String reverseString2(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案(Divide and Conquer)
	 * 时间复杂度：O(nlog(n))
	 * 空间复杂度：O(h) h is the depth of recursion tree generated which is log(n). Space is needed for activation stack during recursion calls.
	 * @param s
	 * @return
	 */
	public String reverseString3(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
	
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(reverseString(str));
	}

}
