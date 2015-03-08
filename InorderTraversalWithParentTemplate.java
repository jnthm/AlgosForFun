import java.lang.Math;

public class InorderTraversalWithParentTemplate {

    public static <T> void inOrderTraversal(BinaryTree<T> root) {

	if (root == null) return;

	BinaryTree<T> curr = root, prev = null;

	if (root.getRight() == null && root.getLeft() == null) {
	    System.out.println(curr.getData());
	    return;
	} else {
	    while (!(root == curr && curr.getRight() == prev) && !(root == curr && curr.getRight() == null && curr.getLeft() == prev)) {
		if (curr.getRight() != prev && (curr.getLeft() == null || curr.getLeft() == prev)) {
		    System.out.println(curr.getData());
		    prev = curr;
		    curr = (curr.getRight() == null) ? curr.getParent() : curr.getRight();
		} else if (curr.getRight() == prev) {
		    prev = curr;
		    curr = curr.getParent();
		} else {
		    prev = curr;
		    curr = curr.getLeft();
		}
	    }
	    return;
	}
	
    }

    public static void main(String[] args) {
	
	BinaryTree<Integer> root = new BinaryTree<Integer>(3, null, null);
	root.setLeft(new BinaryTree<Integer>(2, null, null));
	root.getLeft().setParent(root);
	root.getLeft().setLeft(new BinaryTree<Integer>(1, null, null));
	root.getLeft().getLeft().setParent(root.getLeft());
	root.setRight(new BinaryTree<Integer>(5, null, null));
	root.getRight().setParent(root);
	root.getRight().setLeft(new BinaryTree<Integer>(4, null, null));
	root.getRight().getLeft().setParent(root.getRight());
	root.getRight().setRight(new BinaryTree<Integer>(6, null, null));
	root.getRight().getRight().setParent(root.getRight());
	
	// Should output 1 2 3 4 5 6.
	inOrderTraversal(root);

    }
}
