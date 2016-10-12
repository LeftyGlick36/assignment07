package assignment07;

import java.util.NoSuchElementException;

import assignment06.DoublyLinkedList;

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

	private DoublyLinkedList<E> stack;

	public LinkedListStack() {
		stack = new DoublyLinkedList<E>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear() {

		while (stack.size() > 0) {
			stack.clear();
		}
	}

	/**
	 * Returns true if the stack contains no elements.
	 */
	public boolean isEmpty() {
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. Throws NoSuchElementException if the stack is empty.
	 */
	public E peek() throws NoSuchElementException {
		emptyStack();
		return stack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack. Throws
	 * NoSuchElementException if the stack is empty.
	 */
	public E pop() throws NoSuchElementException {
		emptyStack();
		return stack.removeFirst();
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) {
		stack.addFirst(item);
	}

	/**
	 * Returns the number of items in the stack.
	 */
	public int size() {
		return stack.size();
	}

	private void emptyStack() {
		if (stack.isEmpty()) {
			throw new NoSuchElementException();
		}
	}
}