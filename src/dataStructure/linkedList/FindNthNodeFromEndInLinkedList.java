/*Given a LinkedList, find nth node from end
Method:
	1. Take two ponters p and q at the start of LinkedList
	2. Move p to n-1 places
	3. Move both p and q by 1 place till p.next = null
	4. q is at n-1th place from end

Time Complexity: O(n)
Space Complexity: O(1)*/
	

package dataStructure.linkedList;

public class FindNthNodeFromEndInLinkedList {
	
	private class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	private int size;
	
	public void add(int data) {
		Node node = new Node(data);
		if(head == null){
			head = node;
		}else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = node;
		}
		size++;
	}
	
	public void display() {
		Node current = head;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("");
	}
	
	public int findNodeFromEnd(int n){
		
		if(n<0 || n > size)
			throw new IndexOutOfBoundsException();
		
		Node p = head, q = head;
		//Move p by n-1 place
		for(int i=0; i<n-1; i++)
			p = p.next;
		
		//Move both p and q by 1 place till p reached end
		while(p.next != null){
			p = p.next;
			q = q.next;
		}
		
		return q.data;
	}
	
	
	
	public static void main(String[] args) {
		FindNthNodeFromEndInLinkedList linkedList = new FindNthNodeFromEndInLinkedList();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		linkedList.display();
		int data = linkedList.findNodeFromEnd(6);
		System.out.println(data);
	}

}
