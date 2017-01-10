package stack;
/**
 * @Author Divyanshu Gandhi 
 * Uses the custom linkedlist class to create a custom stack data structure.
 * Implements the Stack interface.
 */

import linkedlist.MyLinkedList;
public class MyStack<AnyType> implements Stack<AnyType> {
	
	private MyLinkedList<AnyType> theStack;
	
	public MyStack() {
		theStack = new MyLinkedList<AnyType>();
	}
	
	public Boolean isEmpty() {
		return theStack.isEmpty();
	}

	public void push(AnyType x) {
		theStack.insertFirst(x);
	}

	public AnyType pop() {
		if(theStack.isEmpty()) 
			return null;
		else 
			return theStack.deleteFirst();
	}

	public AnyType peek() {
		return theStack.getHeadData();
	}

}
