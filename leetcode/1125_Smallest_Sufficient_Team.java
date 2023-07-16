// Had to refer editorial
class Solution 
{
    long[] dp;
    public long helper(int mask, int[] peopleMasks)
    {
        // No skill left out
        if(mask == 0)
            return 0l;
        
        if(dp[mask] != -1l)
            return dp[mask];
        
        for(int i=0;i<peopleMasks.length;++i)
        {
            // Find the skills which remains to be addressed 
            int remaining = mask & ~peopleMasks[i];
            if(remaining != mask)
            {
                // int new_skill_mask = peopleMasks[i] | mask;
                // The new person mask 
                long new_people_mask =  helper(remaining,peopleMasks) | (1l<< i);
                // If the previous ans had a larget bit count than the current one update
                if(dp[mask]==-1l || Long.bitCount(dp[mask]) > Long.bitCount(new_people_mask))
                {
                    dp[mask] = new_people_mask;
                }
            }
        }
        return dp[mask];
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) 
    {
        HashMap<String,Integer> skills_map = new HashMap<>();
        for(int i=0;i<req_skills.length;++i)
            skills_map.put(req_skills[i],i);

        int[] peopleMasks = new int[people.size()];
        for(int i=0;i<people.size();++i)
        {
            int mask = 0;
            for(int j=0;j<people.get(i).size();++j)
            {
                mask = (mask  | (1<<skills_map.get(people.get(i).get(j))));
            }
            peopleMasks[i] = mask;
        }
        dp = new long[(1<<req_skills.length)];
        Arrays.fill(dp,-1l);
        long res = helper(((1<<req_skills.length)-1),peopleMasks);
        int[] ans = new int[Long.bitCount(res)];
        int idx = 0;

        for(int i=0;i<people.size();++i)
        {
            if((res & (1l<<i))>0)
            {
                ans[idx] = i;
                idx+=1;
            }
        }
        return ans; 
    }
}
