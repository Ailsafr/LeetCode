package solution.array;

/**
 * @author By RuiCUI
 * 2019-04-08
 * Easy
 * Question 941:Valid Mountain Array.
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * Recall that A is a mountain array if and only if:
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * Example 1:
 * Input: [2,1]
 * Output: false
 * Example 2:
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * Input: [0,3,2,1]
 * Output: true
 * Note:
 * 1. 0 <= A.length <= 10000
 * 2. 0 <= A[i] <= 10000. 
 */
public class ValidMountainArray {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static boolean validMountainArray(int[] A) {
		int len = A.length;
		if(len<3){
			return false;
		}
		boolean asc = true;
		for(int i=0;i<len-1;i++){
			if(A[i]<A[i+1]){
				if(!asc){
					return false;
				}
			}else if(A[i]==A[i+1]){
				return false;
			}else{
				if(i==0){
					return false;
				}
				if(asc){
					asc = false;
				}
			}
		}
		return !asc;
    }
	
	/**
	 * 答案--One Pass
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public boolean validMountainArray1(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }
    
	public static void main(String[] args) {
		int[] A = {3,2,1};
		System.out.println(validMountainArray(A));
	}

}
