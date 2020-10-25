package dataStructure.tree.binarySearchTree;

public class TreeNode {
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}

	public void insert(int data) {
		if(data == this.data)
			return;
		
		if(data < this.data) {
			if(leftChild == null)
				leftChild = new TreeNode(data);
			else
				leftChild.insert(data);
		}else {
			if(rightChild == null)
				rightChild = new TreeNode(data);
			else
				rightChild.insert(data);
		}
	}
	
	public TreeNode get(int data) {
		if(data == this.data)
			return this;
		
		if(data < this.data) {
			if(leftChild != null)
				return leftChild.get(data);
		}else {
			if(rightChild != null)
				return rightChild.get(data);
		}
		
		return null;
	}
	
	public TreeNode getMin() {
		if(leftChild == null)
			return this;
		
		return leftChild.getMin();
	}
	
	public TreeNode getMax() {
		if(rightChild == null)
			return this;
		
		return rightChild.getMax();
	}
	
	public void traversePreOrder() {
		System.out.print(data + ", ");
		
		if(leftChild != null) {
			leftChild.traversePreOrder();
		}
		
		if(rightChild != null) {
			rightChild.traversePreOrder();
		}
	}
	
	public void traversePostOrder() {
		if(leftChild != null) {
			leftChild.traversePreOrder();
		}
		
		if(rightChild != null) {
			rightChild.traversePreOrder();
		}
		
		System.out.print(data + ", ");
	}
	
	public void traverseInOrder() {
		if(leftChild != null)
			leftChild.traverseInOrder();
		
		System.out.print(data + ", ");
		
		if(rightChild != null)
			rightChild.traverseInOrder();
	}
	
	public TreeNode delete(TreeNode subtreeRoot, int data) {
		if(subtreeRoot == null)
			return null;

		//Case - If the subtreeRoot has 0 or 1 child
		if(data < subtreeRoot.getData()) {
			subtreeRoot.leftChild = delete(subtreeRoot.leftChild, data);
		}else if(data > subtreeRoot.getData()) {
			subtreeRoot.rightChild = delete(subtreeRoot.rightChild, data);
		}
		//Case - If the subtreeRoot has 2 children
		else {
			if(subtreeRoot.leftChild == null) {
				return subtreeRoot.rightChild;
			}else if(subtreeRoot.rightChild == null) {
				return subtreeRoot.leftChild;
			}else {
				//Get min of the right subtree
				int minRightSubtree = subtreeRoot.rightChild.getMin().data;
				//Replace the subtreeRoot value with the min of its right subtree
				subtreeRoot.setData(minRightSubtree);
				//Delete the node with min of the right subtree and set the replacement node to its right subchild
				subtreeRoot.rightChild = delete(subtreeRoot.rightChild, minRightSubtree);
			}
		}
		
		return subtreeRoot;
	}
	
	
}
