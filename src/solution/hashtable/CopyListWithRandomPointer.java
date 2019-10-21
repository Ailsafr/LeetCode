package solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-10-21
 * Medium
 * Question 138:Copy List with Random Pointer.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Example 1:
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 * Note:
 * You must return the copy of the given head as a reference to the cloned list.
 * Hint:
 * 1. Just iterate the linked list and create copies of the nodes on the go. Since a node can be referenced from multiple nodes due to the random pointers, make sure you are not making multiple copies of the same node.
 * 2. You may want to use extra space to keep old node ---> new node mapping to prevent creating multiples copies of same node.
 * 3. We can avoid using extra space for old node ---> new node mapping, by tweaking the original linked list. Simply interweave the nodes of the old and copied list. For e.g.
 *    Old List: A --> B --> C --> D
 *    InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'
 * 4. The interweaving is done using next pointers and we can make use of interweaved structure to get the correct reference nodes for random pointers.
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class CopyListWithRandomPointer {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public static Node copyRandomList(Node head) {
		if (head == null) return null;
		Map<Node, Node> map = new HashMap<Node, Node>();
		// loop 1. copy all the nodes
		Node node = head;
		while (node != null) {
		    map.put(node, new Node(node.val, null, null));
		    node = node.next;
		}
		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
		    map.get(node).next = map.get(node.next);
		    map.get(node).random = map.get(node.random);
		    node = node.next;
		}
		return map.get(head);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public Node copyRandomList1(Node head) {
		Node iter = head, next;
		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
		    next = iter.next;

		    Node copy = new Node(iter.val, null, null);
		    iter.next = copy;
		    copy.next = next;

		    iter = next;
		}

		  // Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
		    if (iter.random != null) {
		      iter.next.random = iter.random.next;
		    }
		    iter = iter.next.next;
		}

		  // Third round: restore the original list, and extract the copy list.
		iter = head;
		Node pseudoHead = new Node(0, null, null);
		Node copy, copyIter = pseudoHead;

		while (iter != null) {
		    next = iter.next.next;

		    // extract the copy
		    copy = iter.next;
		    copyIter.next = copy;
		    copyIter = copy;

		    // restore the original list
		    iter.next = next;

		    iter = next;
		}

		return pseudoHead.next;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 */
	public Node copyRandomList2(Node head) {
		if (head == null) return null;
		Map<Node, Node> map = new HashMap<Node, Node>();
		// loop 1. copy all the nodes
		Node node = head;
		while (node != null) {
		    map.put(node, new Node(node.val, null, null));
		    node = node.next;
		}
		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
		    map.get(node).next = map.get(node.next);
		    map.get(node).random = map.get(node.random);
		    node = node.next;
		}
		return map.get(head);
	}
	
	public static void main(String[] args) {
		Node head = new Node(1, null, null);
		Node node = new Node(2, null, null);
		node.random = node;
		head.next = node;
		head.random = node;
		System.out.println(copyRandomList(head));
	}

}
