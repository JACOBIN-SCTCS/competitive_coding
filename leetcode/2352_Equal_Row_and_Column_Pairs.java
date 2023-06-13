class Solution {
    public int equalPairs(int[][] grid) 
    {
        HashMap<Integer,String> row_set = new HashMap<>();
        HashMap<Integer,String> col_set = new HashMap<>();

        for(int i=0;i<grid.length;++i)
        {
            StringBuilder row_builder = new StringBuilder();
            StringBuilder col_builder = new StringBuilder();

            for(int j=0;j<grid.length;++j)
            {
                row_builder.append(grid[i][j]+",");
                col_builder.append(grid[j][i]+",");
            }
            row_set.put(i,row_builder.toString());
            col_set.put(i,col_builder.toString());
        }

        int ans = 0;
        // for(int i=0;i<grid.length;++i)
        // {
        //     System.out.println(col_set.get(i));

        // }
        // System.out.println("-----");
        // for(int i=0;i<grid.length;++i)
        // {
        //     System.out.println(row_set.get(i));
            
        // }
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid.length;++j)
            {
                if(row_set.get(i).equals(col_set.get(j)))
                    ans+=1;
            }
        }
        return ans;
    }
}
