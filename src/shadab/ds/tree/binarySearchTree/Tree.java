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
}
