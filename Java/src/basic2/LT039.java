package basic2;

import java.util.*;

public class LT039 {
	private static final int SET_SIZE = 20;
	private static final int NUM_SIZE = 100;
	public static void main ( String[] args ) {
		LT039 dummy = new LT039();
		HashSet<Integer> randNumSet = new HashSet<Integer>(SET_SIZE);
		Random gen = new Random();
		for ( int i = 0; i < SET_SIZE; i++ ) {
			int tempNum = gen.nextInt(NUM_SIZE)+1;
			while ( randNumSet.contains(tempNum) )
				tempNum = gen.nextInt(NUM_SIZE)+1;
			randNumSet.add(tempNum);
		}
		int[] candidates = new int[SET_SIZE];
		int i = 0;
		for ( Integer num : randNumSet ) {
			candidates[i++] = num;
		}
		System.out.println(Arrays.toString(candidates));
		Scanner in = new Scanner(System.in);
		long st1, et1, st2, et2;
		while ( in.hasNext() ) {
			int target = in.nextInt();
			
			int[] input = Arrays.copyOf(candidates, SET_SIZE);
			st1 = System.currentTimeMillis();
			List<List<Integer>> result1 = dummy.combinationSum(input,target);
			et1 = System.currentTimeMillis();
			System.out.println("Normal DFS : "+(et1-st1)+" ms");
			
			input = Arrays.copyOf(candidates, SET_SIZE);
			st2 = System.currentTimeMillis();
			List<List<Integer>> result2 = dummy.combinationSumCache(input,target);
			et2 = System.currentTimeMillis();
			System.out.println("Cached DFS : "+(et2-st2)+" ms");
			
			System.out.println("Normal DFS :");
			System.out.println(result1);
			System.out.println("Cached DFS :");
			System.out.println(result2);
			/*
			 * Normal DFS process is better than the cached one.
			 * Because the share of nodes within different paths is rarely happened.
			 */
		}
		in.close();
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if ( candidates == null || candidates.length == 0 ) return new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		if ( target < candidates[0] ) return new LinkedList<List<Integer>>();
        int id = Arrays.binarySearch(candidates,target);
        if ( id >= 0 )
        	return combinationSumHelper(candidates,id,target);
        else
        	return combinationSumHelper(candidates,-id-2,target);
    }
	private List<List<Integer>> combinationSumHelper(int[] candidates, int end, int target) {
		int num = candidates[end];
        if ( end == 0 ) {
        	List<List<Integer>> baseRet = new LinkedList<List<Integer>>(); 
        	if ( target%num==0 ) {
        		List<Integer> baseRetList = new ArrayList<Integer>();  
        		while ( target != 0 ) {
        			baseRetList.add(num);
        			target -= num;
        		}
        		baseRet.add(baseRetList);
        	}
        	return baseRet;
        }
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        for ( int i = 0; i*num <= target; i++ ) {
        	List<List<Integer>> ans = combinationSumHelper(candidates,end-1,target-i*num);
        	if ( !ans.isEmpty() ) {
        		for ( List<Integer> anslist : ans ) {
        			for ( int j = 0 ; j < i; j++ ) {
        				anslist.add(num);
            		}
        			ret.add(anslist);
        		}
        	}
        }
        return ret;
    }
	
	public List<List<Integer>> combinationSumCache(int[] candidates, int target) {
		if ( candidates == null || candidates.length == 0 ) return new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		if ( target < candidates[0] ) return new LinkedList<List<Integer>>();
        int id = Arrays.binarySearch(candidates,target);
        if ( id < 0 ) id = -id-2;
        List<Map<Integer,List<List<Integer>>>> cache = 
        		new ArrayList<Map<Integer,List<List<Integer>>>>(id+1);
        for ( int i = 0; i <= id; i++  ) {
        	Map<Integer,List<List<Integer>>> cacheItem = new HashMap<Integer,List<List<Integer>>>();
        	cache.add(cacheItem);
        }
        return combinationSumCacheHelper(candidates,id,target,cache);
    }
	private List<List<Integer>> combinationSumCacheHelper
	(int[] candidates, int end, int target, List<Map<Integer,List<List<Integer>>>> cache) {
		int num = candidates[end];
		if ( cache.get(end).containsKey(target) ) {
			return cache.get(end).get(target);
		}
        if ( end == 0 ) {
        	List<List<Integer>> baseRet = new LinkedList<List<Integer>>(); 
        	if ( target%num==0 ) {
        		List<Integer> baseRetList = new ArrayList<Integer>();  
        		for ( int targetCopy = target; targetCopy>0 ; targetCopy -= num ){
        			baseRetList.add(num);
        		}
        		baseRet.add(baseRetList);
        	}
        	cache.get(end).put(target, baseRet);
        	return baseRet;
        }
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        for ( int i = 0; i*num <= target; i++ ) {
        	List<List<Integer>> ans = combinationSumCacheHelper(candidates,end-1,target-i*num,cache);
        	if ( !ans.isEmpty() ) {
        		for ( List<Integer> anslist : ans ) {
        			List<Integer> copylist = new ArrayList<Integer>(anslist);
        			for ( int j = 0 ; j < i; j++ ) {
        				copylist.add(num);
            		}
        			ret.add(copylist);
        		}
        	}
        }
        cache.get(end).put(target, ret);
        return ret;
    }
}
