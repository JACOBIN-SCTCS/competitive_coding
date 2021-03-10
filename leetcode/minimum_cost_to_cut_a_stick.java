class Solution {
    
    public int calculatePrice(int[] indices, int[][] dp,int i , int j)
    {
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int min_cost = Integer.MAX_VALUE;
        for(int k = i+1;k<j;++k)
        {
            int cut_cost = calculatePrice(indices,dp,i,k) + calculatePrice(indices,dp,k,j);
            min_cost = Math.min(cut_cost,min_cost);
            
        }
        
        dp[i][j]=min_cost+(indices[j]-indices[i]);
        return dp[i][j];
            
    }
    
    
    public int minCost(int n, int[] cuts) 
    {
        
        int[] indices = new int[cuts.length+2];       
        indices[0] = 0;
        indices[cuts.length+1]=n;
        Arrays.sort(cuts);
        
        for(int i=0;i<cuts.length;++i)
        {
            indices[i+1] = cuts[i];
        }
        
        int[][] dp = new int[indices.length][indices.length];
        
        
        for(int i=0;i<indices.length;++i)
        {
            
            for(int j=0;j<indices.length;++j)
            { 
                if(i==j)
                {
                    dp[i][i]=0;
                }
                else if((i+1)==j)
                {
                    dp[i][j]=0;
                }
                else
                {
                    dp[i][j]=-1;
                }
                
            }
        }
        
 
        
        
        return calculatePrice(indices,dp,0,indices.length-1);
        
    }
}
