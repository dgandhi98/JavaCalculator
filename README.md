#Java Calculator (Infix to Postfix)

This project was an implementation of the Shunting-Yard Algorithm with custom stacks and 
queues.

##Explanation of Files.
* InfixCalculator.java is called by the driver file to run the main calculation method.
* PostfixParser.java is used by the InfixCalculator class to create a postfix expression and uses it to calculate.
* Runner.java is the test driver file, and Helper.java contains a few helper methods used by various files. 
* infix_expr_custom.txt is a sample that contains examples of the following operators: exponentiation, modulus, 
and the trigonometric functions.
* error_detection_custom.txt contains expressions with errors that will be thrown on the console screen and 
printed to the text file.

##Supported Operators/Functions.
!, tan(), sin(), cos(), ^, *, /, %, +, -, >, <, =, &, |

##How to run the program.
The java file can be compiled and called through the command line in this format:
javac Runner.java
java Runner infilename outfilename
==> For Example: java Runner infix_expr_custom.txt out.txt

##Contributors
* Divyanshu Gandhi (Github: dgandhi98)
