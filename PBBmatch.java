import java.util.LinkedList;
import java.io.*;
import java.util.Comparator;

public class PBBmatch {

    public static class Stack<Item> implements Comparator<Item>{
	private LinkedList<Item> s;
	private LinkedList<Item> auxVal;
	private LinkedList<Integer> auxCount;
	private ComparatorImpl myComp = null;

	public static Comparator<Item> myComp = new Comparator<Item>() {

	    public int compare(Item item1, Item item2) {
		Character c1 = (Character)item1;
		Character c2 = (Character)item1;
		if (c1 < c2) return -1;
		else if (c1 > c2) return 1;
		else return 0;
	    }
	};


	public Stack(ComparatorImpl givenComp) {
	    s = new LinkedList<Item>();
	    auxVal = new LinkedList<Item>();
	    auxCount = new LinkedList<Integer>();
	    myComp = givenComp;
	}

	public boolean empty() {
	    return s.isEmpty();
	}

	public void push(Item val) {
	    s.push(val);
	    System.out.println("Push value" + val);
	    if (auxVal.isEmpty()) {
		auxVal.push(val);
		auxCount.push(1);
	    }
	    else {
		if (myComp.compare(val, auxVal.getFirst()) > 0) {
		    auxVal.push(val);
		    auxCount.push(1);
		} else if (myComp.compare(val, auxVal.getFirst())) 
		    auxCount.push(auxCount.pop() + 1);
	    }
	}
	
	public Item pop() {
	    if (s.isEmpty())
		throw new RuntimeException("pop from an empty stack");
	    
	    Item retVal = s.pop();
	    if (retVal.equals(auxVal.getFirst())) {
		auxCount.push(auxCount.pop() + 1);
		if (auxCount.getFirst() == 0) auxCount.pop();
	    }
	    return retVal;
	}
	
	public Item max() {
	    if (s.isEmpty())
		throw new RuntimeException("max from an empty stack");

	    return auxVal.getFirst();
	}
    }
    
    public static void main (String[] args) {
	char[] sChars = args[0].toCharArray();

	Stack<Character> s = new Stack<Character>(myComp);
	int len = sChars.length;
	boolean pbbFlag = true;
	System.out.println("length of the input string = " + len);
	for (Character c : sChars) {
	    if ("{[(".contains(c)) {
		s.push(c);
	    } else if ("}])".contains(c)) {
		if (!c.equals(s.pop())) {
		    pbbFlag = false;
		    break;
		}
	    } else {
		throw new IllegalArgumentException("Input contains characters other than PBB.");
	    }
	}
	
	if (pbbFlag) System.out.println("Input PBB");
	else System.out.println("Input not PBB");
	
    }

}
