package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2018-07-30
 * Easy
 * Question 371:Sum of Two Integers.
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {
	
	/**
	 * 我自己写的方法--只试用于正整数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getSum(int a, int b) {
		String result = "";
		String sa = Integer.toBinaryString(a);
		String sb = Integer.toBinaryString(b);
		int la = sa.length();
		int lb = sb.length();
		int len = la;
		if(la>lb){
			for(int i=0;i<la-lb;i++){
				sb = "0" + sb;
			}
		}else if(la<lb){
			for(int i=0;i<lb-la;i++){
				sa = "0" + sa;
			}
			len = lb;
		}
		int tmp = 0;
		for(int i=len-1;i>=0;i--){
			String ca = sa.substring(i,i+1);
			String cb = sb.substring(i,i+1);
			if("1".equals(ca)&&"1".equals(cb)){
				tmp = 1;
				result = "0" + result;
			}else if("0".equals(ca)&&"0".equals(cb)){
				if(tmp==1){
					result = "1" + result;
					tmp = 0;
				}else{
					result = "0" + result;
				}
			}else{
				if(tmp==1){
					result = "0" + result;
					tmp = 0;
				}else{
					result = "1" + result;
				}
			}
		}
		return Integer.parseInt(result,2);
    }
   
    /**
	 * 官网没有solution,这是其他人的答案，利用位运算
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getSum1(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
    
	/**
	 * 官网没有solution,这是其他人的答案，利用位运算
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum2(int a, int b) {
	    if(b == 0){//没有进为的时候完成运算
	        return a;
	    }
	    int sum,carry;
	    sum = a^b;//完成第一步加发的运算
	    carry = (a&b)<<1;//完成第二步进位并且左移运算
	    return getSum2(sum,carry);//
	}
    
	public static void main(String[] args) {
		int a = -1;
		int b = 2;
		System.out.println(getSum1(a,b));
	}

}
