package Medium1;


public class LT072 {
	public static void main ( String[] args ) {
		System.out.println(minDistance("cdd","abc"));
	}
	public static int minDistance(String word1, String word2) {
        if ( word1 == null || word2 == null ) {
        	if ( word1 == word2 ) return 0;
        	if ( word1 == null ) return word2.length();
        	return word1.length();
        }
        int[] prev = new int[word1.length()+1];
        for ( int i = 0; i < prev.length; i++ )
        	prev[i] = i;
        int[] curr = new int[prev.length];
        for ( int j = 1; j<=word2.length(); j++ ) {
        	curr[0] = j;
        	for ( int i = 1; i < curr.length; i++ ) {
        		int min;
        		if ( word1.charAt(i-1) == word2.charAt(j-1) )
        			min = prev[i-1];    // Do Nothing
        		else
        			min = prev[i-1]+1;  // Replace
        		min = Math.min(min, Math.min(curr[i-1]+1, prev[i]+1));
        		curr[i] = min;
        	}
        	//System.out.println(Arrays.toString(curr));
        	int[] temp = curr;
        	curr = prev;
        	prev = temp;
        }
        return prev[prev.length-1];
    }
}
