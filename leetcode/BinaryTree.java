import java.util.*;

class TreeNode
{
	int val;
	TreeNode left,right;

	TreeNode(int val,TreeNode left,TreeNode right)
	{
		this.left=left;
		this.right=right;
		this.val=val;
	}
}

class Solution
{

	int idx=0;

	TreeNode helper(String s )
	{
		if(idx==s.length())
			return null;

		StringBuilder  no  =new StringBuilder();
		while(idx<s.length() && s.charAt(idx)!='(' && s.charAt(idx)!=')')
		{
			no.append(s.charAt(idx));
			idx+=1;
		}

		TreeNode newnode = null;
		if(no.length()!=0)
		{
			newnode= new TreeNode(Integer.parseInt(no.toString()),null,null);	
		}
		if(newnode==null)
			return null;

		if(idx<s.length() && s.charAt(idx)=='(')
		{
			idx+=1;
			newnode.left = helper(s);
			idx+=1;
		}
		if(idx<s.length()&& s.charAt(idx)=='(')
		{
			idx+=1;
			newnode.right=helper(s);
			idx+=1;
		}
		return newnode;
		

	}
	TreeNode str2tree(String s)
	{
		if(s==null || s.length()==0)
			return null;
		
		return helper(s);
	}

	void preOrder(TreeNode root)
	{
		if(root==null)
			return;
	
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	void InOrder(TreeNode root)
	{
		if(root==null)
			return;
		InOrder(root.left);
		System.out.println(root.val);
		InOrder(root.right);
	}

}


class BinaryTree
{
	public static void main(String args[])
	{

		Solution s = new Solution();
		TreeNode root = s.str2tree(new String("4(2(3)(1))(6(5))"));

		s.preOrder(root);
		System.out.println("Inorder");
		s.InOrder(root);
	}
	
}
