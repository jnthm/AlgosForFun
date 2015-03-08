import java.util.Arrays;

public class SudokuSolve {

    public static boolean solveSudoku(int[][] A) {
	
	return solveSudokuHelper(A, 0, 0);
    }

    private static solveSudokuHelper(int[][] A, int r, int c) {

	// base case:
	if (r == A.length) {
	    if (c != A.length) {
		return solveSudokuHelper(A, 0, ++c);
	    } else {
		return true;
	    }
	}

	// otherwise:
	if (A[r][c] != 0) {
	    return solveSudokuHelper(A, r++, c);
	}

	for (int valNum = 1; valNum < A.length; valNum++) {

	    if (isValidSudoku(A, r, c, valNum)) {
		A[r][c] = valNum;
		if (solveSudokuHelper(A, r + 1, c)) {
		    return true;
		}
	    }

	}

	// undo
	A[r][c] = 0;
	return false;
	
    }

    public static void main(String[] args) {
    int[][] A = new int[9][];
    A[0] = new int[]{0, 2, 6, 0, 0, 0, 8, 1, 0};
    A[1] = new int[]{3, 0, 0, 7, 0, 8, 0, 0, 6};
    A[2] = new int[]{4, 0, 0, 0, 5, 0, 0, 0, 7};
    A[3] = new int[]{0, 5, 0, 1, 0, 7, 0, 9, 0};
    A[4] = new int[]{0, 0, 3, 9, 0, 5, 1, 0, 0};
    A[5] = new int[]{0, 4, 0, 3, 0, 2, 0, 5, 0};
    A[6] = new int[]{1, 0, 0, 0, 3, 0, 0, 0, 2};
    A[7] = new int[]{5, 0, 0, 2, 0, 4, 0, 0, 9};
    A[8] = new int[]{0, 3, 8, 0, 0, 0, 4, 6, 0};
    solveSudoku(A);
  }

}

