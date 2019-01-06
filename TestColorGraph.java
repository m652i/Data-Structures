package assignment7;

import algs41.*;
import stdlib.*;

public class TestColorGraph {

	public static void main(String[] args) {
		
		String[] graphFilenames = {"data/evencycle.txt", "data/star.txt","data/oddcycle.txt","data/k7.txt" };
		
		for(String g:graphFilenames) {
			Graph G = new Graph(new In(g));
			ColorGraph cg = new ColorGraph(G);
			Color[] colors = cg.colors();
			StdOut.println("Vertex colors for " + g);
			for (int v = 0; v < G.V(); v++) {
				StdOut.println(v + ": " + colors[v]);
			}
			//why isn't it returning the nulls?
		}
	}
}
