package solution.string;

/**
 * @author By RuiCUI
 * 2018-09-27
 * Easy
 * Question 482:License Key Formatting.
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. 
 * The string is separated into N+1 groups by N dashes.
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, 
 * except for the first group which could be shorter than K, but still must contain at least one character. 
 * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 * Input: S = "2-5g-3-J", K = 2
 * Output: "2-5G-3J"
 * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 * Note:
 * The length of string S will not exceed 12,000, and K is a positive integer.
 * String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 * String S is non-empty.
 */
public class LicenseKeyFormatting {

	/**
	 * 我自己写的方法-Time Limit Exceeded
	 * @param S
	 * @param K
	 * @return
	 */
	public static String licenseKeyFormatting(String S, int K) {
		S = S.replaceAll("-", "");
		int y = S.length()%K;
		int n = S.length()/K;
		S = S.toUpperCase();
		String result = "";
		result += S.substring(0, y);
		S = S.substring(y);
		for(int i=0;i<n;i++){
			result += "-";
			result += S.substring(i*K,(i+1)*K);
		}
		if(result.startsWith("-")){
			result = result.substring(1);
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param S
	 * @param K
	 * @return
	 */
	 public String licenseKeyFormatting1(String S, int K) {
		 StringBuilder sb = new StringBuilder();
		 for (int i = S.length() - 1; i >= 0; i--)
			 if (S.charAt(i) != '-')
				 sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
		 return sb.reverse().toString().toUpperCase();
	 } 
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param S
	 * @param K
	 * @return
	 */
	 public String licenseKeyFormatting2(String S, int K) {
	        // Replacing all - and converting all letters to uppercase
	        String S1 = S.replace("-","");
	        S1 = S1.toUpperCase();
	        
	        // Making stringBuilder 
	        StringBuilder sb = new StringBuilder();
	         for(int i=0; i<S1.length();i++) {
	            sb.append(S1.charAt(i));
	        }
	        int len = sb.toString().length();
	        // Inserting '-' from back at every K position
	        for(int i=K; i < len; i=i+K) {
                sb.insert(len-i,'-');
            }
	        return sb.toString();   
	    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param S
	 * @param K
	 * @return
	 */
	 public String licenseKeyFormatting3(String S, int K) {
		 if (S == null || S.length() == 0) return "";
		 String[] ss = S.split("-");
		 StringBuilder sb = new StringBuilder();
		 for (String s : ss) sb.append(s);
		 String noDashS = sb.toString();
		 sb = new StringBuilder();
		 int firstK = noDashS.length() % K;
		 if (firstK == 0) firstK = K;
		 for (int i = 0; i < noDashS.length();) {
			 if (i == 0) {
				 if (i + firstK < noDashS.length()) sb.append(noDashS.substring(i, i + firstK));
				 else sb.append(noDashS.substring(i, noDashS.length()));
				 i += firstK;
				 continue;
			 } else if (i + K < noDashS.length()) sb.append("-" + noDashS.substring(i, i + K));
			 else sb.append("-" + noDashS.substring(i, noDashS.length()));
			 i += K;
		 }
		 return sb.toString().toUpperCase();
    }
	
	public static void main(String[] args){
		String S = "5F3Z-2e-9-w";
		int K = 4;
		System.out.println(licenseKeyFormatting(S,K));
	}
	
}
