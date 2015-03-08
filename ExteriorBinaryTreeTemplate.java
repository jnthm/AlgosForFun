import java.lang.Math;

public class ExteriorBinaryTreeTemplate {

    private static <T> void printLeft(BinaryTree<T> node, boolean isBndry) {
	if (node == null) return;
	if (isBndry | (node.getLeft() == null && node.getRight() == null)) System.out.println(node.getData());
	printLeft(node.getLeft(), isBndry);
	printLeft(node.getRight(), isBndry && node.getLeft() == null);
    }

    private static <T> void printRight(BinaryTree<T> node, boolean isBndry) {
	if (node == null) return;
	printRight(node.getLeft(), isBndry && node.getRight() == null);
	printRight(node.getRight(), isBndry);
	if (isBndry | (node.getLeft() == null && node.getRight() == null)) System.out.println(node.getData());
    }

    public static <T> void exteriorBinaryTree(BinaryTree<T> root) {
	if (root == null) return;
	System.out.println(root.getData());
	printLeft(root.getLeft(), true);
	printRight(root.getRight(), true);
    }

    public static void main(String[] args) {
	BinaryTree<Integer> root = new BinaryTree<Integer>(3, null, null);
	root.setLeft(new BinaryTree<Integer>(2, null, null));
	root.getLeft().setRight(new BinaryTree<Integer>(0, null, null));
	root.getLeft().getRight().setLeft(new BinaryTree<Integer>(-1, null, null));
	root.getLeft().getRight().setRight(new BinaryTree<Integer>(-2, null, null));
	root.getLeft().setLeft(new BinaryTree<Integer>(1, null, null));
	root.setRight(new BinaryTree<Integer>(5, null, null));
	root.getRight().setLeft(new BinaryTree<Integer>(4, null, null));
	root.getRight().setRight(new BinaryTree<Integer>(6, null, null));
	// should output 3 2 1 -1 -2 4 6 5
	exteriorBinaryTree(root);
    }
}
