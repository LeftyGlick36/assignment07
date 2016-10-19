package assignment07;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Represents a generic stack (first in, last out).
 * 
 * Stack is a particular kind of abstract data type or collection in which the
 * principal (or only) operations on the collection are the addition of an
 * entity to the collection, known as push and removal of an entity, known as
 * pop. It is known as Last-In-First-Out (LIFO) data structure.
 * 
 * In our visualization, Stack is basically a protected Single Linked List where
 * we can only search the head item (peek), insert new item to the head (push),
 * and remove existing item from the head (pop). All operations are O(1).
 * 
 * For Stack, you can only peek/restricted-search, push/restricted-insert, and
 * pop/restricted-remove from the top/head.
 * 
 * @author ??
 * 
 * @param <E>
 *            -- the type of elements contained in the stack
 */
public class LinkedListStack<E> {

	private LinkedList<E> stack;

	public LinkedListStack() {
		stack = new LinkedList<E>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear() {

		stack.clear();
	}

	/**
	 * Returns true if the stack contains no elements.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. Throws NoSuchElementException if the stack is empty.
	 */
	public E peek() throws NoSuchElementException {
		return stack.peek();
	}

	/**
	 * Returns and removes the item at the top of the stack. Throws
	 * NoSuchElementException if the stack is empty.
	 */
	public E pop() throws NoSuchElementException {
		return stack.pop();
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) {
		stack.push(item);
	}

	/**
	 * Returns the number of items in the stack.
	 */
	public int size() {
		return stack.size();
	}
}