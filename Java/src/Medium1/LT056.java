package Medium1;

import java.util.*;

public class LT056 {
	public static void main ( String[] args ) {
		LT056 dummy = new LT056();
		int[] nums = new int[] {
				7,8,1,3,4,7,5,6, 10,12	
		};
		List<Interval> intervals = new ArrayList<Interval>(nums.length/2);
		for ( int i = 0; i < nums.length; i+=2 ) {
			intervals.add(new Interval(nums[i],nums[i+1]));
		}
		System.out.println(intervals=dummy.merge(intervals));
		System.out.println(dummy.insert(intervals,new Interval(9,9)));
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res;
		if (intervals== null||intervals.size()==0)
			res = new ArrayList<Interval>();
		else
			res = new ArrayList<Interval>(intervals.size()+1);
	   Iterator<Interval> it = intervals.iterator();
	   
	   boolean isInserted = false;
	   while ( it.hasNext() ) {
		   Interval curr = it.next();
		   if ( !isInserted ) {
			   if ( curr.end < newInterval.start )
				   res.add(curr);
			   else if ( newInterval.end < curr.start ) {
				   res.add(newInterval);
				   res.add(curr);
				   isInserted = true;
				   break;
			   } else {
				   if ( curr.start < newInterval.start )
					   newInterval.start = curr.start;
				   if ( curr.end > newInterval.end )
					   newInterval.end = curr.end;
				   res.add(newInterval);
				   isInserted = true;
			   }
		   }
		   else {
			   if ( curr.start > newInterval.end )
				   res.add(curr);
			   else {
				   if ( curr.end > newInterval.end )
					   newInterval.end = curr.end;
			   }
		   }
	   }
	   while ( it.hasNext() ) {
		   res.add(it.next());
	   }
	   if ( !isInserted ) res.add(newInterval);
	   return res;
    }
	public List<Interval> merge(List<Interval> intervals) {
        if ( intervals == null || intervals.size() == 0 ) return new ArrayList<Interval>();
        intervals.sort( new Comparator<Interval>() {
        	public int compare(Interval a, Interval b) {
        		return a.start - b.start;
        	}
        }); // Sort the intervals list into ascending order, according to the start value of each interval
            // O(n*lgn) Time
        int[] record = new int[intervals.size()*2];
        int count = 0;
        for ( Interval item : intervals ) {
        	if ( count == 0 || item.start > record[count-1] ) {
        		record[count++] = item.start;
        		record[count++] = item.end;
        	} else if ( item.end > record[count-1] ) {
        		record[count-1] = item.end; 
        	}
        }
        List<Interval> res = new ArrayList<Interval>(count/2);
        for ( int i = 0; i < count; i+=2 ) {
        	res.add(new Interval(record[i],record[i+1]));
        }
        return res;
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	public String toString() {
		return "["+start+","+end+"]";
	}
}