package queue;
/**
 * @Author Divyanshu Gandhi 
 * @Citation I got this code from the lab assignment sheet in CSC 172.
 */

public interface Queue<AnyType> {
	public boolean isEmpty();
	public void enqueue(AnyType x);
	public AnyType dequeue();
	public AnyType peek();
}
