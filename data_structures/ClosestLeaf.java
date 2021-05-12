import java.util.*;
import java.util.LinkedList;
class TreeNode
{
	int val;
	TreeNode left,right;
	TreeNode(int val)
	{
		this.val=val;
		this.left=null;
		this.right=null;
	}
}
class Solution
{
	TreeNode start=null;
	HashMap<TreeNode,TreeNode> map = new HashMap<>();

	void DFS(TreeNode root, TreeNode parent, int k)
	{
		if(root==null)
			return ;
		if(root.val==k)
			start=root;

		map.put(root,parent);
		DFS(root.left,root,k);
		DFS(root.right,root,k);
	}

	int findClosest(TreeNode root,int k)
	{
		DFS(root,null,k);
		if(start==null)
			return 0;

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(start);

		while(!q.isEmpty())
		{
			TreeNode curr = q.remove();
			if(curr.left==null && curr.right==null)
				return curr.val;
			if(curr.left!=null && !visited.contains(curr.left.val))
				q.add(curr.left);
			
			if(curr.right!=null && !visited.contains(curr.right.val))
				q.add(curr.right);

			if(map.get(curr)!=null && !visited.contains(map.get(curr).val))
				q.add(map.get(curr));

		}
		return 0;
	}
}


class ClosestLeaf
{
	TreeNode createTree()
	{
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		TreeNode c3 = new TreeNode(4);
		TreeNode c4 = new TreeNode(5);
		TreeNode c5 = new TreeNode(6);
		root.left =c1;
		root.right=c2;
		c1.left = c3;
		c3.left = c4;
		c4.left = c5;
		return root;
	}


	public static void main(String args[])
	{
		ClosestLeaf c = new ClosestLeaf();
		TreeNode root = c.createTree();
		Solution s = new Solution();
		System.out.println(s.findClosest(root,2));
	}
}
