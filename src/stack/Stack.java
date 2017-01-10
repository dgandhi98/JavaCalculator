package stack;
/**
 * @Author Divyanshu Gandhi 
 * @Citation I got this code from the lab assignment sheet in CSC 172.
 */

public interface Stack<AnyType> {
	public Boolean isEmpty();
	public void push(AnyType x);
	public AnyType pop();
	public AnyType peek();
}
