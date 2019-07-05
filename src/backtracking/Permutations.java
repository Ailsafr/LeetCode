package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-05
 * Medium
 * Question 46:Permutations.
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 */
public class Permutations {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, new ArrayList<>(), nums);
		return list;
	}
	private static void helper(List<List<Integer>> list, List<Integer> tempList, int[] nums){
	    if(tempList.size() == nums.length){
	    	list.add(new ArrayList<>(tempList));
	    } else{
	    	for(int i = 0; i < nums.length; i++){ 
	    		if(tempList.contains(nums[i])) continue; // element already exists, skip
	    		tempList.add(nums[i]);
	    		helper(list, tempList, nums);
	    		tempList.remove(tempList.size() - 1);
	    	}
	    }
	} 
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){
	    if(tempList.size() == nums.length){
	    	list.add(new ArrayList<>(tempList));
	    } else{
	    	for(int i = 0; i < nums.length; i++){ 
	    		if(tempList.contains(nums[i])) continue; // element already exists, skip
	    		tempList.add(nums[i]);
	    		backtrack(list, tempList, nums);
	    		tempList.remove(tempList.size() - 1);
	    	}
	    }
	} 
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permute2(int[] num) {
	    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    for (int n : num) {
	        int size = res.size();
	        for (; size > 0; size--) {
	            List<Integer> r = res.pollFirst();
	            for (int i = 0; i <= r.size(); i++) {
	                List<Integer> t = new ArrayList<Integer>(r);
	                t.add(i, n);
	                res.add(t);
	            }
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute2(nums));
	}

}
