class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums)
    {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        
        prefix[0]= nums[0];
        for(int i=1;i<n;++i)
            prefix[i]=prefix[i-1]+nums[i];
        
        suffix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            suffix[i] = suffix[i+1]+nums[i];
        }
        //for(int i=0;i<nums.length;++i)
         //   System.out.println(prefix[i] + "---" + suffix[i] );
        
        int[] sum = new int[nums.length];
        for(int i=0;i<nums.length;++i)
        {
            sum[i]=0;
            if(i-1>=0)
                sum[i] += i*nums[i] -prefix[i-1];
            if(i+1<nums.length)
                sum[i]+= suffix[i+1] - (n-1-i)*nums[i];
        }
        return sum;
    }
}
