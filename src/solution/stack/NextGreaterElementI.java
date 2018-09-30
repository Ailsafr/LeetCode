package solution.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-09-30
 * Easy
 * Question 496:Next Greater Element I.
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * 1.All elements in nums1 and nums2 are unique.
 * 2.The length of both nums1 and nums2 would not exceed 1000.
 */
public class NextGreaterElementI {
	
	/**
	 * 我自己写的方法,参考的别人的，没想出来单纯用stack怎么实现，实际上是搭配map用的。
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++)
        	nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++)
        	nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
	    Map<Integer, Integer> m = new HashMap<>();
	    // go through each element in nums and set its location in HashMap
	    for(int i =0;i<nums2.length;++i)
	        m.put(nums2[i],i); //since every element is unique, there is no need (getOrDefault)
	    
	    //scan each element in the first array    
	    for(int i=0;i<nums1.length;++i)
	    {
	        int minIndex =-1;  //initially, set the finding index to be -1
	        int index = m.get(nums1[i]); //findout the corresponding index in the second (nums) array.
	        while(++index < nums2.length) 
	        {
	            if(nums2[index]>nums1[i])
	            {
	                minIndex =index;
	                break;
	            }
	        }
	        if(minIndex ==-1) nums1[i] = -1;
	        else nums1[i] = nums2[minIndex];
	    }
	    return nums1;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		System.out.println(nextGreaterElement(nums1,nums2));
	}

}
