package solution.bitmanipulation;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author By RuiCUI
 * 2019-01-22
 * Easy
 * Question 762:Prime Number of Set Bits in Binary Representation.
 * Given two integers L and R, 
 * find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. 
 * For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 * Example 1:
 * Input: L = 6, R = 10
 * Output: 4
 * Explanation:
 * 6 -> 110 (2 set bits, 2 is prime)
 * 7 -> 111 (3 set bits, 3 is prime)
 * 9 -> 1001 (2 set bits , 2 is prime)
 * 10->1010 (2 set bits , 2 is prime)
 * Example 2:
 * Input: L = 10, R = 15
 * Output: 5
 * Explanation:
 * 10 -> 1010 (2 set bits, 2 is prime)
 * 11 -> 1011 (3 set bits, 3 is prime)
 * 12 -> 1100 (2 set bits, 2 is prime)
 * 13 -> 1101 (3 set bits, 3 is prime)
 * 14 -> 1110 (3 set bits, 3 is prime)
 * 15 -> 1111 (4 set bits, 4 is not prime)
 * Note:
 * 1.L, R will be integers L <= R in the range [1, 10^6].
 * 2.R - L will be at most 10000.
 * Hint:
 * Write a helper function to count the number of set bits in a number, 
 * then check whether the number of set bits is 2, 3, 5, 7, 11, 13, 17 or 19.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param L
	 * @param R
	 * @return
	 */
	static HashSet<Integer> set = new HashSet<Integer>(){{add(2); add(3); add(5); add(7); add(11); add(13); add(17); add(19);}};
	//Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
	public static int countPrimeSetBits(int L, int R) {
		int result = 0;
		for(int i=L;i<=R;i++){
			int n = Integer.bitCount(i);
			if(set.contains(n)){
				result += 1;
			}
		}
		return result;
    }
    
    /**
	 * 答案--Direct[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param L
	 * @param R
	 * @return
	 */
	public int countPrimeSetBits1(int L, int R) {
		int ans = 0;
	    for (int x = L; x <= R; ++x)
	        if (isSmallPrime(Integer.bitCount(x)))
	            ans++;
	    return ans;
	}
	public boolean isSmallPrime(int x) {
	    return (x == 2 || x == 3 || x == 5 || x == 7 ||
	            x == 11 || x == 13 || x == 17 || x == 19);
	}
    
	public static void main(String[] args) {
		int L = 6;
		int R = 10;
		System.out.println(countPrimeSetBits(L,R));
	}

}
