import java.lang.Math;

public class SumRootToLeafBinaryTree {

    public static <T> int getSumRootToLeafBinaryTree(BinaryTree<T> node, int data) {
	if (node == null) 
	    return 0;
	int inData = data * 2 + node.getData();
	int outDataL = getSumRootToLeafBinaryTree(node.getLeft(), inData);
	int outDataR = getSumRootToLeafBinaryTree(node.getRight(), inData);

	if (node.getLeft() == null && node.getRight() == null) 
	    return outDataL + outDataR;
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
