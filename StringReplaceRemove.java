import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class StringReplaceRemove {

    private static String replaceAndRemove(String s) {
	char[] sChars = s.toCharArray();
	int bIndx = 0;
	int aCnt = 0;
	
	for (char c: sChars) {
	    if (c != 'b') {
		sChars[bIndx++] = c;
	    }
	    if (c == 'a') {
		aCnt++;
	    }
	}

	sChars = Arrays.copyOf(sChars, bIndx + aCnt);
	int currIndx = bIndx - 1;
	int wrIndx = sChars.length - 1;
	
	while (currIndx >= 0) {
	    if (sChars[currIndx] == 'a') {
		sChars[wrIndx--] = 'd';
		sChars[wrIndx--] = 'd';
	    } else {
		sChars[wrIndx--] = sChars[currIndx];
	    }
	    currIndx--;
	}


	return new String(sChars);
    }

    public static void main(String[] args) {
	System.out.println(replaceAndRemove(args[0])); // replace 'a' with 'dd', and delete each 'b'
    }	

}
