class Solution {
    

    public boolean binary_search(long target)
    {
        long low = 0;
        long high = target;
        
        while(low <= high)
        {
            long mid = low + (high - low)/2;
            long square = mid * mid;
            if(square == target)
                return true;
            else if(square < target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
    
    public boolean judgeSquareSum(int c) {
        
        for(long i =0; i*i <= c; ++i)
        {
            long remaining = c - (int)(i*i);
            if(remaining >= 0)
            {
                boolean ans = binary_search(remaining);
                if(ans == true)
                    return true;
            }

        }
        return false;
    }
}
