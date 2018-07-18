package solution.dynamicprogramming;

/**
 * @author By RuiCUI
 * 2018-07-18
 * Easy
 * Question 303:Range Sum Query - Immutable.
 * Given an integer array nums, find the sum of the elements between indices i and j (i �� j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
	
	/**
	 * ���Լ�д�ķ���--û�������ʲô��˼��ԭ����Ҫ�Լ�����
	 * @param nums
	 * @return
	 */
	/*public NumArray(int[] nums) {
	        
    }
    
    public static int sumRange(int i, int j) {

    }*/
	
	/**
	 * ��1--Brute Force [Time Limit Exceeded]
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @return
	 */
    /*private int[] data;

    public NumArray(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += data[k];
        }
        return sum;
    }*/
	
	/**
	 * ��2--Caching [Accepted]
	 * ʱ�临�Ӷȣ�O(n^2) 
	 * �ռ临�Ӷȣ�O(n^2)
	 * @param nums
	 * @return
	 */
    /*private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                map.put(Pair.create(i, j), sum);
            }
        }
    }

    public int sumRange(int i, int j) {
        return map.get(Pair.create(i, j));
    }*/
    
	/**
	 * ��3--Caching [Accepted]
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(n)
	 * @param nums
	 * @return
	 */
    /*private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }*/
	
	public static void main(String[] args) {
		//int[] nums = {1,2,3,1};
		//int[] nums = {2,7,9,3,1};
		int[] nums = {2,1,1,2};
		//System.out.println(sumRange(1,1));
	}

}
