package LT100T150;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.Point;

@RunWith( Parameterized.class )
public class LT149Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{ new int[][]{ {-4,-4},{-8,-582},{-3,3},{-9,-651},{9,591} }, 3},
			{ new int[][]{ {0,0}, {1,1}, {0,0} }, 3 },
			{ new int[][]{ {0,0}, {1,1}, {1,1} }, 3 },
			{ new int[][]{ {1,1}, {2,2}, {3,3} }, 3 },
			{ new int[][]{ {1,2}, {1,3}, {2,4} }, 2 }
		});
	}
	@Parameter
	public int[][] rawPoints;
	@Parameter(value=1)
	public int res;
	
	private LT149 dummy = new LT149();
	
	@Test
	public void test() {
		Point[] points = new Point[rawPoints.length];
		for ( int i = 0; i < rawPoints.length; i++ ) {
			points[i] = new Point( rawPoints[i][0], rawPoints[i][1] );
		}
		int maxCount = dummy.maxPoints(points);
		assertEquals( res, maxCount );
	}

}
