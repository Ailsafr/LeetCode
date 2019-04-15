package solution.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-04-15
 * Easy
 * Question 961:N-Repeated Element in Size 2N Array.
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * Return the element repeated N times.
 * Example 1:
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * Note:
 * 1. 4 <= A.length <= 10000
 * 2. 0 <= A[i] < 10000
 * 3. A.length is even.
 */
public class NRepeatedElementInSize2NArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static int repeatedNTimes(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		for(int n:A){
			if(set.contains(n)){
				return n;
			}
			set.add(n);
		}
		return 0;
    }
	
	/**
	 * 答案1--Count
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public int repeatedNTimes1(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int k: count.keySet())
            if (count.get(k) > 1)
                return k;
        throw null;
    }
	
	/**
	 * 答案2--Compare
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int repeatedNTimes2(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];
        throw null;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,3,3};
		System.out.println(repeatedNTimes(A));
	}

}
