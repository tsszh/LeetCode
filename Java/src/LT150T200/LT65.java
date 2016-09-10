package LT150T200;

public class LT65 {
	public int compareVersion(String version1, String version2) {
		return 0;
	}
	private String[] processVersionNumber ( String v ) {
		int dot1 = v.indexOf('.');
		int dot2 = v.indexOf('.', dot1+1);
		if ( dot2 == -1 ) dot2 = v.length();
		return new String[]{  };
	}
	private int compareLargeNumber( String a, String b ) {
		a.replaceAll("^0+", "");
		b.replaceAll("^0+", "");
		if ( a.length() > b.length() ) return 1;
		if ( a.length() < b.length() ) return -1;
		for ( int i = 0; i < a.length(); i++ ) {
			int n_a = a.charAt(i) - '0';
			int n_b = b.charAt(i) - '0';
			if ( n_a > n_b ) return 1;
			if ( n_b > n_a ) return -1;
		}
		return 0;
	}
}
