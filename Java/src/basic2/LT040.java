package basic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LT040 {
	private static final int SET_SIZE = 20;
	private static final int NUM_SIZE = 100;
	public static void main ( String[] args ) throws InterruptedException {
		LT040 dummy = new LT040();
		Random gen = new Random();
		int[] candidates = new int[SET_SIZE];
		for ( int i = 0; i < SET_SIZE; i++ ) {
			candidates[i] = gen.nextInt(NUM_SIZE)+1;
		}
		System.out.println(Arrays.toString(candidates));
		//Scanner in = new Scanner(System.in);
		long st, et, totalBack = 0, totalForward = 0;
		int count = 1000;
		while ( count > 0 ) {
			count--;
			int target = gen.nextInt(SET_SIZE*NUM_SIZE);
			//System.out.println("target = "+target);
			int[] input = Arrays.copyOf(candidates, SET_SIZE);
			st = System.currentTimeMillis();
			List<List<Integer>> result1 = dummy.combinationSum2(input,target);
			et = System.currentTimeMillis();
			totalBack += et-st;
			//System.out.println("<- DFS : "+(et-st)+" ms");
			
			input = Arrays.copyOf(candidates, SET_SIZE);
			st = System.currentTimeMillis();
			List<List<Integer>> result2 = dummy.combinationSum2BackTracking(input,target);
			et = System.currentTimeMillis();
			totalForward += et-st;
			//System.out.println("-> DFS : "+(et-st)+" ms");
			
			
			System.out.println("<- DFS :");
			System.out.println(result1);
			System.out.println("-> DFS :");
			System.out.println(result2);
			
			Thread.sleep(1000);
		}
		System.out.println("<- DFS : "+totalBack+" ms");
		System.out.println("-> DFS : "+totalForward+" ms");
		//in.close();
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if ( candidates == null || candidates.length == 0 ) return new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		if ( target < candidates[0] ) return new LinkedList<List<Integer>>();
        int id = Arrays.binarySearch(candidates,target);
        if ( id >= 0 )
        	return combinationSum2Helper(candidates,id,target);
        else
        	return combinationSum2Helper(candidates,-id-2,target);
    }
	private List<List<Integer>> combinationSum2Helper(int[] candidates, int end, int target) {
		if ( target == 0 ) {
			List<List<Integer>> baseRet = new LinkedList<List<Integer>>();
			baseRet.add(new ArrayList<Integer>());
			return baseRet;
		}
		if ( end < 0 ) {
			return new LinkedList<List<Integer>>();
		}
		int num = candidates[end];
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        int nextEnd = end, count = 0;
        while ( nextEnd >= 0 && candidates[nextEnd] == num ) {
        	nextEnd--;
        	count++;
        }
        for ( int i = 0; i<=count && i*num <= target; i++ ) {
        	List<List<Integer>> ans = combinationSum2Helper(candidates,nextEnd,target-i*num);
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
	
	
	public List<List<Integer>> combinationSum2BackTracking(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if ( candidates == null || candidates.length == 0 ) return res;
		Arrays.sort(candidates);
		if ( target < candidates[0] ) return res;
		boolean[] record = new boolean[candidates.length];
        combinationSum2BackTrackingHelper(candidates, res, record,0,0,target);
        return res;
    }
	private void combinationSum2BackTrackingHelper
	(int[] candidates, List<List<Integer>> res, boolean[] record, int sum, int id, int target) {
		if ( id >= candidates.length ) return;
		int num = candidates[id];
		if ( sum+num > target ) return;
		int nextID = id;
		while ( nextID < candidates.length && candidates[nextID] == num ) {
			sum+=num;
			record[nextID]=true;
			nextID++;
		}
		while ( id <= nextID ) {
			if ( sum == target ) {
				List<Integer> resItem = new ArrayList<Integer>();
				for ( int i = 0; i<nextID; i++ ) {
					if ( record[i] ) resItem.add(candidates[i]);
				}
				res.add(resItem);
			} else if ( sum < target ) {
				combinationSum2BackTrackingHelper(candidates, res, record,sum,nextID,target);
			}
			if ( id < nextID ) {
				record[id]=false;
				sum-=num;
			}
			id++;
		}
    }
}
