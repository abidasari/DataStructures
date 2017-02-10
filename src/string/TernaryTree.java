package string;

/**
 * 
 * @author adasari
 *
 */

public class TernaryTree {
	
	public class TernaryNode{
		public char data;
		public boolean isEndOfString;
		public TernaryNode left;
		public TernaryNode eq;
		public TernaryNode right;
		
		public TernaryNode(){
			isEndOfString = false;
		}
	}
	
	public TernaryNode root;
	
	public TernaryTree(){
		root = new TernaryNode();
	}
	
	public void insertRecursively(String s){
		TernaryNode root = insert(this.root, s, 0);
		this.root = root;
	}
	
	public TernaryNode insert(TernaryNode root, String s, int index){
		if(s.length() == index)
			return root;
		if(root == null){
			root = new TernaryNode();
			root.data = s.charAt(index);
			root.eq = insert(root.eq, s, index + 1);
			if(index == s.length() - 1)
				root.isEndOfString = false;
		} else {
			if(root.data == s.charAt(index)){
				root.eq = insert(root.eq, s, index + 1);
				if(index == s.length() - 1)
					root.isEndOfString = false;
 			} else if (root.data < s.charAt(index)){
 				root.left = insert(root.left, s, index);
 			} else 
 				root.right = insert(root.right, s, index);
		}
		return root;
	}
	
	public boolean search(String s){
		return search(root, s, 0);
	}
	
	public boolean search(TernaryNode root, String s, int index){
		if(root == null)
			return false;
		if(index == s.length())
			return true;
		if(root.data == s.charAt(index)){
			boolean res = search(root.eq, s, index + 1);
			if(index == s.length() - 1){
				return res && root.isEndOfString;
			}
			return res;
		} else if(root.data < s.charAt(index)) {
			return search(root.left, s, index + 1);
		} else 
			return search(root.right, s, index + 1);
	}
}
