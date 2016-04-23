package LT100T150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class LT140 {
	/**
	 * DFS Method
	 * Time: O(2^n)
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
		if ( s.length() == 0 || wordDict.size() == 0 ) return new ArrayList<>();
		int maxLen= maxLenOfWordDict(wordDict);
		
		List<String> res = new ArrayList<>();
		List<Integer> record = new ArrayList<>();
		record.add(0);
		wordBreakHelper(0,s,maxLen,wordDict, record, res);
		return res;
	}

	private void wordBreakHelper(  int start, String s, int maxLen, Set<String> wordDict, List<Integer> record, List<String> res ) {
		for ( int end = start+1; end <= Math.min( s.length(), start+maxLen); end++ ) {
			if ( wordDict.contains( s.substring(start, end) ) ){
				record.add(end);
				if ( end == s.length() ) {
					StringBuilder str = new StringBuilder( );
					for ( int i = 1; i < record.size(); i++  ) {
						str.append( s.substring( record.get(i-1), record.get(i) )+" " );
					}
					res.add(str.toString().trim());
				} else {
					wordBreakHelper(end,s,maxLen,wordDict,record,res);
				}
				record.remove( record.size()-1 );
			}
		}
	}
	
/*
 * ==============================================================================================================
 * ==============================================================================================================
 * ==============================================================================================================
 */
	/**
	 * Dynamic Programming + DFS
	 * 
	 * 0 1 2 3 4 5 6 7 8 9
	 * c a t s a n d d o g
	 *     0 0     3     7
	 *             4 
	 *             
	 * Time: O(n*m)+O(x) // x is the size of final result
	 */
	public List<String> wordBreakDP(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		
		if ( !canWordBreak(s,wordDict) || s.length()==0 || wordDict.size()==0 ) return res;
		List< List<Integer> > record = new ArrayList<>(s.length());
		for ( int t = 0; t < s.length(); t++ ) {
			List<Integer> temp = new ArrayList<>();
			for ( int h = Math.max(0, t-s.length()+1); h <= t; h++ ) {
				if ( wordDict.contains(s.substring(h,t+1)) ) {
					if ( h == 0 || record.get(h-1).size() > 0 ) // Exclude Invalid Result
						temp.add(h);
				}
			}
			record.add( temp );
		}
		
		wordBreakDPHelper( s.length(), new ArrayDeque<>(), s, record, res );
		return res;
	}
	/**
	 * DFS
	 * @param t The tail index
	 * @param temp Storing the string pieces
	 * @param s The initial test string 
	 * @param record The 2D matrix that records the all valid breakpoint
	 * @param res The list that stores the final results
	 */
	private void wordBreakDPHelper( int t, Deque<String> temp, String s, List<List<Integer>> record, List<String> res ) {
		for ( int h : record.get(t-1) ) {
			temp.addFirst( s.substring(h,t) );
			if ( h == 0 ) {
				StringBuilder str = new StringBuilder( );
				for ( String tempStr: temp  ) {
					str.append( tempStr + " " );
				}
				res.add(str.toString().trim());
			} else {
				wordBreakDPHelper( h, temp, s, record, res );
			}
			temp.removeFirst();
		}
	}
	/**
	 * DP method to determine whether the string is word-breakable
	 * Time: O(n*m) Space: O(n) // n = s.length(); m = maxLenOfWordDict(wordDict)
	 * @param s
	 * @param wordDict
	 * @return
	 */
	private boolean canWordBreak(String s, Set<String> wordDict) {
		int n = s.length(),
			maxLen= maxLenOfWordDict(wordDict);
		
		boolean[] res = new boolean[n + 1];
		res[0] = true;

		for (int t = 0; t < n; t++) {
			int h = Math.max(0, t-maxLen+1);
			for (; h <= t; h++) {
				if (!res[h])
					continue;
				String temp = s.substring(h, t + 1);
				if (wordDict.contains(temp)) {
					res[t + 1] = true;
					break;
				}
			}
		}

		return res[n];
	}
	/**
	 * Return the maximum length of string in wordDict set
	 * @param wordDict
	 * @return
	 */
	private int maxLenOfWordDict( Set<String> wordDict ) {
		int maxLen = 0;
		for ( String key : wordDict ) {
			if ( key.length() > maxLen ) maxLen = key.length();
		}
		return maxLen;
	}
}
