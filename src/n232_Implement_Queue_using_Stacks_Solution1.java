import java.util.Stack;

public class n232_Implement_Queue_using_Stacks_Solution1 {

    private Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public n232_Implement_Queue_using_Stacks_Solution1() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }

        Stack<Integer> stackTemp = new Stack<>();
        while(!stack.isEmpty()) {
            stackTemp.push(stack.pop());
        }
        stack.push(x);
        while(!stackTemp.isEmpty()) {
            stack.push(stackTemp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
