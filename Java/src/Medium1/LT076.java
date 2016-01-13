package Medium1;

import java.util.*;

public class LT076 {
	public static void main ( String[] args ) {
		System.out.println(minWindow("a","c"));
	}
	public static String minWindow(String s, String t) {
		if ( s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>(t.length());
        for ( int i = 0; i < t.length(); i++ ) {
        	int ch = t.charAt(i);
        	if ( hashmap.containsKey(ch) ) {
        		hashmap.put(ch, hashmap.get(ch)+1);
        	} else {
        		hashmap.put(ch, 1);
        	}	
        }
        int len = Integer.MAX_VALUE, found = 0, start = -1;
        int i = 0, j = 0;
        while ( j < s.length() ) {
        	while ( j < s.length() && found < t.length() ) {
        		int ch = s.charAt(j++);
        		if ( hashmap.containsKey(ch) ) {
        			int temp = hashmap.get(ch)-1;
            		hashmap.put(ch, temp );
            		if ( temp >= 0 ) found++;
            	}
        	}
        	while ( i < j && found == t.length() ) {
        		int ch = s.charAt(i++);
        		if ( j-i+1 < len ) {
            		len = j-i+1;
            		start = i-1;
            	}
        		if ( hashmap.containsKey(ch) ) {
        			int temp = hashmap.get(ch)+1;
            		hashmap.put(ch, temp );
            		if ( temp > 0 ) found--;
            	}
        	}
        }
        if ( start != -1 )
            return s.substring(start, start+len);
        else
            return "";
    }
}
