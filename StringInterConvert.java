import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class StringInterConvert {

    private static String intToString(int i) {
	int len = 0;
	StringBuilder sb = new StringBuilder();
	boolean isNegative = (i < 0) ? true: false;
	int x = isNegative ? -i : i; // EDGE_CASE:

	if (x == 0) 
	    return sb.append('0').toString();
	while (x != 0) {
	    sb.append((char) (x % 10 + '0'));
	    x = x / 10;
	}
	if (isNegative) sb.append('-');
	return sb.reverse().toString();
    }

    private static int stringToInt(String s) {
	int len = s.length();
	int outInt = 0;
	boolean isNeg = s.charAt(0) == '-';

	for (int i = isNeg ? 1 : 0; i < len; i++) {
	    outInt = outInt * 10 + (s.charAt(i) - '0');
	}
	
	return isNeg ? -outInt : outInt;
    }

    public static void main(String[] args) {

	// System.out.println(stringToInt(args[0])); // string to be converted to int.
	System.out.println(intToString(Integer.parseInt(args[0]))); // int to be converted to string.
    }	

}
