package LT200T250;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator
 * 227. Basic Calculator II
 * 
 * Implement a basic calculator to evaluate a simple
 * expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples: 
 * 		"3+2*2" = 7 
 * 		" 3/2 " = 1 
 * 		" 3+5 / 2 " = 5 
 * 
 * Note: Do not use the eval() built-in library function.
 * 
 * Similar Problems: 282. Expression Add Operators
 * 
 * @author Zehao
 *
 */
public class LT227 {
	public int calculate(String s) {
		String[] input = s.replaceAll("([\\+\\-\\*\\/])", " $1 ").trim().split("\\s+");
		Deque<Integer> nums = new ArrayDeque<>();
		Deque<String> signs = new ArrayDeque<>();
		for ( int i = 0; i < input.length; i++ ) {
			String token = input[i];
			if ( "+-*/".indexOf(token) != -1 ) {
				signs.push(token);
			} else {
				nums.push(Integer.parseInt(token));
				while ( !signs.isEmpty() && ( i == input.length-1 || priority(signs.peek()) >= priority(input[i+1]))) {
					cal( nums, signs );
				}
			}
		}
		return nums.pop();
	}
	private int priority( String op ) {
		return "+-".indexOf(op)>-1?1:2;
	}
	private void cal(Deque<Integer> nums, Deque<String> signs ) {
		int b = nums.pop();
		int a = nums.pop();
		switch (signs.pop()) {
		case "+":
			nums.push(a + b);
			break;
		case "-":
			nums.push(a - b);
			break;
		case "*":
			nums.push(a * b);
			break;
		case "/":
			nums.push(a / b);
			break;
		}
	}
	
	/**
	 * Method Two
	 * 
	 * @param s
	 * @return
	 */
	public int calculate2(String s) {
		if ( s == null || s.length() == 0 ) return 0;
		int n = s.length();
		Deque<Integer> nums = new ArrayDeque<>();
		Deque<Character> signs = new ArrayDeque<>();
		int num = 0;
		for ( int i = 0; i <= n; i++ ) {
			char c = i==n ? 0 : s.charAt(i);
			if ( c == ' ' ) continue;
			if ( Character.isDigit(c) ) {
				num = 10 * num + c - '0';
				continue;
			}
			nums.push(num);
			while ( !signs.isEmpty() && ( i == n || priority2(signs.peek()) >= priority2(c))) {
				cal2( nums, signs );
			}
			signs.push(c);
			num = 0;
		}
		return nums.pop();
	}
	private int priority2( char op ) {
		return "+-".indexOf(op)>-1?1:2;
	}
	private void cal2(Deque<Integer> nums, Deque<Character> signs ) {
		int b = nums.pop();
		int a = nums.pop();
		switch (signs.pop()) {
		case '+':
			nums.push(a + b);
			break;
		case '-':
			nums.push(a - b);
			break;
		case '*':
			nums.push(a * b);
			break;
		case '/':
			nums.push(a / b);
			break;
		}
	}
}
