/** @author Joshua Duda
 *  @Date	10/29/2019
 */

import java.util.Scanner;

public class Infix2Postfix {

	/* in2P() method
	 * Converts infix expression to postfix expression by implementing a stack. Infix
	 * contains only single-digit operands, four binary operators (+, -, *, /) and
	 * parentheses.
	 * Precondition: String infix - Any valid string representing a infix equation
	 * Postcondition: Returns a string result which is the equivalent post-fix expression of the input
	 */
	public static String in2P(String infix) {
		String noW = "";
		String result = "";
		StackArrayBased stack = new StackArrayBased();
		boolean high = false;
		// Removes all whitespace and creates a new string
		for (int i = 0; i < infix.length(); i++) {
			if (!Character.isWhitespace(infix.charAt(i))) {
				noW += String.valueOf(infix.charAt(i));
			}
		}
		char[] exp = new char[noW.length()];
		// creates an array of single characters that are not empty space
		for (int i = 0; i < noW.length(); i++) {
			exp[i] = noW.charAt(i);
		}

		// Cycling through the expression and converting infix to post-fix
		for (int i = 0; i < noW.length(); i++) {
			if (exp[i] == '(') { // if the character is ( then push it into the stack
				stack.push(exp[i]);
			} else if (precedence(exp[i]) >= 1) { // if the character has a precedence > 1
				//if stack if not empty and the precedence of the value in the stack is higher than the current value we are looking at
				//add the value in the stack to the new expression, take it out of the stack and put in the current value
				if (!(stack.isEmpty()) && precedence(exp[i]) < precedence(stack.peek())) {
					result += stack.peek();
					stack.pop();
					stack.push(exp[i]);
				} else { // if value is greater than the top value of the stack or if the stack is empty add the current value to the stack.
					stack.push(exp[i]);
				}
			} else if (exp[i] == ')') { // if the character is ) add all values in the stack until we reach ( to the new expression
				while (!(stack.peek() == '(')) {
					result += stack.peek();
					stack.pop();
				}
				stack.pop();
			} else { // if the character is not ( or ) and had no precedence add it to the result
				result += exp[i];
			}
		}
		//add all remaining values in the stack to the expression until it is empty
		while (!stack.isEmpty()) {
			result += stack.peek();
			stack.pop();
		}
		return result; // return the post-fix expression
	}

	/* precedence() method takes operator as input and return the precedence as an
	 *  integer.
	 *  Precondition: char ch - A valid character data type
	 *  Postcondition: a integer value, a larger number for the higher the precedence
	*/
	public static int precedence(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		}
		return 0;
	}

	//testing out the infix to post-fix method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your infix equation: ");
		String str = sc.next(); //reading next keyboard input
		sc.close(); //closing scanner
		
		//printing result for the inputed infix to post-fix conversion
		System.out.println(in2P(str));
		
		
		System.out.println(in2P("a+b*(c+d)/e"));
		System.out.println(in2P("(2+4)*(6-9)"));
	}
}
