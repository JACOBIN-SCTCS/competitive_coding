class Solution {

    int dp[501][501];
    
    public:
    
    int compute(int idx, int time ,vector<int>& satisfaction)
    {
        if(idx==satisfaction.size() || time> satisfaction.size())
            return 0;
        if(dp[idx][time]!=-1)
            return dp[idx][time];
        
        int ret=INT_MIN;
        ret = max( compute(idx+1,time,satisfaction), satisfaction[idx]*time + compute(idx+1, time+1,satisfaction));
        dp[idx][time]=ret;
        return dp[idx][time];
        
    }
    
    
    int maxSatisfaction(vector<int>& satisfaction)
    {
        memset(dp,-1,sizeof(dp));
        sort(satisfaction.begin(),satisfaction.end());
        
        return compute(0,1,satisfaction); 
       
    }
};
