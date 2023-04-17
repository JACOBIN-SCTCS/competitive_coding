class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        int max_candies = 0;
        for(int i=0;i<candies.length;++i)
            max_candies = Math.max(candies[i],max_candies);

        List<Boolean> res = new ArrayList<Boolean>();
        for(int i=0;i<candies.length;++i)
        {
            if(candies[i] + extraCandies >= max_candies)
                res.add(true);
            else
                res.add(false);
        }

        return res;    

    }
}
