import java.lang.Math;

public class Successor {

    public static <T> BinaryTree<T> findSuccessor(BinaryTree<T> node) {
	if (node == null) return null;
	BinaryTree<T> curr = node, prev = null;

	if (curr.getRight() != null) {
	    curr = curr.getRight();
	    while (curr.getLeft() != null) {
		curr = curr.getLeft();
	    }
	    return curr;
	} else {
	    prev = curr;
	    curr = curr.getParent();
	    if (curr == null) return null;
	    else if (curr.getLeft() == prev) {
		return curr;
	    } else if (curr.getRight() == prev) {
		while (curr != null && curr.getLeft() != prev) {
		    prev = curr;
		    curr = curr.getParent();
		}
		return curr;
	    }
	}
	return null;
    }

    public static void main(String[] args) {

	// 3
	// 2 5
	// 1 4 6
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
	// should output 6
	BinaryTree<Integer> node = findSuccessor(root.getRight());
	assert (node.getData().equals(6));
	System.out.println(node.getData());
	// should output "null"
	node = findSuccessor(root.getRight().getRight());
	assert (node == null);
	if (node != null) {
	    System.out.println(node.getData());
	} else {
	    System.out.println("null");
	}
  }
}
