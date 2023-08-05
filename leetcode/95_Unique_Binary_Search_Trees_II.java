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
    
    HashMap<Pair<Integer,Integer>,List<TreeNode>> map;
    public List<TreeNode> helper(int left, int right)
    {
        if(left > right)
        {
            List<TreeNode> empty = new ArrayList<TreeNode>();
            empty.add(null);
            return empty;
        }
        if(map.containsKey(new Pair<>(left,right)))
            return map.get(new Pair<>(left,right));
        
        List<TreeNode> ans = new ArrayList<TreeNode>();
        for(int i = left; i<=right;++i)
        {
            List<TreeNode> lefttree = helper(left,i-1);
            List<TreeNode> righttree = helper(i+1,right);
            for(int j=0;j<lefttree.size();++j)
            {
                for(int k=0;k<righttree.size();++k)
                {
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = lefttree.get(j);
                    currentRoot.right = righttree.get(k);

                    ans.add(currentRoot);
                }
            }
        }
        map.put(new Pair<>(left,right),ans);
        return ans;
    }
        
    public List<TreeNode> generateTrees(int n) 
    {
        map = new HashMap<>();
        List<TreeNode> ans = helper(1,n);
        return ans;
    }
}
