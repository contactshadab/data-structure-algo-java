/*
 Given an unsorted linkedlist, remove duplicates
Method 1:
	1. Traverse the linked list. Keep two pointers prev and current
	2. If prev.data == current.data then do nothing just continue the loop with current = current.next
	3. Else set prev.next = current. Reset prev to current
	
	Time Complexity: O(n)
	Space Complexity: O(1)

Method 2:
	Use Nested loop
	For each node traverse from its next till end
	If duplicate element is found, remove it
	
	Time Complexity: O(n^2)
	Space Complexity: O(1)
*/

package shadab.programs.linkedList;

public class RemoveDuplicatesFromSortedLinkedList {
	
	private class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	
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
	}
	
	public void removeDuplicates() {
		if(head == null)
			return;
		
		Node prev = head;
		Node current = head;
		while(current.next != null){
			current = current.next;
			if(prev.data != current.data){
				prev.next = current;
				//Reset prev
				prev = current;
			}
		}
	}
	
	public void display() {
		Node current = head;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedLinkedList linkedList = new RemoveDuplicatesFromSortedLinkedList();
		linkedList.add(10);
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(20);
		linkedList.add(20);
		linkedList.add(40);
		linkedList.display();
		linkedList.removeDuplicates();
		linkedList.display();
	}

}
