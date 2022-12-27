class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) 
    {
        List<Integer> arraylist = new ArrayList<Integer>();
        int ans = 0;
        for(int i=0;i<capacity.length;++i)
        {
            int leftout = capacity[i] - rocks[i] ;
            if(leftout > 0)
                arraylist.add(leftout);    
            else if(leftout==0)
                ans += 1;  
        }
        Collections.sort(arraylist);
        for(int a : arraylist)
        {   
            if(a<= additionalRocks)
            {
                ans += 1;
                additionalRocks -= a;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
}
