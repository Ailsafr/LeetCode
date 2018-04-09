package solution.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author By RuiCUI
 * 2018-04-09
 * Easy
 * Question 155:Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
	
	/**
	 * 我自己写的方法
	 * 这里我忽略了一个东西，就是这个MinStack也可以用stack完成啊
	 */
	private List<Object> stack = null;
	
	/** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Object>();
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
		return (int) stack.get(stack.size()-1);
    }
    
    public int getMin() {
    	int n = stack.size();
    	if(n==0){
    		return 0;
    	}
    	int result = (int) stack.get(0);
    	for(int i=1;i<stack.size();i++){
    		if((int)stack.get(i)<result){
    			result = (int) stack.get(i);
    		}
    	}
    	return result;
    }

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
    
	/**
	 * 我自己写的方法--用栈stack 获取最小值的时候用了遍历，这样用时很长
	 * Stack类 
	 * 栈：桶型或箱型数据类型，后进先出，相对堆Heap为二叉树类型，可以快速定位并操作 
	 * Stack<E>，支持泛型 
	 * public class Stack<E> extends Vector<E> 
	 * Stack的方法调用的Vector的方法，被synchronized修饰，为线程安全(Vector也是) 
	 * Stack methods： 
	 * push : 把项压入堆栈顶部 ，并作为此函数的值返回该对象 
	 * pop : 移除堆栈顶部的对象，并作为此函数的值返回该对象  
	 * peek : 查看堆栈顶部的对象，并作为此函数的值返回该对象，但不从堆栈中移除它 
	 * empty : 测试堆栈是否为空  
	 * search : 返回对象在堆栈中的位置，以 1 为基数  
	 */
	//private Stack<Integer> stack = null;
    /** initialize your data structure here. */
    /*public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
		return stack.peek();
    }
    
    public int getMin() {
    	int n = stack.size();
    	if(n==0){
    		return 0;
    	}
    	int result = stack.get(0);
    	for(int x : stack){
    		if(x<result){
    			result = x;
    		}
    	}
    	return result;
    }*/
    
    /**
	 * 官网没有solution,这是其他人的答案,利用栈,在push的时候就记录最小值
	 */
    /*long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop=stack.pop();
        
        if (pop<0)  min=min-pop;//If negative, increase the min value
        
    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }*/
    
    /**
	 * 官网没有solution,这是其他人的答案,利用栈,更好理解
	 */
    /*static class Element
    {
        final int value;
        final int min;
        Element(final int value, final int min)
        {
            this.value = value;
            this.min = min;
        }
    }
    final Stack<Element> stack = new Stack<>();
    
    public void push(int x) {
        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
        stack.push(new Element(x, min));
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        return stack.peek().value;
    }

    public int getMin()
    {
        return stack.peek().min;
    }*/
    
    /**
	 * 官网没有solution,这是其他人的答案,利用栈,更好理解
	 */
    /*int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }*/
    
    /**
	 * 官网没有solution,这是其他人的答案,利用自己新写的类
	 */
    /*private Node head;
    
    public void push(int x) {
        if(head == null) 
            head = new Node(x, x);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }*/
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
	}

}
