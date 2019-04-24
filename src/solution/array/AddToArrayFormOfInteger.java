package solution.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-04-24
 * Easy
 * Question 989:Add to Array-Form of Integer.
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * Note：
 * 1. 1 <= A.length <= 10000
 * 2. 0 <= A[i] <= 9
 * 3. 0 <= K <= 10000
 * 4. If A.length > 1, then A[0] != 0.
 */
public class AddToArrayFormOfInteger {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @param K
	 * @return
	 */
	public static List<Integer> addToArrayForm(int[] A, int K) {
		int len = A.length;
		String str = K + "";
		int lenK = str.length();
		List<Integer> list = new ArrayList<Integer>();
		int plusOne = 0;
		for(int i=len-1;i>=0;i--){
			if(lenK>0){
				int n = Integer.parseInt(str.substring(lenK-1, lenK));
				int num = n + A[i] + plusOne;
				if(num>9){
					plusOne = 1;
					num = num%10;
				}else{
					plusOne = 0;
				}
				list.add(0, num);
				lenK--;
			}else{
				int num = A[i] + plusOne;
				if(num>9){
					plusOne = 1;
					num = num % 10;
				}else{
					plusOne = 0;
				}
				list.add(0, num);
			}
		}
		while(lenK>0){
			int num = plusOne+Integer.parseInt(str.substring(lenK-1, lenK));
			if(num>9){
				plusOne = 1;
				num = num % 10;
			}else{
				plusOne = 0;
			}
			list.add(0,num);
			lenK--;
		}
		if(plusOne==1){
			list.add(0,1);
		}
		return list;
    }
	
	/**
	 * 答案--Schoolbook Addition
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n) 
	 * @param A
	 * @param K
	 * @return
	 */
	public List<Integer> addToArrayForm1(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
	
	public static void main(String[] args) {
		int[] A = {9,9,9,9,9,9,9,9,9,9};
		int K = 1;
		System.out.println(addToArrayForm(A,K));
	}

}
