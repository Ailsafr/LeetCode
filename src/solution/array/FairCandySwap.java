package solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-03-18
 * Easy
 * Question 888:Fair Candy Swap.
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, 
 * and B[j] is the size of the j-th bar of candy that Bob has.
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, 
 * they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, 
 * and ans[1] is the size of the candy bar that Bob must exchange.
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 * Example 1:
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. 1 <= B.length <= 10000
 * 3. 1 <= A[i] <= 100000
 * 4. 1 <= B[i] <= 100000
 * 5. It is guaranteed that Alice and Bob have different total amounts of candy.
 * 6. It is guaranteed there exists an answer.
 */
public class FairCandySwap {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n) 
	 * @param A
	 * @param B
	 * @return
	 */
	public static int[] fairCandySwap(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		Map<Integer,Integer> mapA = new HashMap<Integer,Integer>();
		Map<Integer,Integer> mapB = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		for(int a:A){
			sumA += a;
			mapA.put(a, a);
		}
		for(int b:B){
			sumB += b;
			mapB.put(b, b);
		}
		int sum = sumA + sumB;
		int tmp = sum/2;
		if(tmp>sumA){
			int diff = tmp - sumA;
			for(int a:A){
				if(mapB.containsKey(a+diff)){
					result[0] = a;
					result[1] = a + diff;
					return result;
				}
			}
		}else{
			int diff = sumA - tmp;
			for(int a:A){
				if(mapB.containsKey(a-diff)){
					result[0] = a;
					result[1] = a - diff;
					return result;
				}
			}
		}
		return result;
    }
	
	/**
	 * 答案--Solve the Equation
	 * 时间复杂度：O(A.length+B.length) 
	 * 空间复杂度：O(B.length) 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] fairCandySwap1(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,5};
		int[] B = {2,4};
		System.out.println(Arrays.toString(fairCandySwap(A,B)));
	}

}
