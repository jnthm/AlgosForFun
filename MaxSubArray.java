import java.lang.Math;

public class MaxSubArray {

    public static int maxSubArray(int[] A) {

	int currSubArrayMax = A[0];
	int subArrayMax = A[0];
	
	for (int i = 1; i < A.length; i++) {
	    currSubArrayMax = Math.max(A[i], currSubArrayMax + A[i]);
	    subArrayMax = Math.max(subArrayMax, currSubArrayMax);
	}

	return subArrayMax;
    }

    public static void main (String[] args) {

	int[] A = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4, 1, -1};
	System.out.println(maxSubArray(A));
    }

}
5
