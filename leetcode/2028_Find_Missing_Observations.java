class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int sum = mean* (n + rolls.length);
        int total = 0;
        for(int i=0; i < rolls.length;++i)
            total = total + rolls[i];

        int remaining_sum =  sum - total;
        
        int[] ans = new int[n];
        if(remaining_sum < n || remaining_sum > 6*n)
        {
            return new int[0];
        }

        int idx = 0;
        while(remaining_sum > 0)
        {
            ans[idx] +=1;
            remaining_sum -=1;

            idx = (idx+1)%(ans.length);
        }
        return ans;

    }
}
