package Medium2;

import java.util.*;

public class LT131 {
	public static void main ( String[] args ) {
		LT131 dummy = new LT131();
		String str = "abac";
		System.out.println(dummy.partition(str));
		System.out.println(dummy.minCut(str));
	}
	/**
	 * Return the minimum number of cuts needed for a palindrome partition of String s
	 * Dynamic Programming : Time O(n^2) Space O(n)
	 * Greedy Algorithm Not Applicable : "acacaac" "acaca|a|c" "aca|caac"
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
        if ( s == null || s.length() < 2 ) return 0;
        int[] newStr = new int[s.length()*2+3];
        Arrays.fill(newStr,-1);
        newStr[0] = -2;
        newStr[newStr.length-1] = -3;
        for ( int i = 0; i < s.length(); i++ ) {
        	newStr[(i+1)<<1] = s.charAt(i);
        }
        int[] palLen = new int[newStr.length];
        int id = 0, front = 1;
        for ( int i = 1; i < newStr.length-1; i++ ) {
        	int j = (i>=front)?1:Math.min(front-i, palLen[(id<<1)-i]);
        	while ( newStr[i-j] == newStr[i+j] )
    			j++;
    		palLen[i] = j;
    		id = i;
    		front = id+j;
        }
        int[] minCut = new int[s.length()+1];
        minCut[0] = -1;
        for ( int i = 0; i < s.length(); i++ ) {
        	int min = Integer.MAX_VALUE;
        	for ( int j = i; j >= 0; j-- ) {
        		if ( palLen[2+i+j] > i-j+1 ) {
        			if ( minCut[j]+1 < min )
        				min = minCut[j]+1;
        		}
        	}
        	minCut[i+1] = min;
        }
        System.out.println(Arrays.toString(minCut));
        return minCut[s.length()];
    }
	public List<List<String>> partition(String s) {
		List<List<String>> res = new LinkedList<List<String>>();
		if ( s == null ) return res;
        int[] newStr = new int[s.length()*2+3];
        Arrays.fill(newStr, -1);
        newStr[0] = -2;
        newStr[newStr.length-1]=-3;
        for ( int i = 0; i < s.length(); i++ ) {
        	newStr[(i+1)<<1] = s.charAt(i);
        }
        int[] palLen = new int[newStr.length];
        int id = 0, front = 0;
        for ( int i = 1; i < newStr.length-1; i++ ) {
        	int j = (i>=front)?1:Math.min(front-i, palLen[(id<<1)-i]);
        	while ( newStr[i-j] == newStr[i+j] )
    			j++;
    		palLen[i] = j;
    		id = i;
    		front = id+j;
        }
        //System.out.println(Arrays.toString(newStr));
        //System.out.println(Arrays.toString(palLen));
        partitionHelper(s,0,palLen,res);
        return res;
    }
	private Deque<Integer> stack = new LinkedList<Integer>();
	private void partitionHelper( String s, int begin, int[] palLen, List<List<String>> res ) {
		if ( begin >= s.length() ) {
			List<String> resItem = new ArrayList<String>(stack.size());
			Iterator<Integer> it = stack.descendingIterator();
			int i = 0;
			while ( it.hasNext() ) {
				int len = it.next();
				resItem.add( s.substring(i,i+len) );
				i += len;
			}
			res.add(resItem);
		} else {
			for ( int end = begin; end < s.length(); end++ ) {
				if ( palLen[2+begin+end] > end-begin+1 ) {
					stack.push(end-begin+1);
					partitionHelper(s,end+1,palLen,res);
					stack.pop();
				}
			}
		}
	}
}
