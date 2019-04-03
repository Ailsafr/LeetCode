package solution.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2019-04-03
 * Easy
 * Question 933:Number of Recent Calls.
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 * Example 1:
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 * Note:
 * 1. Each test case will have at most 10000 calls to ping.
 * 2. Each test case will call ping with strictly increasing values of t.
 * 3. Each call to ping will have 1 <= t <= 10^9.
 */
public class NumberOfRecentCalls {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param t
	 * @return
	 */
	/**
	 * Your RecentCounter object will be instantiated and called as such:
	 * RecentCounter obj = new RecentCounter();
	 * int param_1 = obj.ping(t);
	 */
	static Queue<Integer> queue;
	public NumberOfRecentCalls() {
		queue = new LinkedList();
    }
    
    public static int ping(int t) {
    	queue.add(t);
        while (queue.peek() < t - 3000)
            queue.poll();
        return queue.size();
    }
	
	/**
	 * 答案--Queue
	 * 时间复杂度：O(Q) where Q is the number of queries made.
	 * 空间复杂度：O(1). 
	 * @param t
	 * @return
	 */
    class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList();
        }

        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000)
                q.poll();
            return q.size();
        }
    }
	
	public static void main(String[] args) {
		int t = 3002;
		System.out.println(ping(t));
	}

}
