import java.util.*;
import java.util.LinkedList;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val)
	{
		this.val = val;
		
	}
	TreeNode(int val, TreeNode left,TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right=right;
	}
}

class Solution
{

	List<Integer> path = new ArrayList<Integer>();
	boolean check=false;
	void binaryTreeFinder( TreeNode root, int target)
	{

  		if(root==null)
   			return ;

		//boolean res = find(root,target);
		helper( root, target);
	}

	public boolean find(TreeNode root,int target)
	{
  		if(root==null)
    		return false;
  		if(root.val==target)
  		{
    		path.add(root.val);
   			return true;
  		}
  		boolean left = find(root.left,target);
  		if(left)
  		{
    		path.add(root.val);
    		return true;
  		}
  		boolean right = find(root.right,target);
  		if(right)
  		{
    		path.add(root.val);
			return true;
  		}
  		return false;
	}
	
	public void helper( TreeNode root, int target)
	{
  
  		if(root==null)
    		return ;
  
  		if(root.val == target)
  		{
   
   			path.add(root.val);
    		check = true;
    		return;
 		}
  
  		helper(root.left, target);
  		if(check)
  		{ 
			path.add(root.val);
			return;
  		}
  		helper(root.right, target);
  
  		if(check)
    		path.add(root.val);
  
  
  		return ;
  
  
	}



	void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	void postOrder(Node root)
	{
		if(root==null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+ " ");
		
	}
	
	void InOrder(Node root)
	{
		if(root==null)
			return;
		InOrder(root.left);
		System.out.print(root.val " ");
		InOrder(root.right);
	}


	void LevelOrder(Node root)
	{
		
		Queue<Node> q = new LinkedList<>();
		Node ele;
		if(root==null)
			return;
		q.add(root);
		while(!q.isEmpty())
		{
			ele=q.remove();
			System.out.print(ele.val+" ");
			if(ele.left!=null)
				q.add(ele.left);
			if(ele.right!=null)
				q.add(ele.right);

		}

	}

	TreeNode createTreeI()
	{	
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(4,a,b);
		TreeNode d = new TreeNode(10);
		TreeNode e = new TreeNode(11);
		TreeNode f = new TreeNode(5,d,e);
		TreeNode g = new TreeNode(2,c,f);
		TreeNode h = new TreeNode(13);
		TreeNode i = new TreeNode(6,null,h);
		TreeNode j = new TreeNode(14);
		TreeNode k = new TreeNode(7,j,null);
		TreeNode l = new TreeNode(3,i,k);
		TreeNode m = new TreeNode(1,g,l);
		return m;

	}

}

class Tree
{
	public static void main(String args[])
	{
		Solution s = new Solution();
		TreeNode root = s.createTreeI();
		s.binaryTreeFinder(root,13);
		for(int i=0;i<s.path.size();++i)
		{
			System.out.print(s.path.get(i)+ " ");
		}
	}
}
