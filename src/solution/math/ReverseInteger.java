package solution.math;

/**
 * @author By RuiCUI
 * 2017-12-27
 * Question 007:Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Example:
 * Input: 123  Output:321
 * Input: -123 Output: -321
 * Input: 120  Output: 21
 */
public class ReverseInteger {
	
	/**
	 * 我自己写的方法
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int reverse(int x) {
		if(Integer.bitCount(x)>31){
			return 0;
		}
		String str = x + "";  //String.valueOf(x)  Integer.toString(x);
		String resultStr = "";
		for(int i=str.length()-1;i>=0;i--){
			String charStr = str.substring(i,i+1);
			if(("0".equals(charStr)&&"".equals(resultStr)||"".equals(charStr))){
				continue;
			}else if("-".equals(charStr)){
				resultStr = "-" + resultStr;
			}else{
				resultStr += charStr;
			}
		}
		int resultInt = 0;
		try{
			resultInt = Integer.parseInt(resultStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultInt;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,利用余数
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int reverse1(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,利用StringBuffer的reverse方法
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int reverse2(int x) {
        String str = "";
        int result = 0;
        StringBuffer sb = new StringBuffer(Integer.toString(x));
        if(x < 0){
            sb = new StringBuffer(sb.substring(1));
            str = "-";
        }
        str += sb.reverse().toString();
        try {
        	result = Integer.valueOf(str);
		}catch (java.lang.NumberFormatException e) {
			result = 0;
		}
        return result;
    }
	
	public static void main(String[] args) {
		int x = 90100;
		System.out.println(reverse(x));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.bitCount(2147483647));
	}

}
