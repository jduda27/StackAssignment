import java.util.Scanner;

public class Infix2Postfix {

	/*
	 * Convert infix expression to postfix expression by implementing a stack. Infix
	 * contains only single-digit operands, four binary operators (+, -, *, /) and
	 * parentheses.
	 */
	public String in2P(String infix) {
		
		
		return "";
	}
	
	
	
	// precedence() method takes operator as input and return the precendence as an
	// integer.
	// Larger number indicates higher precedence.
	public static int precedence (char ch) {
		if (ch == '+' || ch == '-') {
			return 1;}
		else if (ch == '*' || ch == '/') {
			return 2;
			}
		return 0;
	}
	
	public static void main(String[] args) {
		// Read user's input, no space between each character.
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String postfixExp = ""; 
		//This isyour postfix result.
		StackArrayBased stack = new StackArrayBased(); 
		//Create a new stack using StackArrayBased class.
		//Your implementation of infix to postfix algorithm goes here.
	}
}
