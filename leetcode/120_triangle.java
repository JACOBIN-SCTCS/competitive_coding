class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int[][]  path_sum =  new int[triangle.size()][triangle.size()];
        path_sum[0][0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();++i)
        {
            for(int j=0;j<i+1;++j)
            {
                path_sum[i][j] = Integer.MAX_VALUE;
                if(j-1>=0)
                    path_sum[i][j] = Math.min(path_sum[i][j], triangle.get(i).get(j)+ path_sum[i-1][j-1]);
                if(j<i)
                    path_sum[i][j] = Math.min(path_sum[i][j],triangle.get(i).get(j)+path_sum[i-1][j]);
                
            }
        }
        
        
        int min_value = Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();++i)
            min_value = Math.min(path_sum[triangle.size()-1][i],min_value);
        
        return min_value;
    }
}
