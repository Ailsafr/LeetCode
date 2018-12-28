package solution.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author By RuiCUI
 * 2018-12-28
 * Easy
 * Question 705:Design HashSet.
 * Design a HashSet without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * add(value): Insert a value into the HashSet. 
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 * Example:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);         
 * hashSet.add(2);         
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);          
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // returns false (already removed)
 * Note:
 * 1.All values will be in the range of [0, 1000000].
 * 2.The number of operations will be in the range of [1, 10000].
 * 3.Please do not use the built-in HashSet library.
 */
public class DesignHashSet {
	
	/**
	 * 我自己写的方法
	 */
	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */
	 /** Initialize your data structure here. */
	List<Integer> set = null;
    public DesignHashSet() {
        set = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        set.add(key);
    }
    
    public void remove(int key) {
    	Predicate<Integer> filter = x -> x==key;;
        set.removeIf(filter);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	for(int k:set){
        	if(k==key){
        		return true;
        	}
        }
		return false;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 */
   /* private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;
    
    *//** Initialize your data structure here. *//*
    public MyHashSet() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }
    
    public void add(int key) {
        int hashkey = hash(key);
        
        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null)
            table[hashkey][pos(key)] = false;
    }
    
    *//** Returns true if this set did not already contain the specified element *//*
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }*/
    
	public static void main(String[] args) {
		DesignHashSet set = new DesignHashSet();
		set.add(1);
		set.add(2);
		System.out.println(set.contains(1));
		System.out.println(set.contains(3));
		set.add(2);
		System.out.println(set.contains(2));
		set.remove(2);
		System.out.println(set.contains(2));
	}

}
