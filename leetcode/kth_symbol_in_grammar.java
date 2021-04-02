class Solution {
    
    
    public int solve(int n,int k)
    {
        
        if(n==0)
            return 0;
        int prevbit = solve(n-1,k/2);
        if(prevbit==0)
        {
            if(k%2==0)
                return 0;
            else
                return 1;
        }
        else
        {
            if(k%2==0)
                return 1;
            else
                return 0;
        }
    }
        
    
    
    public int kthGrammar(int N, int K) 
    {
        N-=1;
        K-=1;
        
        return solve(N, K);
    }
}
