/**
 * @Author Divyanshu Gandhi
 * @Project Project 2: Calculator
 * This file holds the helper functions such as ones that hold switch-case
 * data and boolean checkers that are used in the other two main files.
 */

import queue.MyQueue;

public class Helper {
	/**
	 * Prints out the queue at once, used for debugging.
	 */
	public static void printQ(MyQueue<String> qr) {
		while(qr.peek() != null) {
			System.out.print(qr.dequeue() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Checks if the string is just made out of letters.
	 */
	public static boolean checkAlpha(String s) {
		return s.matches("[a-zA-Z]");
	}
	
	/**
	 * Checks if the string is just an integer.
	 */
	public static boolean isInteger(String s) {
		double d = Double.parseDouble(s);
		if((int)d == d)
			return true;
		else return false;
	}
	
	/**
	 * Checks if the string is a valid number (decimal and integer).
	 */
	public static boolean isOperand(String op) {
		String digits = "(?:[0-9]+|[0-9]+\\.|[0-9]+\\.[0-9]+|\\.[0-9]|[\\.])";		
		return op.matches(digits);
	}
	
	/**
	 * Checks if the function/operator is a supported one.
	 */
	public static boolean isValidFunction(String s) {
		if(s==null) return false;
		return ( s.equals("tan") || 
				 s.equals("cos") || 
				 s.equals("sin") || 
				 s.equals("!") ||
				 s.equals("^") ||
				 s.equals("*") ||
				 s.equals("/") ||
				 s.equals("%") ||
				 s.equals("+") ||
				 s.equals("-") ||
				 s.equals("&") ||
				 s.equals("|") ||
				 s.equals("=") ||
				 s.equals(">") ||
				 s.equals("<")
				);
	}
	
	/**
	 * Returns the precedence of each function/operator.
	 */
	public static int getPrecedence(String operator) {
		switch (operator) {
			case "!": return 3;
			case "tan": return 3;
			case "sin": return 3;
			case "cos": return 3;
			case "^": return 4;
			case "*": return 5; 
			case "/": return 5;
			case "%": return 5;
			case "+": return 6;
			case "-": return 6;
			case ">": return 7;
			case "<": return 7;
			case "=": return 8;
			case "&": return 9;
			case "|": return 10;
			default: return -1;
		}
	}
	
	/**
	 * Returns the associativity of the operator (Left or Right)
	 */
	public static String getAssociativity(String operator) {
		switch (operator) {
			case "!": return "R";
			case "tan": return "R";
			case "sin": return "R";
			case "cos": return "R";
			case "^": return "R";
			case "*": return "L"; 
			case "/": return "L";
			case "%": return "L";
			case "+": return "L";
			case "-": return "L";
			case ">": return "L";
			case "<": return "L";
			case "=": return "L";
			case "&": return "L";
			case "|": return "L";
			default: return "L";
		}
	}
	
	/**
	 * Returns the number of operands needed for the operator/function.
	 */
	public static int getNumOperands(String operator) {
		switch (operator) {
			case "!": return 1;
			case "tan": return 1;
			case "sin": return 1;
			case "cos": return 1;
			case "^": return 2;
			case "*": return 2; 
			case "/": return 2;
			case "%": return 2;
			case "+": return 2;
			case "-": return 2;
			case ">": return 2;
			case "<": return 2;
			case "=": return 2;
			case "&": return 2;
			case "|": return 2;
			default: return 2;
		}
	}
}
