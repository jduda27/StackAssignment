import java.util.Scanner;

public class Infix2Postfix {

	/*
	 * Convert infix expression to postfix expression by implementing a stack. Infix
	 * contains only single-digit operands, four binary operators (+, -, *, /) and
	 * parentheses.
	 */
	public static String in2P(String infix) {
		String noW = "";
		String result ="";
		StackArrayBased stack = new StackArrayBased();
		//Removes all whitespace and creates a new string
		for(int i = 0; i <infix.length(); i++) {
			if(!Character.isWhitespace(infix.charAt(i))) {
				noW += String.valueOf(infix.charAt(i));
			}
		}
		char[] exp = new char[noW.length()];
		//creates an array of single characters that are not empty space
		for(int i =0; i < noW.length();i++) {
				exp[i] = noW.charAt(i);
				//System.out.println(exp[i]);
		}
		
		for (int i = 0; i < noW.length(); i++){
			System.out.print("\nInput: "+String.valueOf(exp[i])+"\nStack: ");
			if ( precedence(exp[i]) == 1 || precedence(exp[i]) == 2 || exp[i]=='(') {
				stack.push(String.valueOf(exp[i]));
				//System.out.println(stack.peek());
			}else if(exp[i]==')') {
				while(String.valueOf(stack.peek()) != "("){
					System.out.println(stack.peek());
					result += stack.peek(); 
					System.out.println(result);
					stack.pop();
				}
			}else {
				result += String.valueOf(exp[i]);
			}
			if(!stack.isEmpty()) {
				System.out.print(stack.peek());
			}
			System.out.println("\nPostfix: "+result);
		}
		while(!stack.isEmpty()) {
			result += String.valueOf(stack.peek());
			stack.pop();
		}
		
		return result;
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
		//Scanner sc = new Scanner(System.in);
		//String str = sc.next();
		//String postfixExp = ""; 
		//This isyour postfix result.
		//StackArrayBased stack = new StackArrayBased(); 
		//Create a new stack using StackArrayBased class.
		//Your implementation of infix to postfix algorithm goes here.
		System.out.println(in2P("a+b*(c+d)/e"));
	}
}
