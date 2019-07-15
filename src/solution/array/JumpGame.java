package solution.array;

/**
 * @author By RuiCUI
 * 2019-07-15
 * Medium
 * Question 55:Jump Game.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. 
 * 	            Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	
	/**
	 * ��1--Backtracking
	 * ʱ�临�Ӷȣ�O(2^n)
	 * �ռ临�Ӷȣ�O(n) 
	 * @param nums
	 * @return
	 */
	public boolean canJump1(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
	public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * ��2--Dynamic Programming Top-down
	 * ʱ�临�Ӷȣ�O(n^2)
	 * �ռ临�Ӷȣ�O(2n) 
	 * @param nums
	 * @return
	 */
	public boolean canJump2(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition1(0, nums);
    }
	enum Index {
	    GOOD, BAD, UNKNOWN
	}
	Index[] memo;
    public boolean canJumpFromPosition1(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition1(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
	
	/**
	 * ��3--Dynamic Programming Bottom-up
	 * ʱ�临�Ӷȣ�O(n^2)
	 * �ռ临�Ӷȣ�O(n) 
	 * @param nums
	 * @return
	 */
    public boolean canJump3(int[] nums) {
    	Index1[] memo = new Index1[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index1.UNKNOWN;
        }
        memo[memo.length - 1] = Index1.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index1.GOOD) {
                    memo[i] = Index1.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index1.GOOD;
    }
    enum Index1{
        GOOD, BAD, UNKNOWN
    }
	
	/**
	 * ��4--Greedy
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1) 
	 * @param nums
	 * @return
	 */
    public boolean canJump4(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(canJump(nums));
	}

}
