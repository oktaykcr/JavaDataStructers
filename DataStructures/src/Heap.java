
public class Heap<T extends Comparable<T>> {
	private static final int CAPACITY=100;
	private int size;//number of elements in heap
	private  T[] heap;//the heap array
	
	public Heap(){
		size=0;
		heap=(T[]) new Comparable[CAPACITY];
	}
	
	public Heap(T[] array){
		size=array.length;
		heap=(T[]) new Comparable[array.length+1];
		System.arraycopy(array,0,heap,1,array.length);//heap index start 1
	}
	
	public void insert(T data){
		if(size>=heap.length) return;
		
		int pos=++size;//insert new data to end of the array
		
		//Percolate up
		while(pos>1 && data.compareTo(heap[pos/2])<0){
			heap[pos]=heap[pos/2];
			pos=pos/2;
		}
		heap[pos]=data;
	}
	public T deleteMin(){
		if(size==0) throw new RuntimeException();
		T min=heap[1];
		heap[1]=heap[size--];
		percolateDown(1);
		return min;
	}
	
	public void percolateDown(int k){
		T tmp = heap[k];
		int child;
		for (; 2 * k <= size; k = child) {
		child = 2 * k;
		//choose smallest of the two childs
		if (child != size && heap[child].compareTo(heap[child + 1]) > 0)
		child++;
		if (tmp.compareTo(heap[child]) > 0)
		heap[k] = heap[child];
		else
		break;
		}
		heap[k] = tmp;
	}
	public void displayHeap(){
		for(int i=1;i<=size;i++)System.out.print(heap[i]+" - ");
		System.out.println();
		for(int i=1;i<=size;i++)System.out.print(i+" - ");	
	}
	
}
