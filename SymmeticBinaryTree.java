import java.lang.Math;

public class SymmeticBinaryTree {

    public static <T> boolean isSymmetricBinaryTree(BinaryTree<T> Node) {
	if (Node == null) return true;
	return isSymmetricBinaryTree(Node.getLeft(), Node.getRight());
    }

    private static <T> boolean isSymmetricBinaryTree(BinaryTree<T> Node1, BinaryTree<T> Node2) {
	if (Node1 == null && Node2 == null)
	    return true;
	else if (Node1 == null && Node2 != null || Node1 != null && Node2 == null)
	    return false;

	return ((Node1.getData().equals(Node2.getData())) && 
		isSymmetricBinaryTree(Node1.getLeft(), Node2.getRight()) && 
		isSymmetricBinaryTree(Node1.getRight(), Node2.getLeft()));
    }
    

    public static void main(String[] args) {
	
	BinaryTree<Integer> root = new BinaryTree<Integer>(314);
	root.setLeft(new BinaryTree<Integer>(6));
	root.setRight(new BinaryTree<Integer>(6));
	root.getRight().setLeft(new BinaryTree<Integer>(2));
	root.getLeft().setRight(new BinaryTree<Integer>(2));
	root.getRight().getLeft().setLeft(new BinaryTree<Integer>(3));
	root.getLeft().getRight().setRight(new BinaryTree<Integer>(3));
	assert(isSymmetricBinaryTree(root));
	System.out.println(isSymmetricBinaryTree(root));
    }
}
