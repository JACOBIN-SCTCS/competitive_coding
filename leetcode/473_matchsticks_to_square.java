class Solution {
   
    public  boolean backtrack(int[] matchsticks,int idx, int[] sum, int target)
    {
        if(idx>=matchsticks.length)
            return true;
        
        
        for(int i=0;i<4;++i)
        {
            if(sum[i]+matchsticks[idx]<=target)
            {
                sum[i] = sum[i] + matchsticks[idx];
                if(backtrack(matchsticks,idx+1,sum,target))
                    return true;
                sum[i]  = sum[i] - matchsticks[idx];
            }
        }
        return false;
        
    }
    
    public boolean makesquare(int[] matchsticks)
    {
        int sum = 0;
        for(int match:matchsticks)
            sum += match;
            
        if(matchsticks.length<4 || ((sum%4)!=0) ) 
            return false;
        
        return backtrack(matchsticks,0,new int[4],sum/4);
    }
}
