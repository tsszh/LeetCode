package LT200T250;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 224. Basic Calculator
 * 227. Basic Calculator II
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 *  
 * The expression string may contain open ( and closing parentheses ), the plus + or
 * minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * Similar Problems: 150. Evaluate Reverse Polish Notation
 * 					 227. Basic Calculator II
 * 					 241. Different Ways to Add Parentheses
 * 					 282. Expression Add Operators
 * 
 */
public class LT224 {
	public int calculate(String s) {
		String[] input = ("( " + s.replaceAll("([\\(\\)+\\-\\*/])", " $1 ").trim() + " )").split("\\s+");
		Deque<String> signs = new ArrayDeque<>();
		Deque<Integer> nums = new ArrayDeque<>();
		Map<String, Integer> priority = priorityMap();
		for (int i = 0; i < input.length; i++) {
			String token = input[i];
			if (token.equals(")")) {
				signs.pop();
				cal2(nums, signs);
			} else if (isSign(token) || token.equals("(")) {
				signs.push(token);
			} else {
				nums.push(Integer.parseInt(token));
				while (priority.get(signs.peek()) >= priority.get(input[i + 1])) {
					if ( !cal2(nums, signs) ) break;
				}
			}
		}
		return nums.pop();
	}

	private boolean isSign(String op) {
		return "+-*/".indexOf(op) > -1;
	}

	private Map<String, Integer> priorityMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("(", 3);
		map.put("*", 2);
		map.put("/", 2);
		map.put("+", 1);
		map.put("-", 1);
		map.put(")", 0);
		return map;
	}

	private boolean cal2(Deque<Integer> nums, Deque<String> signs) {
		if (signs.isEmpty() || signs.peek().equals("(")) return false;
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
		return true;
	}
}
