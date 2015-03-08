import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math.*;

public class RomanToInt {

    private static int romanToInt(String s) {

	Map<Character, Integer> T = new HashMap<Character, Integer>() {
	    {
		put('I', 1);
		put('V', 5);
		put('X', 10);
		put('L', 50);
		put('C', 100);
		put('D', 500);
		put('M', 1000);
	    }
	};

	int len = s.length();
	int runInt = 0;
	for (int i = 0; i < len; i++) {
	    int currCnt = T.get(s.charAt(i));

	    if (s.charAt(i) == 'I' || s.charAt(i) == 'C'|| s.charAt(i) == 'X') {
		int iCnt = 1;
		while (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
		    i++; iCnt++;
		}
		if (i + 1 < len) {
		    i++;
		    int currCntNew = T.get(s.charAt(i));
		    currCnt = currCntNew - (iCnt * currCnt);
		}
		else 
		    currCnt *=  iCnt;
	    }

	    runInt += currCnt;
	}
	return runInt;
    }


    public static void main(String[] args) {
	System.out.println(romanToInt("LIX"));
	System.out.println(romanToInt("MMMMCMXCIX"));
	System.out.println(romanToInt("MMIII"));
	System.out.println(romanToInt("MLXL"));
	System.out.println(romanToInt(""));
	System.out.println(romanToInt(""));
	System.out.println(romanToInt(""));
	// ecila sekil bob
	// bob likes alice
    }	

}
