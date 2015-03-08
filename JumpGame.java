import java.io.*;
import java.util.*;

public class JumpGame {

    private static boolean canReach(List<Integer> Ints) {

	int furthestReach = 0;
	int N = Ints.size();
	
	for (int i = 0; i <= furthestReach && furthestReach < N - 1; i++) 
	    furthestReach = Math.max(i + Ints.get(i), furthestReach);

	return furthestReach >= N - 1;

    }

    public static void main(String[] args) {
	List<Integer> Ints = new ArrayList<Integer>();

	BufferedReader br = null;
	String sCurrLine;
	try {
	br = new BufferedReader(new FileReader("input.txt"));
	while ((sCurrLine = br.readLine()) != null) 
	    Ints.add( (Integer.valueOf(sCurrLine)));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	finally {
	    try {
		if (br != null) br.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

	System.out.println("Input:");
	for (Integer i: Ints)
	    System.out.println(i);

	System.out.println("Can the Game be reachable?:" + canReach(Ints));

	
    }
}
