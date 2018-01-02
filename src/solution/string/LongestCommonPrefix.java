package solution.string;

/**
 * @author By RuiCUI
 * 2018-01-02
 * Easy
 * Question 014:Write a function to find the longest common prefix string amongst an array of strings.
 * 这道题竟然还可以用单词查找树(Trie)来解答（需要构建）
 */
public class LongestCommonPrefix {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(S)
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	private static String longestCommonPrefix(String[] strs) {
		String result = "";
		if(strs.length>0){
			String str = strs[0];
			for(int i=0;i<str.length();i++){
				for(int j=1;j<strs.length;j++){
					if(strs[j].length()>i){
						if(strs[j].charAt(i)!=str.charAt(i)){
							return result;
						}
					}else{
						return result;
					}
				}
				result += str.charAt(i);
			}
		}
		return result;
    }
	
	/**
	 * 答案1--水平扫描  依次比较  利用indexOf方法
	 * 时间复杂度：O(S) where S is the sum of all characters in all strings.
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	public String longestCommonPrefix1(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	/**
	 * 答案2--垂直扫描  跟我的解法一样
	 * 时间复杂度：O(S) where S is the sum of all characters in all strings.
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	
	/**
	 * 答案3--分治算法
	 * 时间复杂度：O(S) where S is the sum of all characters in all strings.
	 * 空间复杂度：O(m∗log(n))
	 * @param x
	 * @return
	 */
	public String longestCommonPrefix3(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private String longestCommonPrefix(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix(strs, l , mid);
	        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}
	
	/**
	 * 答案4--二分法检索 
	 * 时间复杂度：O(S∗log(n)) where S is the sum of all characters in all strings.
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	public String longestCommonPrefix4(String[] strs) {
	    if (strs == null || strs.length == 0)
	        return "";
	    int minLen = Integer.MAX_VALUE;
	    for (String str : strs)
	        minLen = Math.min(minLen, str.length());
	    int low = 1;
	    int high = minLen;
	    while (low <= high) {
	        int middle = (low + high) / 2;
	        if (isCommonPrefix(strs, middle))
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len){
	    String str1 = strs[0].substring(0,len);
	    for (int i = 1; i < strs.length; i++)
	        if (!strs[i].startsWith(str1))
	            return false;
	    return true;
	}
	
	public static void main(String[] args) {
		//String[] strs = {"apple","applist","appniso"};
		String[] strs = {"aa","a"};
		System.out.println(longestCommonPrefix(strs));
	}

}
