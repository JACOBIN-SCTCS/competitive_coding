
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king)
    {
        boolean[][] queen_grid = new boolean[8][8];
        List<List<Integer>> ret_list = new ArrayList<List<Integer>>();
        
        for(int[] queen: queens)
            queen_grid[queen[0]][queen[1]] = true;
        
        int[] dx = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
        
        for(int i=0;i<8;++i)
        {
            int x_inc = dx[i];
            int y_inc = dy[i];
            int curr_x = king[0];
            int curr_y = king[1];
            
            while(true)
            {
                if(curr_x<0 || curr_x>=8 || curr_y<0 || curr_y>=8)
                    break;
                if(queen_grid[curr_x][curr_y])
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(curr_x);
                    list.add(curr_y);
                    ret_list.add(list);
                    break;
                }
                curr_x += x_inc;
                curr_y += y_inc;
            }
            
        }
        
        return ret_list;
    }
}
