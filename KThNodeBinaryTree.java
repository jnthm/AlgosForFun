import java.lang.Math;

public class KThNodeBinaryTree {

    public static <T> BinaryTree<T> boolean findKth(BinaryTree<T> node, int k, int Total) {

	// recursion
	if (node.size() == k) return node;
	else if (node.getLeft().size() >= k) return (findKth(node.getLeft(), k, node.getLeft().size()));
	else return (findKth(node.getRight(), Total - k - 1, node.getRight().size()));

	// iteration
	BinaryTree<T> tree = node;
	while (tree != null) {
	    if (tree.size() == k) return tree;
	    else if (tree.getLeft().size() >= k) {
		tree = Tree.getLeft();
		Total = Tree.getLeft().size();
	    }
	    else {
		tree = Tree.getRight();
		k = Total - k - 1;
		Total = Tree.getRight().size()
	    }
	}
	return null;
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
