package solution.string;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2019-01-30
 * Easy
 * Question 796:Rotate String.
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. 
 * For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. 
 * Return True if and only if A can become B after some number of shifts on A.
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 * A and B will have length at most 100.
 */
public class RotateString {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean rotateString(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		if(lenA!=lenB){
			return false;
		}
		if(lenA==0){
			return true;
		}
		for(int i=0;i<lenA;i++){
			String S = A.substring(i) + A.substring(0, i);
			if(S.equals(B)){
				return true;
			}
		}
		return false;
    }
	
	/**
	 * 答案1--Brute Force[Accepted]
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean rotateString1(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        search:
            for (int s = 0; s < A.length(); ++s) {
                for (int i = 0; i < A.length(); ++i) {
                    if (A.charAt((s+i) % A.length()) != B.charAt(i))
                        continue search;
                }
                return true;
            }
        return false;
    }
	
	/**
	 * 答案2--Simple Check[Accepted]
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
	
	/**
	 * 答案3--Rolling Hash[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean rotateString3(String A, String B) {
        if (A.equals(B)) return true;

        int MOD = 1_000_000_007;
        int P = 113;
        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

        long hb = 0, power = 1;
        for (char x: B.toCharArray()) {
            hb = (hb + power * x) % MOD;
            power = power * P % MOD;
        }

        long ha = 0; power = 1;
        char[] ca = A.toCharArray();
        for (char x: ca) {
            ha = (ha + power * x) % MOD;
            power = power * P % MOD;
        }

        for (int i = 0; i < ca.length; ++i) {
            char x = ca[i];
            ha += power * x - x;
            ha %= MOD;
            ha *= Pinv;
            ha %= MOD;
            if (ha == hb && (A.substring(i+1) + A.substring(0, i+1)).equals(B))
                return true;

        }
        return false;
    }
	
	/**
	 * 答案4--KMP(Knuth-Morris-Pratt)[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean rotateString4(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }
	
	public static void main(String[] args) {
		String A = "abcde";
		String B = "cdeab";
		System.out.println(rotateString(A,B));
	}

}
