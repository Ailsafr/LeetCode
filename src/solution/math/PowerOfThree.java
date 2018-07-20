package solution.math;

/**
 * @author By RuiCUI
 * 2018-07-19
 * Easy
 * Question 326:Power of Three.
 * Given an integer, write a function to determine if it is a power of three.
 * Example 1:
 * Input: 27
 * Output: true
 * Example 2:
 * Input: 0
 * Output: false
 * Example 3:
 * Input: 9
 * Output: true
 * Example 4:
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree {

	/**
	 * 我自己写的方法--我想的复杂了
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree(int n) {
		if(n==1){
			return true;
		}
		if(n%3!=0){
			return false;
		}
		while(n>2){
			if(n%3!=0){
				n = n%3;
			}else{
				if(n==3){
					return true;
				}else{
					n = n/3;
				}
			}
		}
		return false;
	}
	
	/**
	 * 答案1--Loop Iteration [Accepted]
	 * 时间复杂度：O(log3n) 3为底数
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree1(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
	
	/**
	 * 答案2--Base Conversion [Accepted]
	 * 时间复杂度：O(log3n) 3为底数
	 * 空间复杂度：O(log3n) 3为底数
	 * @param n
	 * @return
	 */
    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
    
    /**
	 * 答案3--Mathematics [Accepted]
	 * 时间复杂度：unknown
	 * 空间复杂度：O(1) 
	 * @param n
	 * @return
	 */
    public boolean isPowerOfThree3(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        //This solution is problematic because we start using doubles, which means we are subject to precision errors. 
        //This means, we should never use == when comparing doubles. 
        //That is because the result of Math.log10(n) / Math.log10(3) could be 5.0000001 or 4.9999999. 
        //This effect can be observed by using the function Math.log() instead of Math.log10().
        //In order to fix that, we need to compare the result against an epsilon.
        //return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
    
    /**
	 * 答案4--Integer Limitations [Accepted]
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
    public boolean isPowerOfThree4(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    
	public static void main(String[] args) {
		int num = 9;
		System.out.println(isPowerOfThree(num));
	}

}
