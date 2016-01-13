package Medium1;

public class LT091 {
	public static void main ( String[] args ) {
		System.out.println(numDecodings("30"));
	}
	public static int numDecodings(String s) {
        if ( s == null || s.length() == 0 ) return 0;
        int num = (s.charAt(0)=='0')?0:1, oneL = 1, twoL = 1;
        for ( int i = 1 ; i < s.length() && num != 0; i++ ) {
            char ch2=s.charAt(i);
            num  = ( ch2 != '0' )?oneL:0;
            char ch1=s.charAt(i-1);
            if ( ch1=='1'||(ch1=='2'&&(ch2>='0'&&ch2<='6')) )
            	num+=twoL;
            twoL = oneL;
            oneL = num;
        }
        return num;
    }
}
