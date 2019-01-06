//Mike Chen
package assignment4;

import stdlib.*;
import java.util.ArrayList;
import algs33.RedBlackBST;


public class A4GeneticSequences {
		
	RedBlackBST<String, String> geneticSequences = new RedBlackBST<String, String>();
	public void addSpecies(String species, String sequence) {
		geneticSequences.put(species, sequence);
	}
	
	public void removeSpecies(String species) {
		geneticSequences.delete(species);
	}
	
	public ArrayList<String> speciesList() {
		ArrayList<String> spclist = new ArrayList<String>();
		for (String key : geneticSequences.keys() ) {
			spclist.add(key);
		}
		return spclist;
		}
	
	public String sequence(String species) {
		return geneticSequences.get(species);
		}
	
	public int size() {
		return geneticSequences.size();
	}

}
