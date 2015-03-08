import java.util.*;

public class CompareKthLargestInHeap {

    public static enum Ordering {
	SMALLER, EQUAL, LARGER
    }

    public static Ordering compareKthLargestHeap(int[] maxHeapArr, int k, int x) {
	PriorityQueue<Integer> myMaxHeap = new PriorityQueue<Integer>();
	// preorder
	Integer result = compareKthLargestHeapHelper(maxHeapArr, 0, 0, k, x, myMaxHeap);
	System.out.println("result = " + result);
	return result == -1 ? Ordering.SMALLER : result == 1 ? Ordering.LARGER : Ordering.EQUAL;
    }

    private static Integer compareKthLargestHeapHelper(int[] maxHeapArr, int currPos, int counter, int k, int x, PriorityQueue<Integer> myMaxHeap) {

	System.out.println("k = " + k);
	System.out.println("counter = " + counter);
	System.out.println("currPos = " + currPos);
		
	Integer leftval = null, rightval = null;

	if (counter == k)
	    return null;
	
	if (maxHeapArr[currPos] >= x) {
	    counter++;
	    System.out.println("counter = " + counter);
	    if (counter == k) {
		myMaxHeap.add(maxHeapArr[currPos]);
		System.out.println("here also k = " + k);
		return maxHeapArr[currPos] > x ? 1 : maxHeapArr[currPos] < x ? -1 : 0;
	    }

	    if (currPos * 2 + 1 < maxHeapArr.length - 1)
		leftval = compareKthLargestHeapHelper(maxHeapArr, currPos * 2 + 1, counter, k, x, myMaxHeap);
	    if ((currPos * 2 + 2 < maxHeapArr.length - 1) && (leftval == null))
		rightval = compareKthLargestHeapHelper(maxHeapArr, currPos * 2 + 2, counter, k, x, myMaxHeap);
	} else {
	    return 
	}

	if (leftval == null) {
	    System.out.println("here");
	    return rightval;
	}
	else
	    return leftval;
		    
    }

    public static void main(String[] args) {

	// 5
	// 4 5
	// 4 4 4 3
	// 4
	int[] maxHeap = new int[]{5, 4, 5, 4, 4, 4, 3, 4};
	int k, x;
	if (args.length == 2) {
	    k = Integer.parseInt(args[0]);
	    x = Integer.parseInt(args[1]);
	    Ordering res = compareKthLargestHeap(maxHeap, k, x);
	    System.out.println(res);
	} else {
	    assert (Ordering.SMALLER == compareKthLargestHeap(maxHeap, 1, 6)); // expect smaller
	    assert (Ordering.EQUAL == compareKthLargestHeap(maxHeap, 1, 5)); // expect equal
	    assert (Ordering.EQUAL == compareKthLargestHeap(maxHeap, 6, 4)); // expect equal
	    assert (Ordering.EQUAL == compareKthLargestHeap(maxHeap, 3, 4)); // expect equal
	    assert (Ordering.SMALLER == compareKthLargestHeap(maxHeap, 8, 4)); // expect smaller
	    assert (Ordering.LARGER == compareKthLargestHeap(maxHeap, 2, 4)); // expect larger
	    assert (Ordering.LARGER == compareKthLargestHeap(maxHeap, 2, 3)); // expect larger
	}
    }
}
