import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class LookAndSay {

    private static String lookAndSay(int n) {
	String s = "1";
	for (int i = 1; i < n; i++) 
	    s = getSeq(s);
	return s;
    }

    public static String getSeq(String s) {

	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < s.length(); i++) {
	    int count = 1;
	    while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
		i++; count++;
	    }
	     sb.append(count); 
	     sb.append(s.charAt(i));
	}
	return sb.toString();
    }

    public static void main(String[] args) {
	System.out.println(lookAndSay(8));
	// ecila sekil bob
	// bob likes alice
    }	

}
