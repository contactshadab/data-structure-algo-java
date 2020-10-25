package dataStructure.queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackWithTwoQueues {

    /*
        10 20 30 40 50
        1:  Q1: 10 20 30
            Q2:

        2: Q1:
           Q2:

        3: Q1:
           Q2: 10 20 40

        4: Q1:
           Q2: 10 20 40 50
     */

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    int top;

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    //O(1)
    public void push(int item) {
        getNonEmptyQueue().add(item);
        top = item;
    }

    //O(1)
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return top;
    }

    private Queue<Integer> getNonEmptyQueue() {
        return queue1.isEmpty()? queue2: queue1;
    }

    private Queue<Integer> getEmptyQueue() {
        return queue1.isEmpty()? queue1: queue2;
    }

    //O(1)
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Queue<Integer> nonEmptyQueue = getNonEmptyQueue();
        Queue<Integer> emptyQueue = getEmptyQueue();
        while (nonEmptyQueue.size() > 1) {
            top = nonEmptyQueue.remove();
            emptyQueue.add(top);
        }

        return nonEmptyQueue.remove();
    }

    //O(1)
    public int size() {
        return getNonEmptyQueue().size();
    }

    //O(n)
    public String toString() {
        Queue<Integer> queue = queue1.isEmpty()? queue2: queue1;
        return queue.toString();
    }

    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        //stack.pop();    //NoSuchElementException
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push(40);
        stack.push(50);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
        //stack.pop();    //NoSuchElementException
    }
}
