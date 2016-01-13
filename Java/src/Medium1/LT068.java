package Medium1;

import java.util.*;

public class LT068 {
	public static void main ( String[] args ) {
		String[] words = new String[] {
			"aa","aa","aa","aa","aa","aa","aa","aa","aa","aa"
		};
		List<String> res = fullJustify(words,11);
		for ( String line : res )
			System.out.println(line);
	}
	public static List<String> fullJustify(String[] words, int maxWidth) {
		StringBuilder line = new StringBuilder(maxWidth);
        for ( int i = 0; i < maxWidth; i++ ) {
        	line.append(' ');
		}
        String spaceLine = line.toString();
        List<String> res = new LinkedList<String>();
        for ( int i = 0; i < words.length; ) {
        	int j = i;
        	line.replace(0, maxWidth, spaceLine);
        	int space = maxWidth;
        	while ( j < words.length && words[j].length() <= space ) {
        			space -= words[j].length()+1;
        			j++;
        	}
        	space += j-i;
        	if ( j == i+1 ) {
        		line.replace(0, words[i].length(), words[i]);
        		i++;
        	} else {
        		int lowSpace = space/(j-i-1);
        		space = space%(j-i-1);
        		for ( int k = 0; k < maxWidth && i < j; i++) {
        			line.replace(k, k+words[i].length(), words[i]);
        			if ( j == words.length ) {
        				k+=words[i].length()+1;
        			} else if ( space > 0 ) {
        				k+=words[i].length()+lowSpace+1;
        				space--;
        			} else {
        				k+=words[i].length()+lowSpace;
        			}
        		}
        	}
        	res.add(line.toString());
        }
        return res;
    }
}
