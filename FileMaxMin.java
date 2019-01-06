package assignment2;
import stdlib.*;


public class FileMaxMin {
	
	public static void main(String[] args) {
		StdIn.fromFile("data/100ints.txt");
		String i = StdIn.readLine();
		String j = i.replaceAll(" ","");
		int jj = Integer.parseInt(j);
		int Max = jj;
		int Min = jj;
		
		while(StdIn.hasNextLine()) {
			String cur0 = StdIn.readLine();
			String cur = cur0.replaceAll(" ","");
			int curr = Integer.parseInt(cur);
			Max = Integer.max(curr, Max);
			Min = Integer.min(curr, Min);	
		}
		StdOut.println("Max num : " + Max);
		StdOut.println("Min num : " + Min);
	}
	
}
