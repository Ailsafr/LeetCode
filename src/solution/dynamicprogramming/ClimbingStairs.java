package solution.dynamicprogramming;

/**
 * @author By RuiCUI
 * 2018-03-07
 * Easy
 * Question 070:Climbing Stairs.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * Example 1:
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(2^n) 
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if(n<2){
			return 1;
		}
		return climbStairs(n-1)+climbStairs(n-2);
	}
	
	/**
	 * 我自己写的方法--想用斐波那契通项公式，但是好像不对
	 * @param n
	 * @return
	 */
	public static int climbStairs1(int n) {
		return (int) (1/(Math.sqrt(5))*((Math.pow((1+Math.sqrt(5))/2, n))-(Math.pow((1-Math.sqrt(5))/2, n))));
	}

	/**
	 * 答案1--Brute Force【超出时限】
	 * 时间复杂度：O(2^n) 
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
        return climb_Stairs2(0, n);
    }
    public int climb_Stairs2(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs2(i + 1, n) + climb_Stairs2(i + 2, n);
    }
	
    /**
	 * 答案2--递归与记忆（备忘录方法的递归）
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
    public int climbStairs3(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs3(0, n, memo);
    }
    public int climb_Stairs3(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs3(i + 1, n, memo) + climb_Stairs3(i + 2, n, memo);
        return memo[i];
    }
    
    /**
	 * 答案3--动态规划
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    /**
	 * 答案4--斐波那契数列
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
    public int climbStairs5(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    
    /**
	 * 答案5--Binets方法（理解起来比较费劲，大学学的数学全还给老师了）
	 * 时间复杂度：O(logn) 
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
    public int climbStairs6(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
    
    /**
	 * 答案6--斐波那契公式
	 * 时间复杂度：O(logn) 
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
    public int climbStairs7(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
    
	public static void main(String[] args) {
		int n = 2;
		System.out.println(climbStairs1(n));
	}

}
