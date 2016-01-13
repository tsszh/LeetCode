package Medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UndirectedGraph {
	List<UndirectedGraphNode> vertexs;
	UndirectedGraph( int[] vertexs, String[] matrix ) {
		this.vertexs = new ArrayList<UndirectedGraphNode>(vertexs.length);
		for ( int label : vertexs ) {
			this.vertexs.add(new UndirectedGraphNode(label));
		}
		for ( int i = 0; i < matrix.length; i++ ) {
			List<UndirectedGraphNode> neighbors = this.vertexs.get(i).neighbors;
			String neighs = matrix[i];
			for ( int j = 0; j < neighs.length(); j++ ) {
				if ( neighs.charAt(j) == '1' )
					neighbors.add(this.vertexs.get(j));
			}
		}
		Collections.sort(this.vertexs, new Comparator<UndirectedGraphNode>(){
			public int compare ( UndirectedGraphNode a, UndirectedGraphNode b ) {
				return a.label - b.label;
			}
		});
	}
	UndirectedGraph( UndirectedGraphNode root ) {
		if ( root == null ) {
			vertexs = new ArrayList<UndirectedGraphNode>();
		}
		HashSet<UndirectedGraphNode> nodeSet = new HashSet<UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(root);
		while ( !queue.isEmpty() ) {
			UndirectedGraphNode node = queue.remove();
			nodeSet.add(node);
			for ( UndirectedGraphNode neigh : node.neighbors ) {
				if ( !nodeSet.contains(neigh) ) {
					nodeSet.add(neigh);
					queue.add(neigh);
				}
			}
		}
		vertexs = new ArrayList<UndirectedGraphNode>(nodeSet.size());
		for ( UndirectedGraphNode node : nodeSet )
			vertexs.add(node);
		Collections.sort(vertexs, new Comparator<UndirectedGraphNode>(){
			public int compare ( UndirectedGraphNode a, UndirectedGraphNode b ) {
				return a.label - b.label;
			}
		});
	}
	public String toString() {
		StringBuilder res = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		res.append('[');
		res.append(newLine);
		for ( UndirectedGraphNode node : vertexs ) {
			res.append(String.format("  %3d : ", node.label));
			for ( UndirectedGraphNode neigh : node.neighbors ) {
				res.append(String.format("%2d ->",neigh.label));
			}
			if ( res.charAt(res.length()-1) == '>' )
				res.delete(res.length()-2, res.length());
			res.append(newLine);
		}
		res.append(']');
		return res.toString();
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append('[');
		res.append(String.format("  %3d : ", label));
		for ( UndirectedGraphNode neigh : neighbors ) {
			res.append(String.format("%2d ->",neigh.label));
		}
		if ( res.charAt(res.length()-1) == '>' )
			res.delete(res.length()-2, res.length());
		res.append(']');
		return res.toString();
	}
}
