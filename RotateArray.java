import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class RotateArray {

    private static int getGCD(int m, int n) {
	int i = Math.min(m, n), max = Math.max(m, n);
	while (i > 0) {
	    if (max % i == 0)
		return i;
	    i--;
	}
	return 1;
    }

    private static void rotateArr(List<Integer> Ints, int width) {
	int N = Ints.size();
	int gcd = getGCD(N, width);

	for (int i = 0; i < gcd; i++) {
	    int temp = Ints.get(i);
	    for (int j = 0; j < (N / gcd); j++) {
		int srcPos = N - ( (j + 1) * gcd) + i;
		int swapTemp = Ints.get(srcPos);
		Ints.set(srcPos, temp);
		temp = swapTemp;
	    }
	}
    }

    public static void main(String[] args) {
	List<Integer> Ints = new ArrayList<Integer>();
	int howMuchToRotate = Integer.parseInt(args[0]);

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

	rotateArr(Ints, howMuchToRotate);

	System.out.println("Output:");
	for (Integer i: Ints)
	    System.out.println(i);

    }
}
