package solution.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author By RuiCUI
 * 2018-08-14
 * Easy
 * Question 414:Third Maximum Number.
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. 
 * The time complexity must be in O(n).
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int thirdMax(int[] nums) {
		Arrays.sort(nums);
		if(nums.length<3){
			return nums[nums.length-1];
		}
		int a = nums[nums.length-1];
		int b = a;
		for(int i=nums.length-2;i>=0;i--){
			if(nums[i]!=a){
				if(a==b){
					b = nums[i];
				}else{
					if(nums[i]!=b){
						return nums[i];
					}
				}
			}
		}
		return a;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,思维很巧妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int thirdMax1(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public int thirdMax3(int[] nums) {
        int max, mid, small, count;
        max = mid = small = Integer.MIN_VALUE;
        count = 0;  //Count how many top elements have been found.

        for(int x:nums){
            //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
            if( x == max || x == mid ){
                continue;
            }
            if(x>max){
                //right shift
                small = mid;
                mid = max;
                max = x;
                count++;
            }else if(x>mid){
                //right shift
                small = mid;
                mid = x;
                count++;
            }else if(x>=small){ //if small duplicated, that's find, there's no shift and need to increase count.
                small = x;
                count++;
            }
        }
        //"count" is used for checking whether found top 3 maximum elements.
        if(count>=3){ 
            return small;
        }else{
            return max;
        }
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public final int N = 3;
    public int thirdMax4(int[] nums) {
        if (nums.length == 0) return 0;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (set.size() < N || nums[i] > set.first()) {
                if (set.size() == N) set.remove(set.first());
                set.add(nums[i]);
            }
        }
        return set.size() == N ? set.first() : set.last();
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println(thirdMax(nums));
	}
}
