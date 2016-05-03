package LT100T150;

import java.util.HashMap;
import java.util.Map;

import utilities.Point;

/**
 * 149. Max Points on a Line 
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author Zehao
 *
 */

/*
 * 
 * Use the String representation of slope as the key
 * 
 * Time: O(n^2) Space: O(n)
 * 
 */
public class LT149 {
	public int maxPoints(Point[] points) {
		if (points.length <= 2)
			return points.length;
		int globalMax = 2;
		for ( int j = 0; j < points.length; j++ ) {
			int x0 = points[j].x, y0 = points[j].y;
			int base = 1;
			Map<String, MutableInt> map = new HashMap<>(points.length);
			for (int i = j+1; i < points.length; i++) {
				int x = points[i].y - y0, y = points[i].x - x0;
				if ( x == 0 && y == 0 ) { base++; continue; }
				int d = GCD(x,y);
				x = d==0?x:x/d;
				y = d==0?y:y/d;
				String key = x+"|"+y;
				MutableInt count = map.get(key);
				if (count == null) {
					map.put(key, new MutableInt());
				} else {
					count.increment();
				}
			}
			int max = 0;
			for (MutableInt count : map.values()) {
				if (count.get() > max)
					max = count.get();
			}
			max += base;
			if ( globalMax < max ) globalMax = max;
		}
		return globalMax;
	}
	
	private int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	private class MutableInt {
		private int i = 1;

		public void increment() {
			i++;
		}

		public int get() {
			return i;
		}
	}
}
