public class CoinChangeNoLimit {

    public static int CoinChange(int[] A, int Sum) {

	int [] table = new int[Sum + 1];

	Arrays.fill(table, MAX_VALUE);
	table[0] = 0;

	for (int j = 1; j <= Sum; j++) {
	    for (int i = 0; i < A.length; i++) {
		if (j >= A[i])
		    table[j] = Math.min(table[j], table[j - A[i]] + 1);
	    }
	}
	
	return table[j];
    } 
}
