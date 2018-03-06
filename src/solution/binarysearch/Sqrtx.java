package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2018-03-06
 * Easy
 * Question 069:Implement int sqrt(int x).
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * Example 1:
 * Input: 4
 * Output: 2
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 */
public class Sqrtx {

	/**
	 * 我自己写的方法，用的二分法
	 * 时间复杂度：O（log2n）
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		if(x==1){
			return 1;
		}else if(x>=2147395600){
			return 46340;
		}
		return binarysearch(0,x,x);
    }
	
	private static int binarysearch(int left,int right,int x){
		int middle = left+(right-left)/2;
		if(middle>46340){
			right = 46340;
			left = 0;
			middle = 23170;
		}
		if(middle*middle<=x&&(middle+1)*(middle+1)>x){
			return middle;
		}else if(middle*middle<x){
			left = middle + 1;
			return binarysearch(left,right,x);
		}else{
			right = middle-1;
			return binarysearch(left,right,x);
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案，跟我的差不多，他用了除法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	public int mySqrt1(int x) {
	    if (x == 0)
	        return 0;
	    int left = 1, right = Integer.MAX_VALUE;
	    while (true) {
	        int mid = left + (right - left)/2;
	        if (mid > x/mid) {
	            right = mid - 1;
	        } else {
	            if (mid + 1 > x/(mid + 1))
	                return mid;
	            left = mid + 1;
	        }
	    }
	}
	
	/**
	 * 官网没有solution,这是其他人的答案，很新奇的想法
	 * @param x
	 * @return
	 */
	public int mySqrt2(int x) {
		long r = x;
	    while (r*r > x)
	        r = (r + x/r) / 2;
	    return (int) r;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案，很新奇的想法
	 * @param x
	 * @return
	 */
	public int mySqrt3(int x) {
	    if(x < 4) return x == 0 ? 0 : 1;
	    int res = 2 * mySqrt3(x/4);
	    if((res+1) * (res+1) <= x && (res+1) * (res+1) >= 0) return res+1;
	    return res;
	}
	
	public static void main(String[] args) {
		int x = 2147395600;
		//int x = 0;
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(mySqrt(x));
	}
	
	
	
}
