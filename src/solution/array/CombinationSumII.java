package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-07-03
 * Medium
 * Question 40:Combination Sum II.
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
	[
	  [1,2,2],
	  [5]
	]
 */
public class CombinationSumII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		helper(candidates,0,target,path,result);
		return result;
    }
	private static void helper(int[] candidates, int cur, int target, List<Integer> path, List<List<Integer>> result){
		if(target==0){
			result.add(new ArrayList(path));
			return;
		}else if(target<0){
			return;
		}else{
			for(int i=cur;i<candidates.length;i++){
				if(i>cur&&candidates[i]==candidates[i-1]){
					continue;
				}
				path.add(path.size(),candidates[i]);
				helper(candidates, i+1, target-candidates[i], path, result);
				path.remove(path.size()-1);
			}
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param candidates
	 * @param target
	 * @return
	 */
	 public List<List<Integer>> combinationSum21(int[] cand, int target) {
		 Arrays.sort(cand);
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 List<Integer> path = new ArrayList<Integer>();
		 dfs_com(cand, 0, target, path, res);
		 return res;
	 }
	 void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
	    if (target == 0) {
	        res.add(new ArrayList(path));
	        return ;
	    }
	    if (target < 0) return;
	    for (int i = cur; i < cand.length; i++){
	        if (i > cur && cand[i] == cand[i-1]) continue;
	        path.add(path.size(), cand[i]);
	        dfs_com(cand, i+1, target - cand[i], path, res);
	        path.remove(path.size()-1);
	    }
	 }
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(combinationSum2(candidates,target));
	}

}
