package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

	class Node<E> {

		Node<E> next;
		E data;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int currentSize;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.currentSize = 0;
	}

	/**
	 * Adds a new data to start of the list
	 * @param data the data to be added
	 */
	@Override
	public void addFirst(E data) {
		Node<E> node = new Node<>(data);
		node.next = head;
		head = node;

		// set tail node of the list
		if(tail == null)
			tail = head;

		currentSize++;
	}

	/**
	 * Adds a new data to end of the list
	 * @param data the data to be added
	 */
	@Override
	public void addLast(E data) {
		Node<E> node = new Node<>(data);
		currentSize++;

		// empty boundary condition
		if(head == null) {
			head = tail = node;
			return;
		}

		tail.next = node;
		tail = node;
	}

	/**
	 * Removes the data from start of the list
	 * @return the data to be removed
	 */
	@Override
	public E removeFirst() {
		// empty boundary condition
		if (head == null)
			return null;

		Node<E> tmpNode = head;
		currentSize--;

		// single element boundary condition
		if(head == tail) {
			head = tail = null;
			return tmpNode.data;
		}

		head = head.next;

		return tmpNode.data;
	}

	/**
	 * Removes the last data of the list
	 * @return the data to be removed
	 */
	@Override
	public E removeLast() {

		// empty boundary condition
		if(head == null)
			return null;

		Node<E> previouseNode = null;
		Node<E> currentNode = head;
		currentSize--;

		// single element boundary condition
		if(head == tail)
			return removeFirst();

		// to find previous node of tail
		while (currentNode != tail) {
			previouseNode = currentNode;
			currentNode = currentNode.next;
		}

		// old tail is garbage collected
		previouseNode.next = null;
		tail = previouseNode;

		return currentNode.data;
	}

	/**
	 * Removes Node from list according to specified data
	 * @param data the data to be removed
	 * @return
	 */
	@Override
	public E remove(E data) {
		Node<E> previousNode = null;
		Node<E> currentNode = head;

		while (currentNode != null) {
			if(((Comparable<E>)currentNode.data).compareTo(data) == 0) {

				if(currentNode == head) return removeFirst();
				if(currentNode == tail) return removeLast();

				currentSize--;
				previousNode.next = currentNode.next;
				return currentNode.data;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		return null;
	}

	/**
	 * Returns the data of head node in the list, if the list is empty returns null
	 * @return the data of the head node
	 */
	@Override
	public E peekFirst() {
		if(head == null)
			return null;

		return head.data;
	}

	/**
	 * Returns the data of tail node in the list, if the list is empty returns null
	 * @return the data of the tail node
	 */
	@Override
	public E peekLast() {
		if(head == null)
			return null;

		return tail.data;
	}

	/**
	 * Checks the list for specified data is contain in list or not
	 * @param data the data for contain in list
	 * @return if the data is contain in the list returns true, otherwise returns false
	 */
	@Override
	public boolean contains(E data) {
		Node<E> current = head;

		while (current != null) {
			if(((Comparable<E>)current.data).compareTo(data) == 0) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * The iterator of the structures.LinkedList
	 * @return
	 */
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	class LinkedListIterator implements Iterator<E> {

		private Node<E> nextNode;

		public LinkedListIterator() {
			this.nextNode = head;
		}

		/**
		 * Checks the iterator has next elements
		 * @return if iterator has next element returns true, otherwise returns false
		 */
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		/**
		 * Gets the data of the next node
		 * @return the data of the next node if it has
		 */
		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();

			E data = nextNode.data;
			nextNode = nextNode.next;
			return data;
		}
	}

}
