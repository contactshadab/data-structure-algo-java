package dataStructure.queue;

import java.util.Stack;

class Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int first;
    private int firstInStack1;

    public void enqueue (int item) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            first = item;
            firstInStack1 = item;
        } else if (stack1.isEmpty()) {
            firstInStack1 = item;
        }
        stack1.push(item);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            throw new IllegalStateException();
        }

        if (stack2.isEmpty()){
            //Move items from stack 1 to stack 2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int item = stack2.pop();
        first = stack2.isEmpty()? firstInStack1: stack2.peek();
        return item;
    }

    public int peek() {
        if (stack1.isEmpty() & stack2.isEmpty()){
            throw new IllegalStateException();
        }

        return first;
    }

    @Override
    public String toString() {
        return stack1.toString();
    }
}

public class ImplementQueueUsingStack {

    public static void main(String[] args) {
        Queue queue = new Queue();
        //System.out.println(queue.peek()); IllegalStateException
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        //System.out.println(queue.peek()); IllegalStateException
        //queue.dequeue();  IllegalStateException
    }

}
