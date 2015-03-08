import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Palindrome {

    private static boolean isPalindrome(String s) {
	char[] sChars = s.toCharArray();
	int len = sChars.length;
	int leftPtr = 0, rightPtr = len - 1;

	while (leftPtr < rightPtr) {
	    while (!Character.isLetterOrDigit(sChars[leftPtr])) {
		leftPtr++; 
	    }
	    while (!Character.isLetterOrDigit(sChars[rightPtr])) {
		rightPtr--; 
	    }

	    if (Character.toLowerCase(sChars[leftPtr++]) != Character.toLowerCase(sChars[rightPtr--]))
		return false;

	}

	return true;
    }

    public static void main(String[] args) {
	//System.out.println(isPalindrome(args[0])); 
	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	System.out.println(isPalindrome(""));
	System.out.println(isPalindrome("race a car"));
    }	

}
