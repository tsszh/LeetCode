package Medium2;

public class LT125 {
	public static void main ( String[] args ) {
		System.out.println(isPalindrome("ab,,,d,,a"));
	}
	public static boolean isPalindrome(String s) {
        if ( s == null || s.length() < 2 ) return true;
        s = s.toLowerCase();
        for ( int i = 0, j = s.length()-1; i < j; ) {
            int ich = s.charAt(i++);
            while ( !Character.isAlphabetic(ich) && !Character.isDigit(ich) )
            	if ( i < j )
            		ich = s.charAt(i++);
            	else
            		return true;
            int jch = s.charAt(j--);
            while ( !Character.isAlphabetic(jch) && !Character.isDigit(jch) )
            	if ( i < j )
            		jch = s.charAt(j--);
            	else
            		return true;
            if ( ich != jch ) return false;
        }
        return true;
    }
}
