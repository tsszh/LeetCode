package basic2;

import java.util.*;

public class LT044 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			String s = in.nextLine();
			if ( s.equals("exit") ) break;
			String p = in.nextLine();
			long st, et;
			boolean result;
			st = System.nanoTime();
			result = isMatch(s,p);
			et = System.nanoTime();
			System.out.printf("Dynamic Programing : %5s %15d ns\n",result,et-st);
			
			st = System.nanoTime();
			result = isMatch2(s,p);
			et = System.nanoTime();
			System.out.printf("Greedy Algorithm   : %5s %15d ns\n",result,et-st);
		}
		in.close();
	}
	/**
	 * Dynamic Programing: Time O(n*m) Space O(m)
	 * M[p[i],s[j]] 
	 *              = (p[i]==s[j]||p[i]=='?')&&(M[p[i-1],s[j-1]]) if (p[i]!='*')
	 *              = (M[p[i-1],s[j]]) || (M[p[i-1],s[j-1]]||M[p[i],s[j-1]])) if (p[i]=='*')
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if ( s==null || p==null ) return false;
		if ( p.replace("*","").length() > s.length() ) return false;
        boolean[] prev = new boolean[p.length()+1];
        prev[0] = true;
        for ( int i = 0; i < p.length(); i++ ) {
        	if ( p.charAt(i) == '*' ) {
        		prev[i+1] = true;
        	} else {
        		break;
        	}
        }
        boolean[] curr = new boolean[prev.length];
        for ( int j = 0; j<s.length(); j++ ) {
        	char sch = s.charAt(j);
        	for ( int i = 1; i<curr.length; i++ ) {
        		char ch = p.charAt(i-1);
        		if ( ch == '*' ) {
        			curr[i] = (curr[i-1])||((prev[i-1]||prev[i]));
        		} else {
        			curr[i] = (ch=='?'||ch==sch)&&(prev[i-1]);
        		}
        	}
        	//System.out.println(Arrays.toString(curr));
        	boolean[] temp = prev;
        	prev = curr;
        	curr = temp;
        	curr[0] = false;
        }
        return prev[prev.length-1];
    }
	
	/**
	 * Greedy Algorithm : Time  O(m+n) BestCase O(m*n) WorstCase
	 * 					  Space O(1)
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch2(String s, String p) {
		if ( s == null || p == null ) return false;
		int pS=0, pE=0, sP=0;
		pE = p.indexOf('*',0);
		if ( pE == -1 ) // No '*' return s.equals(p);
			return  s.length()==p.length() && firstIndex(s,0,s.length(),p,0,p.length())==0;
		else {
			if ( pE!=0 && firstIndex(s,0,s.length(),p,0,pE)!=0 ) return false;
			sP = pE;
			while ( pE<p.length()&&p.charAt(pE)=='*' ) pE++;
			pS = pE;
		}
		while ( pS < p.length() && sP < s.length()) {
			pE = p.indexOf('*',pS);
			if ( pE == -1 ) {
				sP = Math.max(sP, s.length()-p.length()+pS);
				return firstIndex(s,sP,s.length(),p,pS,p.length()) == sP;
			}
			int off = firstIndex(s,sP,s.length(),p,pS,pE);
			if ( off == -1 ) return false;
			sP = off+(pE-pS);
			while ( pE<p.length()&&p.charAt(pE)=='*' ) pE++;
			pS = pE;
		}
		return pS==p.length();
 	}
	private static int firstIndex ( String s, int ss, int se, String p, int ps, int pe ) {
		int len = pe-ps;
		for ( int i = ss; i <= se-len; i++ ) {
			int j = i, k = ps;
			while (  k < pe && (p.charAt(k)=='?'||s.charAt(j)==p.charAt(k)) ) {
				j++; 
				k++;
			}
			if ( k == pe ) return i;
		}
		return -1;
	}
}
