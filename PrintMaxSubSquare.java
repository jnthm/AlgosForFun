
public class PrintMaxSubSquare {
	
	public static int[][] printMaxSubSquare(int[][] A) {
		if (A == null || A[0].length <= 1) return A;
		
		int[][] S = new int[A.length][A[0].length];
		
		for (int i = 0; i < A[0].length; i++) {
			S[0][i] = A[0][i];
		}
		for (int i = 0; i < A.length; i++) {
			S[i][0] = A[i][0];
		}
		
		for (int r = 1; r < A.length; r++) {
			for (int c = 0; c < A[0].length; c++) {
				if (A[r][c] == 1) {
					S[r][c] = Math.min(Math.min(A[r-1][c], A[r][c-1]), A[r-1][c-1]) + 1;
				}
			}
		}
		
		return S;
	}
	
}