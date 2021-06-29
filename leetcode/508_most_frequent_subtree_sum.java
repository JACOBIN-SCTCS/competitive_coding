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
    
    HashMap<Integer,Integer> subtree_map;
    
    int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int tree_sum = root.val + left+ right;
        subtree_map.put(tree_sum,subtree_map.getOrDefault(tree_sum,0)+1);
        return tree_sum;
    }
    
    public int[] findFrequentTreeSum(TreeNode root)
    {
        subtree_map = new HashMap<Integer,Integer>();
        dfs(root);
        
        int max_freq=-1;
        int max_freq_ele_count = 0;
        
        for(int key:subtree_map.keySet())
        {
            if(subtree_map.get(key)>max_freq)
            {
                max_freq_ele_count=1;
                max_freq = subtree_map.get(key);
            }
            else if(subtree_map.get(key)==max_freq)
            {
                max_freq_ele_count+=1;
            }
        }
        int[] ret_array = new int[max_freq_ele_count];
        int idx=0;
        
        
        for(int key:subtree_map.keySet())
        {
            if(subtree_map.get(key)==max_freq)
            {
                ret_array[idx++] = key;
            }
        }
        
        return ret_array;
        
        
    }
}
