class Solution {
    public int maxScore(String s) {
        int ones = 0;
        for(int i=0;i < s.length();++i)
        {
            if(s.charAt(i) == '1')
                ones+=1;
        }

        int zeros = 0;
        int ans = 0;
        for(int i=0;i<s.length()-1;++i)
        {
            if(s.charAt(i) == '0')
                zeros+=1;
            else
                ones-=1;
            ans = Math.max(ans,ones+zeros);
        }
        return ans;
    }
}
