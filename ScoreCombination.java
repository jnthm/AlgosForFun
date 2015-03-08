public class ScoreCombination {
     public static long countCombinations(int k, List<Integer> scoreWays) {
	 int[] table = new table[k + 1];
	 table[0] = 1;
	 for (int i = 0; i < scoreWays.size(); i++) {
	     int currScore = scoreWays.get(i);
	     for (int j = currScore; j <= k; k++) {
		 table[i] += table[j - currScore];
	     }
	 }
	 return table[k];
     }
}
