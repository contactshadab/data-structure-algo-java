package shadab.programs.array;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    /*
        Write a program to reverse a queue
        Input: Queue (10 20 30)
        Output: Queue (30 20 10)
        Complexity: O(n)
     */

    public Queue<Integer> reverse(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            throw new IllegalStateException();
        }

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println((new ReverseQueue()).reverse(queue));
    }
}
