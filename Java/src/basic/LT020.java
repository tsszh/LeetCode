package basic;

import java.util.*;

public class LT020 {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextLine() ) {
			String str = in.nextLine();
			if ( str.equals("exit") )
				break;
			System.out.println(isValid(str));
		}
		in.close();
	}
	public static boolean isValid(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for ( int i=0; i<s.length(); i++ ) {
        	int ch = s.charAt(i);
        	if ( ch=='('||ch=='['||ch=='{' )
        		stack.push(ch);
        	else if ( ch==')' || ch==']' || ch=='}') {
        		if ( stack.isEmpty() ) return false;
        		int left = stack.pop();
        		switch(ch) {
        			case ')': if ( left != '(' ) return false; break;
        			case ']': if ( left != '[' ) return false; break;
        			case '}': if ( left != '{' ) return false; break;
        		}
        	}
        }
        return stack.isEmpty();
    }
}
