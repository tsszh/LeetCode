package LT150T200;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * 
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example, Given numerator = 1, denominator = 2, return "0.5". Given
 * numerator = 2, denominator = 1, return "2". Given numerator = 2, denominator
 * = 3, return "0.(6)".
 * 
 * @author Zehao
 *
 */
public class LT166 {
	/**
	 * 
	 * Must convert to long type to avoid the overflow.
	 * 
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		long a = numerator, b = denominator;
		long res = a / b;
		long remainder = a % b;
		String decimal = fractionToDecimalTrue(Math.abs(remainder), Math.abs(b));
		return (a < 0 ^ b < 0 ? "-" : "") + Math.abs(res) + decimal;
	}

	/**
	 * Record all passing remainders
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private String fractionToDecimalTrue(long a, long b) {
		if (a == 0)
			return "";
		StringBuilder str = new StringBuilder();
		Map<Long, Integer> remainderMap = new HashMap<>();
		int p = 0;
		remainderMap.put(a, p++);
		while (a != 0) {
			str.append((10 * a) / b);
			a = (10 * a) % b;
			if (!remainderMap.containsKey(a)) {
				remainderMap.put(a, p++);
			} else {
				str.insert((int) remainderMap.get(a), '(');
				str.append(')');
				break;
			}

		}
		str.insert(0, '.');
		return str.toString();
	}
}
