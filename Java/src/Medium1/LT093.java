package Medium1;

import java.util.*;

public class LT093 {
	public static void main ( String[] args ) {
		LT093 dummy = new LT093();
		System.out.println(dummy.restoreIpAddresses("0001"));
	}
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new LinkedList<String>();
        if ( s == null || s.length() < 4 ) return res;
        StringBuilder str = new StringBuilder(s);
        int[] ans = new int[5];
        restoreIpAddressesHelper(0,s.length(),ans,str,res);
        return res;
    }
	private void restoreIpAddressesHelper
	(int level, int remainSize, int[] ans, StringBuilder s, List<String> res ) {
		if ( level == 4 ) {
			for ( int i = 3; i >0; i-- )
				s.insert(ans[i], '.');
			res.add( s.toString() );
			for ( int i = 1; i <4; i++ )
				s.deleteCharAt(ans[i]);
			return;
		}
		for ( int l = level==3?remainSize:Math.max(1, remainSize+3*level-9), 
				max = level==3?remainSize:Math.min(3, remainSize+level-3); 
				l <= max; l++ ) {
			if ( s.charAt(ans[level]) == '0' && l != 1) return;
			if ( l == 3 ) {
				int check = Integer.parseInt(s.substring(ans[level], ans[level]+3));
				if ( check >255 ) continue;
			}
			ans[level+1] = ans[level]+l;
			restoreIpAddressesHelper(level+1,remainSize-l,ans,s,res);
		}
	}
}
