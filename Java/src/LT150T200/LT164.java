package LT150T200;

/**
 * 164. Maximum Gap
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * 
 * @author Zehao
 *
 */
public class LT164 {
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		nums = binaryRadixSort(nums);
		int maxGap = 0;
		for (int i = 1; i < nums.length; i++) {
			maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
		}
		return maxGap;
	}

	private int[] binaryRadixSort(int[] nums) {
		for (int mask = 1; mask != 0; mask <<= 1) {
			int n0 = 0, n1 = 0;
			for (int i = 0; i < nums.length; i++) {
				if ((nums[i] & mask) == 0)
					n0++;
				else
					n1++;
			}
			n1 += n0;
			int[] newNums = new int[nums.length];
			for (int i = nums.length - 1; i >= 0; i--) {
				if ((nums[i] & mask) == 0)
					newNums[--n0] = nums[i];
				else
					newNums[--n1] = nums[i];
			}
			nums = newNums;
		}
		int posN = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0)
				posN++;
		}
		leftShift(nums, posN);
		return nums;
	}

	private void leftShift(int[] nums, int d) {
		int n = nums.length, count = n;
		if (n <= 1)
			return;
		d = d % n;
		for (int i = 0; i < n && count > 0; i++) {
			int temp = nums[i];
			int prev = i, next = i + d < n ? i + d : i + d - n;
			while (next != i) {
				nums[prev] = nums[next];
				prev = next;
				next += d;
				if (next >= n)
					next -= n;
				count--;
			}
			nums[prev] = temp;
			count--;
		}
	}
}
