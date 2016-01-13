package Medium2;

import java.util.*;

public class LT133 {
	public static void main ( String[] args ) {
		String[] matrix = new String[] {
			"11100",//1
			"10110",//3
			"11001",//5
			"01001",//7
			"00110" //9
		};
		int[] vertexs = new int[]{1,3,5,7,9};
		UndirectedGraph graph = new UndirectedGraph(vertexs,matrix);
		System.out.println(graph);
		System.out.println(new UndirectedGraph(cloneGraph(graph.vertexs.get(0))));
	}
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if ( node == null ) return null;
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>(node.neighbors.size());
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
		map.put(newRoot.label, newRoot);
        queue.add(node);
        while ( !queue.isEmpty() ) {
        	UndirectedGraphNode oldNode = queue.remove();
        	UndirectedGraphNode newNode = map.get(oldNode.label);
        	for ( UndirectedGraphNode oldNodeNeigh : oldNode.neighbors ) {
        		UndirectedGraphNode newNodeNeigh = map.get(oldNodeNeigh.label);
        		if ( newNodeNeigh == null ) {
            		newNodeNeigh = new UndirectedGraphNode(oldNodeNeigh.label);
            		map.put(newNodeNeigh.label, newNodeNeigh);
            		queue.add(oldNodeNeigh);
            	}
        		newNode.neighbors.add(newNodeNeigh);
        	}
        }
        return newRoot;
    }
}
 