import java.io.*;
import java.util.*;

public class LongestIncreasingSubarray {

    private static void longestIncreasingSubarray(List<Integer> Ints) {
	int maxLen = 1;
	int i = 0, j = 0, N = Ints.size();
	boolean isSkippable = false;

	for (i = 0; i < N - 1; i++) {

	    // only if isSkippable is flase, just keep incrementing
	    if (!isSkippable && Ints.get(i) < Ints.get(i + 1)) {
		maxLen++;
		isSkippable = false;
	    } else 
		if (maxLen > 1) isSkippable = true;


	    // only if array elements are skippable
	    if (maxLen > 1 && isSkippable && (i + maxLen < N)) {

		for (j = i + maxLen; j > i; j--) 
		    if (Ints.get(j - 1) >= Ints.get(j)) 
			break;
		
		if (j == i + 1) 
		    i += maxLen - 1;

		isSkippable = false;
	    }
	}


	System.out.println("maxLen = " + maxLen);
	
    }

    public static void main(String[] args) {
	List<Integer> Ints = new ArrayList<Integer>();

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

	longestIncreasingSubarray(Ints);

    }
}
