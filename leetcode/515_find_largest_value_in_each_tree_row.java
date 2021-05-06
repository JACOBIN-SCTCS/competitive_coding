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
class Solution {
    
    HashMap<Integer,Integer> map = new HashMap<>();
    public void compute(TreeNode root,int level)
    {
        if(root==null)
            return;
        
        if(!map.containsKey(level))
            map.put(level,root.val);
        else
            map.put(level,Math.max(map.get(level),root.val));
        
        compute(root.left,level+1);
        compute(root.right,level+1);
        
    }
    
    public List<Integer> largestValues(TreeNode root) 
    {
          compute(root,0);
          List<Integer> ret_list = new ArrayList<>(map.size());
          for(int i=0;i<map.size();++i)
              ret_list.add(map.get(i));
            return ret_list;
    }
}
