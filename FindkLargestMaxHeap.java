import java.util.*;

public class FindkLargestMaxHeap {

    public static List<Integer> kLargestElements(int[] maxHeapArr, int k) {

	Comparator<Pair<Integer, Integer>> myHeapComp = new Comparator<Pair<Integer, Integer>> () {
	    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
		return p2.getFirst().compareTo(p1.getFirst());
	    }
	};

	List<Integer> resultList = new ArrayList<Integer>();
	PriorityQueue<Pair<Integer, Integer>> maxHeapK = new PriorityQueue<Pair<Integer, Integer>>(k , myHeapComp);
	maxHeapK.add(new Pair(maxHeapArr[0], 0));

	int i = 0, pos;
	while (i < k && maxHeapK.size() != 0) {
	    Pair<Integer, Integer> currMax = maxHeapK.poll();
	    resultList.add(currMax.getFirst());
	    pos = currMax.getSecond() * 2 + 1;
	    System.out.println("pos = " + pos);
	    if (pos <= maxHeapArr.length)
		maxHeapK.add(new Pair (maxHeapArr[pos], pos));
	    pos++;
	    if (pos <= maxHeapArr.length)
		maxHeapK.add(new Pair (maxHeapArr[pos], pos));
	    i++;
	}
	return resultList;
    }

    public static void main(String[] args) {

	System.out.println(kLargestElements(new int[]{15, 13, 14, 10, 11, 12, 8, 9, 5, 4, 3, 2, 1, 7, 6}, 4));
    }
}






