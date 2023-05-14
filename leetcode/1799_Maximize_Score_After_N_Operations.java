class Solution 
{
    HashMap<Integer,Integer> dp;

    public int gcd(int a, int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    
    public int helper(int[] nums, int current_mask, int founded_pairs)
    {
        if(2*founded_pairs >= nums.length)
            return 0;
        
        if(dp.containsKey(current_mask))
            return dp.get(current_mask);
        
        int maxscore = 0;
        int new_mask;
        for(int i=0;i<nums.length;++i)
        {
            for(int j=i+1;j<nums.length;++j)
            {
               if (((current_mask >> i) & 1) == 1 || ((current_mask >> j) & 1) == 1)
                    continue;
                new_mask = current_mask | (1<<i) | (1<<j);

                int current_score = (founded_pairs + 1)*gcd(nums[i],nums[j]);
                int remaining_score = helper(nums,new_mask,founded_pairs+1);
                maxscore = Math.max(maxscore,current_score + remaining_score);
            }
        }
        dp.put(current_mask,maxscore);
        return maxscore;
    }

    public int maxScore(int[] nums) 
    {
        dp = new HashMap<Integer,Integer>();
        return helper(nums,0,0);

    }
}
