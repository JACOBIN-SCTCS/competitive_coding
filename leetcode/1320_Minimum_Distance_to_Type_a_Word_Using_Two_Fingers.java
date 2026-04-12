class Solution {

    int[][][] dp;
    int word_len;
    String word;

    public int helper(int index, int left, int right) {
        
        if(index >=  word_len)
            return 0;
        
        if(dp[index][left+1][right+1] != -1)
            return dp[index][left+1][right+1];

        char current_char = word.charAt(index);
        int char_x = (current_char - 'A') / 6;
        int char_y = (current_char - 'A') % 6;

        int res = Integer.MAX_VALUE;
        
        int res1 = 0;
        if(left != -1) {
            int left_x = left/6;
            int left_y = left % 6;
            res1 = Math.abs(char_x - left_x) + Math.abs(char_y - left_y);
        }
        res = Math.min(res ,  res1 + helper(index+1, (current_char-'A'), right));

        int res2 = 0;
        if(right != -1) {
            int right_x = right / 6;
            int right_y = right % 6;
            res2 = Math.abs(char_x - right_x) + Math.abs(char_y - right_y);
        }

        res = Math.min(res ,  res2 + helper(index+1, left, (current_char-'A')));

        dp[index][left+1][right+1] = res;
        return res;
    }

    public int minimumDistance(String word) {

        this.word = word;
        word_len = this.word.length();

        this.dp = new int[word_len][28][28];

        for(int i=0; i < word_len; ++i)
            for(int j= 0; j <= 27; ++j)
                Arrays.fill(dp[i][j] , -1);

        int ans = helper(0,-1,-1);
        return ans;
    }
}
