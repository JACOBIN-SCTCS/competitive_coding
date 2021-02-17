
//  103 : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


import java.util.*;
class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) {this.val=val;}
	TreeNode(int val,TreeNode left,TreeNode right)
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}

}





class ZigZag
{



	public static  TreeNode createStubTree()
	{
		TreeNode c1 = new TreeNode(15);
		TreeNode c2 = new TreeNode(7);
		TreeNode c3 = new TreeNode(20,c1,c2);
		TreeNode c4 = new TreeNode(9);
		TreeNode root = new TreeNode(3,c4,c3);
		return root;
	}
	
	public static void traverseTree(TreeNode root)
	{
		if(root==null)	
			return;
		else 
		{
			traverseTree(root.left);
			System.out.print(root.val+" ");
			traverseTree(root.right);

		}
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
        
        	List<List<Integer>> returnlist = new ArrayList<List<Integer>>();
		Stack<TreeNode> currentstack = new Stack<>();
		Stack<TreeNode> nextlevelstack = new Stack<>();
		int lr = 1;
		if(root==null)
			return returnlist;

		currentstack.push(root);
		List<Integer> list = new ArrayList<>();
		list.clear();
		while(!currentstack.isEmpty())
		{
			TreeNode curr = currentstack.pop();
			list.add(curr.val);
			if(lr==1)
			{
				if(curr.left!=null)
					nextlevelstack.push(curr.left);
				if(curr.right!=null)
					nextlevelstack.push(curr.right);
			}
			else
			{	
				if(curr.right!=null)
					nextlevelstack.push(curr.right);
				if(curr.left!=null)
					nextlevelstack.push(curr.left);


			}
			if(currentstack.isEmpty())
			{
				returnlist.add(list);
				list = new ArrayList<Integer>();
				list.clear();
				lr = 1 -lr;
				Stack<TreeNode> temp = currentstack;
				currentstack=nextlevelstack;
				nextlevelstack = temp;
			}
		}


		return returnlist;
        
    	}

	public static void main(String args[])
	{
		TreeNode root = createStubTree();
		traverseTree(root);
		List<List<Integer>> l = zigzagLevelOrder(root);
		
		for(List<Integer> list: l)
		{
			System.out.print(" [");
			for(int item:list)
			{
				System.out.print(" " + item + ",");
			}
			System.out.print(" ] ");
		}

	}
}	
