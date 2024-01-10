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
    
    HashMap<Integer,List<Integer>> adj_list;
    HashMap<Integer,Integer> visited;


    public void traverse(TreeNode root, TreeNode parent)
    {
        if(root == null)
            return;
        List<Integer> neighbours = new ArrayList<Integer>();
        if(root.left != null)
            neighbours.add(root.left.val);
        if(root.right != null)
            neighbours.add(root.right.val);
        if(parent != null)
            neighbours.add(parent.val);
        adj_list.put(root.val, neighbours);

        traverse(root.left,  root);
        traverse(root.right, root);
    }
    

    public int amountOfTime(TreeNode root, int start) 
    {
        adj_list = new HashMap<Integer,List<Integer>>();
        traverse(root,null);
        visited = new HashMap<Integer,Integer>();

        int ans = 0; 

        Queue<Integer> q = new LinkedList<>();
        visited.put(start,0);
        q.add(start);

        while(!q.isEmpty())
        {
            int curr = q.poll();
            
            for(int i = 0 ; i < adj_list.get(curr).size(); ++i)
            {
                int neighbour = adj_list.get(curr).get(i);
                if(!visited.containsKey(neighbour))
                {
                    visited.put(neighbour, visited.get(curr) + 1);
                    ans = Math.max(ans,  visited.get(curr) + 1);
                    q.add(neighbour);
                }
            }
            
        }
        return ans;
    }
}
