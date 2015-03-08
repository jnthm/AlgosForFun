import java.io.*;
import java.util.*;

public class LinkedListOps {

    private class Node {
	int val;
	Node next;

	private Node(int n){
	    val = n;
	    next = null;
	}
    }

    private static Node detectCycles(Node L) {
	Node fastPtr = L, slowPtr = L;
	while (slowPtr != null && fastPtr.next != null) {
	    slowPtr = slowPtr.next;
	    fastPtr = fastPtr.next.next;
	    if ( slowPtr == fastPtr)
		return slowPtr;
	}
	return null;
    }
    
    public static Node evenOddMergeList (Node L) {
	Node even = L, odd = null, oddHead = null;
	if (L != null && L.next != null) {
	    odd = even.next;
	    oddHead = odd;
	}
	else return L;

	while (odd.next != null) {
	    even.next = odd.next;
	    even = even.next;
	    odd.next = (even.next != null) ? even.next : null;
	    odd = odd.next;
	    if (odd == null) break;
	}
	even.next = oddHead;
	return L;
    }

    private static int getListCount(Node L) {
	int c = 0; Node head = L;
	
	while (head != null) {
	    head = head.next;
	    c++;
	}
	return c;
    }

    private static Node reverseListIter(Node L) {
	Node runningNode = L, prevNode = null, nextNode = null;
	
	while (runningNode != null) {
	    nextNode = runningNode.next;
	    runningNode.next = prevNode;
	    prevNode = runningNode;
	    runningNode = nextNode;
	}
	
	return prevNode;
    }

    public static Node listZip (Node L) {
	Node subListOneHead = L, subListTwoHead = null;
	// find midpoint

	Node slow = L, fast = L, preSlow = null;
	while (fast != null) {
	    fast = fast.next;
	    if (fast != null) {
		fast = fast.next;
		preSlow = slow;
		slow = slow.next;
	    }
	}

	if (preSlow == null) return L;
	preSlow.next = null;
	subListTwoHead = slow;
	
	// reverse 2nd half
	subListTwoHead = reverseListIter(subListTwoHead);

	// interleave 1st and 2nd halves
	Node currNode1st = subListOneHead, currNode2nd = subListTwoHead, nextcurrNode1st = null, nextcurrNode2nd = null;
	while (currNode1st != null && currNode2nd != null) {
	    nextcurrNode1st = currNode1st.next;
	    nextcurrNode2nd = currNode2nd.next;
	    currNode1st.next = currNode2nd;
	    if (nextcurrNode1st != null) currNode2nd.next = nextcurrNode1st;
	    currNode1st = nextcurrNode1st;
	    currNode2nd = nextcurrNode2nd;
	}

	return L;
    }

    public static Node deDupLinkedList (Node L) {
	Node curr = null, ahead = null, prev = L;
	if (L.next != null) {
	    curr = L.next;
	    ahead = L.next;
	} else return L;
	
	while (ahead != null) {
	    curr.val = ahead.val;
	    if(prev.val != curr.val) {
		prev = curr;
		curr = curr.next;
	    }
	    ahead = ahead.next;
	}
	prev.next = null;
	return L;
    }

    private static Node detectAndReturnOverlapNode(Node L1, Node L2) {
	int len1 = 0, len2 = 0, diffLen = 0, count = 0, bigLen = 0, smallLen = 0;
	Node currNode1 = L1, currNode2 = L2, bigListHead = null, smallListHead = null;
	
	while (currNode1 != null) {
	    len1++;
	    currNode1 = currNode1.next;
	}
	
	currNode2 = L2;
	while (currNode2 != null) {
	    len2++;
	    currNode2 = currNode2.next;
	}

	bigListHead = len1 > len2 ? L1 : L2;
	bigLen = len1 > len2 ? len1 : len2;
	smallLen = len1 > len2 ? len2 : len1;
	smallListHead = len1 > len2 ? L2 : L1;
	diffLen = bigLen - smallLen;
	currNode1 = L1;
	currNode2 = L2;

	while (currNode1 != null && currNode2 != null) {
	    if (currNode1 == currNode2) return currNode1;
	    if (count > diffLen) {
		currNode1 = currNode1.next;
		currNode2 = currNode2.next;
	    } 
	}

	return null;

    }

    public static void main(String[] args) {
	
	LinkedListOps ListOps = new LinkedListOps();
	Node ListHead = null, currNode = null, ListOneHead = null, ListTwoHead = null;
	boolean first = true;
	
	// ==================
	// 1st LIST
	// ==================
	BufferedReader br = null;
	String sCurrLine;
	try {
	br = new BufferedReader(new FileReader("input.txt"));
	while ((sCurrLine = br.readLine()) != null) 
	    if (first) {
		ListOneHead = ListOps.new Node(Integer.valueOf(sCurrLine));
		currNode = ListOneHead;
		first = false;
	    } else {
		Node newNode = ListOps.new Node(Integer.valueOf(sCurrLine));
		currNode.next = newNode;
		currNode = newNode;
	    }
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

	System.out.println("Input-1:");
	currNode = ListOneHead;
	Node tempNode = null, tailNode = null;
	while (currNode != null) {
	    if (currNode.val == 6) 
		tempNode = currNode;
	    if (currNode.next == null) tailNode = currNode;
	    System.out.println(currNode.val);
	    currNode = currNode.next;
	}
	// ==================
	// 2nd LIST
	// ==================
	BufferedReader br2 = null;
	boolean first2 = true;
	String sCurrLine2;
	try {
	br2 = new BufferedReader(new FileReader("input2.txt"));
	while ((sCurrLine2 = br2.readLine()) != null) 
	    if (first2) {
		ListTwoHead = ListOps.new Node(Integer.valueOf(sCurrLine2));
		currNode = ListTwoHead;
		first2 = false;
	    } else {
		Node newNode = ListOps.new Node(Integer.valueOf(sCurrLine2));
		currNode.next = newNode;
		currNode = newNode;
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	finally {
	    try {
		if (br2 != null) br2.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

	System.out.println("Input-2:");
	currNode = ListTwoHead;
	Node tempNode2 = null, tailNode2 = null;
	while (currNode != null) {
	    if (currNode.val == 6) 
		tempNode2 = currNode;
	    if (currNode.next == null) tailNode2 = currNode;
	    System.out.println(currNode.val);
	    currNode = currNode.next;
	}

	// ============
	// Operations
	// ============

	//System.out.println("creating a cycle now...");
	//tailNode.next = tempNode;
	//currNode = detectCycles(ListOneHead);
	
	

	/*
	if (currNode == null) System.out.println("No cycles detected");
	else System.out.println("Cycle detect at the node with value " + currNode.val);
	*/
	


	System.out.println("Output:");
	currNode = listZip(ListOneHead);
	while (currNode != null) {
	    System.out.println(currNode.val);
	    currNode = currNode.next;
	}

	
    }
}
