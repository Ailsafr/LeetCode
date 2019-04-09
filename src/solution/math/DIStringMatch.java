package solution.math;

/**
 * @author By RuiCUI
 * 2019-04-09
 * Easy
 * Question 942:DI String Match.
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * Example 1:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * Input: "DDI"
 * Output: [3,2,0,1]
 * Note:
 * 1. 1 <= S.length <= 10000
 * 2. S only contains characters "I" or "D".
 */
public class DIStringMatch {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public static int[] diStringMatch(String S) {
		int num = S.length();
		int numD = num - S.replaceAll("D", "").length();
		int[] result = new int[num+1];
		if(numD==0){
			for(int i=0;i<=num;i++){
				result[i] = i;
			}
		}else if(numD==num){
			for(int i=0;i<=num;i++){
				result[i] = num - i;
			}
		}else{
			int k = 0;
			int d = 0;
			for(int i=0;i<=num;i++){
				if(i!=num){
					if('D'==S.charAt(i)){
						result[i] = num - d;
						d++;
					}else{
						result[i] = k;
						k++;
					}
				}else{
					if('D'==S.charAt(num-1)){
						result[i] = num - d;
					}else{
						result[i] = k;
					}
				}
			}
		}
		return result;
    }
	
	/**
	 * 答案--Ad-Hoc
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public int[] diStringMatch1(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }
	
	public static void main(String[] args) {
		String S = "DDI";
		System.out.println(diStringMatch(S));
	}

}
