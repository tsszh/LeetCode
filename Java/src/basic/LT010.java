package basic;

import java.util.*;

public class LT010 {
	public static void main (String[] args ) {
		Scanner in = new Scanner(System.in);
		String s,p;
		while ( in.hasNextLine() ) {
			s = in.nextLine();
			p = in.nextLine();
			System.out.println(isMatch(s,p));
		}
		in.close();
	}
	/**
	 * Dynamic Programming - time consuming O(n^2) space consuming O(n)
	 * M[pi,sj] = (pi==sj||pi=='.')&&(M[pi-1,sj-1])             if pi+1 != '*'
	 *          = (pi==sj||pi=='.')&&(M[pi-1,sj-1]||M[pi,sj-1]) if pi+1 == '*'
	 *          = M[pi-1,sj]                                    if pi   == '*'
	 * return M[p last,s last]
	 * @param s string
	 * @param p pattern
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		boolean[] prev = new boolean[p.length()+1]; // Initialized to false
        prev[0] = true;
        for ( int i =1; i<p.length()&&prev[i-1]; i+=2) {
        	if ( i<p.length() && p.charAt(i) == '*' ) {
        		prev[i]=prev[i+1]=true;
        	}
        }
        boolean[] curr = new boolean[prev.length];
        for ( int j=0; j<s.length();j++ ) {
        	char sch = s.charAt(j);
        	curr[0]=false;
        	for ( int i=1; i<curr.length;i++ ) {
        		char pch = p.charAt(i-1);
        		if ( pch == '*' )
        			curr[i] = curr[i-1];
        		else {
        			if ( i<p.length() && p.charAt(i)=='*')
        				curr[i] = curr[i-1]||(
        						(pch=='.'||pch==sch)&&(prev[i-1]||prev[i])
        					);
        			else
        				curr[i] = (pch=='.'||pch==sch)&&(prev[i-1]);
        		}
        	}
        	boolean[] temp = prev;
        	prev = curr;
        	curr = temp;
        }
        return prev[prev.length-1];
	}
}
