class Solution {

    List<Integer> retlist;
    HashSet<Integer> hashset;
    
    int[] powertwo;
    
    public void compute(int number,int n)
    {
        
        retlist.add(number);
        hashset.add(number);
        
        if(retlist.size() == powertwo[n])
            return;
        
        for(int i=0;i<n;++i)
        {
            int current = (number)^(1<<i);
            if(!hashset.contains(current))
            {
                compute(current,n);
                if(retlist.size()==powertwo[n])
                    return;
            }
        }
        
    }
        
    
    public List<Integer> grayCode(int n) 
    {
        powertwo = new int[n+1];
        powertwo[0]=1;
        for(int i=1;i<n;++i)
            powertwo[i] = powertwo[i-1]*2;
        
        retlist = new ArrayList<Integer>();
        hashset = new HashSet<Integer>();
        compute(0,n);
        return retlist;
    }
}
