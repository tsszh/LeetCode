package utilities;

/**
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * 
 * @author Zehao
 * 
 */
public class RandomListNode {
	public int label;
	public RandomListNode next, random;
	public RandomListNode(int x) { this.label = x; }
	
	/*
	 * Self-defined methods
	 */
	public String toString() {
		return String.format("( %3d -> %3s )", label, random==null?"nul":random.label);
	}
	public String listToString() {
		StringBuilder str = new StringBuilder();
		for ( RandomListNode curr = this; curr != null; curr = curr.next ) {
			str.append(curr.toString());
		}
		return str.toString();
	}
}
