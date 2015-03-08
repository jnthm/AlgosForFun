public class DrawingSkylines {

    public static class Skyline {
	int left, right, height;
	public Skyline (int l, int r, int h) {
	    this.left = l;
	    this.right = r;
	    this.height = h;
	}
    }

    public static List<Pair<Integer, Integer>> drawingSkylines(List<Skyline> A) {
	if (A.size() == 0) return null;
	return helper (A, 0, A.size());
    }

    private static List<Pair<Integer, Integer>> helper(List<Skyline> A, int start, int end) {
	// base:
	if (end - start == 1) {
	    List<Pair<Integer, Integer>> ans = new List<Pair<Integer, Integer>>();
	    Skyline curr = A.get(start);
	    ans.add(curr.left, curr, height);
	    ans.add(curr.right, curr, 0);
	    return ans;
	}

	// else:
	
	int mid  = start + (end - start) / 2;

	List<Pair<Integer, Integer>> leftAns = helper(A, start, mid);
	List<Pair<Integer, Integer>> rightAns = helper(A, start, mid);
	return merge (leftAns, rightAns);
    }

    private static List<Pair<Integer, Integer>> merge(List<Pair<Integer, Integer>> leftAns, List<Pair<Integer, Integer>> rightAns) {

	List<Pair<Integer, Integer>> ans = new List<Pair<Integer, Integer>>();
	
	int i = 0, j = 0;

	while ( i < leftAns.size() && j < rightAns.size()) {
	}

	mergeRemaining(i, leftAns);
	mergeRemaining(j, rightAns);


    }

    private static void mergeRemaining(int i, List<Pair<Integer, Integer>> leftAns) {

	while (i < leftAns.size()) {

	    Skyline curr = leftAns.get(i), prev = leftAns.get(i - 1); 

	    if ((curr.height > prev.height && curr.left < prev.right)) {
		ans.add(curr.left, curr.height);
	    } else if ((curr.height < prev.height && curr.left < prev.right)) {
		ans.add(prev.right, curr.height);
	    } else if (curr.left > prev.right) {
		ans.add(prev.right, 0);
		ans.add(curr.left, curr.height);
	    }
	    
	    if (i == leftAns.size() - 1) {
		if (curr.right > prev.right) {
		    ans.add(curr.right, 0);
		}
	    }
	}
    }


    public static void main(String[] args) {

	A.add(new Skyline(1, 5, 11));
	A.add(new Skyline(2, 7, 6));
	A.add(new Skyline(3, 9, 13));
	A.add(new Skyline(12, 16, 7));
	A.add(new Skyline(14, 25, 3));
	A.add(new Skyline(19, 22, 18));
	A.add(new Skyline(23, 29, 13));
	A.add(new Skyline(24, 28, 4));

	List<Pair<Integer, Integer>> ans = drawingSkylines(A);
	
	for (int i = 0; i < ans.size(); i++) {
	    System.out.println(ans.get(i).getFirst(), ans.get(i).getSecond());
	}

    }
}
