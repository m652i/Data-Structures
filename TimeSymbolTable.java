package assignment2;
import algs31.SequentialSearchST;
import algs32.BST;
import stdlib.*;


public class TimeSymbolTable {
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> wordtableSQ = new SequentialSearchST<String, Integer>();
		BST<String, Integer> wordtableBST = new BST<String, Integer>();
	
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();
		
		Stopwatch time = new Stopwatch();
		
		//SQ
		for(String w : words) {
			if(wordtableSQ.get(w) == null) wordtableSQ.put(w, 1); //word not in table
			else wordtableSQ.put(w, 1 + wordtableSQ.get(w));//count + 1
		}
		double SQtime = time.elapsedTime();
		StdOut.println("Squential search time : " + SQtime);
		
		//BST
		Stopwatch time2 = new Stopwatch();
		for(String w : words) {
			if(wordtableBST.get(w) == null) wordtableBST.put(w, 1); //word not in table
			else wordtableBST.put(w, 1 + wordtableBST.get(w));//count + 1
		}
		double BSTtime = time2.elapsedTime();
		StdOut.println("Binary search time : " + BSTtime);
	}
}
	

