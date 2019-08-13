package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-08-13
 * Medium
 * Question 90:Subsets II.
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: [1,2,2]
 * Output:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 */
public class SubsetsII {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> each = new ArrayList<>();
	    helper(res, each, 0, nums);
	    return res;
	}
	private static void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
	    if (pos <= n.length) {
	        res.add(each);
	    }
	    int i = pos;
	    while (i < n.length) {
	        each.add(n[i]);
	        helper(res, new ArrayList<>(each), i + 1, n);
	        each.remove(each.size() - 1);
	        i++;
	        while (i < n.length && n[i] == n[i - 1]) {i++;}
	    }
	    return;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup1(int[] nums) {
	    Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> each = new ArrayList<>();
	    helper1(res, each, 0, nums);
	    return res;
	}
	public void helper1(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
	    if (pos <= n.length) {
	        res.add(each);
	    }
	    int i = pos;
	    while (i < n.length) {
	        each.add(n[i]);
	        helper1(res, new ArrayList<>(each), i + 1, n);
	        each.remove(each.size() - 1);
	        i++;
	        while (i < n.length && n[i] == n[i - 1]) {i++;}
	    }
	    return;
	}

	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        result.add(path);
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,result);
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums));
	}

}
