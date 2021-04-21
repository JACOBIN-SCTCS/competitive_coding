class Solution {
    public boolean canJump(int[] nums) 
    {
    
        boolean[] canreach = new boolean[nums.length];
        Arrays.fill(canreach,false);
        canreach[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--)
        {
            int maximum_distance = Math.min(i+nums[i],nums.length-1);
            for(int j=i+1;j<=maximum_distance;++j)
            {
                if(canreach[j]==true)
                {
                    canreach[i]=true;
                    break;
                }
            }
            
        }
        return canreach[0];
        
    }
}
