class Solution {
    public double new21Game(int n, int k, int maxPts) 
    {
        // Probability of getting q points = 
        // \sum^{maxPts}_{i=1} ( P(i | I have q-i points currently) * P(I have q-i poiints currently)   ) 

        // = \sum^{maxPts}_{i=1} ( P(i) * P(I have q-i poiints currently)) 
        // Because each draw is independent

        // GAVE TLE
        // double[] dp = new double[n+1];
        // dp[0] = 1.0;

        // for(int i=1;i<= n ; ++i)
        // {
        //     for(int j=1; j<= maxPts ; ++j)
        //     {
        //         if((i-j) < 0 || (i-j) >= k)
        //             continue;
        //         dp[i] = dp[i] + dp[i-j]/maxPts; // uniform distribution
        //     }
        // }

        // double ans = 0;
        // for(int i=k;i<=n;++i)
        // {
        //     ans = ans + dp[i];
        // }

        // return ans;

        double sum = 1;
        if(k==0)
            sum = 0;
            
        double[] dp = new double[n+1];
        dp[0] = 1;

        for(int i=1; i<= n ; ++i)
        {
            dp[i] = sum / maxPts;   // Basically summing up the the probabilities of required events
            if(i < k)
                sum = sum + dp[i];
            if(i-maxPts >= 0 && (i-maxPts) < k) // Make sure we are staying between limit
            {
                sum = sum - dp[i-maxPts];
            }
        }
        double ans = 0;
        for(int i=k;i<=n;++i)
            ans = ans + dp[i];
        return ans;
    }
}
