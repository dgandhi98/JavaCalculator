/**
 * @Author Divyanshu Gandhi
 * @Project Project 2: Calculator
 * This class creates the postfix representation from the infix and is
 * called by the InfixCalculator class.
 */

import queue.MyQueue;
import stack.MyStack;

public class PostFixParser {
	public static MyQueue<String> queue = new MyQueue<String>();
	public static MyStack<String> stack = new MyStack<String>();
	
	/**
	 * Main method for the class, called by the InfixCalculator.
	 */
	public static MyQueue<String> createPostFix(String exp) {
		queue = new MyQueue<String>();
		stack = new MyStack<String>();
		int n = exp.length();
		
		// These two are not mutually exclusive because of one-parameter operators and functions
		boolean lastTokenIsOperand = false;
		boolean lastTokenIsTwoOperandConnector = false; // used to check operators that need two operands
		
		for(int i = 0; i < n; i++) {
			String token = ""+exp.charAt(i);
			if(token.equals(" ")) { // added for error detection, before I just took them all out
				continue;
			}
			else if(Helper.isOperand(token)) {
				if(lastTokenIsOperand) { // error detection, can't have two operands next two each other
					System.out.println("Expected operator at character " + i + ".");
					return null;
				}
				
				while( i+1 < n && Helper.isOperand( token ) && Helper.isOperand( "" + exp.charAt(i+1) ) ) {
					token += exp.charAt(i+1);
					i++;
				}

				considerOperand(token);
				lastTokenIsOperand = true;
				lastTokenIsTwoOperandConnector = false;
			} 
			else if(token.equals("(")) {
				considerLeftParenthesis();
			}
			else if(token.equals(")")) {
				if(!considerRightParenthesis()) { // if an error was thrown with the expression
					return null;
				}
			}
			else {
				if( Helper.checkAlpha(token) ) { // non-operator functions must start with a letter

					while( i+1 < n && exp.charAt(i+1) != '(' ) {
						token += exp.charAt(i+1);
						i++;
					}
					if ( !Helper.isValidFunction(token) ) { // error detected
						System.out.println("Unsupported function: " + token);
						return null;
					}
					else { // If we have the function available
						considerOperator(token);
						lastTokenIsOperand = false;
					}
				}
				else if(Helper.isValidFunction(token)) { // operators
					if(Helper.getNumOperands(token) == 2) {
						if(lastTokenIsTwoOperandConnector) {
							System.out.println("Expected operand at character " + i + ".");
							return null;
						}
						lastTokenIsOperand = false;
						lastTokenIsTwoOperandConnector = true;
					} else {
						lastTokenIsOperand = false;
						lastTokenIsTwoOperandConnector = false;
					}
					considerOperator(token);
				}
				else { // error detected
					System.out.println("Unsupported function: " + token);
					return null;
				}
			}
			
		}
		
		// Went through the whole string
		// now pop everything left into the queue
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		
		return queue;
	}
	
	
	/**
	 * Manipulates the queue for when we encounter an operand. Just enqueues it.
	 */
	private static void considerOperand(String op) {
		queue.enqueue(op);
	}
	
	/**
	 * Manipulates the queue for when we encounter a left parenthesis. Just pushes it.
	 */
	private static void considerLeftParenthesis() {
		stack.push("(");
	}

	/**
	 * This method will manipulate the queue and the stack when a right Parenthesis is encountered.
	 * It will enqueue things in the queue until it peeks the respective left Parenthesis or 
	 * if the queue becomes empty, then we throw an error indicating that there are unbalanced
	 * parenthesis.
	 */
	private static boolean considerRightParenthesis() {
		while( !stack.isEmpty() && !(stack.peek()).equals("(")  ) {
			queue.enqueue(stack.pop());
		}
		if(stack.isEmpty()) { // error detected
			System.out.println("Unbalanced Parenthesis.");
			return false;
		}
		else {
			stack.pop(); //pops out the left parenthesis
			if( Helper.isValidFunction( stack.peek() ) ) { 
				queue.enqueue(stack.pop());
			}
		}
		return true;
	}
	
	/**
	 * This method will manipulate the queue and the stack when an operator is encountered.
	 * Takes in the operator as a parameter.
	 */
	private static void considerOperator(String op) {
		int currP = Helper.getPrecedence(op);
		String currAssoc = Helper.getAssociativity(op);
		String lastOperator;
		int lastP;
		while( (lastOperator = stack.peek()) != null && Helper.isValidFunction(lastOperator ) ) {
			lastP = Helper.getPrecedence(lastOperator);
			if(currAssoc.equals("L") && currP >= lastP) {
				queue.enqueue(stack.pop());
			}
			else if(currAssoc.equals("R") && currP > lastP) {
				queue.enqueue(stack.pop());
			}
			else { 
				break; // It does not meet the specifications, break, otherwise inf loop
			}
		}
		stack.push(op);
	}
	

}
