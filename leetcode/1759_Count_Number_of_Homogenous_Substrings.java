class Solution {
     
    int mod = 1000000007;
    public int countHomogenous(String s) 
    {
        int ans = 1;
        int count = 1;
        char character = s.charAt(0);

        for(int i=1;i<s.length();++i)
        {
            if(s.charAt(i) != character)
            {
                count = 1;
                character = s.charAt(i);
            }
            else
            {
                count += 1;
            }
            ans = (ans + count ) %mod;
        }
        return ans;
    }
}
