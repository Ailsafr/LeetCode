package solution.design;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-10-28
 * Medium
 * Question 146:LRU Cache.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * Example:
 * LRUCache cache = new LRUCache( 2 {* capacity *});
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
	/**
	 * 我自己写的方法
	 * @param capacity
	 * @return
	 */
	private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
    	CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
    	return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
    	map.put(key, value);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param capacity
	 * @return
	 */
    class DLinkedNode {
    	int key;
    	int value;
    	DLinkedNode pre;
    	DLinkedNode post;
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node){
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail. 
	private DLinkedNode popTail(){
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}

	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	/*public LRUCache(int capacity) {
	  this.count = 0;
	  this.capacity = capacity;

	  head = new DLinkedNode();
	  head.pre = null;

	  tail = new DLinkedNode();
	  tail.post = null;

	  head.post = tail;
	  tail.pre = head;
	}

	public int get(int key) {

	  DLinkedNode node = cache.get(key);
	  if(node == null){
	    return -1; // should raise exception here.
	  }

	  // move the accessed node to the head;
	  this.moveToHead(node);

	  return node.value;
	}

	public void put(int key, int value) {
	  DLinkedNode node = cache.get(key);

	  if(node == null){

	    DLinkedNode newNode = new DLinkedNode();
	    newNode.key = key;
	    newNode.value = value;

	    this.cache.put(key, newNode);
	    this.addNode(newNode);

	    ++count;

	    if(count > capacity){
	      // pop the tail
	      DLinkedNode tail = this.popTail();
	      this.cache.remove(tail.key);
	      --count;
	    }
	  }else{
	    // update the value.
	    node.value = value;
	    this.moveToHead(node);
	  }
	}*/

	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param capacity
	 * @return
	 */
	/*private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }
    
    public void set(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }
    
    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }*/
    
	public static void main(String[] args) {
		int capacity = 2;
		LRUCache cache = new LRUCache( 2*capacity);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

}
