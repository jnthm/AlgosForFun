import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static String hasEquilibriumIndex(int[] arr) {
	int arrSum = 0;
	for (int e: arr) {
	    arrSum += e;
	}

	int leftSum = 0;
	int rightSum = arrSum;
	for (int i = 0; i < arr.length; i++) {
	    int currElem = arr[i];
	    rightSum -= currElem;
	    if (leftSum == rightSum) {
		return "YES";
	    }
	    leftSum += currElem;
	}
	return "NO";
    }

    public static void main(String[] args) {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	Scanner sc=new Scanner(System.in);
	int totalTests = sc.nextInt();

	for (int i = 0; i < totalTests; i++) {
	    int currTestLen = sc.nextInt();

	    int[] currArr = new int[currTestLen];
	    for (int j = 0; j < currTestLen; j++) {
		currArr[j] = sc.nextInt();
	    }
	    System.out.println(hasEquilibriumIndex(currArr));
	}
    }

}
