package structures;

public class AVLtree {
	private static class Node{
		private int data;
		private int height;
		private Node left,right;
		public Node(int d){
			this.data=d;
			this.height=1;
		}
	}
	private Node root;
	
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(Node node){
		if(node!=null){
			inOrder(node.left);
			System.out.print(node.data+"-");
			inOrder(node.right);
		}
	}
	public int getHeight(Node node){
		if(node==null) return 0;
		return node.height;
	}
	
	public int Max(int a,int b){
		return (a>b) ? a:b;
	}
	
	public Node rightRotate(Node y){
		Node x=y.left;
		Node T2=x.right;
		
		//ROTATE
		x.right=y;
		y.left=T2;
		
		//UPDATE HEIGHT
		y.height=Max(getHeight(y.left),getHeight(y.right))+1;
		x.height=Max(getHeight(x.left),getHeight(x.right))+1;
		
		return x;
	}
	public Node leftRotate(Node x){
		Node y=x.right;
		Node T2=y.left;
		
		//ROTATE
		y.left=x;
		x.right=T2;
		
		//UPDATE
		x.height=Max(getHeight(x.left),getHeight(x.right))+1;
		y.height=Max(getHeight(y.left),getHeight(y.right))+1;
		
		return y;
	}
	public int getBalance(Node node){
		if(node==null) return 0;
		return getHeight(node.left)-getHeight(node.right);
	}
	public void insert(int data){
		root=insert(root,data);
	}
	private Node insert(Node node,int data){
		//BINARY SEARCH TREE INSERTION
        if (node == null)
            return (new Node(data));
 
        if (data < node.data)
            node.left = insert(node.left,data);
        else if (data > node.data)
            node.right = insert(node.right,data);
        else return node;
            
 
        //UPDATE HEIGHT OF ANCESTOR
        node.height = 1 + Max(getHeight(node.left),getHeight(node.right));
                              
        
        int balance = getBalance(node);
 
        //Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        return node;
	}
}
