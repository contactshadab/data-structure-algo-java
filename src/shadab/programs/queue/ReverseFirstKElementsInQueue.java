package shadab.programs.queue;

import java.util.ArrayDeque;

public class ReverseFirstKElementsInQueue {

    /*
    Queue: 10 20 30 40 50
    k = 3
    Output: 30 20 10 40 50
     */


    public ArrayDeque<Integer> reverse(ArrayDeque<Integer> queue, int count) {
        if (queue.isEmpty() || count < 1 || count > queue.size()) {
            throw new IllegalStateException();
        }

        Integer[] items = new Integer[count];

        //Fill the array with first k items in reverse order
        for (int i=0; i<count; i++) {
            items[count-1-i] = queue.remove();
        }

        //Fill the queue with each item from the temo array. All items are queued to end
        for (int i=0; i<count; i++) {
            queue.add(items[i]);
        }

        //Remove first size-count items from the queue and add to the end
        for (int i=0; i<queue.size()-count; i++) {
            queue.add(queue.remove());
        }

        return queue;
    }

    public static void main(String[] args) {
        ReverseFirstKElementsInQueue queueReverse = new ReverseFirstKElementsInQueue();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        System.out.println(queueReverse.reverse(queue, 1)); //IllegalStateException
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queueReverse.reverse(queue, 2));
        System.out.println(queueReverse.reverse(queue, 2));
//        System.out.println(queueReverse.reverse(queue, 10));    //IllegalStateException
//        System.out.println(queueReverse.reverse(queue, 0));   //IllegalStateException
    }
}
