public class UniqueBinaryTreesAllMine {

    public static List<BinaryTree<Integer>> generateAllBinaryTrees(int n) {

	helper(1, n, result);
	return result;
    }

    private static List<BinaryTree<Integer>> helper(int k, int n) {

	List<BinaryTree<Integer>> result = new ArrayList<BinaryTree<Integer>>();

	// base case:
	if (k >= n) {
	    result.add(null);
	    return result;
	}

	// recursive case:
	for (int i = k; i <= n; i++) {
	    List<BinaryTree<Integer>> leftTree = helper(k, i - 1);
	    List<BinaryTree<Integer>> rightTree = helper(i + 1, n);
	    
	    for (BinaryTree<Integer> left : leftTree) {
		for (BinaryTree<Integer> right : rightTree) {
		    result.add(new BinaryTree<Integer>(i, left, right));
		}
	    }
	}

	return result;
    }
	
}



// sudoku

private static boolean solveSudokuHelper(int[][] A, int i, int j) {
    
}
