
public class BinaryTree <T extends Comparable<T>>{
	private Node<T> root;
	
	private static class Node<T>{
		private T data;
		private Node<T> right,left;
		public Node(T data){
			this.data=data;
			right=left=null;
		}
	}
	/*--------------------
	 * 					 | 
	 * 		INSERT		 |	
	 * 					 |
	 * -------------------
	 */
	public void insert(T data){
		root=insert(data,root);
	}
	private Node<T> insert(T data,Node<T> node){
		if(node==null) node=new Node<T>(data);
		else if(data.compareTo(node.data)<0) node.left=insert(data,node.left);
		else if(data.compareTo(node.data)>0) node.right=insert(data,node.right);
		return node;	
	}
	/*--------------------
	 * 					 | 
	 * 		DELETE		 |	
	 * 					 |
	 * -------------------
	 */
	public Node<T> delete(T data){
		Node<T> deletedNode=delete(data,root);
		return deletedNode;
	}
	private Node<T> delete(T data,Node<T> node){
		if(node==null) return node;
		if(data.compareTo(node.data)<0) node.left=delete(data, node.left);
		else if(data.compareTo(node.data)>0) node.right=delete(data, node.right);
		else if(node.left!=null && node.right!=null){//TWO CHILDREN
			node.data=findMin(node.right).data;
			node.right=delete(node.data,node.right);
		}
		else node= (node.left!=null) ? node.left : node.right;
		return node;
	}
	/*--------------------
	 * 					 | 
	 * 		FIND(min,max)|	
	 * 					 |
	 * -------------------
	 */
	public Node<T> find(T data){
		Node<T> searchedNode=find(data,root);;
		return searchedNode;
	}
	private Node<T> find(T data,Node<T> node){
		if(node==null) return null;
		else if(data.compareTo(node.data)<0) return find(data, node.left);
		else if(data.compareTo(node.data)>0) return find(data, node.right);
		else return node;
	}
	
	public T findMin(){
		Node<T> minNode=findMin(root);
		return  minNode.data;
	}
	private Node<T> findMin(Node<T> node){
		if(node==null) return null;
		else if(node.left==null) return node;
		return findMin(node.left);
	}
	
	public T findMax(){
		Node<T> maxNode=findMax(root);
		return maxNode.data;
	}
	private Node<T> findMax(Node<T> node){//recursive
		if(node==null) return null;
		else if(node.right==null) return node;
		return findMax(node.right);
	}
	private Node<T> findMaxNonRecursive(Node<T> node){//nonrecursive
		if(node!=null){
			while(node.right!=null) node=node.right;	
		}
		return node;
	}
	
	/*--------------------
	 * 					 | 
	 * 		TRAVERSALS	 |	
	 * 					 |
	 * -------------------
	 */
	public void preOrder(){
		preOrder(root);
	}
	public void inOrder(){
		inOrder(root);
	}
	public void postOrder(){
		postOrder(root);
	}
	private void preOrder(Node<T> node){
		if(node!=null){
			System.out.print(node.data+" - ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	private void inOrder(Node<T> node){
		if(node!=null){
			inOrder(node.left);
			System.out.print(node.data+" - ");
			inOrder(node.right);
		}
	}
	private void postOrder(Node<T> node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+" - ");
		}	
	}
}