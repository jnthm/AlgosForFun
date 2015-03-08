import java.lang.Math;

public class PopulatingNextRightPointers {

    public static class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left, right;
	public BinaryTreeNode<T> next; // Populates this field.
	
	public BinaryTreeNode(T data) {
	    this.data = data;
	}
    }


    private static void populateNextPointerRecur(BinaryTreeNode<Integer> node) {
	
	if (node.left == null && node.right == null) return;

	node.left.next = node.right;
	node.right.next = node.next == null ? null : node.next.left;

	populateNextPointerRecur(node.left);
	populateNextPointerRecur(node.right);

    }
    
    public static void populateNextPointer(BinaryTreeNode<Integer> root) {
	root.next = null;
	populateNextPointerRecur(root);
    }


    
    public static void main(String[] args) {
	// 3
	// 2 5
	// 1 7 4 6
	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(3);
	root.left = new BinaryTreeNode<Integer>(2);
	root.left.right = new BinaryTreeNode<Integer>(7);
	root.left.left = new BinaryTreeNode<Integer>(1);
	root.right = new BinaryTreeNode<Integer>(5);
	root.right.left = new BinaryTreeNode<Integer>(4);
	root.right.right = new BinaryTreeNode<Integer>(6);
	populateNextPointer(root);
	assert (root.next == null);
	assert (root.left.next == root.right);
	assert (root.left.left.next == root.left.right);
	assert ((root.left.right.next == root.right.left));
	assert (root.right.left.next == root.right.right);	
    }
}
