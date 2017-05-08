import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		//LINKEDLIST PART
		
		/*LinkedList<String> myList=new LinkedList<String>();
		myList.addFirst("First");
		myList.addFirst("Second");
		myList.addFirst("Third");
		myList.addFirst("Fourth");
		myList.addLast("BeforeLast");
		myList.addLast("LastItem");
		myList.addFirst("Fifth");
		myList.insertAfter("Fourth","After fourth");
		myList.insertBefore("Fourth","Before fourth");
		//myList=myList.reverse();
		//myList.printData();
		Iterator<String> ite=myList.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}*/
		
		//QUEUE PART
		/*Queue<Integer> myQueue=new Queue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.dequeue();
		Iterator<Integer> ite=myQueue.iterator();
		while(ite.hasNext()){
			System.out.print("<--"+ite.next());
		}
		System.out.println();
		System.out.println("Peek:"+myQueue.peek());*/
		
		//STACK PART
		/*Stack<Integer> myStack=new Stack<Integer>();
		for(int i=0;i<5;i++){
			myStack.push(i);
		}
		System.out.println("POP:"+myStack.pop());
		System.out.println("PEEK:"+myStack.peek());
		Iterator<Integer> ite=myStack.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
			System.out.println("|");
		}*/
		
		//BINARYTREE PART
		/*BinaryTree<Integer> br=new BinaryTree<Integer>();
		
		//insert
		br.insert(23);
		br.insert(4);
		br.insert(67);
		br.insert(56);
		br.insert(89);
		br.insert(10);
		
		//traversals
		br.preOrder();
		System.out.println();
		br.inOrder();
		System.out.println();
		br.postOrder();
		
		//Finding min in Binary Tree
		System.out.println();
		System.out.println(br.findMin());
		//Finding max in Binary Tree
		System.out.println(br.findMax());
		
		//delete
		System.out.println(br.delete(67));
		br.inOrder();*/
		
		//AVLtree PART
		/*AVLtree tree=new AVLtree();
		tree.insert(95);
		tree.insert(85);
		tree.insert(65);
		tree.insert(45);
		tree.insert(100);
		tree.insert(70);
		tree.insert(10);
		tree.insert(50);
		tree.insert(20);
		tree.inOrder();*/
		
		//HEAP PART
		Heap<Integer> heap=new Heap<>();
		heap.insert(45);
		heap.insert(23);
		heap.insert(2);
		heap.insert(1);
		heap.insert(15);
		
		heap.displayHeap();
		
	}

}
