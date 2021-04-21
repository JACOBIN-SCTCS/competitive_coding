class Solution {
    public int jump(int[] nums) 
    {
        int[] numways = new int [nums.length];
        Arrays.fill(numways,Integer.MAX_VALUE);
        numways[nums.length-1] = 0;
        
        for(int i=nums.length-2;i>=0;i--)
        {
            int maximum_jump = Math.min(i+nums[i],nums.length-1);
            for(int j=i+1;j<=maximum_jump;++j)
            {
                if(numways[j]!=Integer.MAX_VALUE)
                {
                    numways[i] = Math.min(numways[i],1+numways[j]);
                }
            }
        }
        return numways[0];
        
    }
}
