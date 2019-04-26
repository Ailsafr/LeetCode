package solution.depthfirstsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author By RuiCUI
 * 2019-01-11
 * Easy
 * Question 743:Network Delay Time.
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), 
 * where u is the source node, v is the target node, 
 * and w is the time it takes for a signal to travel from source to target.
 * Now, we send a signal from a certain node K. 
 * How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * Note:
 * 1.N will be in the range [1, 100].
 * 2.K will be in the range [1, N].
 * 3.The length of times will be in the range [1, 6000].
 * 4.All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 * Hint:
 * We visit each node at some time, and if that time is better than the fastest time we've reached this node, 
 * we travel along outgoing edges in sorted order. Alternatively, we could use Dijkstra's algorithm.
 */
public class NetworkDelayTime {

	/**
	 * 我自己写的方法
	 * 时间复杂度： O(N^2+E) where E is the length of times.
	 * 空间复杂度：O(N+E)
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
	public static int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
	}
	
	/**
	 * 答案1--Depth-First Search[Accepted]
	 * 时间复杂度：O(N^N+ElogE) where E is the length of times. 
	 * 空间复杂度：O(N+E)
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
	Map<Integer, Integer> dist;
    public int networkDelayTime1(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        for (int node: graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dfs(graph, K, 0);
        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info: graph.get(node))
                dfs(graph, info[1], elapsed + info[0]);
    }
	
	/**
	 * 答案2--Dijkstra's Algorithm[Accepted]
	 * 时间复杂度： O(N^2+E) where E is the length of times.
	 * 空间复杂度：O(N+E)
	 * @param times
	 * @param N
	 * @param K
	 * @return
	 */
    public int networkDelayTime2(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }

	public static void main(String[] args) {
		int[][] times = {{1,1,1},{1,1,0},{1,0,1}};
		int N = 1;
		int K = 1;
		System.out.println(networkDelayTime(times,N,K));
	}

}
