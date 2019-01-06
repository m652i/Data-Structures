//Mike Chen
package assignment8;

import algs13.Queue;
import algs42.Digraph;
import algs42.BreadthFirstDirectedPaths;
import week8examples.SimplerDirectedCycle;
import stdlib.*;
import algs31.BinarySearchST;

public class IndependentCourses {
	private static BinarySearchST<String, Integer> CourseVertex = new BinarySearchST<String, Integer>();
	private static BinarySearchST<Integer, String> VertexCourse = new BinarySearchST<Integer, String>();
	
	public static void prereqlist(Digraph G, int val) {
		final boolean[] marked = new boolean[G.V()];
		StdOut.print(VertexCourse.get(val) + " is required before you can take : ");
		int i = 0;
		prereqlist(G, val , val, marked, i);
		StdOut.println();
	}
	private static void prereqlist(Digraph G, int val, int start, boolean[] marked, int i) {
		marked[start] = true;
		for(int w : G.adj(start)) {
			if(!marked[w]) {
				i++;
				prereqlist(G, val , w, marked, i);
				StdOut.print(VertexCourse.get(w) + "  ");
			}
		}
		if(i == 0)StdOut.print("None." + VertexCourse.get(start) + " is not a pre req of any classes.");
	}
	
	public static void main(String[] args) {
		StdIn.fromFile("data/a8courses.txt"); //put courses and vertex into a ST
		String[] courses = StdIn.readAllStrings();
		StdOut.println("Available course List : ");
		int i = 0;
		for(String c : courses) {
			StdOut.print(c + "  ");
			CourseVertex.put(c, i);
			VertexCourse.put(i, c);
			i++;
		}
		
		StdOut.println("\nEdges : ");
		
		
		Digraph dg = new Digraph(i);
		StdIn.fromFile("data/a8prereqs.txt");
		while(StdIn.hasNextLine()) {
			String line = StdIn.readLine();
			String[] split = line.split("\\s+");
			int preV = CourseVertex.get(split[0]); 
			int nextV = CourseVertex.get(split[1]);
			dg.addEdge(preV, nextV); //reminder* easier to read
			StdOut.println("Connected : " + split[0] +" to " + split[1]);
		}
		
		SimplerDirectedCycle DAGcheck = new SimplerDirectedCycle(dg);//DAG must be directed have no cycle
		if(DAGcheck.hasCycle()) {StdOut.println("Not DAG. Exiting.");return;}
		else{StdOut.println("Is DAG.");}
		

		
		for(String s : CourseVertex.keys()) {
				int val = CourseVertex.get(s);
				prereqlist(dg, val);
		}
		
		
		StdIn.fromFile("data/a8independence.txt");
		while (StdIn.hasNextLine()) {
			String line1 = StdIn.readLine();
			String[] split1 = line1.split("\\s+");
			int cr = CourseVertex.get(split1[0]);
			int cr1 = CourseVertex.get(split1[1]);
			BreadthFirstDirectedPaths crtocr1 = new BreadthFirstDirectedPaths(dg, cr1);
			BreadthFirstDirectedPaths cr1tocr = new BreadthFirstDirectedPaths(dg, cr);
			if(crtocr1.hasPathTo(cr)||cr1tocr.hasPathTo(cr1)) StdOut.println("Courses : " + split1[0] + " & " + split1[1] + " not independent");
			else StdOut.println("Courses : " + split1[0] + " & " + split1[1] + " are independent");
		}
	}
}
