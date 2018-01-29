package solution.array;

/**
 * @author By RuiCUI
 * 2018-01-26
 * Easy
 * Question 035:Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		if(n==0){
			return 0;
		}
		for(int i=0;i<n;i++){
			if(nums[i]>=target){
				return i;
			}
		}
		return n;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,���ַ�
	 * ʱ�临�Ӷȣ�O(Log2n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert2(int[] nums, int target) {
	    int low = 0, high = nums.length;
	    while(low < high) {
	        int mid = low + (high - low) / 2;
	        if(nums[mid] < target)
	            low = mid + 1;
	        else
	            high = mid;
	    }
	    return low;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 0;
		System.out.println(searchInsert(nums,target));
	}

}
