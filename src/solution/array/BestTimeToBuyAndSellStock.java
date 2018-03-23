package solution.array;

/**
 * @author By RuiCUI
 * 2018-03-23
 * Easy
 * Question 121:Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * 我自己写的方法,动态规划还是不熟悉，参考了动态规划的解法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if(prices==null||prices.length<2){
			return 0;
		}
		int len = prices.length;
		int tmp[] = new int[len-1];
		for(int i=0;i<len-1;i++){
			tmp[i]=prices[i+1]-prices[i];
		}
		int dp[] = new int[len-1];
		dp[0] = tmp[0];
		int result = tmp[0];
		for(int i=1;i<len-1;i++){
			dp[i] = tmp[i] + (dp[i-1]>0?dp[i-1]:0);
			result = Math.max(dp[i], result);
		}
		if(result<0){
			return 0;
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force【超出时限】
	 * 时间复杂度：O(n^2) n的平方 
	 * 空间复杂度：O(1)
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
	
	/**
	 * 答案1--One Pass
	 * 时间复杂度：O(n) n的平方 
	 * 空间复杂度：O(1)
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	
	public static void main(String[] args) {
		//int[] prices = {2,4,1};
		//int[] prices = {7, 1, 5, 3, 6, 4};
		//int[] prices = {7, 6, 4, 3, 1};
		int[] prices = {1};
		System.out.println(maxProfit(prices));
	}

}
