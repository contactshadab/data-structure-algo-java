package shadab.ds.tree.binarySearchTree;

public class Tree {
	TreeNode root;
	
	public void insert(int data) {
		if(root == null)
			root = new TreeNode(data);
		else
			root.insert(data);
	}
	
	public void traverseInOrder() {
		if(root != null)
			root.traverseInOrder();
	}
	
	public TreeNode get(int data) {
		if(root != null)
			return root.get(data);
		return null;
	}
	
	public TreeNode getMin() {
		if(root != null)
			return root.getMin();
		return null;
	}
	
	public TreeNode getMax() {
		if(root != null)
			return root.getMax();
		return null;
	}
	
	public TreeNode delete(int data) {
		if(root != null)
			root.delete(root, data);
		return null;
	}
}
