class Solution {
    public List<String> summaryRanges(int[] nums) 
    {
        List<String> result = new ArrayList<String>();
        int i=0;

        while(i<nums.length)
        {
            int j = i;
            while((j+1)<nums.length && nums[j+1]==(nums[j]+1))
                j+=1;
            if(i!=j)
            {
                result.add(new String(nums[i]+"->"+nums[j]));
            }
            else
            {
                result.add(Integer.toString(nums[i]));
            }
            i=j+1;
        }
        return result;
    }
}
