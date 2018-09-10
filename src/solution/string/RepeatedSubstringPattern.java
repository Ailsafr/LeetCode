package solution.string;

/**
 * @author By RuiCUI
 * 2018-09-10
 * Easy
 * Question 459:Repeated Substring Pattern.
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
	
	/**
	 * 我自己写的方法-Time Limit Exceeded
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public static boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		if(len==0){
			return true;
		}
		if(len==1){
			return false;
		}
		for(int i=1;i<=len/2;i++){
			String subs = s.substring(0,i);
			String res = s.replaceAll(subs, "");
			if("".equals(res)){
				return true;
			}
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,很奇妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public boolean repeatedSubstringPattern1(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public boolean repeatedSubstringPattern2(String s) {
		int l = s.length();
		for(int i=l/2;i>=1;i--) {
			if(l%i==0) {
				int m = l/i;
				String subS = s.substring(0,i);
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<m;j++) {
					sb.append(subS);
				}
				if(sb.toString().equals(s)) return true;
			}
		}
		return false;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public boolean repeatedSubstringPattern3(String str) {
        //This is the kmp issue
        int[] prefix = kmp(str);
        int len = prefix[str.length()-1];
        int n = str.length();
        return (len > 0 && n%(n-len) == 0);
    }
    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }
	
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
    public boolean repeatedSubstringPattern4(String str) {
        return str.matches("(.+)\\1+");
    }
    
	public static void main(String[] args) {
		String s = "abab";
		System.out.println(repeatedSubstringPattern(s));
	}

}
