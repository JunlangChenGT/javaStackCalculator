package h08;



/* 
 * a stack implemented using a linked list
 * @author	Biagioni, Edoardo
 * @assignment	lecture 7
 * @date	February 4, 2008
 */

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInterface<E> {
	// the stack is stored in linked nodes

	/** 
	 * A node in a singly-linked list
	 * @author         Edo Biagioni
	 * @lecture        ICS 211 Jan 27 or later
	 * @date           January 26, 2010
	 * @bugs           private class: include this code within a larger class
	 */

	private static class LinkedNode<T> {
		private T item;
		private LinkedNode<T> next;


		/** 
		 * constructor to build a node with no successor
		 * @param the value to be stored by this node
		 */
		private LinkedNode(T value) {
			item = value;
			next = null;
		}


		/** 
		 * constructor to build a node with a specified (perhaps null) successor
		 * @param the value to be stored by this node
		 * @param the next field for this node
		 */
		private LinkedNode(T value, LinkedNode<T> reference) {
			item = value;
			next = reference;
		}
	}

	protected LinkedNode<E> top;

	/* no-arguments default constructor creates an empty stack */
	public LinkedStack() {
		top = null;		// empty stack
		checkInvariants();
	}

	/* @return	whether the stack is empty */
	public boolean empty() {
		return (top == null);
	}

	/* @param	value to push onto the stack */
	public E push(E value) {
		checkInvariants();
		top = new LinkedNode<E>(value, top);
		checkInvariants();
		return value;
	}

	/* @return	the top value on the stack */
	public E pop() throws EmptyStackException 
	{
		checkInvariants();
		if (empty()) {
			throw new EmptyStackException();
		}
		E result = top.item;
		top = top.next;
		checkInvariants();
		return result;
	}

	/* @return	the top value on the stack */
	public E peek() throws EmptyStackException 
	{
		checkInvariants();
		if (empty()) {
			throw new EmptyStackException();
		}
		return top.item;
	}

	/* convert the stack to a printable string
	 * @return	a string representing the stack
	 */
	public String toString() 
	{
		checkInvariants();
		if (empty()) {
			return "Empty Stack";
		} else {
			return recursiveToString(top);
		}
	}

	/* recursive method to print a non-empty stack
	 * @param	the starting index in the array
	 * @return	a string representing the stack
	 */
	private String recursiveToString(LinkedNode<E> startNode) {
		if (startNode == null) {
			return "";
		}
		String separator = "";
		if (startNode != top) {  // add :: after each item (but not at start)
			separator = " :: ";
		}
		return separator + startNode.item + recursiveToString(startNode.next);
	}
	
	public void checkInvariants()
	{
		//1+ invariant
		if(empty() != (top == null))
		{
			throw new java.lang.AssertionError("empty but not null or vice versa");
		}
	}

	// simple test
	public static void main(String[] args) {
		StackInterface<String> s = new ArrayStack<String>();

		System.out.println("before pushing anything, " + s);
		s.push("hello");
		s.push("world");
		System.out.println("after pushing hello and world, " + s);
		System.out.println("pop returns " + s.pop());
		System.out.println("after popping, " + s);
		StackInterface<Integer> si = new ArrayStack<Integer>();
		// push 100 values
		for (int i = 0; i < 100; i++) {
			si.push(i);
		}
		// now pop them and make sure the same values are returned
		// in LIFO order
		for (int i = 99; i >= 0; i--) {
			Integer returned = si.pop();
			if (! returned.equals(i)) {
				System.out.println("error: pop returns " + returned +
						", expected " + i);
			}
		}
		s.push("a");
		s.push("beautiful");
		s.push("day");
		System.out.println("after pushing 'a beautiful day', " + s);
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("after popping, " + s);
		/* expected output:
		 * before pushing anything, Empty Stack
		 * after pushing hello and world, hello :: world
		 * pop returns world
		 * after popping, hello
		 * after pushing 'a beautiful day', hello :: a :: beautiful :: day
		 * pop returns day
		 * pop returns beautiful
		 * pop returns a
		 * pop returns hello
		 * after popping, Empty Stack
		 */

	}
}

