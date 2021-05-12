class Solution {
    public int smallestDivisor(int[] nums, int threshold)
    {
        int min =1;
        int max = Integer.MIN_VALUE;
        for(int num:nums)
        {
            max = Math.max(num,max);
        }
        
        while(min<max)
        {
            int mid = min + (max-min)/2;
            int sum =0;
            for(int num:nums)
                sum += Math.ceil(num*1.0/mid);
            
            if(sum>threshold)
                min = mid+1;
            else
                max = mid;
        }
        return min;
        
    }
}
