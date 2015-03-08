import java.util.LinkedList;
import java.io.*;

public class StackWithMax {

    public static class Stack {
	private LinkedList<Integer> s = new LinkedList<Integer>();
	private LinkedList<Integer> auxVal = new LinkedList<Integer>();
	private LinkedList<Integer> auxCount = new LinkedList<Integer>();

	public boolean empty() {
	    return s.isEmpty();
	}
	
	public void push(int val) {
	    s.push(val);
	    System.out.println("Push value" + val);
	    if (auxVal.isEmpty()) {
		auxVal.push(val);
		auxCount.push(1);
	    }
	    else {
		if (val > auxVal.getFirst()) {
		    auxVal.push(val);
		    auxCount.push(1);
		} else if (val == auxVal.getFirst()) 
		    auxCount.push(auxCount.pop() + 1);
	    }
	}
	
	public int pop() {
	    if (s.isEmpty())
		throw new RuntimeException("pop from an empty stack");
	    
	    int retVal = s.pop();
	    if (retVal == auxVal.getFirst()) {
		auxCount.push(auxCount.pop() + 1);
		if (auxCount.getFirst() == 0) auxCount.pop();
	    }
	    return retVal;
	}
	
	public int max() {
	    if (s.isEmpty())
		throw new RuntimeException("max from an empty stack");

	    return auxVal.getFirst();
	}
    }

    public static void main (String[] args) {
	Stack s1 = new Stack();
	try {
	    s1.push(4);
	    System.out.println("Max value" + s1.max());
	    s1.push(5);
	    System.out.println("Max value" + s1.max());
	    s1.push(3);
	    System.out.println("Max value" + s1.max());
	    s1.push(7);
	    System.out.println("Max value" + s1.max());
	    s1.push(9);
	    System.out.println("Max value" + s1.max());
	    s1.push(11);
	    System.out.println("Max value" + s1.max());
	    s1.push(10);
	    System.out.println("Max value" + s1.max());
	    s1.push(11);
	    System.out.println("Max value" + s1.max());
	} catch (RuntimeException e) {
	    System.out.println(e.getMessage());
	}
    }

}
