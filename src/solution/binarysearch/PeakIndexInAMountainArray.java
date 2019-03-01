package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2019-03-01
 * Easy
 * Question 852:Peak Index in a Mountain Array.
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * Example 1:
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * 1. 3 <= A.length <= 10000
 * 2. 0 <= A[i] <= 10^6
 * 3. A is a mountain, as defined above.
 */
public class PeakIndexInAMountainArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static int peakIndexInMountainArray(int[] A) {
		int len = A.length;
		for(int i=0;i<len;i++){
			if(A[i]>A[i+1]){
				return i;
			}
		}
		return len-1;
    }
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static int peakIndexInMountainArray1(int[] A) {
		int len = A.length;
		int left = 0;
		int right = len-1;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(mid==0){
				return 0;
			}
			if(A[mid]>A[mid+1]&&A[mid-1]<A[mid]){
				return mid;
			}else if(A[mid-1]<A[mid]&&A[mid]<A[mid+1]){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return 0;
    }
	
	
	/**
	 * 答案1--Linear Scan
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int peakIndexInMountainArray2(int[] A) {
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }
	
	/**
	 * 答案2--Binary Search
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int peakIndexInMountainArray3(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
	
	public static void main(String[] args) {
		int[] A = {18,29,38,59,98,100,99,98,90};
		System.out.println(peakIndexInMountainArray1(A));
	}

}
