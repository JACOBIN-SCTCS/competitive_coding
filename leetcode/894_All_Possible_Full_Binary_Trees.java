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
    HashMap<Integer,List<TreeNode>> dp;

    public List<TreeNode> helper(int n)
    {
        if(n<=0 || n%2 == 0)
            return new ArrayList<>();
        if(n==1)
        {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }
        if(dp.containsKey(n))
            return dp.get(n);
            
        List<TreeNode> ans = new ArrayList<TreeNode>();
        for(int i=1;i<n ; i+=2)
        {
            List<TreeNode> left = helper(i);
            List<TreeNode> right = helper(n-1-i);
        
            for(int j=0;j<left.size();++j)
            {
                for(int k=0;k<right.size();++k)
                {
                    TreeNode root = new TreeNode(0,left.get(j),right.get(k));
                    ans.add(root);
                
                }
            }
        }
        dp.put(n,ans);
        return ans;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        dp = new HashMap<>();
        return helper(n);

    }
}
