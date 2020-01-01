import org.junit.Assert;
import org.junit.Test;
import structures.Stack;

public class StackTest {

    @Test
    public void push_shouldBeSuccess() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(3, (int) stack.peek());
    }

    @Test
    public void pop_shouldBeSuccess() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer popData = stack.pop();

        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(2, (int) stack.peek());
        Assert.assertEquals(3, (int) popData);
    }

}
