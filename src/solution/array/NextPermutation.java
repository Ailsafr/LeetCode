package solution.array;

/**
 * @author By RuiCUI
 * 2019-06-26
 * Medium
 * Question 31:Next Permutation.
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1.
 */
public class NextPermutation {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    /**
	 * ��--Single Pass Approach
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
	public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap1(nums, i, j);
        }
        reverse1(nums, i + 1);
    }

    private void reverse1(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		nextPermutation(nums);
	}

}
