package solution.array;

/**
 * @author By RuiCUI
 * 2018-03-27
 * Easy
 * Question 122:Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if(prices==null||prices.length==0){
			return 0;
		}
		int result = 0;
		for(int i=0;i<prices.length-1;i++){
			if(prices[i]<prices[i+1]){
				result += prices[i+1] - prices[i];
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force【超出时限】
	 * 时间复杂度：O(n^n) n的n次方 
	 * 空间复杂度：O(n)
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }
    
    /**
	 * 答案2--峰谷方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param prices
	 * @return
	 */
    public int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
	
    /**
	 * 答案3--One Pass 跟我的方法一样
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param prices
	 * @return
	 */
    public int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    
	public static void main(String[] args) {
		//int[] prices = {2,4,1};
		int[] prices = {7, 1, 5, 3, 6, 4};
		//int[] prices = {7, 6, 4, 3, 1};
		//int[] prices = {1};
		System.out.println(maxProfit(prices));
	}

}
