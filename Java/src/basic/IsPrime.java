package basic;

import java.util.*;

public class IsPrime {
	public static void main ( String[] args ) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNextInt() ) {
			int num = in.nextInt();
			boolean flag = true;
			for ( int i = 2; flag && i*i<=num; i++ ) {
				flag = num%i != 0;
			}
			System.out.println(flag);
		}
		in.close();
	}
}
