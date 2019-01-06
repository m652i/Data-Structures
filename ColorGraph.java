//Mike Chen
package assignment7;

import algs41.Graph;
//import algs41.BreadthFirstPaths;
import algs13.Queue;
import algs13.Stack;
import java.util.ArrayList;
import stdlib.*;

public class ColorGraph {
	private static final int INFINITY = Integer.MAX_VALUE;
	private final boolean[] marked;
	private final Color[] colored;
	Color[] colorlist = Color.values();
	//private final int[] distTo;
	//Stack<Color> colorused = new Stack<>();
	//Stack<Color> colornotused = new Stack<>();
	

	
	public ColorGraph(Graph G) {
		//distTo = new int[G.V()];
		marked = new boolean[G.V()];
		colored = new Color[G.V()];
		bfsColor(G, 0); //all start from 0
	}
	private void bfsColor(Graph G, int s) {
		ArrayList<Color> colorused = new ArrayList<>(); 
		ArrayList<Color> colornotused = new ArrayList<>();
		
		Queue<Integer> q = new Queue<>();
		marked[s] = true;
		colored[0] = colorlist[0];
		colorused.add(colored[0]);
		
		q.enqueue(s);
		while (!q.isEmpty()) {
			int v = q.dequeue();
			colorused.add(colored[v]);
			colornotused.add(colored[v]);
			
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					for (Color c: colorlist) { //check if not used
						if(!colorused.contains(c)) {
							colored[w] = c; 
							break;
						}
						
					}
				marked[w] = true;
				q.enqueue(w);
				
			} else {
				for (int x : G.adj(w)) {
					if (colored[w] == colored[x]) {
						colornotused.add(colored[w]);
						for (Color color: colorlist) {
							if(!colornotused.contains(color)) {
								colored[w] = color;
								break;
							}
						}
					}
				}	
			}	
			}
		colorused.clear();
		colornotused.clear();
		}
	}

		/*for(int i = 1; i < G.V(); i++) { we should repeat colors, just don't have to be same
			int k = distTo[i];             as neighbors. Should make color stack to check. Stack bad
			colored[i] = colorlist[k];		should just use Arrays lol.
		}*/ 

	public Color[] colors() {
		return colored;
	}
		
	
}
