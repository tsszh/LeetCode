package basic;

public class LT006 {
	public static void main ( String[] agrs ) {
		System.out.println(convert("0123456789",2));
	}
	public static String convert(String s, int numRows) {
		if ( numRows == 1 )
			return s;
        StringBuilder ret = new StringBuilder();
        int interval = 2*numRows-2;
        for ( int r = 0; r < numRows; r++ ) {
        	if ( r == 0 || r == numRows-1 ) {
        		for ( int i = r; i < s.length(); i+=interval  )
        			ret.append(s.charAt(i));
        	} else {
        		for ( int i = r; i < s.length(); i+=interval ) {
        			ret.append(s.charAt(i));
        			int j = i+interval-2*r;;
        			if ( j < s.length() )
        				ret.append(s.charAt(j));
        		}
        	}
        }
        return ret.toString();
    }
}
