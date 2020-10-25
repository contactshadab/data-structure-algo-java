/*
 Given an unsorted linkedlist, remove duplicates
Method 1:
	1. Create a hashtable 
	2. Traverse the linked list.
	3. If current.data is in hashtable 
		a. SET current.data = current.next.data
		b. SET current.next = current.next.next
	
	Time Complexity: O(n)
	Space Complexity: O(n)

Method 2:
	Use Nested loop
	For each node traverse from its next till end
	If duplicate element is found, remove it
	
	Time Complexity: O(n^2)
	Space Complexity: O(1)

Method 3:
	1. Sort the array
	2. Apply algo to remove duplicate from sorted linkedlist
*/

package dataStructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromUnsortedLinkedList {
	
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
		
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		Node prev = head;
		Node current = head;
		while(current!= null){
			int data = current.data;
			//If data is already present in hashtable, it is duplicate
			if(map.containsKey(data)){
				//Remove the current node
				prev.next = current.next;
			}else{
				map.put(data, true);
				prev = current;
			}
			current = current.next;
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
		RemoveDuplicatesFromUnsortedLinkedList linkedList = new RemoveDuplicatesFromUnsortedLinkedList();
		linkedList.add(40);
		linkedList.add(10);
		linkedList.add(40);
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(20);
		linkedList.add(20);
		
		linkedList.display();
		linkedList.removeDuplicates();
		linkedList.display();
	}

}
