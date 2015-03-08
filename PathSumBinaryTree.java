import java.lang.Math;

public class PathSumBinaryTree {

    public static <T> boolean pathSumBinaryTree(BinaryTree<T> node, int sum) {
	if (node == null)
	    return sum == 0;
	
	int currSum = sum - (Integer)node.getData();

	if (pathSumBinaryTree(node.getLeft(), currSum))
	    return true;
	else 
	    return pathSumBinaryTree(node.getRight(), currSum);
    }

    public static void main(String[] args) {

	BinaryTree<Integer> root = new BinaryTree<Integer>(3);
	root.setLeft(new BinaryTree<Integer>(2));
	root.getLeft().setLeft(new BinaryTree<Integer>(1));
	root.setRight(new BinaryTree<Integer>(5));
	root.getRight().setLeft(new BinaryTree<Integer>(4));
	root.getRight().setRight(new BinaryTree<Integer>(6));
	assert (pathSumBinaryTree(root, 6));
	assert (!pathSumBinaryTree(root, 7));
	assert (!pathSumBinaryTree(root, 100));
    }
}
