package solution.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-06-21
 * Easy
 * Question 225:Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * MyStack stack = new MyStack();
 * stack.push(1);
 * stack.push(2);  
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues {
	
	private Queue stack;
	private Queue stack1;
	private int top;
	
	/**
	 * ���Լ�д�ķ���
	 */
	/** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        stack = new LinkedList();
        stack1 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(stack.size()==1){
    		top = 0;
    		return (int) stack.poll();
    	}
    	if(stack1.size()==1){
    		top = 0;
    		return (int) stack1.poll();
    	}
        if(stack.isEmpty()){
        	for(int i=0;i<stack1.size()-2;i++){
        		stack.add(stack1.poll());
        	}
        	top = (int) stack1.poll();
        	stack.add(top);
        	return (int) stack1.poll();
        }else{
        	for(int i=0;i<stack.size()-2;i++){
        		stack1.add(stack.poll());
        	}
        	top = (int) stack.poll();
        	stack1.add(top);
        	return (int) stack.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
    	return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty()&&stack1.isEmpty();
    }

	/**
	 * Your ImplementStackUsingQueues object will be instantiated and called as such:
	 * ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	
    /**
	 * ��1--Two Queues, push O(1), pop O(n)
	 */
    /*
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	private int top;
	
	// Push element x onto stack.
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(1)
	public void push(int x) {
	    q1.add(x);
	    top = x;
	}
	
	* ʱ�临�Ӷȣ�O(n)
	* �ռ临�Ӷȣ�O(1)
	public void pop() {
	    while (q1.size() > 1) {
	        top = q1.remove();
	        q2.add(top);
	    }
	    q1.remove();
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}
     */
    
    /**
	 * ��2--Two Queues, push O(n), pop O(1)
	 */
    /*
    * ʱ�临�Ӷȣ�O(n)
	* �ռ临�Ӷȣ�O(1)
   	public void push(int x) {
	    q2.add(x);
	    top = x;
	    while (!q1.isEmpty()) {                
	        q2.add(q1.remove());
	    }
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}
	
	// Removes the element on top of the stack.
	* ʱ�临�Ӷȣ�O(1)
	* �ռ临�Ӷȣ�O(1)
	public void pop() {
	    q1.remove();
	    if (!q1.isEmpty()) {
	        top = q1.peek();
	    }
	}
	
	// Return whether the stack is empty.
	* ʱ�临�Ӷȣ�O(1)
	* �ռ临�Ӷȣ�O(1)
	public boolean empty() {
	    return q1.isEmpty();
	}
	
	// Get the top element.
	* ʱ�临�Ӷȣ�O(1)
	* �ռ临�Ӷȣ�O(1)
	public int top() {
	    return top;
	}
	*/
    
    /**
	 * ��3--One Queue, push O(n), pop O(1)
	 */
    /*
    private LinkedList<Integer> q1 = new LinkedList<>();
	
	// Push element x onto stack.
	* ʱ�临�Ӷȣ�O(n)
	* �ռ临�Ӷȣ�O(1)
	public void push(int x) {
	    q1.add(x);
	    int sz = q1.size();
	    while (sz > 1) {
	        q1.add(q1.remove());
	        sz--;
	    }
	}
    
    // Removes the element on top of the stack.
    * ʱ�临�Ӷȣ�O(1)
	* �ռ临�Ӷȣ�O(1)
	public void pop() {
	    q1.remove();
	}
	
	// Return whether the stack is empty.
	* ʱ�临�Ӷȣ�O(1)
	* �ռ临�Ӷȣ�O(1)
	public boolean empty() {
	    return q1.isEmpty();
	}
	
	// Get the top element.
	* ʱ�临�Ӷȣ�O(1)
	* �ռ临�Ӷȣ�O(1)
	public int top() {
	    return q1.peek();
	}
     */
    
    
	public static void main(String[] args) {
		ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
		obj.push(1);
		obj.push(2);
		int param_2 = obj.top();
		int param_3 = obj.pop();
		//int param_4 = obj.pop();
		boolean param_5 = obj.empty();
		System.out.println(param_2);
		System.out.println(param_3);
		//System.out.println(param_4);
		System.out.println(param_5);
	}

}
