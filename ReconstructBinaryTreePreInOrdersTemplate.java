import java.util.ArrayList;
import java.util.Random;

public class PopulatingNextRightPointers {



    public static <T> BinaryTree<T> reconstructPreInOrdersRecurs(ArrayList<T> pre, BinaryTree<T> node, ArrayList<T> in, int inLow, int inHigh) {

	// create Node, recons LeftSubtree, recons rightSubtree
	BinaryTree<T> node = new BinaryTree<T>(pre.get(0));
	reconstructPreInOrdersRecurs(pre, node, in, 0, 3);
	reconstructPreInOrdersRecurs(pre, node, in, 5, 8);
	
    }

    public static <T> BinaryTree<T> reconstructPreInOrders(ArrayList<T> pre, ArrayList<T> in) {


    }

    public static void main(String[] args) {
	Random r = new Random();
	for (int times = 0; times < 1000; ++times) {
	    System.out.println(times);
	    int n;
	    if (args.length == 1) {
		n = Integer.parseInt(args[0]);
	    } else {
		n = r.nextInt(10000) + 1;
	    }
	    BinaryTree<Integer> root = generateRandBinaryTree(n, true);
	    ArrayList<Integer> pre = generatePreOrder(root);
	    ArrayList<Integer> in = generateInOrder(root);
	    BinaryTree<Integer> res = reconstructPreInOrders(pre, in);
	    assert (root.equals(res));
    }
  }
}
