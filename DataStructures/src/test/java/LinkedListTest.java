import org.junit.Assert;
import org.junit.Test;
import structures.LinkedList;

public class LinkedListTest {

    @Test
    public void addFirst_shouldBeSuccess() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        Assert.assertEquals(3, (int) linkedList.peekFirst());
    }

    @Test
    public void addLast_shouldBeSuccess() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        Assert.assertEquals(3, (int) linkedList.peekLast());
    }

    @Test
    public void removeFirst_shouldBeSuccess() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        Integer removedData = linkedList.removeFirst();

        Assert.assertEquals(1, (int) removedData);
        Assert.assertEquals(2, (int) linkedList.peekFirst());
    }

    @Test
    public void removeLast_shouldBeSuccess() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        Integer removedData = linkedList.removeLast();

        Assert.assertEquals(3, (int) removedData);
        Assert.assertEquals(2, (int) linkedList.peekLast());
    }

    @Test
    public void remove_shouldBeSuccess() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);

        Integer removedData = linkedList.remove(3);

        boolean isRemoved = true;

        for(Integer i : linkedList) {
            if(i.equals(removedData)) {
                isRemoved = false;
            }
        }

        Assert.assertTrue(isRemoved);
    }

    @Test
    public void contains_shouldBeSuccess() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        linkedList.addFirst(2);

        Assert.assertTrue(linkedList.contains(1));
        Assert.assertTrue(linkedList.contains(2));
        Assert.assertFalse(linkedList.contains(3));
    }

}
