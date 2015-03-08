import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class PrintSpiralOrder {

    // ----->
    //      |
    //      |
    //      |
    //      v
    private static void printTopLayer(int[][] A, int startRow, int endCol, int endRow) {

	int c;
	for (c = startRow; c < endCol - 1; c++) 
	    System.out.println(A[startRow][c]);

	for (int r = startRow; r < endRow - 1; r++) 
	    System.out.println(A[r][c]);

    }

    // ^
    // |
    // |
    // |
    // <-----
    private static void printBottomLayer(int[][] A, int botRow, int startCol, int endCol, int endRow) {

	int c;
	for (c = startCol; c > endCol; c--) 
	    System.out.println(A[botRow][c]);

	for (int r = botRow; r > endRow; r--) 
	    System.out.println(A[r][c]);

    }

    private static void printSpiralOrder(int[][] A) {
	int R = A.length, C = A[0].length;
	// NOTE: didn't handle the case with odd number of rows in the original input matrix.
	for (int row = 0, col = C, endR = R, endC = 0; row < R / 2; row++, col--, endR--, endC++) {
	    printTopLayer(A, row, col, endR);
	    printBottomLayer(A, endR - 1, col - 1, endC, row);
	}
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

	int[][] int2D = new int [4][4];

	int count = 0;
	for (Integer i: Ints) {
	    int row = count / 4;
	    int col = count % 4;
	    int2D[row][col] = i;
	    count++;
	}

	printSpiralOrder(int2D);

    }
}
