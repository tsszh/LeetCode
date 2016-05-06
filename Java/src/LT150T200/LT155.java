package LT150T200;

import java.util.ArrayList;
import java.util.List;

public class LT155 {

}

class MinStack {
	private ListNode top;
	private ListNode min;
	
    public MinStack() {
        
    }
    
    public void push(int x) {
    	ListNode temp = new ListNode(x);
    	if ( min == null ||x < min.val ) {
			temp.lastMin = min;
			min = temp;
		}
    	temp.next = top;
    	top = temp;
    }
    
    public void pop() {
        if ( top == null ) return;
        if ( top == min ) {
        	min = min.lastMin;
        }
        top = top.next;
    }
    
    public int top() {
    	if ( top == null ) return 0;
        return top.val;
    }
    
    public int getMin() {
        if ( min == null ) return 0;
        return min.val;
    }
    
    private class ListNode {
    	int val;
    	ListNode next;
    	ListNode lastMin;
    	public ListNode( int x ){
    		val = x;
    	}
    }
}

class MinStack2 {
	private int topIndex;
	private int minIndex;
	private List<Integer> valStack;
	private List<Integer> minStack;
	
    public MinStack2() {
        topIndex = -1;
        minIndex = -1;
        valStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int x) {
    	topIndex++;
    	int lastMinIndex = -1;
    	if ( minIndex == -1 || x < valStack.get(minIndex) ) {
			lastMinIndex = minIndex;
			minIndex = topIndex;
		}
    	valStack.add(x);
    	minStack.add(lastMinIndex);
    }
    
    public void pop() {
        if ( topIndex == -1 ) return;
        if ( topIndex == minIndex ) {
        	minIndex = minStack.get(minIndex);
        }
        valStack.remove(topIndex);
        minStack.remove(topIndex);
        topIndex--;
    }
    
    public int top() {
    	if ( topIndex == -1 ) return 0;
    	return valStack.get(topIndex);
    }
    
    public int getMin() {
        if ( minIndex == -1 ) return 0;
        return valStack.get(minIndex);
    }
}