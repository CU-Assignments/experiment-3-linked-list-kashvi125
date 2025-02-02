import java.util.Stack;

public class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // Pushes element x to the back of the queue.
    public void push(int x) {
        inputStack.push(x);
    }

    // Removes the element from the front of the queue and returns it.
    public int pop() {
        if (outputStack.isEmpty()) {
            // Transfer all elements from inputStack to outputStack
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    // Returns the element at the front of the queue.
    public int peek() {
        if (outputStack.isEmpty()) {
            // Transfer all elements from inputStack to outputStack
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    // Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
