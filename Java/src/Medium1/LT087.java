package Medium1;

import java.util.Arrays;

public class LT087 {
	public static void main ( String[] args ) {
		System.out.println(isScramble("abcd","badc"));
	}
	public static boolean isScramble(String s1, String s2) {
		if ( s1 == null ) return s2 == null;
		if ( s2 == null ) return false;
		if ( s1.length() != s2.length() ) return false;
		int len = s1.length();
		if ( len == 0 ) return true;
		char[] tempString1 = s1.toCharArray();
		Arrays.sort(tempString1);
		char[] tempString2 = s2.toCharArray();
		Arrays.sort(tempString2);
		if ( !Arrays.equals(tempString1, tempString2) ) return false;
		boolean[][][] dp = new boolean[len][len][len];
		for ( int l = 0; l < len; l++ ) {
			for ( int i = 0; i+l < len; i++  ) {
				for ( int j = 0; j+l < len; j++ ) {
					if ( l == 0 ) {
						if ( s1.charAt(i)==s2.charAt(j) ) {
							dp[i][j][l] = true;
						}
					}
					else {
						for ( int k = 0; k < l; k++ ) {
							if ( (dp[i][j][k]&&dp[i+k+1][j+k+1][l-k-1]) ||
									(dp[i][j+l-k][k]&&dp[i+k+1][j][l-k-1])	) {
								dp[i][j][l] = true;
								break;
							}
						}
					}
				}
			}
		}
		showDP(dp);
		return dp[0][0][len-1];
    }
	private static void showDP( boolean[][][] dp ) {
		int len = dp.length;
		for ( int i = 0; i < len; i++  ) {
			for ( int j = 0; j < len; j++ ) {
				System.out.printf("[i,j]=[%d,%d] ",i,j);
				for ( int l = 0; i+l < len && j+l < len; l++ ) {
					System.out.printf("%d ",dp[i][j][l]?1:0);	
				}
				System.out.println();
			}
		}
	}
}
