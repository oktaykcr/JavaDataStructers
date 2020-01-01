package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements Iterable<E> {

	class Node<E> {
		E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	private Node<E> head;
	private int size;

	public Stack() {
		size = 0;
	}

	/**
	 * Insert a new data into stack
	 * @param data the data to be added to the stack
	 */
	public void push(E data) {
		Node<E> node = new Node<E>(data);
		size++;

		if(isEmpty()) {
			head = node;
			return;
		}

		node.next = head;
		head = node;
	}

	/**
	 * Removes data from top of the stack
	 * @return removed data from stack
	 */
	public E pop() {
		if(isEmpty()) throw new NoSuchElementException();

		E data = head.data;
		head = head.next;
		size--;

		return data;
	}

	/**
	 * Returns the data of the top of the stack
	 * @return the data of the top node
	 */
	public E peek() {
		if(isEmpty()) throw new NoSuchElementException();
		return head.data;
	}

	/**
	 * Checks the stack is empty or not
	 * @return if the stack is empty return true, otherwise returns false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Current size of the stack
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * The iterator of the structures.Stack
	 * @return
	 */
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	class StackIterator implements Iterator<E> {

		private Node<E> current;

		public StackIterator() {
			this.current = head;
		}

		/**
		 * Checks the iterator has next elements
		 * @return if iterator has next element returns true, otherwise returns false
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Gets the data of the next node
		 * @return the data of the next node if it has
		 */
		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();
			E data = current.data;
			current = current.next;
			return data;
		}
	}
}
