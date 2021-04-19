/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    List<Integer> first = new ArrayList<Integer>();
    List<Integer> second = new ArrayList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    
    public void merge()
    {
        int f = 0;
        int s = 0;
        
        while(f<first.size() && s<second.size())
        {
            if(first.get(f) <= second.get(s))
            {
                result.add(first.get(f));
                f+=1;    
            }
            else
            {
                result.add(second.get(s));
                s+=1;
            }
            
        }
        if(f<first.size())
        {
            while(f<first.size())
            {
                result.add(first.get(f));
                f+=1;
            }
        }
        
         if(s<second.size())
        {
            while(s<second.size())
            {
                result.add(second.get(s));
                s+=1;
            }
        }
        
        
        
    }
    
    
    public void InOrder(TreeNode root, List<Integer> list)
    {
        if(root==null)
            return;
        
        InOrder(root.left,list);
        list.add(root.val);
        InOrder(root.right,list);
    }
    
    
    
    
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        InOrder(root1,first);
        InOrder(root2,second);
        merge();
        return result;
    }
}
