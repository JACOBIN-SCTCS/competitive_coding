class Solution {
    public int totalMoney(int n) {
        int coins = 1;
        int prev = 1;

        for(int i=1;i<n;++i)
        {
            if(i%7 == 0)
            {

                prev  = (i/7) + 1;
            }
            else
            {
                prev = prev + 1;
            }
            coins = coins + prev;
        }
        return coins;
    }
}
