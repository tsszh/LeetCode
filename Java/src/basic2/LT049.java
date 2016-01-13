package basic2;

import java.util.*;

public class LT049 {
	public static void main ( String[] args ) {
		LT049 dummy = new LT049();
		String[] strs = new String[] {
			"abc","bca","adc","cba","xyz","yzx"
		};
		System.out.println(dummy.anagrams(strs));
	}
	
	public List<String> anagrams2(String[] strs) {
		List<String> ret = new LinkedList<String>();
        if ( strs == null || strs.length == 1) return ret;
        
        return ret;
	}
	
	/**
	 * A straightforward method with O(n+n*mlgm) time and O(n) space
	 * 
	 * @param strs
	 * @return
	 */
	public List<String> anagrams(String[] strs) {
        List<String> ret = new LinkedList<String>();
        if ( strs == null || strs.length == 1) return ret;
        Map<String,List<String>> record = new HashMap<String,List<String>>(strs.length);
        for ( int i = 0; i < strs.length; i++ ) {
        	char[] keyBuffer = strs[i].toCharArray();
        	Arrays.sort(keyBuffer);
        	String key = Arrays.toString(keyBuffer);
        	if ( record.containsKey(key) )
        		record.get(key).add(strs[i]);
        	else {
        		List<String> tempList = new ArrayList<String>();
        		tempList.add(strs[i]);
        		record.put(key,tempList);
        	}
        }
        for ( List<String> list : record.values() ) {
        	if ( list.size() > 1 ) {
        		ret.addAll(list);
        	}
        }
        return ret;
    }
}
