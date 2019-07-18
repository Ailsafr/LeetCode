package solution.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-18
 * Medium
 * Question 60:Permutation Sequence.
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note:
 * 1. Given n will be between 1 and 9 inclusive.
 * 2. Given k will be between 1 and n! inclusive.
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314".
 */
public class PermutationSequence {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation(int n, int k) {
		List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation1(int n, int k) {
	    List<Integer> numbers = new ArrayList<>();
	    int[] factorial = new int[n+1];
	    StringBuilder sb = new StringBuilder();
	    
	    // create an array of factorial lookup
	    int sum = 1;
	    factorial[0] = 1;
	    for(int i=1; i<=n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    // factorial[] = {1, 1, 2, 6, 24, ... n!}
	    
	    // create a list of numbers to get indices
	    for(int i=1; i<=n; i++){
	        numbers.add(i);
	    }
	    // numbers = {1, 2, 3, 4}
	    
	    k--;
	    
	    for(int i = 1; i <= n; i++){
	        int index = k/factorial[n-i];
	        sb.append(String.valueOf(numbers.get(index)));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }
	    
	    return String.valueOf(sb);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation2(int n, int k) {

	    LinkedList<Integer> notUsed = new LinkedList<Integer>();

		int weight = 1;

		for (int i = 1; i <= n; i++) {
			notUsed.add(i);
			if (i == n)
				break;
			weight = weight * i;
		}

		String res = "";
		k = k - 1;
		while (true) {
			res = res + notUsed.remove(k / weight);
			k = k % weight;
			if (notUsed.isEmpty())
				break;
			weight = weight / notUsed.size();
		}

		return res;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation3(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		System.out.println(getPermutation(n,k));
	}

}
