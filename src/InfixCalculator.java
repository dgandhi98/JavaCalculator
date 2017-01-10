/**
 * @Author Divyanshu Gandhi
 * @Project Project 2: Calculator
 * This class is called by the main runner class and does the main calculations
 * after calling the createPostFix method in the PostFixParser class which returns 
 * the queue that has the postfix representation of the expression.
 */

import queue.MyQueue;
import stack.MyStack;

public class InfixCalculator {
	private static MyQueue<String> queue = new MyQueue<String>();
	private static MyStack<String> stack = new MyStack<String>();
	
	/**
	 * Main method for the InfixCalculator, called by the Runner class.
	 * Takes in the expression as a string, returns the double with the 
	 * answer or a null indicating an error.
	 */
	public static Double calculate(String exp) {
		queue = new MyQueue<String>();
		stack = new MyStack<String>();
		queue = PostFixParser.createPostFix(exp); // convert to postfix
		if(queue == null) { // if an error was thrown
			return null;
		}
		
		
		// Actual calculation
		while(!queue.isEmpty()) {
			if(Helper.isOperand(queue.peek())) {
				stack.push(queue.dequeue());
			}
			else { // Actual Calculation
				String operator  = queue.dequeue();
				String n2 = stack.pop();
				String n1;
				int v2;
				int v1;
				String b2;
				int ansInt;
				double t2;
				double t1;
				double ans;
				switch (operator) {
					// Parenthesis should not exist in the postfix. 
					// If they do, then the parenthesis are unbalanced.
					// The right parenthesis un-balance is already checked beforehand
					// but added here just in case.
					case "(": // throws error
						System.out.println("Unbalanced Parenthesis.");
						return null;
					case ")": // throws error
						System.out.println("Unbalanced Parenthesis.");
						return null;
						
					// Operators
					case "!":
						if(!Helper.isInteger(n2)) { //check if it's an integer
							// throws error
							System.out.println("! can only be used with integers.");
							return null;
						} 
						else {
							v2 = Integer.parseInt(n2);
							b2 = Integer.toBinaryString(v2);
							b2 = b2.replace('0','2').replace('1','0').replace('2','1');
							v2 = Integer.parseInt(b2, 2);
							stack.push(""+v2);
							break;
						}
					case "tan": 
						t2 = Double.parseDouble(n2);
						ans = Math.tan(t2);
						stack.push(""+ans);
						break;
					case "sin": 
						t2 = Double.parseDouble(n2);
						ans = Math.sin(t2);
						stack.push(""+ans);
						break;
					case "cos": 
						t2 = Double.parseDouble(n2);
						ans = Math.cos(t2);
						stack.push(""+ans);
						break;
					case "^":  
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ans = Math.pow(t1,t2);
						stack.push(""+ans);
						break;
					case "*": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ans = t1*t2;
						stack.push(""+ans);
						break; 
					case "/": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ans = t1/t2;
						stack.push(""+ans);
						break;
					case "%":
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ans = t1%t2;
						stack.push(""+ans);
						break;
					case "+": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ans = t1+t2;
						stack.push(""+ans);
						break;
					case "-": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ans = t1-t2;
						stack.push(""+ans);
						break;
					case ">": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ansInt = (t1 > t2)?1:0;
						stack.push(""+ansInt);
						break;
					case "<": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ansInt = (t1 < t2)?1:0;
						stack.push(""+ansInt);
						break;
					case "=": 
						t2 = Double.parseDouble(n2);
						n1 = stack.pop();
						t1 = Double.parseDouble(n1);
						ansInt = (t1 == t2)?1:0;
						stack.push(""+ansInt);
						break;
					case "&": 
						n1 = stack.pop();
						if( !(Helper.isInteger(n2) && Helper.isInteger(n1)) ) { // check if they're integers
							// throws error
							System.out.println("& can only be used with integers.");
							return null;
						} 
						else {
							t2 = Double.parseDouble(n2);
							v2 = (int)t2;
							t1 = Double.parseDouble(n1);
							v1 = (int)t1;
							ansInt = v1 & v2; // bitwise and
							stack.push(""+ansInt);
							break;
						}
					case "|":
						n1 = stack.pop();
						if( !(Helper.isInteger(n2) && Helper.isInteger(n1)) ){
							// throws error
							System.out.println("| can only be used with integers.");
							return null;
						} 
						else {
							t2 = Double.parseDouble(n2);
							v2 = (int)t2;
							t1 = Double.parseDouble(n1);
							v1 = (int)t1;
							ansInt = v1 | v2; // bitwise or
							stack.push(""+ansInt);
							break;

						}
					default: // throws error
						System.out.println("Unsupported function: " + operator);
						return null;
				}
			}
		}
		return Double.parseDouble(stack.pop());
	}
	
}
