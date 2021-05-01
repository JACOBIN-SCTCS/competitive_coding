import java.util.LinkedList;

class Solution {
    public int slidingPuzzle(int[][] board) 
    {
        char[] char_map = new char[]{'0','1','2','3','4','5'};
        
        String dest = new String("123450");
        StringBuilder sb = new StringBuilder();
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        
        for(int i=0;i<2;++i)
            for(int j=0;j<3;++j)
            {
                char curr_ch = char_map[board[i][j]];
                sb.append(curr_ch);
            }
        
    
        HashMap<String,Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        String source = sb.toString();
   
        
        q.add(source);
        map.put(source,0);
        while(!q.isEmpty())
        {
            String curr = q.peek();
            q.poll();
            if(curr.equals(dest))
                return map.get(curr);
            
            int idx = curr.indexOf('0');
            
            int x_coord = idx/3;
            int y_coord = idx%3;
            for(int i=0;i<4;++i)
            {
                int new_x = x_coord + dx[i];
                int new_y = y_coord + dy[i];
                
                if(new_x<0 || new_x>=2 || new_y<0 || new_y>=3)
                    continue;
                String new_string = swap(curr,idx,new_x*3+new_y);
           
                if(!map.containsKey(new_string))
                {
                    map.put(new_string,map.get(curr)+1);
                    q.add(new_string);
                }
            }
            
        }
        return -1;
            
    }
    
    public String swap(String curr, int idx, int new_idx)
    {
        char[] char_array = curr.toCharArray();
        char tmp = char_array[idx];
        char_array[idx] = char_array[new_idx];
        char_array[new_idx] = tmp;
        
        return new String(char_array);
    }
}
