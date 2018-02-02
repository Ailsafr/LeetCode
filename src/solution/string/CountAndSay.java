package solution.string;

/**
 * @author By RuiCUI
 * 2018-01-29
 * Easy
 * Question 038:The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1. 1
 * 2. 11
 * 3. 21
 * 4. 1211
 * 5. 111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 * Example 2:
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {
	
	/**
	 * 我自己写的方法
	 * @param n
	 * @return
	 */
	private static String countAndSay(int n) {
		if(n==0){
			return "";
		}
		int i = 0;
		String result = "";
		while(i!=n){
			result = getNextStr(result);
			i++;
		}
		return result;
    }
	
	private static String getNextStr(String str){
		if(str==""){
			return "1";
		}
		String result = "";
		int j = 0;
		for(int i=0;i<str.length();i++){
			if(i==str.length()-1||str.charAt(i)!=str.charAt(i+1)){
				result += (j+1) + "" + str.charAt(i); 
				j = 0;
			}else{
				j++;
			}
		}
		return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param n
	 * @return
	 */
	public String countAndSay1(int n) {
    	StringBuilder curr=new StringBuilder("1");
    	StringBuilder prev;
    	int count;
    	char say;
        for (int i=1;i<n;i++){
        	prev=curr;
 	        curr=new StringBuilder();       
 	        count=1;
 	        say=prev.charAt(0);
 	        
 	        for (int j=1,len=prev.length();j<len;j++){
 	        	if (prev.charAt(j)!=say){
 	        		curr.append(count).append(say);
 	        		count=1;
 	        		say=prev.charAt(j);
 	        	}
 	        	else count++;
 	        }
 	        curr.append(count).append(say);
        }	       	        
        return curr.toString();
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param n
	 * @return
	 */
	public String countAndSay2(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }else{
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
	
	public static void main(String[] args) {
		//String str = "312211";
		//System.out.println(getNextStr(str));
		System.out.println(countAndSay(8));
	}

}
