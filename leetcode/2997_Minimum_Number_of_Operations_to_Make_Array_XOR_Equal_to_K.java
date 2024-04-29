class Solution {
    public int minOperations(int[] nums, int k) {
        int result = 0;
        for(int i=0; i < nums.length; ++i)
            result = result ^ nums[i];
        
        int ans =0;
        int residue = k ^ result;
        while(residue > 0)
        {
            int bit = residue & 1;
            if(bit > 0)
                ans+=1;
            residue >>=1;
        }

        return ans; 
    }
}
