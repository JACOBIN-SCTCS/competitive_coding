import java.util.LinkedList;

class Node
{
    TreeNode val;
    int position;
    
    Node(TreeNode val,int position)
    {
        this.val =val;
        this.position = position;
    }
}





class Solution 
{
        
    public int widthOfBinaryTree(TreeNode root)
    {
        if(root==null)
            return 0;
        
        Queue<Node> q = new LinkedList<Node>();
        int difference = 0;
        q.add(new Node(root,1));
        while(!q.isEmpty())
        {
            int start = -1;
            int end = -1;
            int size = q.size();
            
            for(int i=0;i<size;++i)
            {
                   
                Node curr = q.poll();
                
                if(curr.val.left!=null)
                {
                    q.add(new Node(curr.val.left,2*curr.position));
                }
                if(curr.val.right!=null)
                {
                    q.add(new Node(curr.val.right,2*curr.position+1));
                }
               
                if(start==-1)
                {
                    start = curr.position;
                }
                end = curr.position;
                
                
            }
            
            /*System.out.print("New level");
            System.out.print(start);
            System.out.print(end+"\n");
            */
            
            int new_diff ;
            if(end==start)
            {
                new_diff = 1;
            }
            else
            {
                new_diff = end-start+1;
            }
            
            
            difference= Math.max(difference,new_diff);
            
        }
        return difference;
        
                
    }
    
    
}
