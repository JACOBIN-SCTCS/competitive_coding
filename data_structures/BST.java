import java.util.*;
import java.util.LinkedList;
class Node
{
	int data;
	Node left;
	Node right;

	Node(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}


class BST
{

	 public static Node delete(Node root,int data)
	 {
		return deleteNode(root,data);
	 }
	 public static int InOrderSuccessor(Node root)
	 {
		 Node tmp=root.right;
		 while(tmp.left!=null )
		 {
			 tmp=tmp.left;
		 }
		 return tmp.data;
	 }

	 public static int InOrderPredecessor(Node root)
	 {
		 Node tmp = root.left;
		 while(tmp.right!=null)
		 {
			 tmp=tmp.right;
		 }
		 return tmp.data;
	 }

	 
	 public static Node deleteNode(Node root,int data)
	 {
		 if(root==null)
			 return null;
		 if(root.data>data)
		 {
			 root.left=deleteNode(root.left,data);
		 }
		 else if(root.data<data)
			 root.right=deleteNode(root.right,data);
		 else
		 {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else
			{	
				int succ = InOrderSuccessor(root);
				root.data=succ;
				root.right=deleteNode(root.right,succ);
			}


		 }
		return root;
	 }

	 public static Node insertRecursive(Node root, int data)
	 {
		 if(root==null)
		 	return new Node(data);
		
		 if(root.data<data && root.right==null)
		{
			if(root.right==null)
			{
				root.right = new Node(data);
			
			}
			else
			{
				root.right = insertRecursive(root.right, data);
			}
		}
		else if(root.data>data )
		{
			if(root.left==null)
			{
				root.left = new Node(data);
				
			}
			else
			{
				root.left = insertRecursive(root.left, data);
			
			}

		}
		return root;
			
	 }

	 public static Node insert(Node root,int data) 
	 {
		 Node newnode = new Node(data);
        	 Node ptr;
        
        
        	if(root==null)
            		return newnode;
					  
        	Node tmp;
        	ptr=root;
        	tmp=ptr;
        	while(ptr!=null)
        	{
            		tmp=ptr;
            		if(ptr.data>data)
            		{
                		ptr=ptr.left;
            		}
            		else
            		{
                		ptr=ptr.right;
            		}
       	 	}	
        	if(tmp.data>data)
            		tmp.left=newnode;
        	else
            		tmp.right=newnode;
        
        
        
        
        	return root;
        
    	}


	public static void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void postOrder(Node root)
	{
		if(root==null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+ " ");
		
	}
	
	public static void InOrder(Node root)
	{
		if(root==null)
			return;
		InOrder(root.left);
		System.out.print(root.data+ " ");
		InOrder(root.right);
	}


	public static void LevelOrder(Node root)
	{
		
		Queue<Node> q = new LinkedList<>();
		Node ele;
		if(root==null)
			return;
		q.add(root);
		while(!q.isEmpty())
		{
			ele=q.remove();
			System.out.print(ele.data+" ");
			if(ele.left!=null)
				q.add(ele.left);
			if(ele.right!=null)
				q.add(ele.right);

		}

	}



	public static void main(String args[])
	{
		Node root=null;
		//root=insert(root,4);
		//root=insert(root,2);
		//root=insert(root,18);
		//root=insert(root,12);
		root=insertRecursive(root,4);
		root=insertRecursive(root,2);
		root=insertRecursive(root,18);
		root=insertRecursive(root,12);
		root=insertRecursive(root,11);
		root=insertRecursive(root,20);
		//int succ=InOrderSuccessor(root);
		//System.out.print(succ);
		//root=delete(root,18);
		InOrder(root);
	
		
	}
}

