package basic2;

import java.util.*;

public class LT042 {
	public static void main ( String[] args ) {
		LT042 dummy = new LT042();
		int[] height;
		long st, et, total1=0, total2=0;
		Random gen = new Random();
		for ( int i = 10; i>0; i-- ) {
			height = new int[gen.nextInt(10000)];
			for ( int j = 0; j < height.length; j++ )
				height[j] = gen.nextInt(gen.nextInt(1000000));
			st = System.nanoTime();
			dummy.trap(height);
			et = System.nanoTime();
			total1 += et-st;
			
			st = System.nanoTime();
			dummy.trap2(height);
			et = System.nanoTime();
			total2 += et-st;
		}
		System.out.println("trap1 = "+total1+" ms");
		System.out.println("trap2 = "+total2+" ms");
	}
	/**
	 * Time : O(n) Space : O(1)
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		if ( height == null || height.length < 3 ) return 0;
		int sum = 0;
		
		// From left to right - leftThres = highest bar (last bar exclusive)
		int leftThres = 0;
		while ( leftThres < height.length-1 && height[leftThres]<=height[leftThres+1] )
			leftThres++;
		int leftThresHeight = height[leftThres];
		for ( int i = leftThres+1; i < height.length-1; i++ ) {
			if ( height[i-1] < height[i] && height[i]>=height[i+1] ) { // Potential Threshold
				if ( height[i] >= leftThresHeight ) {
					for ( int j = leftThres+1; j<i; j++ ) {
						if ( leftThresHeight > height[j] )
							sum += leftThresHeight-height[j];
					}
					leftThres = i;
					leftThresHeight = height[leftThres];
				}
			}
		}
		
		// From rightmost bar to leftThres
		int rightThres = height.length-1;
		while ( leftThres<rightThres && height[rightThres-1]>=height[rightThres]) rightThres--;
		int rightThresHeight = height[rightThres];
		for ( int i = rightThres-1; i >= leftThres; i-- ) {
			if ( i==leftThres || (height[i-1] <= height[i] && height[i]>height[i+1]) ) {
				if ( i==leftThres || height[i] >= rightThresHeight ) { // Potential Threshold
					if ( i==leftThres )
						rightThresHeight = Math.min(leftThresHeight, rightThresHeight);
					for ( int j = rightThres-1; j>i; j-- ) {
						if ( rightThresHeight > height[j] )
							sum += rightThresHeight-height[j];
					}
					rightThres = i;
					rightThresHeight = height[rightThres];
				}
			}
		}
		
		return sum;
    }
	
	/**
	 * O(n) amortized time, O(n) space
	 * Take advantage of stack, a little bit large overheah
	 * @param height
	 * @return
	 */
	public int trap2(int[] height) {
		if ( height==null || height.length < 3 ) return 0;
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int sum = 0;
		for ( int i = 0; i < height.length; i++ ) {
			while ( !stack.isEmpty() && height[i] >= height[stack.peek()] ) {
				int lowH = height[stack.pop()];
				if ( !stack.isEmpty() ) {
					int leftB = stack.peek();
					int highH = Math.min(height[leftB], height[i]);
					sum += (highH-lowH)*(i-leftB-1);
				}
			}
			stack.push(i);
		}
		return sum;
	}
}










