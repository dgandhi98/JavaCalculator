package queue;
/**
 * @Author Divyanshu Gandhi
 * Uses the double linkedlist class to create a custom queue data structure.
 * Implements the Queue interface.
 */
import double_linkedlist.MyDoublyList;
public class MyQueue<AnyType> implements Queue<AnyType> {
	private MyDoublyList<AnyType> theQueue;
	
	public MyQueue() {
		theQueue = new MyDoublyList<AnyType>();
	}
	
	public boolean isEmpty() {
		return theQueue.isEmpty();
	}
	
	public void enqueue(AnyType x) {
		theQueue.insert(x);
	}
	
	public AnyType dequeue() {
		if(theQueue.isEmpty()) 
			return null;
		else 
			return theQueue.deleteFirst();
	}
	
	public AnyType peek() {
		return theQueue.getHeadData();
	}
	
}
