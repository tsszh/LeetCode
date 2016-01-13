package Medium1;

import java.util.*;

public class LT084 {
	public static void main ( String[] args ) {
		int[] height = new int[] {
			3,2,1,1	
		};
		System.out.println(largestRectangleArea(height));
	}
	/**
	 * The Maximum Rectangle must ended with bar at the descending edge or at the end
	 * Time O(n) Space O(n) 
	 * @param height
	 * @return
	 */
	public static int largestRectangleArea(int[] height) {
		if ( height == null ) return 0;
		Deque<Integer> stack = new ArrayDeque<Integer>(height.length);
		int max = 0;
		for ( int i = 0; i <= height.length; i++ ) {
			while ( !stack.isEmpty() && (i==height.length || height[i] < height[stack.peek()]) ) {
				int h = height[stack.pop()];
				int w = i-(stack.isEmpty()?-1:stack.peek())-1;
				max = Math.max(max, h*w);
			}
			stack.push(i);
		}
		return max;
    }
}
