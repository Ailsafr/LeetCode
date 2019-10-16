package solution.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2019-10-16
 * Medium
 * Question 133:Clone Graph.
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. 
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * Example:
 * Input:
 * 		1————————2
 * 		|        |
 * 		|        |
 * 		4————————3
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 * Note:
 * 1. The number of nodes will be between 1 and 100.
 * 2. The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * 3. Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * 4. You must return the copy of the given node as a reference to the cloned graph.
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
public class CloneGraph {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n) 
	 * @param node
	 * @return
	 */
	public static Node cloneGraph(Node node) {
		if (node == null) return null;
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(node);
    	Map<Node, Node> map = new HashMap<Node, Node>();
    	map.put(node, new Node(node.val, new ArrayList<Node>()));
    	while (!queue.isEmpty()) {
    		Node node1 = queue.poll();
    		for (Node neighbor : node1.neighbors) {
    			if (!map.containsKey(neighbor)) {
    				map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
    				queue.add(neighbor);
    			}
    			map.get(node1).neighbors.add(map.get(neighbor));
    		}
    	}
    	return map.get(node);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param node
	 * @return
	 */
	private HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph1(Node node) {
        return clone(node);
    }
    private Node clone(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node clone = new Node(node.val,new ArrayList<Node>());
        map.put(clone.val, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param node
	 * @return
	 */
    public Node cloneGraph2(Node node) {
    	if (node == null) return null;
    	// use a queue to help BFS
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(node);
    	// use a map to save cloned nodes
    	Map<Node, Node> map = new HashMap<Node, Node>();
    	// clone the root
    	map.put(node, new Node(node.val, new ArrayList<Node>()));
    	while (!queue.isEmpty()) {
    		Node node1 = queue.poll();
    		// handle the neighbors
    		for (Node neighbor : node1.neighbors) {
    			if (!map.containsKey(neighbor)) {
    				// clone the neighbor
    				map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
    				// add it to the next level
    				queue.add(neighbor);
    			}
    			// copy the neighbor
    			map.get(node1).neighbors.add(map.get(neighbor));
    		}
    	}
    	return map.get(node);
    }
	
    /**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param node
	 * @return
	 */
    private Map<Node, Node> map1 = new HashMap<Node, Node>();
	// DFS
	public Node cloneGraph3(Node node) {
		if (node == null) return null;
	    if (map1.containsKey(node)) return map1.get(node);
	    Node copy = new Node(node.val, new ArrayList<Node>());
	    map1.put(node, copy);
	    for (Node n : node.neighbors)
	    	copy.neighbors.add(cloneGraph3(n));
	    return copy;
	}
	// BFS
	public Node cloneGraph4(Node node) {
	    if (node == null) return null;
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(node);
	    Node copy = new Node(node.val, new ArrayList<Node>());
	    map1.put(node, copy);
	    while (!q.isEmpty()) {
	    	Node cur = q.poll();
	        for (Node neigh : cur.neighbors) {
	            if (map1.containsKey(neigh)) map1.get(cur).neighbors.add(map1.get(neigh));
	            else {
	            	Node neighCopy = new Node(neigh.val, new ArrayList<Node>());
	            	map1.put(neigh, neighCopy);
	            	map1.get(cur).neighbors.add(neighCopy);
	                q.add(neigh);
	            }
	        }
	    }
	    return copy;
	}
    
	public static void main(String[] args) {
		Node node1 = new Node(1,null);
		Node node2 = new Node(2,null);
		Node node3 = new Node(3,null);
		Node node4 = new Node(4,null);
		List<Node> list1 = new ArrayList<Node>();
		List<Node> list2 = new ArrayList<Node>();
		List<Node> list3 = new ArrayList<Node>();
		List<Node> list4 = new ArrayList<Node>();
		list1.add(node2);
		list1.add(node4);
		list2.add(node1);
		list2.add(node3);
		list3.add(node2);
		list3.add(node4);
		list4.add(node1);
		list4.add(node3);
		node1.neighbors = list1;
		node2.neighbors = list2;
		node3.neighbors = list3;
		node4.neighbors = list4;
		
		System.out.println(cloneGraph(node1));
	}

}
