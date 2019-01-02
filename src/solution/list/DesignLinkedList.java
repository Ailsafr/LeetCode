package solution.list;

/**
 * @author By RuiCUI
 * 2019-01-02
 * Easy
 * Question 707:Design Linked List.
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. 
 * A node in a singly linked list should have two attributes: val and next. 
 * val is the value of the current node, and next is a pointer/reference to the next node. 
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. 
 * Assume all nodes in the linked list are 0-indexed.
 * Implement these functions in your linked list class:
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. 
 * After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. 
 * If index equals to the length of linked list, the node will be appended to the end of linked list. 
 * If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 * 1.All values will be in the range of [1, 1000].
 * 2.The number of operations will be in the range of [1, 1000].
 * 3.Please do not use the built-in LinkedList library.
 */
public class DesignLinkedList {
	
	/**
	 * 我自己写的方法
	 * @return
	 */
	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList();
	 * int param_1 = obj.get(index);
	 * obj.addAtHead(val);
	 * obj.addAtTail(val);
	 * obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
	
	class Node{
		int val;
		Node next;
		public Node(int v) {
            this.val = v;
        }
	}
	
	Node currHead;
    Node currTail;
    int size;
	/** Initialize your data structure here. */
    public DesignLinkedList() {
        currHead = null;
        currTail = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if(index>=size){
    		return -1;
    	}
        Node tmp = currHead;
        for (int i=0;i<index;i++){
        	tmp = tmp.next;
        }
        return tmp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = currHead;
        currHead = node;
        if(currTail==null){
        	currTail = currHead;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	Node node = new Node(val);
    	if(currTail!=null){
    		currTail.next = node;
    	}
        if(currTail==null){
        	currHead = node;
        }
        currTail = node;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. 
     * If index equals to the length of linked list, the node will be appended to the end of linked list. 
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index>size){
    		return;
    	}
        if (index==size) {
            addAtTail(val);
            return;
        }
        if(index==0) {
            addAtHead(val);
            return;
        }
        
        Node ith = currHead;
        for(int i=0;i<index-1;i++){
        	ith = ith.next;
        }
        
        Node node = new Node(val);
        Node saveIth = ith;
        ith = ith.next;
        
        saveIth.next = node;
        node.next = ith;
        
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if(size==0){
    		return;
    	}
        if(index>=size){
        	return;
        }
        if(index==0){
            if(size==1){
                size = 0;
                currHead = null;
                currTail = null;
                return;
            }
            currHead = currHead.next;
            size--;
            return;
        }
        if (index!=0) {
            Node ith = currHead;
            for(int i = 0; i < index-1; i++){
            	ith = ith.next;
            }
            if(index==size-1) {
                currTail = ith;
                currTail.next = null;
                size--;
                return;
            }
            Node nekMinnit = ith.next;
            ith.next = nekMinnit.next;
        }
        
        size--;
    }

	/**
	 * 官网没有solution,这是其他人的答案
	 */
/*    class Node {
        int val;
        Node next;
        public Node(int v) {
            this.val = v;
        }
    }
    
    Node currHead;
    Node currTail;
    int size;

    *//** Initialize your data structure here. *//*
    public MyLinkedList() {
        
        currHead = null;
        currTail = null;
        
        size = 0;
        
    }
    
    *//** Get the value of the index-th node in the linked list. If the index is invalid, return -1. *//*
    public int get(int index) {
        if (index >= size) return -1;
        Node tmp = currHead;
        for (int i = 0; i < index; i++) tmp = tmp.next;
        
        return tmp.val;
        
    }
    
    *//** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. *//*
    public void addAtHead(int val) {
        Node tmp = new Node(val);
        tmp.next = currHead;
        currHead = tmp;
        if (currTail == null) currTail = currHead;
        size++;
    }
    
    *//** Append a node of value val to the last element of the linked list. *//*
    public void addAtTail(int val) {
        
        Node tmp = new Node(val);
        if (currTail != null) currTail.next = tmp;
        if (currTail == null) currHead = tmp;
        currTail = tmp;
        size++;
        
    }
    
    *//** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. *//*
    public void addAtIndex(int index, int val) {
        
        if (index > size) return;
        
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        Node ith = currHead;
        for (int i = 0; i < index-1; i++) ith = ith.next;
        
        Node tmp = new Node(val);
        Node saveIth = ith;
        ith = ith.next;
        
        saveIth.next = tmp;
        tmp.next = ith;
        
        size++;
    }
    
    *//** Delete the index-th node in the linked list, if the index is valid. *//*
    public void deleteAtIndex(int index) {
        if (size == 0) return;
        if (index >= size) return;
        if (index == 0) {
            if (size == 1) {
                size = 0;
                currHead = null;
                currTail = null;
                return;
            }
            currHead = currHead.next;
            size--;
            return;
        }

        if (index != 0) {
            Node ith = currHead;
            for (int i = 0; i < index-1; i++) ith = ith.next;
            if (index == size - 1) {
                currTail = ith;
                currTail.next = null;
                size--;
                return;
            }
            Node nekMinnit = ith.next;
            ith.next = nekMinnit.next;
            
        }
        
        size--;
    }
*/

	 
	/**
	 * 官网没有solution,这是其他人的答案
	 */
   /* static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    Node head = null;
    private int length = 0;

    public MyLinkedList() {};

    public int length() {
        return length;
    }

    private Node findAtIndex(int index) {
        if (length == 0 || index > length-1)
            return null;
        if (index <= 0)
            return head;

        Node result = head.next;
        int idx = 1;
        while (idx < index) {
            result = result.next;
            idx++;
        }
        return result;
    }

    public int get(int index) {
        Node result = findAtIndex(index);
        return result != null ? result.value : -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > length)
            return;

        Node nodeAtIndex = findAtIndex(index-1);
        Node node = new Node(val);
        if (nodeAtIndex == null)
            head = node;
        else if (index == 0) {
            node.next = head;
            head = node;
        }
        else {
            node.next = nodeAtIndex.next;
            nodeAtIndex.next = node;
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        if (length == 0 || index > length - 1 || index < 0)
            return;

        if (index == 0)
            head = head.next;
        else {
            Node nodeAtIndex = findAtIndex(index - 1);
            if (nodeAtIndex.next != null)
                nodeAtIndex.next = nodeAtIndex.next.next;
        }
        length--;
    }

*/

    
	public static void main(String[] args) {
		DesignLinkedList linkedList = new DesignLinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
		linkedList.get(1);            // returns 2
		linkedList.deleteAtIndex(1);  // now the linked list is 1->3
		linkedList.get(1);            // returns 3
	}

}
