class Solution {
   
    int[][] dp;
    
    public int compute(int index, int pos) { 
        
        if(pos== (dp[0].length-1)) {
            return 1;
        }
        if(pos > (dp[0].length-1)) {
            return 0;
        }
        
        if(dp[index][pos]!=-1)
            return dp[index][pos];
        
        int ans = 0;
        for (int i = index ; i<5;++i) {
            ans = ans + compute(i,pos+1);
        }
        dp[index][pos] = ans;
        return ans;    
    }
    
    public int countVowelStrings(int n) {
        
        dp = new int[5][n+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }    
      
        int total = 0;
        for(int i=0;i<5;++i){
            total += compute(i,1);
        }
        return total;
        
    }   
}
