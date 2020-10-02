package shadab.programs.queue;

import java.util.NoSuchElementException;

class Node {
    int value;
    Node next;

    public Node(int value){
        this.value = value;
    }
}

public class QueueUsingLinkedList {

    Node head;
    Node tail;
    int count;

    // O(1)
    public void enqueue(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    // O(1)
    public int dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        Node originalHead = head;
        head = head.next;
        originalHead.next = null;
        count--;
        return originalHead.value;
    }

    // O(1)
    public int peek() {
        return head.value;
    }

    // O(1)
    public int size() {
        return count;
    }

    // O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    // O(n)
    public void display() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        System.out.println(queue.isEmpty() + " " + queue.size());
//        queue.dequeue(); //NoSuchElementException
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.isEmpty() + " " + queue.size());
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.display();
        queue.enqueue(60);
        queue.enqueue(70);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.display();
        queue.dequeue();
//        queue.display();    //NoSuchElementException
//        queue.dequeue();     //NoSuchElementException

    }


}
