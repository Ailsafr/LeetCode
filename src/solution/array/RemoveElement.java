package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-01-12
 * Easy
 * Question 027:Given an array and a value, remove all instances of that value in-place and return the new length.	 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {

	/**
	 * ���Լ�д�ķ���(����1һ��)
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @param val
	 * @return
	 */
	private static int removeElement(int[] nums, int val) {
		int i = 0;
		if(nums==null||nums.length==0){
			return 0;
		}
		for(int j=0;j<nums.length;j++){
			if(nums[j]!=val){
				nums[i] = nums[j];
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return i;
    }
	
	/**
	 * ��1--����ָ��
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement1(int[] nums, int val) {
	    int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	}
	
	/**
	 * ��2--����ָ�루����Ҫɾ����Ԫ�غ���ʱ������nums=[1,2,3,5,4],val=4��
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement2(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,3,3,3,5};
		int val = 3;
		System.out.println(removeElement(nums, val));
	}

}
