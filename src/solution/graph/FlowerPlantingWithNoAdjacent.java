package solution.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-05-22
 * Easy
 * Question 1042:Flower Planting With No Adjacent.
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
 * Also, there is no garden that has more than 3 paths coming into or leaving it.
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, 
 * they have different types of flowers.
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  
 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 * Example 1:
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * Example 2:
 * Input: N = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * Example 3:
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * Note:
 * 1. 1 <= N <= 10000
 * 2. 0 <= paths.size <= 20000
 * 3. No garden has 4 or more paths coming into or leaving it.
 * 4. It is guaranteed an answer exists.
 * Hint:
 * Since each garden is connected to at most 3 gardens, there's always an available color for each garden. 
 * For example, if one garden is next to gardens with colors 1, 3, 4, then color #2 is available.
 */
public class FlowerPlantingWithNoAdjacent {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @param paths
	 * @return
	 */
	public static int[] gardenNoAdj(int N, int[][] paths) {
		int[] result = new int[N];
		Map<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
		//获取各个花园都跟哪几个花园相连
		for(int[] array:paths){
			int num1 = array[0] - 1;
			int num2 = array[1] - 1;
			HashSet<Integer> set = map.getOrDefault(num1, new HashSet<Integer>());
			set.add(num2);
			map.put(num1, set);
			HashSet<Integer> set1 = map.getOrDefault(num2, new HashSet<Integer>());
			set1.add(num1);
			map.put(num2, set1);
		}
		for(int i=0;i<N;i++){
			int[] colors=new int[4];
            if(!map.containsKey(i)) {
                result[i] = 1;
                continue;
            }
            for(int j:map.get(i)){
            	if(result[j]!=0) colors[result[j]-1]=-1;
            }
            for(int j=0;j<4;j++) {
                if(colors[j]==0) result[i]=j+1;
            }
		}
		return result;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @param paths
	 * @return
	 */
	public int[] gardenNoAdj1(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int i=0;i<paths.length;i++) {
            if(!graph.containsKey(paths[i][0]-1)) graph.put(paths[i][0]-1, new HashSet<Integer>());
            if(!graph.containsKey(paths[i][1]-1)) graph.put(paths[i][1]-1, new HashSet<Integer>());
            graph.get(paths[i][0]-1).add(paths[i][1]-1);
            graph.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        int[] res=new int[N];
        for(int i=0;i<N;i++) {
            int[] colors=new int[4];
            if(!graph.containsKey(i)) {
                res[i]=1;
                continue;
            }
            for(int j : graph.get(i)) if(res[j]!=0) colors[res[j]-1]=-1;
            for(int j=0;j<4;j++) {
                if(colors[j]==0) res[i]=j+1;
            }
        }
        return res;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param N
	 * @param paths
	 * @return
	 */
	 public int[] gardenNoAdj2(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }
        int[] ans = new int[N];
        for (int i = 1; i <= N; i++) {
            Set<Integer> neiColor = new HashSet<>();
            for (int nei : map.get(i)) {
                neiColor.add(ans[nei - 1]);
            }
            for (int color = 1; color <= 4; color++) {
                if (!neiColor.contains(color)) {
                    ans[i - 1] = color;
                }
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int N = 4;
		int[][] paths = {{1,2},{3,4}};
		System.out.println(Arrays.toString(gardenNoAdj(N,paths)));
	}
	
}
