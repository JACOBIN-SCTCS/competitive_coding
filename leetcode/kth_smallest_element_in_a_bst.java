
class Solution {
    
    
    List<Integer> elements = new ArrayList<Integer>();

    public void InOrder(TreeNode root)
    {
        if(root==null)
            return;
        InOrder(root.left);
        elements.add(root.val);
        InOrder(root.right);
    }
    
    public int kthSmallest(TreeNode root, int k) 
    {
        InOrder(root);
        return elements.get(k-1);
    }
}
