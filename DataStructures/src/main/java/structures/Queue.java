package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {

	class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Adds data to end of the queue
	 * @param data the data to be added to queue
	 */
	public void enqueue(E data) {
		Node<E> node = new Node<>(data);

		size++;

		// if the queue is empty, new data is both tail and head
		if(isEmpty()) {
			tail = head = node;
			return;
		}

		// add new data to end of the queue and mark as tail
		tail.next = node;
		tail = node;
	}

	/**
	 * Removes the data which in front of the queue
	 * @return removed data from queue
	 */
	public E dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		E data = head.data;
		head = head.next;
		size--;

		// if the queue is empty then tail must be null
		if (isEmpty()) tail = null;

		return data;
	}

	/**
	 * Returns the data of in front of the queue
	 * @return the data in front of the queue
	 */
	public E peek() {
		if(isEmpty()) return null;
		return head.data;
	}

	/**
	 * Current size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks the queue is empty or not
	 * @return if the queue is empty return true, otherwise returns false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * The iterator of the structures.Queue
	 * @return
	 */
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	class QueueIterator implements Iterator<E> {

		private Node<E> current;

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
