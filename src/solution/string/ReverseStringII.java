package solution.string;

/**
 * @author By RuiCUI
 * 2018-10-23
 * Easy
 * Question 541:Reverse String II.
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * 1.The string consists of lower English letters only.
 * 2.Length of the given string and k will in the range [1, 10000].
 */
public class ReverseStringII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @param k
	 * @return
	 */
	public static String reverseStr(String s, int k) {
		int n = s.length();
		if(n<=k){
			StringBuilder sb = new StringBuilder(s);	                  
			return sb.reverse().toString();
		}
		String result = "";
		for(int i=0;i<n;i+=k){
			String sub = s.substring(i,Math.min(i+k,n));
			String rev = "";
			if(i/k%2==0){
				rev = (new StringBuilder(sub)).reverse().toString();
				result += rev;
			}else{
				result += sub;
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Direct [Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @param k
	 * @return
	 */
	public String reverseStr1(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
	
	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		System.out.println(reverseStr(s,k));
	}

}
