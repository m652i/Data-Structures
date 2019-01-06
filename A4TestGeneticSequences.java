//Mike Chen
package assignment4;

import java.util.ArrayList;
import stdlib.*;

public class A4TestGeneticSequences {
	
	public static void main (String[] args) {
		A4GeneticSequences a4Sequences = new A4GeneticSequences();
        StdIn.fromFile("data/sequences.txt");
		
		while (StdIn.hasNextLine()) {
			 String line = StdIn.readLine();
			 String[] fields = line.split("\\s+");
			 String speciesName = fields[0] + " " + fields[1];
			 String geneticSequence = fields[2];
			 a4Sequences.addSpecies(speciesName, geneticSequence);
		}
		
		int speciesNum1 = a4Sequences.size();
		StdOut.println("There are " + speciesNum1 + " species in the collection.");
		

		ArrayList<String> list = a4Sequences.speciesList();
		
		for (String speciesList : list) {
			String shortSequence = a4Sequences.sequence(speciesList).substring(0,20);
			StdOut.println("Name : " + speciesList + "\n" + "And the shortened genetic sequence is (20 characters): " + shortSequence +"\n");
		}
		
		for (String speciesList : list) {
			a4Sequences.removeSpecies(speciesList);
		}
		

		int speciesNum2 = a4Sequences.size();
		StdOut.println("After deletion, there are " + speciesNum2 + " species in the collection.");
	}
	

}
