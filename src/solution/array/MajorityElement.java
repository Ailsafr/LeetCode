package solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author By RuiCUI
 * 2018-04-13
 * Easy
 * Question 169:Majority Element.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i],map.get(nums[i])+1);
			}else{
				map.put(nums[i], 1);
			}
		}
		int tmp = 0;
		int result = 0;
		for(int i:map.keySet()){
			if(tmp<map.get(i)){
				tmp = map.get(i);
				result = i;
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force【超出时限】
	 * 时间复杂度：O(n^2) n的平方 
	 * 空间复杂度：O(1)
	 * @param prices
	 * @return
	 */
	public int majorityElement1(int[] nums) {
        int majorityCount = nums.length/2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;    
    }
	
	/**
	 * 答案2--HashMap 跟我的解法一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    
    /**
	 * 答案3--排序，这个比较机智
	 * 时间复杂度：O(nlgn)
	 * 空间复杂度：O(n) or O(1)
	 * @param nums
	 * @return
	 */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    /**
	 * 答案4--随机选择，竟然还可以这样
	 * 时间复杂度：O(无穷)
	 * 空间复杂度：O(n) or O(1)
	 * @param nums
	 * @return
	 */
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement4(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length/2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
	
    /**
	 * 答案5--Divide and Conquer 分治法
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(lgn)
	 * @param nums
	 * @return
	 */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }
        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);
        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }
        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public int majorityElement5(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
    
    /**
	 * 答案6--Boyer-Moore Voting Algorithm 多数投票算法  机智！
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
    public int majorityElement6(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(majorityElement(nums));
	}

}
