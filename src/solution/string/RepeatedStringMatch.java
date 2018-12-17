package solution.string;

import java.math.BigInteger;

/**
 * @author By RuiCUI
 * 2018-12-17
 * Easy
 * Question 686:Repeated String Match.
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
 * and B is not a substring of A repeated two times ("abcdabcd").
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @param B
	 * @return
	 */
	public static int repeatedStringMatch(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int n = lenB/lenA + 2;
		String s = A;
		for(int i=0;i<n;i++){
			if(s.indexOf(B)>-1){
				return i+1;
			}
			s += A;
		}
		return -1;
    }

	/**
	 * 答案1--Ad-Hoc[Accepted]
	 * 时间复杂度：O(N*(N+M)) where M, N are the lengths of strings A, B.
	 * 空间复杂度：O(M+N) where M, N are the lengths of strings A, B.
	 * @param A
	 * @param B
	 * @return
	 */
	public int repeatedStringMatch1(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
	
	/**
	 * 答案2--Rabin-Karp(Rolling Hash)[Accepted]
	 * 时间复杂度：O(M+N) where M, N are the lengths of strings A, B.
	 * 空间复杂度：O(1)
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public int repeatedStringMatch2(String A, String B) {
        int q = (B.length() - 1) / A.length() + 1;
        int p = 113, MOD = 1_000_000_007;
        int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();

        long bHash = 0, power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * B.codePointAt(i);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0; power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            power = (power * p) % MOD;
        }

        if (aHash == bHash && check(0, A, B)) return q;
        power = (power * pInv) % MOD;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            aHash -= A.codePointAt((i - B.length()) % A.length());
            aHash *= pInv;
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		//String A = "abcd";
		//String B = "cdabcdab";
		String A = "a";
		String B = "aa";
		System.out.println(repeatedStringMatch(A,B));
	}

}
