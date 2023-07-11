/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    HashMap<Integer,List<Integer>> adj_list;
    int[] visited;
    List<Integer> ans;

    void buildGraph(TreeNode current, TreeNode parent)
    {
        if(current==null)
            return;
        if(!adj_list.containsKey(current.val))
        {
            adj_list.put(current.val, new ArrayList<Integer>());
        }
        List<Integer> neighbour = adj_list.get(current.val);
        if(parent!=null)
        {
            neighbour.add(parent.val);
        }
        if(current.left!=null)
        {
            neighbour.add(current.left.val);
        }
        if(current.right!=null)
        {
            neighbour.add(current.right.val);
        }
        adj_list.put(current.val,neighbour);

        buildGraph(current.left,current);
        buildGraph(current.right,current);
    }

    void helper(int source,int distance)
    {
        if(distance<0 || visited[source]==1)
            return;

        visited[source] = 1;
        if(distance == 0)
        {
            ans.add(source);
            return;
        }

        List<Integer> neighbours = adj_list.get(source);
        for(int i=0;i<neighbours.size();++i)
        {
            int neighbour = neighbours.get(i);
            if(visited[neighbour]==0)
            {
                helper(neighbour,distance-1);
            }
        }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        adj_list = new HashMap<>();
        buildGraph(root,null);
        
        visited = new int[501];
        ans = new ArrayList<Integer>();
        
        helper(target.val,k);
        return ans;

    }
}
