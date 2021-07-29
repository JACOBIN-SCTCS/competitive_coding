
class Solution {
    public int[][] updateMatrix(int[][] mat) 
    {
        int[][] distance = new int[mat.length][mat[0].length];
        for(int i=0;i<distance.length;++i)
            Arrays.fill(distance[i],100000);
        
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[0].length;++j)
            {
                if(mat[i][j]==0)
                    distance[i][j] = 0;
                else
                {
                  if(i>0)
                      distance[i][j] = Math.min(distance[i][j],distance[i-1][j]+1);
                  if(j>0)
                      distance[i][j] = Math.min(distance[i][j],distance[i][j-1]+1);
                }
            }
            
        }
        
        for(int i=mat.length-1;i>=0;i--)
        {
            for(int j=mat[0].length-1;j>=0;j--)
            {
                if(mat[i][j]==0)
                    distance[i][j] = 0;
                else
                {
                    if(i<mat.length-1)
                        distance[i][j] = Math.min(distance[i][j],distance[i+1][j]+1);
                    if(j<mat[0].length-1)
                        distance[i][j] = Math.min(distance[i][j],distance[i][j+1]+1);
                }
            }
            
        }
        
        return distance;
        
        
        
    }
}
