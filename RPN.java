import java.util.LinkedList;
import java.io.*;

public class RPN {

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
	String[] symbols = args[0].split(",");
	Stack s = new Stack();
	int len = symbols.length;
	System.out.println("length of the input string" + len);
	int i = 0, n1 = 0, n2 = 0;
	while (i < len) {
	    String symbol = symbols[i];
	    
	    if (symbol.length() == 1 && !"+-x/".contains(symbol) && !Character.isDigit(symbol.toCharArray()[0])) 
		throw new IllegalArgumentException("Malformed RPN with the following symbol " + symbol);

	    if (symbol.length() == 1 && "+-x/".contains(symbol)) {
		n1 = s.pop();
		n2 = s.pop();
		switch(symbol.charAt(0)) {
		case '+':
		    s.push(n2 + n1);
		    break;
		case '-':
		    s.push(n2 - n1);
		    break;
		case 'x':
		    s.push(n2 * n1);
		    break;
		case '/':
		    s.push(n2 / n1);
		    break;
		}
	    } else {
		System.out.println("Pushing Integer");
		s.push(Integer.parseInt(symbol));
	    }
	    i++;
	}
	System.out.println("Final value = " + s.pop());
    }

}
