import java.io.*;
import java.util.*;

public class RemoveElement {

    private static int removeElement(List<Integer> Ints, int k) {
	int i = 0, j = 0, N = Ints.size();

	while (i < N) {
	    if (Ints.get(i) != k) 
		Ints.set(j++, Ints.get(i));
	    i++; 
	}

	return j;
    }

    public static void main(String[] args) {
	List<Integer> Ints = new ArrayList<Integer>();
	int k = Integer.parseInt(args[0]);

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

	int newSize = 0;
	System.out.println("Element removed, and new size = " + (newSize = removeElement(Ints, k)));

	System.out.println("Output:");
	for (int i = 0; i < newSize; i++)
	    System.out.println(Ints.get(i));

	
    }
}
