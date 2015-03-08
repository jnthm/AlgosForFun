public class BinaryTree<T> {
    
    private BinaryTree<T> left, right;
    private T data;
    private BinaryTree<T> parent;

    public BinaryTree() {
    }

    public BinaryTree(T data) {
	this.data = data;
    }

    public BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
	this.left = left;
	this.right = right;
	this.data = data;
    }

    public BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right,
                      BinaryTree<T> parent) {
	this(data, left, right);
	this.parent = parent;
    }

    public BinaryTree<T> getLeft() {
	return left;
    }

    public BinaryTree<T> getRight() {
	return right;
    }

    public void setLeft(BinaryTree<T> left) {
	this.left = left;
    }

    public void setRight(BinaryTree<T> right) {
	this.right = right;
    }

    public T getData() {
	return this.data;
    }

    public BinaryTree<T> getParent() {
      return parent;
    }

    public void setParent(BinaryTree<T> parent) {
      this.parent = parent;
    }

}
