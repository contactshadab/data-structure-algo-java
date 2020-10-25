package dataStructure.tree.binarySearchTree;

public class Main {

	public static void main(String[] args) {
		Tree intTree = new Tree();
		intTree.insert(25);
	    intTree.insert(20);
	    intTree.insert(15);
	    intTree.insert(27);
	    intTree.insert(30);
	    intTree.insert(29);
	    intTree.insert(26);
	    intTree.insert(22);
	    intTree.insert(32);
	    intTree.insert(17);
	    
	    intTree.traverseInOrder();
	    System.out.println();
	    
	    intTree.traversePreOrder();
	    System.out.println();
	    
	    intTree.traversePostOrder();
	    System.out.println();
	    
	    System.out.println("Get: " + intTree.get(27));
	    System.out.println("Get invalid: " + intTree.get(999));

	    System.out.println("Min: " + intTree.getMin());
	    
	    System.out.println("Max: " + intTree.getMax());
	    
	    System.out.println(intTree.delete(277));
	    
	    intTree.traverseInOrder();
	}

}
