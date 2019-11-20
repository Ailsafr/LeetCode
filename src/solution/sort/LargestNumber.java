package solution.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author By RuiCUI
 * 2019-11-20
 * Medium
 * Question 179:Largest Number.
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(nlgn)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static String largestNumber(int[] nums) {
		String result = "";
		int len = nums.length;
		if (len == 0) {
			return result;
		}
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				int n1 = nums[i];
				int n2 = nums[j];
				String s1 = String.valueOf(n1);
				String s2 = String.valueOf(n2);
				if ((s1+s2).compareTo(s2+s1) < 0) {
					swap(nums, i, j);
				} else {
					continue;
				}
			}
		}
		for (int n : nums) {
			result += n;
		}
		if (result.startsWith("0")) {
			result = "0";
		}
		return result;
    }
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	/**
	 * 答案--Sorting via Custom Comparator
	 * 时间复杂度：O(nlgn)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber1(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,30,34,5,9};
		System.out.println(largestNumber(nums));
	}

}
