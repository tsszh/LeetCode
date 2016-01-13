package Medium1;

public class LT065 {
	public static void main ( String[] args ) {
		System.out.println(addBinary("111","1"));
	}
	public static int[] plusOne(int[] digits) {
        int carry = 1;
        for ( int i = digits.length-1; i>=0&&carry!=0; i-- ) {
            int temp = digits[i] + carry;
            digits[i] = temp%10;
            carry = temp/10;
        }
        if ( carry > 0 ) {
        	int[] res = new int[digits.length+1];
        	res[0] = carry;
            for ( int i = 1; i < res.length; i++ )
            	res[i] = digits[i-1];
            return res;
        } else {
        	return digits;
        }
    }
	public static String addBinary(String a, String b) {
		if ( a == null || a.length() == 0  ) return b;
		if ( b == null || b.length() == 0  ) return a;
		if ( a.length() < b.length() ) {
			String c = a;
			a = b;
			b = c;
		}
		char[] buffer = a.toCharArray();
		int carry = 0;
		for ( int an = a.length()-1, n = b.length()-1; an>=0; n--, an-- ) {
			int bitSum = carry+buffer[an]-'0'+((n>=0)?b.charAt(n)-'0':0);
			carry = bitSum>>1;
			buffer[an]=(char)((bitSum&1)+'0');
		}
		if ( carry > 0 ) return "1"+new String(buffer);
		else return new String(buffer);
    }
}
