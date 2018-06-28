package solution.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-05-28
 * Easy
 * Question 232:Implement Queue using Stacks
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {
	
	/**
	 * 我自己写的方法
	 */
	private Stack stack1;
	private Stack stack2;
	
	/** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack1.empty()){
        	return 0;
        }else if(stack1.size()==1){
        	return (int) stack1.pop();
        }
        int len = stack1.size();
    	for(int i=0;i<len;i++){
    		stack2.push(stack1.pop());
    	}
    	int result = (int) stack2.pop();
    	for(int i=0;i<len-1;i++){
    		stack1.push(stack2.pop());
    	}
    	return result;
    }
    
    /** Get the front element. */
    public int peek() {
    	if(stack1.empty()){
        	return 0;
        }else if(stack1.size()==1){
        	return (int) stack1.peek();
        }
    	int len = stack1.size();
    	for(int i=0;i<len;i++){
    		stack2.push(stack1.pop());
    	}
    	int result = (int) stack2.peek();
    	for(int i=0;i<len;i++){
    		stack1.push(stack2.pop());
    	}
    	return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    
    /**
	 * 答案1--(Two Stacks) Push - O(n) per operation, Pop - O(1) per operation.
	 */
    /*
    private int front;

	public void push(int x) {
	    if (s1.empty())
	        front = x;
	    while (!s1.isEmpty())
	        s2.push(s1.pop());
	    s2.push(x);
	    while (!s2.isEmpty())
	        s1.push(s2.pop());
	}
	
	public boolean empty() {
	    return s1.isEmpty();
	}
	
	public void pop() {
	    s1.pop();
	    if (!s1.empty())
	        front = s1.peek();
	}
	
	public int peek() {
	    return front;
	}
    */
    
    /**
	 * 答案2--(Two Stacks) Push - O(1) per operation, Pop - Amortized O(1) per operation.
	 */
    /*
    private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	
	// Push element x to the back of queue.
	public void push(int x) {
	    if (s1.empty())
	        front = x;
	    s1.push(x);
	}
	
	public void pop() {
	    if (s2.isEmpty()) {
	        while (!s1.isEmpty())
	            s2.push(s1.pop());
	    }
	    s2.pop();    
	}
	
	public boolean empty() {
	    return s1.isEmpty() && s2.isEmpty();
	}
	
	public int peek() {
	    if (!s2.isEmpty()) {
	            return s2.peek();
	    }
	    return front;
	}
    
    */
    
	public static void main(String[] args) {
		ImplementQueueUsingStacks minStack = new ImplementQueueUsingStacks();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.peek());   
		System.out.println(minStack.pop());      
		System.out.println(minStack.peek());
	}

}
