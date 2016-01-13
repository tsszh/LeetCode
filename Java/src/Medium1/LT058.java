package Medium1;

public class LT058 {
	public static void main ( String[] args ) {
		System.out.println(lengthOfLastWord("      "));
	}
	public static int lengthOfLastWord(String s) {
        if ( s == null || s.length() == 0 ) return 0;
        int count = 0;
        int i = s.length()-1;
        while ( i>=0 && s.charAt(i) == ' ' ) i--;
        while ( i>=0 && s.charAt(i) != ' ' ) {
        	count++;
        	i--;
        }
        return count;
    }
}
