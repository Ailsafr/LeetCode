package solution.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2018-05-17
 * Easy
 * Question 202:Happy Number.
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

	/**
	 * 我自己写的方法
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		return useMap(map,n);
    }
	
	private static boolean useMap(Map<Integer,Integer> map,int n){
		if(n==1){
			return true;
		}
		if(map.get(n)!=null&&map.get(n)!=1){
			return false;
		}
		int result = 0;
		String str = n + "";
		for(int i=0;i<str.length();i++){
			result += Math.pow(Integer.parseInt(str.substring(i, i+1)),2);
		}
		map.put(n, result);
		return useMap(map,result);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路差不多
	 * @param n
	 * @return
	 */
	public static boolean isHappy1(int n) {
		Set<Integer> inLoop = new HashSet<Integer>();
		int squareSum,remain;
		while (inLoop.add(n)) {
			squareSum = 0;
			while (n > 0) {
				remain = n%10;
				squareSum += remain*remain;
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum;
		}
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,用了小技巧
	 * @param n
	 * @return
	 */
	public boolean isHappy2(int n) {
        if(n<=0) return false;
        while(true){
            int sum=0;
            while(n!=0){
              sum+=(n%10)*(n%10);
              n=n/10;
            }
            if(sum/10==0){
               if(sum==1||sum==7) return true;
               else return false;
            }
            n=sum;
        }
    }
	
	public static void main(String[] args) {
		int n = 0;
		System.out.println(isHappy(n));
	}

}
