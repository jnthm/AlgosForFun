import java.util.LinkedList;


public class QueWithMax {

    public static class queWithMax<T extends Comparable<T>> {

	LinkedList<T> q = null;
	LinkedList<T> deq = null;

	public queWithMax() {
	    q = new LinkedList<T>();
	    deq = new LinkedList<T>();
	}
	
	public void enqueue(T in) {
	    q.addLast(in);
	    while(!deq.isEmpty() && in.compareTo(deq.peekLast()) > 0) 
		deq.removeLast();
	    deq.addLast(in);
	}

	public T dequeue() {
	    T retVal = q.remove();
	    if (retVal.compareTo(deq.element()) == 0)
		deq.remove();
	    return retVal;
	}

	public int size() {
	    return q.size();
	}

	public T max() {
	    if (!deq.isEmpty())
		return deq.element();
	    else 
		throw new RuntimeException("max from empty queue!");
	}

    }

    public static void main(String[] args) {

	queWithMax<Integer> q = new queWithMax<Integer>();
	q.enqueue(4);
	System.out.println("max = 4? " + q.max());
	q.enqueue(11);
	System.out.println("max = 11? " + q.max());
	q.enqueue(7);
	System.out.println("max = 11? " + q.max());
	q.enqueue(6);
	System.out.println("max = 11? " + q.max());
	q.enqueue(3);
	System.out.println("max = 11? " + q.max());

	q.dequeue();
	System.out.println("max = 11? " + q.max());
	q.dequeue();
	System.out.println("max = 7? " + q.max());
	q.dequeue();
	System.out.println("max = 6? " + q.max());
    }

}
