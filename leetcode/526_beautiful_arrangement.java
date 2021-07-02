class Solution {

    
    int count=0;
    
    void compute(int n, int index, boolean[] taken)
    {
        if(index>n)
        {
            count+=1;
            return;
        }
        
        for(int i=1;i<=n;++i)
        {
            if(taken[i] || ((i%index!=0)&&(index%i!=0)))
                continue;
            taken[i] = true;
            compute(n,index+1,taken);
            taken[i]= false;
        }
    }
    
    int countArrangement(int n) 
    {
        boolean[] taken  = new boolean[n+1];
        Arrays.fill(taken,false);
        compute(n,1,taken);
        return count;
    }
};
