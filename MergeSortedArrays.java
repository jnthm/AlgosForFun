
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;


public class MergeSortedArrays {

    public static List<Integer> mergeSortedArrays(int[][] sortedArrays) {

	// comparator for heap objects
	Comparator<Pair<Pair<Integer, Integer>, Integer>> heapComp = new Comparator<Pair<Pair<Integer, Integer>, Integer>>() {
	    public int compare(Pair<Pair<Integer, Integer>, Integer> o1, Pair<Pair<Integer, Integer>, Integer> o2) {
		return o1.getFirst().getFirst().compareTo(o2.getFirst().getFirst());
	    }
	};

	PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> minH = new PriorityQueue<Pair<Pair<Integer, Integer>, Integer>>(11, heapComp);

	List<Integer> ans = new ArrayList<Integer>();

	// first loop!
	int i = 0;
	while (i < sortedArrays.length) {
	    //	    System.out.println("i = " + i + "len = " + sortedArrays.length);
	    minH.add(new Pair(new Pair(sortedArrays[i][0], i++), 0));
	}

	while (minH.peek() != null) {
	    Pair<Pair<Integer, Integer>, Integer> o = minH.poll();
	    int row = o.getFirst().getSecond();
	    int col = o.getSecond();
	    //	    System.out.println("row = " + row);
	    ans.add(o.getFirst().getFirst());
	    if (col < sortedArrays[row].length - 1) 
		minH.add(new Pair(new Pair(sortedArrays[row][col + 1], row), col + 1));
	}

	return ans;
    }


    public static void main(String[] args) {

	Random rnd = new Random();
	for (int times = 0; times < 100; ++times) {
	    int n;
	    n = rnd.nextInt(100);
	    
	    int[][] S = new int[n][];
	    for (int i = 0; i < n; ++i) {
		S[i] = new int[rnd.nextInt(500) + 1];
		for (int j = 0; j < S[i].length; ++j) {
		    S[i][j] = rnd.nextInt(10000);
		}
		Arrays.sort(S[i]);
	    }

	    List<Integer> ans = mergeSortedArrays(S);
	    for (int i = 1; i < ans.size(); ++i) {
		assert ((ans.get(i - 1) <= ans.get(i)));
	    }

	}
    }

}
