package Medium2;

public class LT135 {
	public static void main ( String[] args ) {
		int[] ratings = new int[] {
				1,2,3,3,2,1,0
		};
		System.out.println(candy(ratings));
	}
	public static int candy(int[] ratings) {
		if ( ratings == null || ratings.length == 0 ) return 0;
        //int[] record = new int[ratings.length];
        int prevCandy = 1, sum = 1;
        //record[0] = 1;
        for ( int i = 1; i < ratings.length; i++ ) {
        	if ( ratings[i] == ratings[i-1] ) {
        		//record[i] = 1;
        		prevCandy = 1;
        		sum++;
        	} else if ( ratings[i] > ratings[i-1] ) {
        		prevCandy++;
        		//record[i] = prevCandy;
        		sum += prevCandy;
        	} else {
        		int j = i+1;
        		while ( j<ratings.length && ratings[j] < ratings[j-1] ) {
        			j++;
        		}
        		int count = j-i+1;
        		sum += Math.max(prevCandy, count)-prevCandy;
        		//record[i-1] = Math.max(prevCandy, count);
        		while ( i < j ) {
        			sum += --count;
        			i++;
        			//record[i++] = count;
        		}
        		i--;
        		prevCandy = 1;
        	}
        }
        //System.out.println(Arrays.toString(record));
        return sum;
    }
}
