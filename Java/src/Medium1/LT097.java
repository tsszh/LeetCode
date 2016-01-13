package Medium1;

//import java.util.Arrays;

public class LT097 {
	public static void main ( String[] args ) {
		System.out.println(isInterleave("abc","def","abdcfe"));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
		if ( s1==null ) return (s2==null&&s3==null)||(s2!=null&&s2.equals(s3));
		if ( s2==null ) return s1.equals(s3);
		if ( s3==null || s3.length()!=s1.length()+s2.length() ) return false;
		boolean[] prev = new boolean[s2.length()+1];
		boolean[] curr = new boolean[s2.length()+1];
		boolean isPosible = true;
		for ( int i = -1; i < s1.length()&&isPosible; i++ ) {
			isPosible=curr[0] = i==-1||(prev[0]&&s1.charAt(i)==s3.charAt(i));
			for ( int j = 1; j < curr.length; j++ ) {
				if ( ((i>=0&&s1.charAt(i)==s3.charAt(i+j))&&prev[j]) ||
					 (s2.charAt(j-1)==s3.charAt(i+j)&&curr[j-1])	) {
					curr[j] = true;
					isPosible = true;
				}	else
					curr[j]=false;
			}
			//System.out.println(Arrays.toString(curr)+i);
			boolean[] temp = curr;
			curr = prev;
			prev = temp;
		}
		return prev[prev.length-1];
    }
}
