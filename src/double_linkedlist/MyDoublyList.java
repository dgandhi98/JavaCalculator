package double_linkedlist;
/**
 * @Author Divyanshu Gandhi
 * Implements the DoublyLinkedList interface to create a custom double linked list.
 */
public class MyDoublyList<AnyType> implements DoublyLinkedList<AnyType> {
	public MyDoubleNode<AnyType> head;
	public MyDoubleNode<AnyType> tail;
	
	public MyDoublyList() {
		head = new MyDoubleNode<AnyType>();
		tail = new MyDoubleNode<AnyType>();
		head.next = tail;
		tail.prev = head;
	}
	
	// new method for lab 7
	public AnyType getHeadData() {
		return head.data;
	}
	
	// insert will run in O(1) time
	// edited to allow duplicate values in queues for lab 7
	public void insert(AnyType x) {
		if(isEmpty()) {
			head.data = x;
		}
		else if(tail.data==null) {
			tail.data = x;
		}
		else {
			tail.next = new MyDoubleNode<AnyType>();
			(tail.next).prev = tail;
			(tail.next).data = x;
			tail = tail.next;
			
		}
		
	}

	public void delete(AnyType x) {
		if(head.data == x) {
			(head.next).prev = null;
			head = head.next;
			return;
		}
		else if(tail.data == x) {
			(tail.prev).next = null;
			tail = tail.prev;
			return;
		}
		else {
			MyDoubleNode<AnyType> current = head;
			while(current != null) {
				if(current.data == x) {
					(current.next).prev = current.prev;
					(current.prev).next = current.next;
					return;
				}
				current = current.next;
			}
		}
		System.out.println("Did not find anything to delete.");
	}
	
	// insert will run in constant time
	public AnyType deleteFirst() {
		AnyType ans = head.data;
		if(isEmpty()) {
			return null;
		}
		else if(tail.data == null) {
			head = new MyDoubleNode<AnyType>();
			head.next = tail;
			tail.prev = head;
		} 
		else if (tail.data != null && head.next == tail) {
			head = tail;
			tail = new MyDoubleNode<AnyType>();
			head.next = tail;
			head.prev = null;
			tail.prev = head;
		} else {
			(head.next).prev = null;
			head = head.next;
		}
		return ans;
	}
	
	public boolean contains(AnyType x) {
		MyDoubleNode<AnyType> current = head;
		while(current != null) {
			if(current.data == x)
				return true;
			current = current.next;
		}
		return false;
	}

	public AnyType lookup(AnyType x) {
		MyDoubleNode<AnyType> current = head;
		while(current != null) {
			if(current.data == x)
				return current.data;
			current = current.next;
		}
		return null;
	}

	public boolean isEmpty() {
		return (head.data == null);
	}

	//printList will run in O(n) time
	public void printList() {
		MyDoubleNode<AnyType> current = head;
		while(current != null) {
			if(current.data != null)
				System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	//printListRev will run in O(n) time
	public void printListRev() {
		MyDoubleNode<AnyType> current = tail;
		while(current != null) {
			if(current.data != null)
				System.out.print(current.data + " ");
			current = current.prev;
		}
		System.out.println();
	}
	
}
