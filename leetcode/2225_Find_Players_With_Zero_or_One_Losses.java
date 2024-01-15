class Solution {
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        int[] map = new int[100001];
        
        for(int i =0 ; i < matches.length; ++i)
        {
            if(map[matches[i][0]] == 0)
            {
                map[matches[i][0]] = 1;
            }
            if(map[matches[i][1]] == 0  )
            {
                map[matches[i][1]] = 2;
            }
            else
            {
                map[matches[i][1]] += 1;
            }

            
        }
        List<Integer> zero_loss = new ArrayList<Integer>();
        List<Integer> one_loss = new ArrayList<Integer>();

        for(int i = 1 ; i <= 100000; ++i)
        {
            if(map[i] == 0)
                continue;
            else if(map[i] == 1)
                zero_loss.add(i);
            else if ( map[i] == 2)
                one_loss.add(i);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(zero_loss);
        ans.add(one_loss);
        return ans;
    }
}
