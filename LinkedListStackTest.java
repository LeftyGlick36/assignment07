package assignment07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedListStackTest {
	LinkedListStack<Integer> list = new LinkedListStack<>();

	@Before
	public void setUp() throws Exception {
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.push(7);
		list.push(8);
		list.push(9);
		list.push(10);
	}

	@Test
	public void testLinkedListStack() {

	}

	@Test
	public void testClear() {
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testIsEmpty() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testPeek() {
		int item = list.peek();
		assertEquals(10, item);

	}

	@Test(expected = NoSuchElementException.class)
	public void testPeekNoSuchElement() {
		list.clear();
		list.peek();
	}

	@Test
	public void testPop() {
		int item = list.pop();
		int peekedItem = list.peek();
		assertEquals(10, item);
		assertEquals(9, peekedItem);

	}

	@Test(expected = NoSuchElementException.class)
	public void testPopNoSuchElement() {
		list.clear();
		list.pop();

	}

	@Test
	public void testPush() {
		list.push(500);
		int topOfTheStack = list.pop();
		assertEquals(500, topOfTheStack);
	}

	@Test
	public void testSize() {
		assertEquals(10, list.size());
	}

}
