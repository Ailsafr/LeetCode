package solution.math;

/**
 * @author By RuiCUI
 * 2018-08-23
 * Easy
 * Question 441:Arranging Coins.
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int arrangeCoins(int n) {
		return (int) ((Math.sqrt(1+8*(long)n)-1)/2);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的答案一样
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int arrangeCoins1(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int arrangeCoins2(int n) {
        if(n < 1)
            return 0;
        for(int i = 1; ;i++){
            n -=i;
            if(n < 0)
                return i-1;
        }
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int arrangeCoins3(int n) {   
        //convert int to long to prevent integer overflow
        long nLong = (long)n;
        
        long st = 0;
        long ed = nLong;
        
        long mid = 0;
        
        while (st <= ed){
            mid = st + (ed - st) / 2;
            
            if (mid * (mid + 1) <= 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }
        return (int)(st - 1);
    }
	
	public static void main(String[] args) {
		int n = 1804289383;
		System.out.println(arrangeCoins(n));
	}

}
