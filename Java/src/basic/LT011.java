package basic;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

public class LT011 {
	public static void main (String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			ArrayList<Integer> input = new ArrayList<Integer>();
			while ( in.hasNextInt() ) {
				input.add(in.nextInt());
			}
			if ( input.size() == 0 ) break;
			in.nextLine();
			System.out.println(input);
			int[] height = new int[input.size()];
			for ( int i = 0; i<height.length; i++)
				height[i] = input.get(i);

			System.out.println(maxArea(height));
		}
		in.close();
	}
	public static int maxArea(int[] height) {
		if ( height == null ) return 0;
        int max = 0;
        for ( int i = 0, j = height.length-1; i<j; ) {
        	int h = min(height[i],height[j]);
        	max = max(h*(j-i),max);
        	while ( i<j && height[i]<=h ) i++;
        	while ( i<j && height[j]<=h ) j--;
        }
        return max;
    }
}
