/*Given two sorted LinkedList merge them

Method:
	1. Take two pointers p and q and set at head of list1 and list 2 respectively
	2. Take two pointers head and tail and set to null initially
	3. Compare p and q and set tail to refer who ever is lessor. If head is null set head to tail.
	4. Set p to next element if p was lessor other wise set q to next element
	5. Iterate till both p and q are not null
	6. Once out of loop set rest of the elements for list1 or list 2 whoever has more elements
	
Time Complexity: O(n)
Space Complexity: O(1)*/

package shadab.programs.linkedList;

import shadab.ds.linkedlist.MyLinkedList;
import shadab.ds.linkedlist.Node;

public class MergeTwoSortedLinkedList {
	
	public Node<Integer> mergeLinkedLists(MyLinkedList list1, MyLinkedList list2) {
		Node<Integer> head = null, p, q, tail = null;
		p = list1.getHead();
		q = list2.getHead();
		
		while(p!=null && q!= null) {
			if(p.getType() < q.getType()){
				if(head == null){
					head = tail = p;
				}else{
					tail.setNext(p);
					tail = p;
				}
				//Set p to next position
				p = p.getNext();
				
			}else {
				if(head == null){
					head = tail = q;
				}else{
					tail.setNext(q);
					tail = q;
				}
				//Set q to next position
				q = q.getNext();
			}
		}
		
		//Handle case when list 1 is not traversed completely as second one was shorter
		while(p != null){
			tail.setNext(p);
			p = p.getNext();
		}
		//Handle case when list 2 is not traversed completely as firat one was shorter
		while(q != null){
			tail.setNext(q);
			q = q.getNext();
		}
		return head;
	}

	public static void main(String[] args) {
		MergeTwoSortedLinkedList merge = new MergeTwoSortedLinkedList();
		
		MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
		list1.addToFirst(90);
		list1.addToFirst(70);
		list1.addToFirst(50);
		list1.addToFirst(30);
		list1.addToFirst(20);
		list1.addToFirst(10);
		list1.printList();
		
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		list2.addToFirst(100);
		list2.addToFirst(60);
		list2.addToFirst(30);
		list2.addToFirst(0);
		list2.printList();
		
		Node<Integer> headMergedList = merge.mergeLinkedLists(list1, list2);
		Node<Integer> current = headMergedList;
		while(current != null){
			System.out.print(current.getType() + "->");
			current = current.getNext();
		}
	}

}
