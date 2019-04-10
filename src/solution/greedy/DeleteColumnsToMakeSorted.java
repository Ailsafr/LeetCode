package solution.greedy;

/**
 * @author By RuiCUI
 * 2019-04-10
 * Easy
 * Question 944:Delete Columns to Make Sorted.
 * We are given an array A of N lowercase letter strings, all of the same length.
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, 
 * then the final array after deletions is ["bef", "vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  
 * (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 * Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in non-decreasing sorted order.
 * Return the minimum possible value of D.length.
 * Example 1:
 * Input: ["cba","daf","ghi"]
 * Output: 1
 * Explanation: 
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
 * Example 2:
 * Input: ["a","b"]
 * Output: 0
 * Explanation: D = {}
 * Example 3:
 * Input: ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation: D = {0, 1, 2}
 * Note:
 * 1. 1 <= A.length <= 100
 * 2. 1 <= A[i].length <= 1000.
 */
public class DeleteColumnsToMakeSorted {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(N) where N is the total content of A.
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public static int minDeletionSize(String[] A) {
		int len = A.length;
		int n = A[0].length();
		int res = 0;
		for(int i=0;i<n;i++){
			char c = 'Z';
			for(int j=0;j<len;j++){
				if(c>A[j].charAt(i)){
					res += 1;
					break;
				}else{
					c = A[j].charAt(i);
				}
			}
		}
		return res;
    }
	
	/**
	 * 答案--Greedy
	 * 时间复杂度：O(N) where N is the total content of A.
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public int minDeletionSize1(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }
	
	public static void main(String[] args) {
		String[] A = {"zyx","wvu","tsr"};
		System.out.println(minDeletionSize(A));
	}

}
