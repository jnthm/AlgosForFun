import java.io.*;
import java.util.*;

public class QuickSelect {

    private static void exch(List<Integer> Ints, int pos1, int pos2) {
	int temp = Ints.get(pos2);
	Ints.set(pos2, Ints.get(pos1));
	Ints.set(pos1, temp);
    }

    private static void 3Waypartition(List<Integer> Ints, int lo, int hi) {
	int i = lo + 1, lt = lo, gt = hi;
	
	while (i <= gt) {
	    if (Ints.get(i) < Ints.get(lt)) {
		exch(Ints, i++, lt++);
	    } else if (Ints.get(i) > Ints.get(lt)) {
		exch(Ints, i, gt--);
	    } else {
		i++;
	    }

	}
    }

    /*In place quick select. */
    private static void qs(List<Integer> Ints, int pivotIndex) {
	exch(Ints, 0, pivotIndex);
	3Waypartition(Ints, 0, Ints.size() - 1);
    }

    public static void main(String[] args) {
	List<Integer> Ints = new ArrayList<Integer>();
	int pivotIndex = Integer.parseInt(args[0]);

	BufferedReader br = null;
	String sCurrLine;
	try {
	br = new BufferedReader(new FileReader("input.txt"));
	while ((sCurrLine = br.readLine()) != null) 
	    Ints.add( (Integer.valueOf(sCurrLine)));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	finally {
	    try {
		if (br != null) br.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

	System.out.println("Input:");
	for (Integer i: Ints)
	    System.out.println(i);

	qs(Ints, pivotIndex);

	System.out.println("Output:");
	for (Integer i: Ints)
	    System.out.println(i);

	
    }
}
