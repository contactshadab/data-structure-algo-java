package shadab.ds.tree.binarySearchTree;

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
		
		return new TreeNode(0);
	}
	
	public void traverseInOrder() {
		if(leftChild != null)
			leftChild.traverseInOrder();
		
		System.out.print(data + ", ");
		
		if(rightChild != null)
			rightChild.traverseInOrder();
	}
	
	
}
