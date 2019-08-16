package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-08-16
 * Medium
 * Question 93:Restore IP Addresses.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"].
 */
public class RestoreIPAddresses {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if(s==null||s.length()<4||s.length()>12){
			return result;
		}
		int len = s.length();
		for(int i=1;i<len-2;i++){
			for(int j=i+1;j<len-1;j++){
				for(int k=j+1;k<len;k++){
					String str1 = s.substring(0, i);
					String str2 = s.substring(i, j);
					String str3 = s.substring(j, k);
					String str4 = s.substring(k, len);
					if((str1.length()>1&&str1.startsWith("0"))||(str2.length()>1&&str2.startsWith("0"))||(str3.length()>1&&str3.startsWith("0"))||(str4.length()>1&&str4.startsWith("0"))){
						continue;
					}
					int first = Integer.parseInt(str1);
					int second = Integer.parseInt(str2);
					int third = Integer.parseInt(str3);
					int fourth = Integer.parseInt(str4);
					if(first>=0&&first<256&&second>=0&&second<256&&third>=0&&third<256&&fourth>=0&&fourth<256){
						result.add(s.substring(0, i)+"."+s.substring(i, j)+"."+s.substring(j, k)+"."+s.substring(k, len));
					}
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public List<String> restoreIpAddresses2(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }
    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);
        
        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
	
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public List<String> restoreIpAddresses3(String s) {
    	List<String> ans = new ArrayList<String>();
    	int len = s.length();
    	for (int i = 1; i <=3; ++i){  // first cut
    		if (len-i > 9) continue;    		
    		for (int j = i+1; j<=i+3; ++j){  //second cut
    			if (len-j > 6) continue;    			
    			for (int k = j+1; k<=j+3 && k<len; ++k){  // third cut
    				int a,b,c,d;                // the four int's seperated by "."
    				a = Integer.parseInt(s.substring(0,i));  
    				b = Integer.parseInt(s.substring(i,j)); // notice that "01" can be parsed into 1. Need to deal with that later.
    				c = Integer.parseInt(s.substring(j,k));
    				d = Integer.parseInt(s.substring(k));
    				if (a>255 || b>255 || c>255 || d>255) continue; 
    				String ip = a+"."+b+"."+c+"."+d;
    				if (ip.length()<len+3) continue;  // this is to reject those int's parsed from "01" or "00"-like substrings
    				ans.add(ip);
    			}
    		}
    	}
    	return ans;
    }
    
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public List<String> restoreIpAddresses4(String s) {
        List<String> res = new ArrayList<>();
        helper(s,"",res,0);
        return res;
    }
    public void helper(String s, String tmp, List<String> res,int n){
        if(n==4){
            if(s.length()==0) res.add(tmp.substring(0,tmp.length()-1));
            //substring here to get rid of last '.'
            return;
        }
        for(int k=1;k<=3;k++){
            if(s.length()<k) continue;
            int val = Integer.parseInt(s.substring(0,k));
            if(val>255 || k!=String.valueOf(val).length()) continue;
            /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(s.substring(k),tmp+s.substring(0,k)+".",res,n+1);
        }
    }
    
	public static void main(String[] args) {
		String s = "010010";
		System.out.println(restoreIpAddresses(s));
	}

}
