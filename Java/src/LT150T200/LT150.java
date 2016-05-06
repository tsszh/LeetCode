package LT150T200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 * ["2", "1", "+", "3", "*"]  -> ((2 + 1) * 3)  -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * Similar Problem:  224. Basic Calculator
 * 					 282. Expression Add Operators
 */
public class LT150 {
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>(tokens.length);
		for ( String operant : tokens ) {
			if ( "+-*/".indexOf(operant) != -1 ) {
				int a = stack.pop();
				int b = stack.pop();
				int c = 0;
				switch ( operant ){
					case "+": c = b+a; break;
					case "-": c = b-a; break;
					case "*": c = b*a; break;
					case "/": c = b/a; break;
				}
				stack.push(c);
			} else {
				stack.push( Integer.parseInt(operant) );
			}
		}
		return stack.pop();
	}
}
