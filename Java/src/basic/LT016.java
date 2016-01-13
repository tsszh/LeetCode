package basic;

import java.util.*;

public class LT016 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextLine() ) {
			String input= in.nextLine();
			System.out.println(letterCombinations(input));
		}
		in.close();
	}
	
	public static final String[] lmap = new String[] {
		" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"	
	};
	public static List<String> letterCombinations(String digits) {
        if ( digits == null || digits.length() == 0 ) return new ArrayList<String>();
        ArrayList<String> ret = new ArrayList<String>((int)Math.pow(3, digits.length()));
        char[] ans = new char[digits.length()];
        letterCombinationsHelper(ret,ans,digits,0);
        return ret;
    }
	private static void letterCombinationsHelper(List<String> ret,char[] ans,String str, int d ){
		if ( d == str.length() ) {
			ret.add(new String(ans));
			return;
		}
		int num = str.charAt(d)-'0';
		for ( int i = 0; i<lmap[num].length(); i++ ) {
			ans[d] = lmap[num].charAt(i);
			letterCombinationsHelper(ret,ans,str,d+1);
		}
	}
}
