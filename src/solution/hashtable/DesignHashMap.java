package solution.hashtable;

/**
 * @author By RuiCUI
 * 2018-12-29
 * Easy
 * Question 706:Design HashMap.
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * put(key, value) : Insert a (key, value) pair into the HashMap. 
 * If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * Example:
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);         
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1 
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found) 
 * Note:
 * 1.All keys and values will be in the range of [0, 1000000].
 * 2.The number of operations will be in the range of [1, 10000].
 * 3.Please do not use the built-in HashMap library.
 */
public class DesignHashMap {
	
	/**
	 * 我自己写的方法
	 */
	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
	/** Initialize your data structure here. */
	int num = 1000;
	int value = -1;
	int[][] array = null;
    public DesignHashMap() {
        array = new int[num][num];
        for(int i=0;i<num;i++){
        	for(int j=0;j<num;j++){
        		array[i][j] = -1;
        	}
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        array[key/num][key%num] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
		return  array[key/num][key%num];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	 array[key/num][key%num] = -1;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 */
    /*final ListNode[] nodes = new ListNode[10000];

    public void put(int key, int value) {
        int i = idx(key);
        if (nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(nodes[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get(int key) {
        int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (nodes[i] == null) return;
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    int idx(int key) { return Integer.hashCode(key) % nodes.length;}

    ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
*/
    
    /**
	 * 官网没有solution,这是其他人的答案
	 */
    /*int [] map;
    *//** Initialize your data structure here. *//*
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    *//** value will always be non-negative. *//*
    public void put(int key, int value) {
        map[key]=value;
    }
    
    *//** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key *//*
    public int get(int key) {
        return map[key];
    }
    
    *//** Removes the mapping of the specified value key if this map contains a mapping for the key *//*
    public void remove(int key) {
        map[key]=-1;
    }*/
    
	public static void main(String[] args) {
		DesignHashMap hashMap = new DesignHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);                             // update the existing value
		System.out.println(hashMap.get(2));            // returns 1 
		hashMap.remove(2);                             // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found) 
	}

}
