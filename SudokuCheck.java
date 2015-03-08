import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class SudokuCheck {

    private static boolean checkSubRegion(int[][] A) {
	int nSubRegions = (A.length * A[0].length) / (3 * 3);

	for (int sR = 0; sR < nSubRegions; sR++) {
	    boolean[] boolSubReg = new boolean[3 * 3];

	    for (int row = 0; row < 3; row++) 
		for (int col = 0; col < 3; col++) {
		    int currVal = A[row + (sR / 3) * 3][col + (sR % 3) * 3];
		    if (currVal != 0 && !boolSubReg[currVal - 1]) 
			boolSubReg[currVal - 1] = true;
		    else 
			return false;
		}
	}
	return true;
    }

    private static boolean checkCol(int[][] A) {
	for (int col = 0; col < A[0].length; col++) {
	    boolean[] boolCol = new boolean[A[0].length];

	    for (int row = 0; row < A.length; row++) {
		int currVal = A[row][col];
		if (currVal != 0 && !boolCol[currVal - 1]) 
		    boolCol[currVal - 1] = true;
		else 
		    return false;
	    }
	}

	return true;

    }

    private static boolean checkRow(int[][] A) {

	for (int row = 0; row < A.length; row++) {
	    boolean[] boolRow = new boolean[A.length];

	    for (int col = 0; col < A[0].length; col++) {
		int currVal = A[row][col];
		if (currVal != 0 && !boolRow[currVal - 1]) 
		    boolRow[currVal - 1] = true;
		else return false;
	    }
	}

	return true;
    }

    private static boolean sudokuCheck(int[][] A) {
	return checkRow(A) && checkCol(A) && checkSubRegion(A);
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

	int[][] int2D = new int [9][9];

	int count = 0;
	for (Integer i: Ints) {
	    int row = count / 9;
	    int col = count % 9;
	    int2D[row][col] = i;
	    count++;
	}

	System.out.println("Result = " + sudokuCheck(int2D));

    }
}
