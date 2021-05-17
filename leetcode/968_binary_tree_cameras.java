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
    
    enum State {NOTHING ,COVERED, HASCAMERA};
    int cameras = 0;
    
    public State compute(TreeNode root)
    {
        if(root==null)
            return State.COVERED;
    
        State left = compute(root.left);
        State right = compute(root.right);
        
        if(left==State.NOTHING || right==State.NOTHING)
        {
            cameras+=1;
            return State.HASCAMERA;
        }
        if(left==State.HASCAMERA || right==State.HASCAMERA)
            return State.COVERED;
        return State.NOTHING;
        
        
    }

    public int minCameraCover(TreeNode root) 
    {
        if(compute(root)==State.NOTHING)
            return cameras+1;
        else
            return cameras;
    }
}
