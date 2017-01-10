/**
 * @Author Divyanshu Gandhi
 * @Project Project 2: Calculator
 * This file reads in the the expressions to solve from the text files and uses
 * the InfixCalculator class to solve them.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Runner {
	public static void main(String[] args) throws IOException {

		// Takes in the file names from args
		String inFile = args[0];
		String outFile = args[1];
		
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
		
		String expression= in.readLine();
		while (expression != null) {
			// ans will return a Double class which will either contain an actual number
			// or a null value if there was an error, which is printed to the screen beforehand.
			Double ans = InfixCalculator.calculate(expression); 
			String expressionNext = in.readLine();
			if(ans != null) {
				System.out.println(expression);
				System.out.print("=> ");
				System.out.printf("%.2f\n",ans);
				System.out.println();
				if(expressionNext == null) {
					out.printf("%.2f", ans);
					break;
				}
				else {
					out.printf("%.2f\n", ans);
				}
			}
			else { // when there's an error
				System.out.println("Check the error above for the following expression:\n" + expression);
				System.out.println();
				out.println("Check console, there exists an error in: " + expression);
			}
			expression = expressionNext;
			
		}
		
		in.close();
		out.close();
		
	}
}
