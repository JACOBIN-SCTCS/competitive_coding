class Solution {
    public int longestIdealString(String s, int k) {
        
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        for(int i=0;i < 26;++i)
            map.add(new ArrayList<Integer>());
        
        int max_ans = 1;
        int[] dp = new int[s.length()];
        Arrays.fill(dp,1);

        for(int i = s.length()-1; i>=0; i--)
        {
            int character_idx = s.charAt(i)-'a';
            int current_ans = 1;
            for(int j=Math.max(0,character_idx-k); j <= Math.min(25,character_idx+k);++j)
            {
                List<Integer> next_idxes = map.get(j);
                if(next_idxes.size() > 0)
                {
                   current_ans = Math.max(current_ans, dp[next_idxes.get(next_idxes.size()-1)] +1);
                }
            }
            map.get(character_idx).add(i);
            dp[i] = current_ans;
            max_ans = Math.max(dp[i], max_ans);
        }

        return max_ans;
    }
}
