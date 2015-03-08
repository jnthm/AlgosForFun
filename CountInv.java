import java.util.Arrays;

public class CountInv {

    public static int countInversions(int[] A) {
	
	return cInvHelper(A, 0 , A.length);
	
    }

    private static int cInvHelper(int[] A, int start, int end) {

	// base case:
	if (start == end - 1) {
	    return 0;
	}

	int lCount = cInvHelper(A, start, start + (end - start)/2);
	int rCount = cInvHelper(A, start + (end - start)/2, end);
	int lSize = (end - start)/2;
	
	// array is already sorted between start and end
	int[] tempA = new int[end - start];
	int tempI = 0;
	int cInv = lCount + rCount, i = start, j = start + (end - start)/2;

	while (i < start + (end - start)/2 && j < end) {
	    if (A[i] < A[j]) {
		tempA[tempI++] = A[i++];
	    } else {
		cInv += lSize - i;
		tempA[tempI++] = A[j++];
	    }
	}

	while (i < start + (end - start)/2) {
	    tempA[tempI++] = A[i++];
	}

	while (j < end) {
	    tempA[tempI++] = A[j++];
	}
	
	// copy back tempA to A
	i = 0;
	while (i < tempI) {
	    A[start + i] = tempA[i];
	    i++;
	}

	return cInv;
    }

    public static void main (String[] args) {

	int[] A = new int[] {4, 3, 2, 1};
	System.out.println("Inversions Count = " + countInversions(A));
	System.out.println("Sorted Array " + Arrays.toString(A));
    }
}
