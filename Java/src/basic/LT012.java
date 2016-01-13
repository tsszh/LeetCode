package basic;

import java.util.Scanner;

public class LT012 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		String input;
		while ( in.hasNext() ) {
			input = in.next();
			if ( input.charAt(0) >= '0' && input.charAt(0) <= '9' )
				System.out.println(""+input+" = "+intToRoman(Integer.parseInt(input)));
			else {
				if ( input.charAt(0) == 'Q' )
					break;
				else
					System.out.println(""+input+" = "+romanToInt(input));
			}
		}
		in.close();
	}
	public static String intToRoman(int num) {
        String[] symbol = new String[] {
        		"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"
        };
        int[] value = new int[] {
        		1000,900,500, 400,100, 90,  50, 40, 10,   9,  5,   4,  1
        };
        StringBuilder ans = new StringBuilder();
        for ( int i = 0; i<value.length; i++ ) {
        	while ( num>=value[i] ) {
        		num -= value[i];
        		ans.append(symbol[i]);
        	}
        }
        return ans.toString();
    }
	public static int romanToInt(String s) {
        int[] vmap = new int[] {
        	0,0,100/*C*/,500/*D*/,0,0,0,0,1/*I*/,
        	0,0,50/*L*/,1000/*M*/,0,0,0,0,0,0,0,0,5/*V*/,0,10/*X*/,0,0
        };
        int ans = 0, prev = 0, curr = 0;
        for ( int i = 0; i<s.length(); i++ ) {
        	curr = vmap[s.charAt(i)-'A'];
        	if ( prev < curr )
        		ans-=prev;
        	else
        		ans+=prev;
        	prev = curr;
        }
        return ans+prev;
    }
}
