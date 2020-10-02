package shadab.programs.array;

class MyArrayQueue {
    private int[] arr;
    private int front = 0;
    private int back = 0;
    private int count;

    public MyArrayQueue(int size) {
        arr = new int[size];
    }

    public boolean isFull() {
        return count == arr.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue (int item) {
        if (isFull()) {
            throw new StackOverflowError();
        }

        arr[back] = item;
        count++;
        back = (back + 1) % arr.length;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw  new IllegalStateException();
        }

        int item = arr[front];
        count--;

        front = (front + 1) % arr.length;

        return item;
    }

    public int peek(){
        if (isEmpty()) {
            throw  new IllegalStateException();
        }

        return arr[front];
    }

    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int i = front;
        while (i != back) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % arr.length;
        }
        System.out.println("");
    }
}

public class ImplementQueueUsingArray {
    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue(5);

        //System.out.println(queue.dequeue());     IllegalStateException
        //System.out.println(queue.peek()); IllegalStateException

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.display();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println(queue.peek());

        queue.enqueue(-100);
        queue.display();

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.display();
        System.out.println(queue.dequeue());
        queue.display();
        System.out.println(queue.dequeue());
        queue.display();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.display();

        queue.enqueue(60);
        queue.enqueue(80);
        queue.display();

        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        //queue.display(); IllegalStateException
        //System.out.println(queue.peek()); IllegalStateException
        //System.out.println(queue.dequeue());  IllegalStateException
    }
}
