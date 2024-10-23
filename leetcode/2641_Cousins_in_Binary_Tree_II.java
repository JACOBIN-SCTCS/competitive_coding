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
    public TreeNode replaceValueInTree(TreeNode root) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i < size ; ++i)
            {
                TreeNode node = q.poll();
                map.put(level, map.getOrDefault(level,0) + node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }

            level +=1;
        }
        /*
        for(int key : map.keySet())
        {
            System.out.println(map.get(key));
        }
        */

        q = new LinkedList<>();
        q.add(root);
        root.val = 0 ;
        level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i < size ; ++i)
            {
                TreeNode node = q.poll();
                //node.val =  map.get(level) - node.val;
                if(map.containsKey(level + 1))
                {
                    int siblings_sum = map.get(level + 1) ;
                    if(node.left != null)
                        siblings_sum -= node.left.val;
                    if(node.right != null)
                        siblings_sum -= node.right.val;

                    if(node.left != null)
                    {
                        node.left.val = siblings_sum;
                        q.add(node.left);
                    }
                    
                    if(node.right != null)
                    {
                        node.right.val = siblings_sum;
                        q.add(node.right);
                    }
                }
                     
            }

            level +=1;
        }
        return root;
    }
}
