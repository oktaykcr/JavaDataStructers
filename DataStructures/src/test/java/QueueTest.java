import org.junit.Assert;
import org.junit.Test;
import structures.Queue;

public class QueueTest {

    @Test
    public void enqueue_shouldBeSuccess() {
        Queue<Integer> queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(1, (int) queue.peek());
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void dequeue_shouldBeSuccess() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Integer dequeueData = queue.dequeue();

        Assert.assertEquals(1, (int) dequeueData);
        Assert.assertEquals(2, queue.size());
    }
}
