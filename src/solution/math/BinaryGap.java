package solution.math;

/**
 * @author By RuiCUI
 * 2019-03-07
 * Easy
 * Question 868:Binary Gap.
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 * If there aren't two consecutive 1's, return 0.
 * Example 1:
 * Input: 22
 * Output: 2
 * Explanation: 
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 * Input: 5
 * Output: 2
 * Explanation: 
 * 5 in binary is 0b101.
 * Example 3:
 * Input: 6
 * Output: 1
 * Explanation: 
 * 6 in binary is 0b110.
 * Example 4:
 * Input: 8
 * Output: 0
 * Explanation: 
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 * Note:
 * 1. 1 <= N <= 10^9.
 */
public class BinaryGap {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @return
	 */
	public static int binaryGap(int N) {
		String str = Integer.toBinaryString(N);
		int result = 0;
		int left = -1;
		int right = -1;
		char[] array = str.toCharArray();
		int len = array.length;
		for(int i=0;i<len;i++){
			if(array[i]=='1'){
				if(left==-1){
					left = i;
				}else{
					right = i;
					result = Math.max(result, right-left);
					left = right;
				}
			}
		}
		if(left==-1&&right==-1){
			return 0;
		}
		return result;
    }
	
	/**
	 * 答案1--Store Indexes
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(logn)
	 * @param N
	 * @return
	 */
	public int binaryGap1(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }
	
	/**
	 * 答案2--One Pass
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param N
	 * @return
	 */
	public int binaryGap2(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }
    
	public static void main(String[] args) {
		int N = 8;
		System.out.println(binaryGap(N));
	}

}
