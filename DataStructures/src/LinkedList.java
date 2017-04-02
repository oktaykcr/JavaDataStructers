import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
	
	private static class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data,Node<T> next){
			this.data=data;
			this.next=next;
		}
	}
	private Node<T> head;
	public LinkedList(){
		head=null;
	}
	public boolean isEmpty(){
		if(head==null) return true;
		else return false;
	}
	public void addFirst(T item){
		head=new Node<T>(item,head);
	}
	public void addLast(T item){
		if(isEmpty()) addFirst(item);
		else{
			Node<T> temp=head;
			while(temp.next!=null) temp=temp.next;
			temp.next=new Node<T>(item,null);
		}
	}
	public void insertAfter(T key,T toInsert){
		Node<T> temp=head;
		while(temp!=null && !(temp.data.equals(key))){
			temp=temp.next;
		}
		if(temp!=null) temp.next=new Node<T>(toInsert,temp.next);
	}
	public void insertBefore(T key,T toInsert){
		if(isEmpty()) return;
		if(head.data.equals(key)){
			addFirst(toInsert);
			return;
		}
		Node<T> prev=null;
		Node<T> cur=head;
		while(cur!=null && !(cur.data.equals(key))){
			prev=cur;
			cur=cur.next;
		}
		if(cur!=null) prev.next=new Node<T>(toInsert,cur);
	}
	public Node<T> searchNode(T key){
		Node<T> temp=head;
		while(temp!=null){
			if(temp.data.equals(key)) return temp;
			temp=temp.next;
		}
		return null;
	}
	public void remove(Node<T> n){
		T key=n.data;
		if(isEmpty()) return;
		if(head.data.equals(key)){
			head=head.next;//head=null;
			return;
		}
		Node<T> cur=head;
		Node<T> prev=null;
		while(cur!=null && !(cur.data.equals(key))){
			prev=cur;
			cur=cur.next;
		}
		if(cur==null) return;//because prev.next=null
		prev.next=cur.next;//prev.next=null;
	}
	public LinkedList<T> reverse(){
		LinkedList<T> list=new LinkedList<T>();
		Node<T> temp=head;
		while(temp!=null){
			list.addFirst(temp.data);
			temp=temp.next;
		}
		return list;
	}
	public Object copy(){
		LinkedList<T> twin=new LinkedList<T>();
		Node<T> temp=head;
		while(temp!=null){
			twin.addFirst(temp.data);
			temp=temp.next;
		}
		return twin.reverse();
	}
	public void printData(){
		Node<T> temp=head;
		while(temp!=null){
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.print("NULL");
	}
	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator();
	}
	
	public class MyLinkedListIterator implements Iterator<T>{
		private Node<T> nextNode;
		public  MyLinkedListIterator() {
			nextNode=head;
		}
		@Override
		public boolean hasNext() {
			/*if(nextNode!=null) return true;
			else return false;*/
			return nextNode!=null;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			else{
				T data=nextNode.data;
				nextNode=nextNode.next;
				return data;
			}
		}

	}

}
