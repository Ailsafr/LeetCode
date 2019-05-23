package solution.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author By RuiCUI
 * 2019-05-23
 * Easy
 * Question 1046:Last Stone Weight.
 * We have a collection of rocks, each rock has a positive integer weight.
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  
 * The result of this smash is:
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * Example 1:
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation: 
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * Note:
 * 1. 1 <= stones.length <= 30
 * 2. 1 <= stones[i] <= 1000.
 * Hint:
 * Simulate the process. We can do it with a heap, or by sorting some list of stones every time we take a turn.
 */
public class LastStoneWeight {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param stones
	 * @return
	 */
	public static int lastStoneWeight(int[] stones) {
		int len = stones.length;
		if(len==1){
			return stones[0];
		}
		Arrays.sort(stones);
		while(stones[len-2]!=0){
			int n1 = stones[len-1];
			int n2 = stones[len-2];
			if(n1==n2){
				stones[len-1] = 0;
				stones[len-2] = 0;
			}else{
				stones[len-1] = n1 - n2;
				stones[len-2] = 0;
			}
			Arrays.sort(stones);
		}
		return stones[len-1];
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(n)
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight1(int[] st) {

         if (st == null || st.length == 0) return Integer.MIN_VALUE;
         if (st.length == 1) return st[0];
         if (st.length == 2) return Math.abs(st[0] - st[1]);

         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
             return -Integer.compare(a, b);
         });
         for (int io : st) pq.offer(io);

         while (pq.size() >= 2)  pq.offer(pq.poll() - pq.poll());
     
         return pq.peek();

    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight2(int[] stones) {
	     
		List<Integer> list = new ArrayList<>();
		for(int stone:stones) {list.add(stone);};
		while(list.size()>1) {
			Collections.sort(list);
			int rock_a = list.get(list.size()-1);
			list.remove(list.size()-1);
			int rock_b = list.get(list.size()-1);
			list.remove(list.size()-1);
			int mat = Math.abs(rock_a-rock_b);
			if(mat>0) list.add(mat);
		}
		return (list.isEmpty())?0:list.get(0);
	}
	
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(stones));
	}

}
