package shadab.programs.queue;

import java.util.Arrays;

class PriorityQueue {
    /*
        Implement a priority queue
        Input: 10, 50, 20, 30, 40
        Queue: 10, 20, 30, 40, 50
     */
    private int[] items;
    private int count;
    private int first;
    //private int last;

    public PriorityQueue() {
        items = new int[10];
    }

    private boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int item) {
        if(isFull()) {
            throw new IllegalStateException();
        }

        if (isEmpty()){
            items[first] = item;
            count++;
            return;
        }

        //Shift items left
        int i;
        for (i=first+count-1; i>=first; i--) {
            if (item < items[i]) {
                items[i+1] = items[i];
            } else {
                break;
            }
        }

        //Insert item
        items[i+1] = item;

        count++;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        int item = items[first];
        items[first++] = 0;
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}

public class PriorityQueueImplementation {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
//        priorityQueue.dequeue();    //IllegalStateException
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(30);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(40);
        priorityQueue.enqueue(50);
        priorityQueue.enqueue(20);
        System.out.println(priorityQueue);
        priorityQueue.dequeue();
        priorityQueue.dequeue();
        priorityQueue.dequeue();
        System.out.println(priorityQueue);
        priorityQueue.enqueue(45);
        priorityQueue.enqueue(55);
        System.out.println(priorityQueue);
        priorityQueue.dequeue();
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue);
        priorityQueue.dequeue();
        priorityQueue.dequeue();
        System.out.println(priorityQueue);
        priorityQueue.dequeue();
        System.out.println(priorityQueue);
//        priorityQueue.dequeue();    //IllegalStateException
    }



}
