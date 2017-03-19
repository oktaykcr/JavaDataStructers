import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> myList=new LinkedList<String>();
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
		}
		
	}

}
