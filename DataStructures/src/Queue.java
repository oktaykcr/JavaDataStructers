import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>{
	private Node<T> first;
	private Node<T> last;
	private int n;//number of elements
	private static class Node<T>{
		private T data;
		private Node<T> next;
	}
	
	public Queue(){
		first=null;
		last=null;
		n=0;
	}

	
	public void enqueue(T data) {
		Node<T> last_temp=last;
		last=new Node<T>();
		last.data=data;
		last.next=null;
		if(isEmpty()) first=last;
		else last_temp.next=last;
		n++;
	}

	
	public T dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
		T data=first.data;
		first=first.next;
		n--;
		if(isEmpty())last=null;
		return data;
	}

	
	public T peek() {
		if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
		else return first.data;
	}

	
	public boolean isEmpty() {
		return first==null;
	}

	
	public int size() {
		return n;
	}

	@Override
	public Iterator<T> iterator() {
		return new myLinkedQueueIterator();
	}
	public class myLinkedQueueIterator implements Iterator<T>{
		private Node<T> nextNode;
		public myLinkedQueueIterator() {
			nextNode=first;
		}
		@Override
		public boolean hasNext() {
			return nextNode!=null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T data=nextNode.data;
			nextNode=nextNode.next;
			return data;
		}
		
	}
	
}
