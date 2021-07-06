class Solution {
    
    List<Integer> retlist = new ArrayList<Integer>();
    
    void compute(int current,int n)
    {
        if(current>n)
            return;
        else
        {
            
            retlist.add(current);
            int next = current*10;
            for(int i=0;i<=9;++i)
            {
                next = next + i;
                if(next>n)
                    return;
                compute(next,n);
                next = next-i;
            }
        }
    }
    
    public List<Integer> lexicalOrder(int n) 
    {
        for(int i=1;i<=9;++i)
        {
            compute(i,n);
        }
        return retlist;
    }
}
