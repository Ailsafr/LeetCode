package solution.string;

/**
 * @author By RuiCUI
 * 2019-01-03
 * Easy
 * Question 709:To Lower Case.
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * Input: "here"
 * Output: "here"
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {
	
	/**
	 * 我自己写的方法
	 * @param str
	 * @return
	 */
	public static String toLowerCase(String str) {
		int len = str.length();
		String result = "";
		for(int i=0;i<len;i++){
			int num = Integer.valueOf(str.charAt(i));
			if(num>64&&num<91){
				result += (char)(num+32);
			}else{
				result += (char)num;
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param str
	 * @return
	 */
	public String toLowerCase1(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param str
	 * @return
	 */
	public String toLowerCase2(String str) {
        StringBuilder res = new StringBuilder();
        
        for (char s: str.toCharArray()){
            char l = s < 91 && s > 64 ? (char) (s + 32) : s;
            res.append(l);
        }
        
        return res.toString();
    }
	
	public static void main(String[] args) {
		String str = "LOVELY";
		System.out.println(toLowerCase(str));
	}

}
