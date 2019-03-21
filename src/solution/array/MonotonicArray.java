package solution.array;

/**
 * @author By RuiCUI
 * 2019-03-21
 * Easy
 * Question 896:Monotonic Array.
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 * Note:
 * 1. 1 <= A.length <= 50000
 * 2. -100000 <= A[i] <= 100000.
 */
public class MonotonicArray {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static boolean isMonotonic(int[] A) {
		boolean inc = false;
		boolean dec = false;
		int len = A.length;
		for(int i=0;i<len-1;i++){
			if(A[i]<A[i+1]){
				inc = true;
			}else if(A[i]>A[i+1]){
				dec = true;
			}
			if(inc&&dec){
				return false;
			}
		}
		return true;
    }
	
	/**
	 * 答案1--Two Pass
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public boolean isMonotonic1(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] > A[i+1]) return false;
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] < A[i+1]) return false;
        return true;
    }

	/**
	 * 答案2--One Pass
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
    public boolean isMonotonic2(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }

	/**
	 * 答案3--One Pass (Simple Variant)
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
    public boolean isMonotonic3(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
	
	public static void main(String[] args) {
		int[] A = {1,1,1};
		System.out.println(isMonotonic(A));
	}

}
