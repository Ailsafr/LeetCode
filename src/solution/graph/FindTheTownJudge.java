package solution.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-04-28
 * Easy
 * Question 997:Find the Town Judge.
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * 1.The town judge trusts nobody.
 * 2.Everybody (except for the town judge) trusts the town judge.
 * 3.There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * Example 1:
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * Note:
 * 1. 1 <= N <= 1000
 * 2. trust.length <= 10000
 * 3. trust[i] are all different
 * 4. trust[i][0] != trust[i][1]
 * 5. 1 <= trust[i][0], trust[i][1] <= N.
 */
public class FindTheTownJudge {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @param trust
	 * @return
	 */
	public static int findJudge(int N, int[][] trust) {
		int result = -1;
		Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
		for(int[] arr:trust){
			Set<Integer> set = map.get(arr[0]);
			if(set==null){
				set = new HashSet<Integer>();
				set.add(arr[1]);
			}else{
				set.add(arr[1]);
			}
			map.put(arr[0], set);
		}
		for(int i=1;i<N+1;i++){
			if(map.get(i)==null){
				if(result==-1){
					result = i;
				}else{
					return -1;
				}
			}
		}
		for(int i=1;i<N+1;i++){
			if(i!=result){
				if(!map.get(i).contains(result)){
					return -1;
				}
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @param trust
	 * @return
	 */
	public int findJudge1(int N, int[][] trust) {
        if (N == 1) {
            return 1;
        }
        if (trust == null || trust.length == 0 || N == 0) {
            return -1;
        }

        Map<Integer, Integer> trustMap = new HashMap<>();
        for (int [] pair : trust) {
            trustMap.computeIfPresent(pair[0], (k,v) -> v-1);
            trustMap.putIfAbsent(pair[0], -1);
            trustMap.computeIfPresent(pair[1], (k,v) -> v+1);
            trustMap.putIfAbsent(pair[1], 1);
        }
        for (Map.Entry<Integer, Integer> entry : trustMap.entrySet()) {
            if (entry.getValue() == N-1) {
                return entry.getKey();
            }
        }
        return -1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @param trust
	 * @return
	 */
	public int findJudge2(int N, int[][] trust) {
        if(trust.length == 0){return 1;}
        Map<Integer,List<Integer>> town = new HashMap<>();
        for(int[] t : trust){
            List<Integer> l = town.getOrDefault(t[0], new ArrayList<>());
            l.add(t[1]);
            town.put(t[0], l);
        }
        Map<Integer, Integer> trustCount = new HashMap<>();
        for(List<Integer> l : town.values()){
            for(Integer i : l){
                int num = trustCount.getOrDefault(i,0) + 1;
                trustCount.put(i,num);
            }
        }
        for(Map.Entry<Integer,Integer> entry : trustCount.entrySet()){
            if(entry.getValue() == N-1 && !town.containsKey(entry.getKey())){
                return entry.getKey();
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int N = 4;
		int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println(findJudge(N,trust));
	}
	
}
