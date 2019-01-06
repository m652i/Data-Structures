package assignment3;
import stdlib.*;
import java.util.Arrays;

public class TestA3SimplerBST {

	public static void main(String[] args) {
		StdIn.fromFile("data/tale.txt");
		String tale[] = StdIn.readAllStrings();
		
		A3SimplerBST<String, Integer> wordtree = new A3SimplerBST<String, Integer>();
		for(String w : tale) {
			if(wordtree.get(w) == null) wordtree.put(w, 1); //word not in table
			else wordtree.put(w, wordtree.get(w) + 1);//count + 1
		}
		StdOut.println("longest word tree path : " + wordtree.longestPathLength());
		
		A3SimplerBST<String, Integer> sortedwordtree = new A3SimplerBST<String, Integer>();
		Arrays.sort(tale);
		for(String t : tale) {
			if(sortedwordtree.get(t) == null) sortedwordtree.put(t, 1); //word not in table
			else sortedwordtree.put(t, sortedwordtree.get(t) + 1);//count + 1
		}
		StdOut.println("longest sorted word tree path : " + sortedwordtree.longestPathLength());
	}
}
