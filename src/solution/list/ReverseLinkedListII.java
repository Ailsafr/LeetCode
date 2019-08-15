package solution.list;

/**
 * @author By RuiCUI
 * 2019-08-15
 * Medium
 * Question 092:Reverse Linked List II.
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL.
 */
public class ReverseLinkedListII {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	private static boolean stop;
    private static ListNode left;
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		left = head;
        stop = false;
        helper(head, m, n);
        return head;
    }
    public static void helper(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }
        right = right.next;
        if (m > 1) {
            left = left.next;
        }
        helper(right, m - 1, n - 1);
        if (left == right || right.next == left) {
            stop = true;            
        }
        if (!stop) {
            int t = left.val;
            left.val = right.val;
            right.val = t;
            left = left.next;
        }
    }
	
	/**
	 * 答案1--Recursion
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween1(ListNode head, int m, int n) {
        this.left1 = head;
        this.stop1 = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
	private boolean stop1;
    private ListNode left1;
    public void recurseAndReverse(ListNode right, int m, int n) {
        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }
        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;
        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left1 = this.left1.next;
        }
        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);
        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left1 == right || right.next == this.left1) {
            this.stop1 = true;            
        }
        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop1) {
            int t = this.left1.val;
            this.left1.val = right.val;
            right.val = t;
            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left1 = this.left1.next;
        }
    }
	
	/**
	 * 答案2--Iterative Link Reversal
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }
        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;
        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		int m = 2;
		int n = 4;
		System.out.println(reverseBetween(l1,m,n));
	}

}
