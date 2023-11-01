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
    int prev_element;
    int current_count;
    int mode_count;
    List<Integer> modes_list;
    
    public void process_value(int val)
    {
        if(prev_element == val)
        {
            current_count+=1; 
        }
        else
        {
            current_count = 1;
            prev_element = val;
        }

        
        if(current_count > mode_count)
        {
            mode_count = current_count;
           
            modes_list.clear();
            modes_list.add(val);
        }
        else if(current_count == mode_count)
        {
            modes_list.add(val);
        }
    }

    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        
        inorder(root.left);
        process_value(root.val);
        inorder(root.right);
    }

    public int[] findMode(TreeNode root) 
    {
        prev_element = 0;
        mode_count = 0;
        current_count = 0;
        modes_list = new ArrayList<Integer>();
        
        
        inorder(root);

        int[] ans = new int[modes_list.size()];
        for(int i=0;i<ans.length;++i)
            ans[i] = modes_list.get(i);
        return ans;
    }
}
