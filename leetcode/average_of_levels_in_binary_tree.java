import java.util.LinkedList;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double> ret_list = new ArrayList<Double>();
        if(root==null)
            return ret_list;
        
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            double sum = 0;
            for(int i=0;i<size;++i)
            {
                TreeNode curr = q.poll();
                sum+=curr.val;
                
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            ret_list.add(sum/size);
        }
        
        return ret_list;
        
        
    }
}
