class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) 
    {
        HashSet<Integer> set = new HashSet<Integer>();
        int i=0,j=0;
        while(Math.pow(x,i) <= bound && i<= Math.ceil(Math.log10(bound)/Math.log10(x)) )
        {
            j=0;
            while(Math.pow(y,j) <= bound && j<= Math.ceil(Math.log10(bound)/Math.log10(y)) )
            {
                int sum = ((int)Math.pow(x,i)) +( (int)Math.pow(y,j));
                if(sum<=bound)
                    set.add(sum);
                if(y==1)
                    break;
                j+=1;
            }
            i+=1;
            if(x==1)
                break;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int ele: set)
            list.add(ele);
        
        return list;
        
    }
}
