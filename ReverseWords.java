import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class ReverseWords {

    private static String reverseWords(String s) {
	char[] sChars = s.toCharArray();
	int len = sChars.length;

	// NOTE: to reverse individual words of the array
	for (int i = 0; i < len; i++) {
	    
	    int j = i, k = i;
	    
	    // find next SPACE
	    // i --> main pointer
	    // j --> start of the word
	    // k --> end of the word
	    while (i < len && sChars[i] != ' ') {
		k++;
		i++;
	    }

	    k--;
	    // after the above loop, i points to SPACE
	    while (j < k) {
		char temp = sChars[k];
		sChars[k] = sChars[j];
		sChars[j] = temp;
		j++;
		k--;
	    }
	}

	// NOTE: to reverse the entire array
	for (int i = 0, j = len - 1; i < len && j >= i; i++, j--) {
		char temp = sChars[j];
		sChars[j] = sChars[i];
		sChars[i] = temp;
	}
	
	return new String(sChars);
    }

    public static void main(String[] args) {
	System.out.println(reverseWords("Alice likes Bob")); 
	// ecila sekil bob
	// bob likes alice
    }	

}
