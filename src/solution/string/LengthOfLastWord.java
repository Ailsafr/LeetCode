package solution.string;

/**
 * @author By RuiCUI
 * 2018-02-13
 * Easy
 * Question 058:Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

	/**
	 * 我自己写的方法
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord(String s) {
		if(s==null || s.replaceAll(" ","").length()==0){
			return 0;
		}
		String[] strs = s.split(" ");
		return strs[strs.length-1].length();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,利用trim
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord1(String s) {
	    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord2(String s) {
	    //228ms
	    int lenIndex = s.length()-1;
	    int len = 0;

	    /*can also use while here, resulting in 264ms
	    while (lenIndex>=0 && s.charAt(lenIndex)==' ') lenIndex--;*/
	    
	    /*or use trim - 324ms
	    s = s.trim();*/

	    for (int i=lenIndex; i>=0 && s.charAt(i)==' '; i--) 
	        lenIndex--;
	    
	    for (int i=lenIndex; i>=0 && s.charAt(i)!=' '; i--) 
	        len++;
	    return len;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,利用trim,和上面的差不多
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord3(String s) {
	    String use = s.trim();
	    int count = 0;
	    for (int i = use.length() - 1; i >= 0; i--) {
	        if (use.charAt(i) != ' ') count++;
	        else break;
	    }
	    return count;
	}
	
	public static void main(String[] args){
		String str = "Hello World ";
		//String str = " ";
		System.out.println(str.trim());
		System.out.println(str);
		System.out.println(lengthOfLastWord1(str));
	}
	
}
