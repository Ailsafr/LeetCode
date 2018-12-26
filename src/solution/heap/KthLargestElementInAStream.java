package solution.heap;

import java.util.PriorityQueue;

/**
 * @author By RuiCUI
 * 2018-12-26
 * Easy
 * Question 703:Kth Largest Element in a Stream.
 * Design a class to find the kth largest element in a stream. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, 
 * which contains initial elements from the stream. 
 * For each call to the method KthLargest.add, 
 * return the element representing the kth largest element in the stream.
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note: 
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class KthLargestElementInAStream {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(k)
	 * @param k
	 * @param nums
	 * @return
	 */
	/**
	 * Your KthLargest object will be instantiated and called as such:
	 * KthLargest obj = new KthLargest(k, nums);
	 * int param_1 = obj.add(val);
	 */
	PriorityQueue<Integer> q;
    int k;
	public void KthLargest(int k, int[] nums) {
		this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }
    
    public int add(int val) {
    	if (q.size() < k)
            q.offer(val);
        else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
	
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(k)
	 * @param k
	 * @param nums
	 * @return
	 */
    PriorityQueue<Integer> q1;
    int k1;
	public void KthLargest1(int k, int[] nums) {
		this.k1 = k;
        q1 = new PriorityQueue<>(k);
        for (int n : nums)
            add1(n);
    }
    
    public int add1(int val) {
    	if (q1.size() < k1)
            q1.offer(val);
        else if (q1.peek() < val) {
            q1.poll();
            q1.offer(val);
        }
        return q1.peek();
    }
	
	public static void main(String[] args) {
		int k = 3;
		int[] nums = {4,5,8,2};
		//KthLargest(k,nums);
	}

}
