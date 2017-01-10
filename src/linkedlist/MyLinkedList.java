package linkedlist;
/**
 * @Author Divyanshu Gandhi
 * Custom LinkedList that implements the SimpleLinkedList interface.
 */
public class MyLinkedList<AnyType> implements SimpleLinkedList<AnyType> {
	private MyNode<AnyType> head;
	
	public MyLinkedList () {
		head = null;
	}

	// New method for Lab 6
	public AnyType getHeadData() {
		if(head != null)
			return head.data;
		else return null;
	}
	
	// This will run in O(n) time
	public void insert(AnyType x) {
		
		if(isEmpty()) {
			head = new MyNode<AnyType>();
			head.data = x;
			return;
		}
		
		MyNode<AnyType> current = head;
		while( current.next != null ) {
			current = current.next;
		}
		current.next = new MyNode<AnyType>();
		current.next.data = x;
	}

	// This will run in constant time
	// New method for Lab 6
	public void insertFirst(AnyType x) {
		MyNode<AnyType> current = new MyNode<AnyType>();
		current.data = x;
		
		if(isEmpty()) {
			head = current;
		} else {
			current.next = head;
			head = current;
		}
	}
	
	public void delete(AnyType x) {
		if(head.data == x) {
			head = head.next;
			return;
		}
		MyNode<AnyType> current = head;
		while(current.next != null) {
			if(current.next.data == x) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		System.out.println("Did not find anything to delete.");
	}
	
	// This will run in constant time
	// New method for Lab 6
	public AnyType deleteFirst() {
		AnyType x = head.data;
		head = head.next;
		return x;
	}

	public boolean contains(AnyType x) {
		MyNode<AnyType> current = head;
		while(current != null) {
			if(current.data == x)
				return true;
			current = current.next;
		}
		return false;
	}

	public AnyType lookup(AnyType x) {
		MyNode<AnyType> current = head;
		while(current != null) {
			if(current.data == x)
				return current.data;
			current = current.next;
		}
		return null;
	}

	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	
	// This will run in O(n) time 
	public void printList() {
		MyNode<AnyType> current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

}
