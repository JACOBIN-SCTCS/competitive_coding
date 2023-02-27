/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    public Node helper(int[][] grid, int s_row, int e_row , int s_col , int e_col)
    {
      
        if((s_row == e_row) &&(s_col==e_col))
        {
            if(grid[s_row][s_col]==1)
            return new Node(true,true,null,null,null,null);
            else
            return new Node(false,true,null,null,null,null);
        }
        
        Node topleft = helper(grid,s_row, (s_row+e_row)/2, s_col , (s_col + e_col)/2);
        Node topright = helper(grid,s_row,(s_row+e_row)/2, (s_col+e_col)/2 + 1 , e_col);
        Node bottomleft = helper(grid,(s_row+e_row)/2+1,e_row, s_col , (s_col + e_col)/2);
        Node bottomright = helper(grid,(s_row+e_row)/2+1,e_row, (s_col+e_col)/2 + 1 , e_col);   

        if(!(topleft.val == topright.val && topleft.val==bottomleft.val && topleft.val==bottomright.val && topleft.isLeaf && topright.isLeaf  
                && bottomleft.isLeaf && bottomright.isLeaf
              ))
        { 

            return new Node(topleft.val,false,topleft,topright,bottomleft,bottomright);
        }
        else
            return new Node(topleft.val,true,null,null,null,null);

    }
    
    
    public Node construct(int[][] grid) 
    {
        return helper(grid,0,grid.length-1,0,grid.length-1);
    }
}
