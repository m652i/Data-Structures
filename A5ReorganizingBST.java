//Mike Chen
package assignment5;

import algs13.Queue;
import java.util.ArrayList;
import java.util.List;
import algs31.SimplerBST;

public class A5ReorganizingBST<K extends Comparable<K>, V>{
	private SimplerBST<K, V> bstree;
	private int totalkeys; //+1 every time put is called
	SimplerBST<K, V> beforeorgBST = new SimplerBST<K, V>();
	
	public void get(K key) {
		beforeorgBST.get(key);
	}
		
	private Iterable<K> listByMedians(List<K> keys) {
		Queue<K> medianQueue = new Queue<>();
		Queue<Integer> queueLeft = new Queue<>();
		Queue<Integer> queueRight = new Queue<>();
		queueLeft.enqueue(0);
		queueRight.enqueue(keys.size()-1);
		while (!queueLeft.isEmpty()) {
			int left = queueLeft.dequeue();
			int right = queueRight.dequeue();
			if (left <= right) {
				int medianIndex = (right+left)/2;
				K median = keys.get(medianIndex);
				medianQueue.enqueue(median);
				queueLeft.enqueue(left);
				queueRight.enqueue(medianIndex-1);
				queueLeft.enqueue(medianIndex+1);
				queueRight.enqueue(right);
			}
		}
		return medianQueue;
	}
	private void reorganize() {
		A5ReorganizingBST();
	}
	public void A5ReorganizingBST() {
		ArrayList<K> keylist = new ArrayList<K>();
		for( K k : beforeorgBST.keys()) keylist.add(k); //keys in array
		Iterable<K> sortedkeylist = listByMedians(keylist); //sort by med
		
		SimplerBST<K, V> orgedBST = new SimplerBST<K, V>();
		for( K k : sortedkeylist) orgedBST.put(k, beforeorgBST.get(k)); //fill orged bst
		
		beforeorgBST = orgedBST; 
		totalkeys = 0; //just in case overflow
	}
	
	public void put(K k, V v) {
		beforeorgBST.put(k, v);
		totalkeys++;
		if(totalkeys % 100 == 0) A5ReorganizingBST();
	}
	
	public void delete(K k, V v) {
		if(beforeorgBST.contains(k))	 {beforeorgBST.delete(k); totalkeys--;}
		if(totalkeys % 100 == 0) reorganize();
	}
	
	public int height() {
		return beforeorgBST.height();
	}
}
	
