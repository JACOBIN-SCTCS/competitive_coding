class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {    
        
        // Referred editorial
        int[] bitCount = new int[33];
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int running_val = 0;
        while(end < nums.length)
        {
            getSetBits(bitCount, nums[end], 1);
            running_val = bitstoNumber(bitCount);
            while(start <= end && bitstoNumber(bitCount) >= k)
            {
                ans = Math.min(ans , end-start + 1);
                getSetBits(bitCount, nums[start], -1);
                start+=1;  
            }
            end+=1;
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public void getSetBits(int[] bitCount, int num, int increment)
    {
        int pos = 0;
        while(num > 0)
        {
            if((num & 1) == 1)
            {
                bitCount[pos] += increment;
            }
            num>>=1;
            pos+=1;
        }
    }

    public int bitstoNumber(int[] bitCount)
    {
        int ans = 0;
        for(int i = 0 ; i < bitCount.length; ++i)
        {
            if(bitCount[i] > 0)
                ans = ans | (1<<i);
        }
        return ans;
    }


}
