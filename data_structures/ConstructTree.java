class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int data)
	{
		val = data;
		left=right=null;
	}
}

class Solution
{
	int idx = 0;   // Global Index Variable used to keep track of the current symbol in string 
	

	TreeNode helper(String s)
	{
		if(idx>=s.length())
			return null;

		// index would be pointing to start of a number 

		StringBuilder sb = new StringBuilder();
		while(idx<s.length() && s.charAt(idx)!='(' && s.charAt(idx)!=')')  // append as long as there is a number
		{
			sb.append(s.charAt(idx));
			idx+=1;
		}


		TreeNode currentNode = null;   // NULL as stringbuilder may not any number so default null
		if(sb.length()!=0)
		{
			currentNode = new TreeNode(Integer.parseInt(sb.toString()));
		}


		/*
		 
			input would be of form   NUMBER ( LEFT SUBTREE ) ( RIGHT SUBTREE )  if there is no left subtree current idx would be something other
			than ( therefore we can return.

			if it is a ( then statements between ( ) is a tree and we recursively solve it and after solving it advance idx as it would 
			be pointing to a ) which is closing paranthesis corresponding to the ( before recursion 
		 */


		if(idx<s.length() && s.charAt(idx)!='(') // No left subtree no right subtree
			return currentNode;

		if(idx<s.length() && s.charAt(idx)=='(')  // construct left subtree first if it exists
		{
			idx+=1;
			currentNode.left = helper(s);
			idx+=1;
		}

		if(idx<s.length() &&s.charAt(idx)=='(')  // construct right subtree if it exists
		{
			idx+=1;
			currentNode.right = helper(s);
			idx+=1;
		}
		return currentNode;

	}


	TreeNode str2Tree(String s)
	{
		if(s.length()==0 || s==null)
			return null;

		return helper(s);
	}


	void preOrder(TreeNode root)
	{
		if(root==null)
			return ;
		
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}


}



class ConstructTree
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		TreeNode root = s.str2Tree(new String("4(2(3)(1))(6(5))"));
		s.preOrder(root);
	}
}
