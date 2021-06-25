class Solution {
    public int arrangeCoins(int n) 
    {
        
        
        long start = 0l;
        long end = n;
        while(start<=end)
        {
            long mid = start+(end-start)/2;
            long result = (mid*(mid+1)/2);
           
            if(result==n)
                return (int)mid;
            
            else if(result<n)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        
        return (int)end;
    }
}
