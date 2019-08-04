import java.util.Stack;

public class n232_Implement_Queue_using_Stacks_Solution2 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackTemp = new Stack<>();
    private int front = 0;

    //使用front变量来保存栈顶元素
    /** Initialize your data structure here. */
    public n232_Implement_Queue_using_Stacks_Solution2() {}

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()) {
            front = x;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackTemp.isEmpty()){
            while(!stack.isEmpty()) {
                stackTemp.push(stack.pop());
            }
        }
        return stackTemp.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stack.isEmpty()) {
            return front;
        }
        return stackTemp.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && stackTemp.isEmpty();
    }
}
