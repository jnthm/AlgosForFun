import java.lang.Math;

public class BalancedBinaryTree {

    public static <T> boolean isBalancedBinaryTree(BinaryTree<T> Node) {
	return isBalancedWithHeight (Node) != -2;
    }
    
    public static <T> int isBalancedWithHeight(BinaryTree<T> Node) {

	if (Node == null) 
	    return -1;

	int leftH8 = isBalancedWithHeight(Node.getLeft());
	if (leftH8 == -2)
	    return -2;

	int rightH8 = isBalancedWithHeight(Node.getRight());
	if (rightH8 == -2)
	    return -2;

	if (Math.abs(leftH8 - rightH8) > 1)
	    return -2;

	return Math.max(leftH8, rightH8) + 1;
    }

    public static void main(String[] args) {
	
	BinaryTree<Integer> root = new BinaryTree<Integer>();
	root.setLeft(new BinaryTree<Integer>());
	root.getLeft().setLeft(new BinaryTree<Integer>());
	root.setRight(new BinaryTree<Integer>());
	root.getRight().setLeft(new BinaryTree<Integer>());
	root.getRight().setRight(new BinaryTree<Integer>());
	assert(isBalancedBinaryTree(root));
	System.out.println(isBalancedBinaryTree(root));
	root = new BinaryTree<Integer>();
	root.setLeft(new BinaryTree<Integer>());
	root.getLeft().setLeft(new BinaryTree<Integer>());
	assert(!isBalancedBinaryTree(root));
	System.out.println(isBalancedBinaryTree(root));
    }
}
