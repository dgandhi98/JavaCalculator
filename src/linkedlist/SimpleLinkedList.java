package linkedlist;
/**
 * @Author Divyanshu Gandhi
 * @Citation I got this code from the lab assignment sheet in CSC 172.
 */
public interface SimpleLinkedList<AnyType> {
	public void insert(AnyType x);
	public void delete(AnyType x);
	public boolean contains(AnyType x);
	public AnyType lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
}
