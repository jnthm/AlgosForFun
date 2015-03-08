import java.lang.Math;

public class SumRootToLeafBinaryTree {

    public static <T> BinaryTree<T> getLCA(BinaryTree<T> node, BinaryTree<T> n1, BinaryTree<T> n2) {
	
	if (node == null) return null;
	else if (node == n1 || node == n2)
	    return node;
	else {
	    BinaryTree<T> leftResult = getLCA(node.getLeft(), n1, n2);
	    BinaryTree<T> rightResult = getLCA(node.getRight(), n1, n2);

	    return (leftResult != null && rightResult != null) ? node : (leftResult == null) ? rightResult : leftResult;
	}
	
    }

    public static void main(String[] args) {
	
	BinaryTree<Integer> N1, N2;
	BinaryTree<Integer> root = new BinaryTree<Integer>(314);
	root.setLeft(new BinaryTree<Integer>(6));
	root.setRight(new BinaryTree<Integer>(6));
	root.getRight().setLeft(new BinaryTree<Integer>(2));
	root.getLeft().setRight(new BinaryTree<Integer>(2));
	root.getLeft().setLeft(new BinaryTree<Integer>(111));
	root.getRight().getLeft().setLeft(N1 = new BinaryTree<Integer>(3));
	root.getLeft().getRight().setRight(N2 = new BinaryTree<Integer>(3));
	System.out.println(getLCA(root, N1, N2).getData());
    }
}
