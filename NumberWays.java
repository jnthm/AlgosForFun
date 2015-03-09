import java.lang.Math;

public class NumberWays {
    public static int numWays(int m, int n) {
	if (n > m) {
	    int temp = m;
	    m = n;
	    n = temp;
	}

	int[] table = new int[n];

	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (i == 0 || j == 0) 
		    table[j] = 1;
		else {
		    table[j] += table[j-1];
		}
	    }
	}
	
	return table[n-1];
    }

    public static void main(String[] args) {
	
	System.out.println(numWays(5,5));
    }
}
