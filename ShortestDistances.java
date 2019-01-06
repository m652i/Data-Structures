//Mike Chen
package assignment6;

import algs31.ArrayST;
import algs41.Graph;
import algs41.BreadthFirstPaths;
import stdlib.*;

public class ShortestDistances {
	public static void main(String[] args) {
		ArrayST<String, Integer> citytable = new ArrayST<String, Integer>();
		StdIn.fromFile("data/a6cities.txt");
		int i = 0; 
		for(String city : StdIn.readAllStrings()) { //fill symbol table. no duplicates
			citytable.put(city, i); 
			i++;
		}
		//for(String c : citytable.keys()) StdOut.println(c + " : " + citytable.get(c)); //double checkin
		
		Graph graph = new Graph(i);
		//StdOut.println(graph.V());
		
		StdIn.fromFile("data/a6connections.txt");
		while(StdIn.hasNextLine()) {
			String line = StdIn.readLine();
			String[] split = line.split("\\s+");
			String city = split[0];
			String connectcity = split[1];
			graph.addEdge(citytable.get(split[0]), citytable.get(split[1])); //connect nums
		}
		//StdOut.println("Edges : " + graph.E());
		
		BreadthFirstPaths Chicago = new BreadthFirstPaths(graph, citytable.get("Chicago"));
		StdOut.println("\t\t Chicago \t\t KansasCity \t\t Minneapolis \t\t Wausau \t\t LaCrosse");
		String[] cities = {"Chicago", "KansasCity", "Minneapolis", "Wausau", "LaCrosse"};
		
		for(String rowcity : cities) {
			StdOut.printf("%-15s\t", rowcity);
			for(String colcity : cities) {
				int shortest = Chicago.distTo(citytable.get(colcity)) + Chicago.distTo(citytable.get(rowcity));
				//gotta add both
				StdOut.printf("%-23d", shortest);
			}
			StdOut.println();//change line
		}
	}
}