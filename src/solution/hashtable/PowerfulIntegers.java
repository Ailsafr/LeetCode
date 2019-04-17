package solution.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-04-17
 * Easy
 * Question 970:Powerful Integers.
 * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
 * Return a list of all powerful integers that have value less than or equal to bound.
 * You may return the answer in any order.  In your answer, each value should occur at most once.
 * Example 1:
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation: 
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * Example 2:
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 * Note:
 * 1. 1 <= x <= 100
 * 2. 1 <= y <= 100
 * 3. 0 <= bound <= 10^6.
 */
public class PowerfulIntegers {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param x
	 * @param y
	 * @param bound
	 * @return
	 */
	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				int n = (int) (Math.pow(x, i) + Math.pow(y, j));
				if(n<=bound&&!list.contains(n)){
					list.add(n);
				}
			}
		}
        return list;
    }
	
	/**
	 * 答案--Brute Force
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param x
	 * @param y
	 * @param bound
	 * @return
	 */
	public List<Integer> powerfulIntegers1(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList(seen);
    }
	
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		int bound = 15;
		System.out.println(powerfulIntegers(x,y,bound));
	}

}
