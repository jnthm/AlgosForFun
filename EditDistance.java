import java.lang.Math;

public class EditDistance {
    public static int editDistance(String s1, String s2) {
	int lenS1 = s1.length(), lenS2 = s2.length();
	int[][] table = new int[lenS1 + 1][lenS2 + 1];
	
	for (int c = 1; c < lenS2 + 1; c++) {
	    table[0][c] = c;
	}

	for (int r = 1; r < lenS1 + 1; r++) {
	    table[r][0] = r;
	}

	for (int r = 1; r < lenS1 + 1; r++) {
	    for (int c = 1; c < lenS2 + 1; c++) {
		int currDistMin = Math.min(table[r-1][c] + 1, table[r][c-1] + 1);
		table[r][c] = Math.min(currDistMin, table[r-1][c-1] + ((s1.charAt(r-1) == s2.charAt(c-1)) ? 0 : 1));
		//		System.out.println("table"+"["+r+"]["+c+"] = " + table[r][c]);
	    }
	}
	return table[lenS1][lenS2];
     }

    public static void main(String[] args) {
	System.out.println(editDistance("commuter", "computer"));
    }
}
