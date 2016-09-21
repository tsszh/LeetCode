package LT150T200;

import java.util.Arrays;

public class LT179 {
	public String largestNumber(int[] nums) {
		String[] numStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numStrs[i] = "" + nums[i];
		}
		Arrays.sort(numStrs, (a, b) -> {
			return (b + a).compareTo(a + b);
		});
		if (numStrs.length == 0 || Integer.parseInt(numStrs[0]) == 0) return "0";
		return String.join("", numStrs);
	}
}
