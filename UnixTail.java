import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math.*;

public class UnixTail {
    
    private static String tail(String fileName, int n) throws IOException{
	RandomAccessFile filePtr = new RandomAccessFile(fileName, "r");
	long len = filePtr.length(); //num of bytes

	int numLinesRead = 0;
	StringBuilder sb = new StringBuilder();
	
	for (long i = len - 1; i >= 0 && numLinesRead < n; i--) {
	    filePtr.seek(i); // set Ptr
	    Character currByte = (char) filePtr.readByte();
	    sb.append(currByte);
	    if (currByte == '\n') 
		numLinesRead++;
	}
	filePtr.close();
	return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException{
	System.out.println(tail("input.txt", 10));
    }	

}
