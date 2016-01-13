package basic2;

import java.util.*;
import java.io.*;

public class LT030 {
	public static void main ( String[] args ) throws FileNotFoundException {
		LT030 dump = new LT030();
		Scanner in = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		in.useDelimiter("[\",\\[\\]\\s]+");
		String s = in.nextLine();
		List<String> words = new ArrayList<String>();
		while ( in.hasNext() ) {
			String word = in.next();
			if ( word.equals("done") ) break;
			words.add(word);
		}
		String[] input = words.toArray(new String[0]);
		System.out.println(s);
		System.out.println(Arrays.toString(input));
		System.out.println(dump.findSubstring(s,input));
		in.close();
	}
	
	private static final int mask = 0xFFFF;
	public List<Integer> findSubstring(String s, String[] words) {
		if ( words == null || words.length == 0 ) return new ArrayList<Integer>();
		int count = words.length;
		if ( words[0] == null || words[0].length() == 0 ) new ArrayList<Integer>();
		int len = words[0].length();
		if ( s==null || s.length() < len*count ) return new ArrayList<Integer>();
		
		List<Integer> ret = new ArrayList<Integer>();
		HashMap<String,WeightNode> table = new HashMap<String,WeightNode>(count);
        int checksum = 0;
        for ( int i = 0; i<count ; i++ ) {
        	if ( table.containsKey(words[i]) )
        		table.get(words[i]).post();
        	else
        		table.put(words[i], new WeightNode());
        	checksum = (checksum+words[i].hashCode()&mask)&mask;
        }
        for ( int i = 0; i<len; i++ ) {
        	int check = 0;
        	int end = i+count*len;
        	int j = i;
        	for ( ; j < end-len; j+=len )
        		check = (check+s.substring(j,j+len).hashCode()&mask)&mask;
        	for ( j = i; end<=s.length(); end+=len, j+=len ) {
        		check = (check+s.substring(end-len,end).hashCode()&mask)&mask;
        		if (  check==checksum && checkMatch(s,j,len,count,table) ) {
        			ret.add(j);
        		}
        		check = (check-s.substring(j,j+len).hashCode()&mask)&mask;
        	}
        }
        return ret;
    }
	private boolean checkMatch( String s, int off, int len, int count, HashMap<String,WeightNode> table ) {
		boolean flag = true;
		for ( int i=off, end=off+count*len; flag&&i<end; i+=len ) {
			WeightNode wn = table.get(s.substring(i,i+len));
			if ( wn == null || !wn.pull() ) flag = false;
		}
		for ( WeightNode wn : table.values() ) {
			if ( wn.pull() ) flag = false;
			wn.reset();
		}
		return flag;
	}
	private class WeightNode {
		private int count;
		private int weight;
		WeightNode() {
			count = 1;
			weight = 1;
		}
		public void post () { weight++; count++; }
		public boolean pull () { count--; return count >= 0; }
		public void reset() { count = weight; }
	}
}
