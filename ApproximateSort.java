
public class ApproximateSort {

    public static void sortApproximatelySortedArray(List<Integer> In, int k) {
	
	List<Integer> tempList = ArrayList<Integer>();

	int indexForIn = 0;
	while (indexForIn++ != In.size()) {
	
	    for (int i = 0; i < k; i++) {
		tempList.add(In.get(indexForIn * + i));
	    }
	}
	
    }

    public static void main(String[] args) {
	
    }


}
