import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T>{
	
	private Node<T> first;
	private int n;//size
	
	private static class Node<T>{
		private T data;
		private Node<T> next;
	}
	
	public Stack(){
		first=null;
		n=0;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return n;
	}
	
	public void push(T data){
		Node<T> temp_first=first;
		first=new Node<T>();
		first.data=data;
		first.next=temp_first;
		n++;
	}
	
	public T pop(){
		if(isEmpty()) throw new NoSuchElementException();
		T data=first.data;
		first=first.next;
		n--;
		return data;
	}
	
	public T peek(){
		if(isEmpty()) throw new NoSuchElementException();
		else return first.data;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyStackIterator();
	}
	
	public class MyStackIterator implements Iterator<T>{
		private Node<T> current;
		
		public MyStackIterator() {
			current=first;
		}
		@Override
		public boolean hasNext() {
			return current !=null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T data=current.data;
			current=current.next;
			return data;
		}
		
	}
}
