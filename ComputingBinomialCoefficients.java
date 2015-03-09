import java.lang.Math;

public class ComputingBinomialCoefficients {
    public static int binCoeff(int n, int k) {
	int[][] table = new int[n+1][k+1];

	for (int i = 0; i <= n; i++) {
	    table[i][0] = 1;
	}

	for (int i = 1; i <= n; i++) {
	    for (int j = 1; j <= Math.min(i,k); j++) {
		table[i][j] = table[i-1][j-1] + table[i-1][j];
		if (i == j)
		    table[i][j] = 1;
	    }
	}

	return table[n][k];
    }

    public static void main(String[] args) {
	System.out.println(binCoeff(10,2));
    }
}
